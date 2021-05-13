package com.codesquad.baseball.domain.game;

import com.codesquad.baseball.domain.game.inning.History;
import com.codesquad.baseball.domain.game.inning.Inning;
import com.codesquad.baseball.domain.game.participant.PlayerParticipatingInGame;
import com.codesquad.baseball.domain.game.participant.TeamParticipatingInGame;
import com.codesquad.baseball.domain.game.pitch.PitchResult;
import com.codesquad.baseball.domain.team.TeamType;
import com.codesquad.baseball.exceptions.game.GameIsNotStartedException;
import com.codesquad.baseball.exceptions.game.NotYourGameException;
import com.codesquad.baseball.exceptions.notfound.TeamNotFoundException;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Game {

    public static final int NO_PLAYER = -1;
    public static final String NO_USER = "NO_ONE";
    private static final int MAXIMUM_STRIKE_COUNT = 3;
    private static final int MAXIMUM_OUT_COUNT = 3;
    private static final int MAXIMUM_BALL_COUNT = 4;
    private static final int LAST_INNING = 9;
    private static final int LAST_EXTENDED_INNING = 12;
    private static final boolean END_OF_THE_GAME = true;

    @Id
    private Integer id;
    private String gameTitle;
    private boolean isTop;
    private int currentStrikeCount;
    private int currentOutCount;
    private int currentBallCount;
    private String gameOccupier;
    private Set<TeamParticipatingInGame> teams = new HashSet<>();
    private int firstBase;
    private int secondBase;
    private int thirdBase;
    @MappedCollection(idColumn = "game", keyColumn = "inning_number")
    private List<Inning> innings = new ArrayList<>();
    @Transient
    private boolean isInitialized = false;

    protected Game() {
    }

    private Game(Builder builder) {
        this.id = builder.id;
        this.gameTitle = builder.gameTitle;
        this.isTop = builder.isTop;
        this.currentStrikeCount = builder.currentStrikeCount;
        this.currentOutCount = builder.currentOutCount;
        this.currentBallCount = builder.currentBallCount;
        this.gameOccupier = builder.gameOccupier;
        this.teams.add(builder.homeTeam);
        this.teams.add(builder.awayTeam);
        this.firstBase = builder.firstBase;
        this.secondBase = builder.secondBase;
        this.thirdBase = builder.thirdBase;
    }

    public static Game createGame(String gameTitle, TeamParticipatingInGame homeTeam, TeamParticipatingInGame awayTeam) {
        Game game = new Builder()
                .gameTitle(gameTitle)
                .gameOccupier(NO_USER)
                .currentStrikeCount(0)
                .currentBallCount(0)
                .currentOutCount(0)
                .isTop(true)
                .homeTeam(homeTeam)
                .awayTeam(awayTeam)
                .firstBase(NO_PLAYER)
                .secondBase(NO_PLAYER)
                .thirdBase(NO_PLAYER)
                .build();
        game.proceedToNextInning();
        return game;
    }

    public void joinGame(String userId) {
        gameOccupier = userId;
    }

    public List<History> showHistoriesOfCurrentInning() {
        return currentInning().showHistory();
    }

    public void initializeGame() {
        if (!isInitialized) {
            teams.forEach(TeamParticipatingInGame::initializeTeam);
            isInitialized = true;
        }
    }

    public List<Map<TeamType, Integer>> showScoreBoard() {
        return innings.stream().map(inning -> {
            Map<TeamType, Integer> scoreMap = new HashMap<>();
            scoreMap.put(TeamType.HOME, inning.getHomeTeamScore());
            scoreMap.put(TeamType.AWAY, inning.getAwayTeamScore());
            return scoreMap;
        }).collect(Collectors.toList());
    }

    public PitchResult pitch(PlayType playType) {
        PitchResult pitchResult = new PitchResult(playType);
        switch (playType) {
            case STRIKE:
                pitchResult = onStrike();
                break;
            case BALL: {
                pitchResult = onBall();
                break;
            }
            case HITS: {
                pitchResult = onHits();
                break;
            }
            case HOMERUN: {
                pitchResult = onHomeRun();
                break;
            }
        }
        savePitchResult(pitchResult);
        updatePlayerRecord(pitchResult);
        return judgePitchResult(pitchResult);
    }

    private void updatePlayerRecord(PitchResult pitchResult) {
        PlayerParticipatingInGame playerRecord = attackingTeam().findPlayerByBatOrder(currentHitter());
        switch (pitchResult.getPlayType()) {
            case HOMERUN:
            case HITS:
                playerRecord.increaseHitCount();
                break;
            case STRIKE_OUT:
                playerRecord.increaseOutCount();
                break;
            case AT_BAT:
                playerRecord.increasePlateAppearances();
                break;
        }
    }

    public List<PlayerParticipatingInGame> showPlayerRecords(TeamType teamType) {
        if (teamType == TeamType.HOME) {
            return homeTeam().getPlayers();
        }
        return awayTeam().getPlayers();
    }

    private void savePitchResult(PitchResult pitchResult) {
        History history = currentInning().createHistory(pitchResult.getPlayType(), currentStrikeCount, currentBallCount,
                defendingTeam().getCurrentPitcher(), attackingTeam().getCurrentHitter(), pitchResult.numberOfRunners());
        pitchResult.setHistory(history);
        currentInning().addHistory(history);
    }

    private PitchResult onStrike() {
        PitchResult pitchResult = new PitchResult(PlayType.STRIKE);
        increaseStrikeCount();
        PlayType strikeResult = judgeThreeStrike();
        if (strikeResult == PlayType.STRIKE_OUT) {
            pitchResult.changePlayTypeToStrikeOut();
        }
        return pitchResult;
    }

    private PitchResult onBall() {
        increaseBallCount();
        return judge4Ball();
    }

    private PitchResult onHits() {
        PitchResult pitchResult = new PitchResult(PlayType.HITS);
        pitchResult.addRunner(pushAllRunners());
        return pitchResult;
    }

    private PitchResult onHomeRun() {
        PitchResult pitchResult = new PitchResult(PlayType.HOMERUN);
        pitchResult.addRunner(recallAllRunners());
        return pitchResult;
    }

    private PitchResult judgePitchResult(PitchResult pitchResult) {
        switch (pitchResult.getPlayType()) {
            case HOMERUN:
            case HITS:
            case FOUR_BALL:
                changeHitterOfAttackingTeam();
                resetStrikeAndBall();
                break;
            case STRIKE_OUT:
                changeHitterOfAttackingTeam();
                resetStrikeAndBall();
                increaseOutCount();
                if (isThreeOut()) {
                    boolean isEndOfTheGame = proceedToNextStage();
                    if (isEndOfTheGame) {
                        pitchResult.changeGameStateToGameOver();
                    }
                }
                break;
        }
        pitchResult.getBackHomeRunners().forEach(i -> currentInning().addScore(attackingTeam()));
        return pitchResult;
    }

    private void changeHitterOfAttackingTeam() {
        attackingTeam().changeHitter();
        updatePlayerRecord(new PitchResult(PlayType.AT_BAT));
    }

    private PlayType judgeThreeStrike() {
        if (isThreeStrike()) {
            return PlayType.STRIKE_OUT;
        }
        return PlayType.STRIKE;
    }

    private PitchResult judge4Ball() {
        PitchResult pitchResult = new PitchResult(PlayType.BALL);
        if (is4Ball()) {
            int backHomeRunner = pushAllRunners();
            pitchResult.changePlayTypeToFourBall();
            pitchResult.addRunner(backHomeRunner);
            return pitchResult;
        }
        return pitchResult;
    }

    private int pushAllRunners() {
        int backHomePlayer = NO_PLAYER;
        if (hasThirdBaseRunner()) {
            backHomePlayer = thirdBase;
        }
        if (hasSecondBaseRunner()) {
            thirdBase = secondBase;
        }
        if (hasFirstBaseRunner()) {
            secondBase = firstBase;
        }
        firstBase = attackingTeam().getCurrentHitter();
        return backHomePlayer;
    }

    private List<Integer> recallAllRunners() {
        List<Integer> backHomeRunners = new ArrayList<>();
        if (hasThirdBaseRunner()) {
            backHomeRunners.add(thirdBase);
            thirdBase = NO_PLAYER;
        }
        if (hasSecondBaseRunner()) {
            backHomeRunners.add(secondBase);
            secondBase = NO_PLAYER;
        }
        if (hasFirstBaseRunner()) {
            backHomeRunners.add(firstBase);
            firstBase = NO_PLAYER;
        }
        backHomeRunners.add(attackingTeam().getCurrentHitter());
        return backHomeRunners;
    }

    public boolean hasFirstBaseRunner() {
        return firstBase != NO_PLAYER;
    }

    public boolean hasSecondBaseRunner() {
        return secondBase != NO_PLAYER;
    }

    public boolean hasThirdBaseRunner() {
        return thirdBase != NO_PLAYER;
    }

    public int firstBaseRunner() {
        return firstBase;
    }

    public int secondBaseRunner() {
        return secondBase;
    }

    public int thirdBaseRunner() {
        return thirdBase;
    }

    public int currentHitter() {
        return attackingTeam().getCurrentHitter();
    }

    public int nextHitter() {
        return attackingTeam().nextHitter();
    }

    public int currentPitcher() {
        return defendingTeam().getCurrentPitcher();
    }

    private boolean proceedToNextStage() {
        resetField();
        if (isTop) {
            isTop = false;
        } else {
            if (judgeGameOver()) {
                return END_OF_THE_GAME;
            }
            proceedToNextInning();
        }
        return !END_OF_THE_GAME;
    }

    private boolean judgeGameOver() {
        if (isLastInning() && !isTieState()) {
            return END_OF_THE_GAME;
        } else if (isExtendedInning() && !isTieState()) {
            return END_OF_THE_GAME;
        } else if (isLastExtendedInning()) {
            return END_OF_THE_GAME;
        }
        return !END_OF_THE_GAME;
    }

    private boolean isTieState() {
        return homeTeamScore() == awayTeamScore();
    }

    private boolean isLastInning() {
        return currentInningNumber() == LAST_INNING;
    }

    private boolean isExtendedInning() {
        int inningNumber = currentInningNumber();
        return LAST_INNING < inningNumber && inningNumber <= LAST_EXTENDED_INNING;
    }

    private boolean isLastExtendedInning() {
        return currentInningNumber() == LAST_EXTENDED_INNING;
    }

    private void increaseStrikeCount() {
        currentStrikeCount++;
    }

    private void increaseBallCount() {
        currentBallCount++;
    }

    private void resetField() {
        currentOutCount = 0;
        resetStrikeAndBall();
        firstBase = NO_PLAYER;
        secondBase = NO_PLAYER;
        thirdBase = NO_PLAYER;
    }

    private void resetStrikeAndBall() {
        currentStrikeCount = 0;
        currentBallCount = 0;
    }

    private void increaseOutCount() {
        currentOutCount++;
    }

    private boolean isThreeStrike() {
        return currentStrikeCount == MAXIMUM_STRIKE_COUNT;
    }

    private boolean is4Ball() {
        return currentBallCount == MAXIMUM_BALL_COUNT;
    }

    private boolean isThreeOut() {
        return currentOutCount == MAXIMUM_OUT_COUNT;
    }

    private TeamParticipatingInGame attackingTeam() {
        // TOP OF THE 8TH INNING = 8회 초
        // BOTTOM OF 9TH INNING  = 9회 말
        if (isTop) {
            return awayTeam();
        } else {
            return homeTeam();
        }
    }

    private TeamParticipatingInGame defendingTeam() {
        if (isTop) {
            return homeTeam();
        } else {
            return awayTeam();
        }
    }

    public int currentInningNumber() {
        return innings.size();
    }

    private Inning currentInning() {
        return innings.get(innings.size() - 1);
    }

    public int teamScore(Function<Inning, Integer> score) {
        return innings.stream()
                .map(score)
                .mapToInt(value -> value)
                .sum();
    }

    public int homeTeamScore() {
        return teamScore(Inning::getHomeTeamScore);
    }

    public int awayTeamScore() {
        return teamScore(Inning::getAwayTeamScore);
    }

    private void proceedToNextInning() {
        this.innings.add(Inning.createDefaultInning());
        this.isTop = true;
    }

    public boolean isJoinable() {
        return gameOccupier.equals(NO_USER);
    }

    public boolean isSameTitle(String title) {
        return this.gameTitle.equals(title);
    }

    public boolean isOccupied() {
        return !isJoinable();
    }

    public void verifyGameIsPlayable(String userId) {
        if (!isOccupied()) {
            throw new GameIsNotStartedException();
        }
        if (!gameOccupier.equals(userId)) {
            throw new NotYourGameException();
        }
    }

    public int homeTeamId() {
        return homeTeam().getTeam();
    }

    public int awayTeamId() {
        return awayTeam().getTeam();
    }

    public TeamParticipatingInGame homeTeam() {
        return teams.stream()
                .filter(TeamParticipatingInGame::isHomeTeam)
                .findFirst()
                .orElseThrow(() -> new TeamNotFoundException(TeamNotFoundException.HOME_TEAM_NOT_FOUND));
    }

    public TeamParticipatingInGame awayTeam() {
        return teams.stream()
                .filter(TeamParticipatingInGame::isAwayTeam)
                .findFirst()
                .orElseThrow(() -> new TeamNotFoundException(TeamNotFoundException.AWAY_TEAM_NOT_FOUND));
    }

    public int sizeOfHomeTeam() {
        return homeTeam().sizeOfPlayer();
    }

    public int sizeOfAwayTeam() {
        return awayTeam().sizeOfPlayer();
    }

    public boolean isFirstBaseEmpty() {
        return firstBase == NO_PLAYER;
    }

    public boolean isSecondBaseEmpty() {
        return secondBase == NO_PLAYER;
    }

    public boolean isThirdBaseEmpty() {
        return thirdBase == NO_PLAYER;
    }

    public Integer getId() {
        return id;
    }

    public int getCurrentStrikeCount() {
        return currentStrikeCount;
    }

    public int getCurrentOutCount() {
        return currentOutCount;
    }

    public int getCurrentBallCount() {
        return currentBallCount;
    }

    public boolean isTop() {
        return isTop;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public List<Inning> getInnings() {
        return innings;
    }

    public static class Builder {
        private Integer id;
        private String gameTitle;
        private boolean isTop;
        private int currentStrikeCount;
        private int currentOutCount;
        private int currentBallCount;
        private String gameOccupier;
        private TeamParticipatingInGame homeTeam;
        private TeamParticipatingInGame awayTeam;
        private int firstBase;
        private int secondBase;
        private int thirdBase;

        public Builder id(Integer value) {
            id = value;
            return this;
        }

        public Builder gameTitle(String value) {
            gameTitle = value;
            return this;
        }

        public Builder isTop(boolean value) {
            isTop = value;
            return this;
        }

        public Builder currentStrikeCount(int value) {
            currentStrikeCount = value;
            return this;
        }

        public Builder currentOutCount(int value) {
            currentOutCount = value;
            return this;
        }

        public Builder currentBallCount(int value) {
            currentBallCount = value;
            return this;
        }

        public Builder gameOccupier(String value) {
            gameOccupier = value;
            return this;
        }

        public Builder homeTeam(TeamParticipatingInGame value) {
            homeTeam = value;
            return this;
        }

        public Builder awayTeam(TeamParticipatingInGame value) {
            awayTeam = value;
            return this;
        }

        public Builder firstBase(int value) {
            firstBase = value;
            return this;
        }

        public Builder secondBase(int value) {
            secondBase = value;
            return this;
        }

        public Builder thirdBase(int value) {
            thirdBase = value;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
