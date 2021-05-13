import styled, { css } from 'styled-components';
import { useEffect, useContext } from 'react';
import { withRouter } from 'react-router-dom';
import queryString from 'query-string';

import { API } from "../../common/reference";

import { GamePlayContext } from '../utilComponent/context/GamePlayProvider';
import { GlobalContext } from '../utilComponent/context/GlobalProvider';
import { cssScrollbar, cssTranslate } from '../utilComponent/CommonStyledCSS';

import PlayerListPopup from '../playerListPopup/PlayerListPopup';
import TeamScorePopup from '../teamScorePopup/TeamScorePopup';
import MainFrame from '../utilComponent/MainFrame';

import GameScore from './gameScore/GameScore';
import MatchScreen from './matchScreen/MatchScreen';
import BattleGround from './battleGround/BattleGround';
import SituationScreen from './situationScreen/SituationScreen';

const GamePlay = ({ location }) => {
    const team = queryString.parse(location.search);

    const { globalState } = useContext(GlobalContext);
    const {
        gamePlayState: { teamsData },
        gamePlayDispatch,
        gamePlayOptionsState,
        gamePlayOptionsDispatch,
    } = useContext(GamePlayContext);

    /*
    // gameplay 첫 스타트는 공격으로 시작.
    // 팀 선택 클릭 시 랜덤으로 돌려도 될듯.
    const [sequence, setSequence] = useState('attack');
    const [onOff, setOnOff] = useState(false); // pitch 버튼 attack일때 off     // 제외 (sequence로 제어 가능할듯)
    const [strike, setStrike] = useState([]);
    const [ball, setBall] = useState([]);
    const [awayScore, setAwayScore] = useState(0);
    const [homeScore, setHomeScore] = useState(0);
    const [pitcher, setPitcher] = useState('');
    const [hitter, setHitter] = useState('');

    const randomSituation = () => {
        let kind = ['HIT', 'OUT', 'BALL', 'STRIKE'];
        let randomNumber = Math.floor(Math.random() * kind.length) + 1;
        return kind[randomNumber];
    };
    const gamePlay = () => {
        if (sequence === 'attack') {
            setPitcher(gamePlayState.playerList.opponent.players[0]); // 투수
            setHitter(gamePlayState.playerList.user.players[1]); // 타자
        } else if (sequence === 'defense') {
            setOnOff(true);
            setPitcher(gamePlayState.playerList.user.players[0]); // 투수
            setHitter(gamePlayState.playerList.opponent.players[1]); // 타자
        }
    };
    */

    // useFetch로 --------------- 수정 예정 START
    const options = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            user: globalState.clickLocation === 'away' ? team.away : team.home,
            opponent:
                globalState.clickLocation === 'away' ? team.home : team.away,
        }),
        // 클릭이 좌측 away인지 우측 home 인지 판별하기.
    };
    const fetchData = async (url) => {
        const res = await fetch(url, options);
        console.log(res);
        const result = await res.json();
        gamePlayDispatch({ type: 'setTeamsData', payload: result });
    };

    useEffect(() => {
        if (!globalState.clickLocation) return;
        globalState.clickLocation === 'away'
            ? fetchData(API + '/api/games/type-away')
            : fetchData(API + '/api/games/type-home');
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [globalState.clickLocation]);
    // useFetch로 --------------- 수정 예정  END

    useEffect(() => {
        if (!teamsData || !globalState) return;
        const { user, opponent } = teamsData;
        const { clickLocation } = globalState;
        if (!user || !opponent || !clickLocation) return;

        const { players: userPlayers, team_name: userTeamName } = user;
        const { players: opponentPlayers, team_name: opponentTeamName } = opponent;

        gamePlayDispatch({
            type: 'manyChangeGameProgress',
            payload: {
                homeOrAway: clickLocation,
                attacker: (clickLocation === 'away') 
                    ? userTeamName
                    : opponentTeamName,
                userTeamName, opponentTeamName,
                pitcher: (clickLocation === 'away') ? opponentPlayers[0] : userPlayers[0],
                hitter: (clickLocation === 'away') ? userPlayers[1] : opponentPlayers[1],
            },
        });
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [teamsData]);

    const childComponents = [
        <GameScore />,
        <MatchScreen />, //
        <BattleGround />, // 어택인지 디펜스인지에 따라 피치버튼 on & off
        <SituationScreen />,
    ];
    const gamePlayItems = childComponents.map((child, i) => (
        <GamePlayItem key={i} idx={i + 1}>
            {child}
        </GamePlayItem>
    ));

    const handleMouseEnter = ({ target }) => {
        if (!target || target.tagName !== 'SECTION') return;
        const targetID = Number(target.dataset.id);
        if (targetID === 1)
            gamePlayOptionsDispatch({ type: 'teamScoreVisibleToggle' });
        else gamePlayOptionsDispatch({ type: 'playerListVisibleToggle' });
    };

    const handleMainFrameClick = ({ target }) => {
        if (!target) return;
        const targetDataSetName = target.dataset.name;
        if (targetDataSetName !== 'gameplay') return;
        const { teamScorePopupVisible, playListPopupVisible } = gamePlayOptionsState;
        teamScorePopupVisible &&
            gamePlayOptionsDispatch({ type: 'teamScoreVisibleToggle' });
        playListPopupVisible &&
            gamePlayOptionsDispatch({ type: 'playerListVisibleToggle' });
    };

    return (
        <MainFrame onClick={handleMainFrameClick} data-name="gameplay">
            <StyledGamePlay>
                <GamePlayPopupSection
                    data-id={1}
                    onMouseEnter={handleMouseEnter}
                    isTop
                />
                <GamePlayPopupSection
                    data-id={2}
                    onMouseEnter={handleMouseEnter}
                />
                <TeamScorePopup
                    visible={gamePlayOptionsState.teamScorePopupVisible}
                />
                <PlayerListPopup
                    visible={gamePlayOptionsState.playListPopupVisible}
                />
                <GamePlayItems>{gamePlayItems}</GamePlayItems>
            </StyledGamePlay>
        </MainFrame>
    );
};

export default withRouter(GamePlay);

// --- Styled Components ---
const StyledGamePlay = styled.div`
    width: 60%;
    color: ${({ theme }) => theme.colors.white};
    position: relative;
    overflow: hidden;
`;

const GamePlayItems = styled.ul`
    display: grid;
    grid-template-columns: 3fr 1fr;
    border: 3px solid ${({ theme }) => theme.colors.white};
`;

const GamePlayItem = styled.li`
    padding: 16px;

    ${({ idx }) =>
        idx % 2 === 0 &&
        css`
            border-left: 3px solid ${({ theme }) => theme.colors.white};
        `};
    ${({ idx }) =>
        (idx === 1 || idx === 2) &&
        css`
            border-bottom: 3px solid ${({ theme }) => theme.colors.white};
        `};
    ${({ idx }) =>
        (idx === 3 || idx === 4) &&
        css`
            max-height: 600px;
        `};

    ${({ idx }) => idx === 4 && cssScrollbar};
`;

const GamePlayPopupSection = styled.section`
    ${cssTranslate};
    width: 100%;
    padding: 16px 0;

    position: absolute;
    z-index: 8;
    top: ${({ isTop }) => (isTop ? 0 : 'auto')};
    bottom: ${({ isTop }) => (isTop ? 'auto' : 0)};
`;
