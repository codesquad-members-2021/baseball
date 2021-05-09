import styled from 'styled-components';

const ScoreStatus = ({ data = true, playerTeam = 'teamName' }) => {
    return (
        data && (
            <StyledScoreStatus>
                <Status>
                    <StatusItem type="team">
                        <span>Rockets</span>
                        <span className="score">1</span>
                    </StatusItem>
                </Status>
                <StatusItem>VS</StatusItem>
                <Status>
                    <StatusItem type="team">
                        <span className="score">2</span>
                        <span>Dodgers</span>
                    </StatusItem>
                    {/* {playerTeam && <IsPlayer />} */}
                    <IsPlayer>Player</IsPlayer>
                </Status>
            </StyledScoreStatus>
        )
    );
};

export default ScoreStatus;

// --- Styled Components ---
const StyledScoreStatus = styled.div`
    display: flex;
    justify-content: space-evenly;
    width: 95%;
    margin: 32px auto 16px;
`;

const Status = styled.div`
    width: inherit;
`;

const StatusItem = styled.div`
    width: inherit;
    display: flex;
    align-items: center;
    justify-content: ${({ type }) =>
        type === 'team' ? 'space-between' : 'center'};


    font-size: ${({ type, theme }) =>
        type === 'team' ? theme.fontSize.XXXXL : theme.fontSize.XXL};
    font-weight: ${({ type, theme }) =>
        type === 'team' ? theme.fontWeight.bold2 : theme.fontWeight.bold};
    color: ${({ type, theme }) =>
        type === 'team' ? theme.colors.white : theme.colors.gray3};

    .score {
        color: ${({ theme }) => theme.colors.gray5};
    }
`;

const IsPlayer = styled.p`
    font-size: ${({ theme }) => theme.fontSize.M};
    color: ${({ theme }) => theme.colors.red };
    text-align: center;

    ${StatusItem} + & {
        margin-top: 16px;
    }
`;