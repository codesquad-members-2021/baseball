import styled, { css } from 'styled-components';
import GameScore from './gameScore/GameScore';
import MatchScreen from './matchScreen/MatchScreen';
import BattleGround from './battleGround/BattleGround';
import SituationScreen from './situationScreen/SituationScreen';
import { cssScrollbar } from '../utilComponent/CommonStyledCSS';

import PlayerListPopup from '../playerListPopup/PlayerListPopup';

const GamePlay = () => {
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

    return (
        <StyledGamePlay>
            <PlayerListPopup/>
            <GamePlayItems>{gamePlayItems}</GamePlayItems>
        </StyledGamePlay>
    );
};

export default GamePlay;

// --- Styled Components ---
const StyledGamePlay = styled.div`
    width: 60%;
    color: ${({ theme }) => theme.colors.white};
    position: relative;
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