package com.codesquad.baseball.domain;

import com.codesquad.baseball.exceptions.TeamNotFoundException;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Game {

    private static final int NO_PLAYER = -1;
    private static final int MAXIMUM_STRIKE_COUNT = 3;
    private static final int MAXIMUM_OUT_COUNT = 3;
    private static final int MAXIMUM_BALL_COUNT = 4;

    @Id
    private Integer id;
    private String gameTitle;
    private boolean isTop;
    private int currentStrikeCount;
    private int currentOutCount;
    private int currentBallCount;
    private boolean isOccupied;
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
        this.isOccupied = builder.isOccupied;
        this.teams.add(builder.homeTeam);
        this.teams.add(builder.awayTeam);
        this.firstBase = builder.firstBase;
        this.secondBase = builder.secondBase;
        this.thirdBase = builder.thirdBase;
    }

    public static Game createGame(String gameTitle, TeamParticipatingInGame homeTeam, TeamParticipatingInGame awayTeam) {
        Game game = new Builder()
                .gameTitle(gameTitle)
                .isOccupied(false)
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

    public void initializeGame() {
        if (!isInitialized) {
            teams.forEach(TeamParticipatingInGame::initializeTeam);
            isInitialized = true;
        }
    }

    public List<Integer> pitch(PlayType playType) {
        List<Integer> backHomeRunners = new ArrayList<>();
        switch (playType) {
            case STRIKE:
                onStrike();
                break;
            case BALL: {
                int backHomeRunner = onBall();
                if (backHomeRunner != NO_PLAYER) {
                    backHomeRunners.add(backHomeRunner);
                }
                break;
            }
            case HITS: {
                int backHomeRunner = onHits();
                if (backHomeRunner != NO_PLAYER) {
                    backHomeRunners.add(backHomeRunner);
                }
                break;
            }
            case HOMERUN: {
                backHomeRunners = onHomeRun();
                break;
            }
        }
        judgeScore(backHomeRunners);
        return backHomeRunners;
    }

    private void onStrike() {
        increaseStrikeCount();
        judgeThreeStrike();
    }

    private int onBall() {
        increaseBallCount();
        return judge4Ball();
    }

    private int onHits() {
        return judgeHits();
    }

    private List<Integer> onHomeRun() {
        return recallAllRunners();
    }

    private void judgeScore(List<Integer> backHomeRunners) {
        backHomeRunners.forEach(i -> currentInning().addScore(attackingTeam()));
    }

    private void judgeThreeStrike() {
        if (isThreeStrike()) {
            resetStrikeAndBall();
            increaseOutCount();
            if (isThreeOut()) {
                proceedToNextStage();
            }
        }
    }

    private int judge4Ball() {
        int backHomePlayer = NO_PLAYER;
        if (is4Ball()) {
            backHomePlayer = pushAllRunners();
        }
        return backHomePlayer;
    }

    private int judgeHits() {
        return pushAllRunners();
    }

    private int pushAllRunners() {
        resetStrikeAndBall();
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
        attackingTeam().changeHitter();
        return backHomePlayer;
    }

    private List<Integer> recallAllRunners() {
        resetStrikeAndBall();
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
        attackingTeam().changeHitter();
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

    private void proceedToNextStage() {
        resetField();
        if (isTop) {
            isTop = false;
        } else {
            proceedToNextInning();
        }
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

    public boolean isAvailable() {
        return !isOccupied;
    }

    public boolean isSameTitle(String title) {
        return this.gameTitle.equals(title);
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

    public static class Builder {
        private Integer id;
        private String gameTitle;
        private boolean isTop;
        private int currentStrikeCount;
        private int currentOutCount;
        private int currentBallCount;
        private boolean isOccupied;
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

        public Builder isOccupied(boolean value) {
            isOccupied = value;
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

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", gameTitle='" + gameTitle + '\'' +
                ", isTop=" + isTop +
                ", currentStrikeCount=" + currentStrikeCount +
                ", currentOutCount=" + currentOutCount +
                ", currentBallCount=" + currentBallCount +
                ", isOccupied=" + isOccupied +
                ", teams=" + teams +
                '}';
    }
}
