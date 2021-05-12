import styled from 'styled-components';
import { useEffect, useContext } from "react"
import { PostsContext } from "../GamePlay";

const ScoreStatus = ({ data = true}) => {
    const { team } = useContext(PostsContext);
    const options = {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({"user" : team.home, "opponent" : team.away})
    }
    const fetchData = async (url) => {
        const res = await fetch(url, options);
        const result = await res.json();
        console.log(result)
        return result;
    };
    useEffect(() => {
        console.log("fetch요청 갔다!")
        fetchData("/api/games/type-away");
    }, [])

    return (
        data && (
            <StyledScoreStatus>
                <Status>
                    <StatusItem type="team">
                        <span>{team.away}</span>
                        <span className="score">1</span>
                    </StatusItem>
                </Status>
                <Versus>VS</Versus>
                <Status>
                    <StatusItem type="team">
                        <span className="score">2</span>
                        <span>{team.home}</span>
                    </StatusItem>
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
    margin: 24px 32px;
`;

const Status = styled.div`
    text-align: center;
    height: 100%;
`;

const Versus = styled.div`
    font-size: ${({ theme }) => theme.fontSize.XXXL};
    font-weight: ${({ theme }) => theme.fontWeight.bold};
    color: ${({ theme }) => theme.colors.gray5};
    margin: auto 0;
`;

const StatusItem = styled.div`
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    align-items: center;
    justify-content: space-between;

    font-size: ${({ theme }) => theme.fontSize.XL};
    font-weight: ${({ theme }) => theme.fontWeight.bold2};

    color: ${({ theme }) => theme.colors.white};
    .score {
        font-size: ${({ theme }) => theme.fontSize.XXXXL};
        color: ${({ theme }) => theme.colors.gray4};
    }
`;

const IsPlayer = styled.p`
    font-size: ${({ theme }) => theme.fontSize.L};
    font-weight: ${({ theme }) => theme.fontWeight.bold};
    color: ${({ theme }) => theme.colors.red};
    text-align:right;
    padding-right:55px;

    ${StatusItem} + & {
        margin-top: 16px;
    }
`;
