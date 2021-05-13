import styled from "styled-components";
import { useContext } from 'react';
import { GamePlayContext } from "../../utilComponent/context/GamePlayProvider";

const MatchScreen = () => {
    const { gamePlayState: { gameProgress } } = useContext(GamePlayContext);
    const { pitcher, hitter } = gameProgress;
    console.log(pitcher, hitter)

    return (pitcher&& hitter) && (
        <StyledMatchScreen>
            <div>
                <Position>투수</Position>
                <Info>
                    <span className="name">{pitcher.name}</span>
                    <span className="info">#{pitcher.id}</span>
                </Info>
            </div>
            <div>
                <Position>타자</Position>
                <Info>
                    <span className="name">{hitter.name}</span>
                    <span className="info">{hitter.at_bat}타석 {hitter.hits}안타</span>
                </Info>
            </div>
        </StyledMatchScreen>
    );
};

export default MatchScreen;

// --- Styled Components ---
const StyledMatchScreen = styled.div`
    height: 100%;
    display: grid;
    grid-row-gap: 32px;
    align-items: center;
`;

const Position = styled.p`
    font-size: ${({ theme }) => theme.fontSize.L};
    font-weight: ${({ theme }) => theme.fontWeight.bold2};
`;

const Info = styled.div`
    font-size: ${({ theme }) => theme.fontSize.S};
    font-weight: ${({ theme }) => theme.fontWeight.bold};

    ${Position} + & {
        margin-top: 16px;
    }

    .name {
        color: ${({ theme }) => theme.colors.gray5};
    }

    .info {
        color: ${({ theme }) => theme.colors.mint};
    }

    span + span { margin-left: 16px; }
`;
