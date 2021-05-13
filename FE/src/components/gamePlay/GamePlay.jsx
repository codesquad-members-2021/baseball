import styled, { css } from 'styled-components';
import { useState, useEffect, useContext, createContext } from "react";
import { withRouter } from "react-router-dom";
import queryString from "query-string";

import { GamePlayContext } from "../utilComponent/context/GamePlayProvider";
import { GlobalContext } from '../utilComponent/context/GlobalProvider';
import { cssScrollbar, cssTranslate } from '../utilComponent/CommonStyledCSS';

import PlayerListPopup from '../playerListPopup/PlayerListPopup';
import TeamScorePopup from '../teamScorePopup/TeamScorePopup';
import MainFrame from '../utilComponent/MainFrame';

import GameScore from './gameScore/GameScore';
import MatchScreen from './matchScreen/MatchScreen';
import BattleGround from './battleGround/BattleGround';
import SituationScreen from './situationScreen/SituationScreen';

export const PostsContext = createContext();

const GamePlay = ({ location }) => {
    const [scorePopupVisible, setScorePopupVisible] = useState(false);
    const [listPopupVisible, setListPopupVisible] = useState(false);

    const team = queryString.parse(location.search);
    const { gamePlayState, gamePlayDispatch } = useContext(GamePlayContext);

    const { globalState } = useContext(GlobalContext);
    const [playerList, setPlayerList] = useState("");
    console.log(playerList)

    // gameplay 첫 스타트는 공격으로 시작.
    // 팀 선택 클릭 시 랜덤으로 돌려도 될듯.
    const [sequence,setSequence] = useState("attack");
    const [onOff,setOnOff] = useState(false); // pitch 버튼 attack일때 off
    const [strike,setStrike] = useState([]);
    const [ball,setBall] = useState([]);
    const [awayScore,setAwayScore] = useState(0);
    const [homeScore,setHomeScore] = useState(0);
    const [pitcher,setPitcher] = useState("");
    const [hitter,setHitter] = useState("");
    
    const randomSituation = () => {
        let kind = ["HIT","OUT","BALL","STRIKE"];
        let randomNumber = Math.floor(Math.random()*kind.length)+1;
        return kind[randomNumber];
    }
    const gamePlay = () => {
        if(sequence === "attack") {
            setPitcher(playerList.opponent.players[0]); // 투수
            setHitter(playerList.user.players[1]);      // 타자
        } else if(sequence === "defense"){
            setOnOff(true);
            setPitcher(playerList.user.players[0]);     // 투수
            setHitter(playerList.opponent.players[1]);  // 타자
        }
    }

    const options = {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({"user" : globalState.clickLocation === "away" ? team.away : team.home, "opponent" : globalState.clickLocation === "away" ? team.home : team.away})
        // 클릭이 좌측 away인지 우측 home 인지 판별하기.
    }
    const fetchData = async (url) => {
        const res = await fetch(url, options);
        const result = await res.json();
        setPlayerList(result);
    };

    useEffect(() => {
        if (!globalState.clickLocation) return;
        globalState.clickLocation === "away" ? fetchData("/api/games/type-away") : fetchData("/api/games/type-home");
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [globalState.clickLocation])

    const childComponents = [
        <GameScore />,
        <MatchScreen />,  //
        <BattleGround />, // 어택인지 디펜스인지에 따라 피치버튼 on & off
        <SituationScreen />,
    ];
    const gamePlayItems = childComponents.map((child, i) => (
        <GamePlayItem key={i} idx={i + 1}>
            {child}
        </GamePlayItem>
    ));

    const handleMouseEnter = ({target}) => {
        if (!target || target.tagName !== "SECTION") return;
        const targetID = Number(target.dataset.id);
        if (targetID === 1) 
            gamePlayDispatch({type: "teamScoreVisibleControl"});
        else
            gamePlayDispatch({type: "playerListVisibleControl"});
    };

    const handleMainFrameClick = ({ target }) => {
        if (!target) return;
        const targetDataSetName = target.dataset.name;
        if (targetDataSetName !== "gameplay") return;
        const { teamScorePopupVisible, playListPopupVisible } = gamePlayState;
        teamScorePopupVisible && gamePlayDispatch({type: "teamScoreVisibleControl"});
        playListPopupVisible && gamePlayDispatch({type: "playerListVisibleControl"});
    };

    return (
        <PostsContext.Provider value={{playerList}}>
            <MainFrame onClick={handleMainFrameClick} data-name="gameplay">
                <StyledGamePlay>
                    <GamePlayPopupSection data-id={1} onMouseEnter={handleMouseEnter} isTop />
                    <GamePlayPopupSection data-id={2} onMouseEnter={handleMouseEnter} />
                    <TeamScorePopup visible={gamePlayState.teamScorePopupVisible} />
                    <PlayerListPopup visible={gamePlayState.playListPopupVisible} />
                    <GamePlayItems>{gamePlayItems}</GamePlayItems>
                </StyledGamePlay>
            </MainFrame>
        </PostsContext.Provider>
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

    ${({ idx }) => (idx % 2 === 0) && 
        css`border-left: 3px solid ${({ theme }) => theme.colors.white};`};
    ${({ idx }) => (idx === 1 || idx === 2) 
        && css`border-bottom: 3px solid ${({ theme }) => theme.colors.white};`};
    ${({ idx }) => (idx === 3 || idx === 4) 
        && css`max-height: 600px;`};

    ${({ idx }) => (idx === 4) && cssScrollbar};
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