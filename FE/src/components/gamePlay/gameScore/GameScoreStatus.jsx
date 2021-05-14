import styled from 'styled-components';
import { useState, useEffect, useContext } from "react"
import { GamePlayContext } from "../../utilComponent/context/GamePlayProvider";
import { isAllNullObjectValues } from "../../../common/util";

const GameScoreStatus = () => {
    const { gamePlayState: { gameProgress } } = useContext(GamePlayContext);

    const [names, setNames] = useState({ awayTeam: null, homeTeam: null });
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        if (!gameProgress) return;
        const { homeOrAway, userTeamName, opponentTeamName } = gameProgress;
        if (!homeOrAway || !userTeamName || !opponentTeamName) return;
        setNames({
            ...names,
            awayTeam: homeOrAway === 'away' ? userTeamName : opponentTeamName,
            homeTeam: homeOrAway === 'away' ? opponentTeamName : userTeamName,
        })
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [gameProgress]);

    useEffect(() => setIsLoading(isAllNullObjectValues(names)), [names]);

    return gameProgress && !isLoading && (
        <StyledGameScoreStatus>
            <Status>
                {/* away */}
                <StatusItem type="team">
                    <div>
                        <p>{names.awayTeam}</p>
                        {gameProgress.homeOrAway === 'away' && <IsPlayer>Player</IsPlayer>}
                    </div>
                </StatusItem>
            </Status>

            <Versus>
                <span className="score">{gameProgress.awayScore}</span>
                <span>VS</span>
                <span className="score">{gameProgress.homeScore}</span>
            </Versus>

            <Status>
                {/* home */}
                <StatusItem type="team">
                    <div>
                        <p>{names.homeTeam}</p>
                        {gameProgress.homeOrAway === 'home' && <IsPlayer>Player</IsPlayer>}
                    </div>
                </StatusItem>
            </Status>
        </StyledGameScoreStatus>
    );
};

export default GameScoreStatus;

// --- Styled Components ---
const StyledGameScoreStatus = styled.div`
    display: flex;
    justify-content: space-evenly;
    margin: 36px 24px 12px;
    width: 100%;
`;

const Status = styled.div`
    text-align: center;
    height: 100%;
`;

const Versus = styled.div`
    font-size: ${({ theme }) => theme.fontSize.XXXL};
    font-weight: ${({ theme }) => theme.fontWeight.bold};
    color: ${({ theme }) => theme.colors.gray5};

    span {
        margin: 0 20px;
    }

    .score {
        font-size: ${({ theme }) => theme.fontSize.XXXXL};
        color: ${({ theme }) => theme.colors.gray4};
    }
`;

const StatusItem = styled.div`
    font-size: ${({ theme }) => theme.fontSize.XL};
    font-weight: ${({ theme }) => theme.fontWeight.bold2};

    color: ${({ theme }) => theme.colors.white};
`;

const IsPlayer = styled.p`
    font-size: ${({ theme }) => theme.fontSize.L};
    font-weight: ${({ theme }) => theme.fontWeight.bold};
    color: ${({ theme }) => theme.colors.red};

    p + & {
        margin-top: 16px;
    }
`;
