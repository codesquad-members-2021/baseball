import styled, { css } from 'styled-components';
import { useState } from "react";
import { withRouter } from "react-router-dom";
import queryString from "query-string";
import GameScore from './gameScore/GameScore';
import MatchScreen from './matchScreen/MatchScreen';
import BattleGround from './battleGround/BattleGround';
import SituationScreen from './situationScreen/SituationScreen';
import { cssScrollbar, cssTranslate } from '../utilComponent/CommonStyledCSS';
import { createContext } from 'react';

import PlayerListPopup from '../playerListPopup/PlayerListPopup';
import TeamScorePopup from '../teamScorePopup/TeamScorePopup';

export const PostsContext = createContext();

const GamePlay = ({ location }) => {
    const [scorePopupVisible, setScorePopupVisible] = useState(false);
    const [listPopupVisible, setListPopupVisible] = useState(false);

    const team = queryString.parse(location.search);

    const childComponents = [
        <GameScore />,
        <MatchScreen />,
        <BattleGround />,
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
            setScorePopupVisible(true)
        else
            setListPopupVisible(true);
    };

    return (
        <PostsContext.Provider value={{team}}>
            <StyledGamePlay>
                <GamePlayPopupSection data-id={1} onMouseEnter={handleMouseEnter} isTop />
                <GamePlayPopupSection data-id={2} onMouseEnter={handleMouseEnter} />

                <TeamScorePopup visible={scorePopupVisible} callBackFrameLeave={setScorePopupVisible} />
                <PlayerListPopup visible={listPopupVisible} callBackFrameLeave={setListPopupVisible}/>

                <GamePlayItems>{gamePlayItems}</GamePlayItems>
            </StyledGamePlay>
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