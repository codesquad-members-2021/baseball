import { useContext } from "react";
import styled from "styled-components";
import { GamePlayContext } from "../../../utilComponent/context/GamePlayProvider";

const Round = () => {
    const { gamePlayState: { gameProgress } } = useContext(GamePlayContext);
    const { attackOrDefense, roundState } = gameProgress;
    return (
        <StyledRound>
            <span>{roundState}회{attackOrDefense === "attack" ? '초' : '말'}</span>
            <span>{attackOrDefense === "attack" ? '공격' : '수비'}</span>
        </StyledRound>
    );
};

export default Round;

// --- Styled Components ---
const StyledRound = styled.span`
    font-size: ${({theme}) => theme.fontSize.XXL};
    font-weight: ${({theme}) => theme.fontWeight.bold};
    span + span {
        margin-left: 10px;
    }
`;