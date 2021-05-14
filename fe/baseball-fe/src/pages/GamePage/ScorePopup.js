import { useContext } from 'react';
import styled from 'styled-components';
import { GameContext } from 'util/context.js';

//Gameid/score 로 요청하면 score가 올 예정
function ScorePopup() {
    const { gameState } = useContext(GameContext);
    const totalRound = Array(12).fill(0).map((el, i) => el + (i + 1));
    console.log("GameState", gameState)

    return (
        <StyledScorePopup>
           <div className="innings">
                {totalRound.map(num => <div>{num}</div>)}
                <div>R</div>
           </div>
           <div className="score-container">
                <div className="team-names">
                    <div>
                        <span>{gameState.away.mode === "BATTING" && "⚾️"}</span>
                        <span className="team-name">{gameState.away.name}</span>
                        <div className="curr-player">{gameState.mode === gameState.away.mode && "Player"}</div>
                    </div>
                    <div>
                        <span>{gameState.home.mode === "BATTING" && "⚾️"}</span>
                        <span className="team-name">{gameState.home.name}</span>
                        <div className="curr-player">{gameState.mode === gameState.home.mode && "Player"}</div>
                    </div>
                </div>
                <div className="inning-scores">
                    <div>{[1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0].map(score => <div>{score}</div>)}</div>
                    <div>{[1, 2, 3, 1, 2, 1, 3, 0, 0, 0, 1, 2].map(score => <div>{score}</div>)}</div>
                </div>
                <div className="total-score">
                    <div>{gameState.away.score}</div>
                    <div>{gameState.home.score}</div>
                </div>
           </div>
        </StyledScorePopup>
    )
}

export default ScorePopup;

const StyledScorePopup = styled.div`
    color: #fff;
    font-weight: 700;
    font-size: 1.5rem;
    border: 3px solid #fff;
    height: 15rem;
    text-align: center;

    .innings {
        margin: 2rem 0rem 1rem 3.5rem;
        position: relative;
        &:after {
            background-color: #fff;
            content: '';
            position:absolute;
            top: 3rem;
            left: 5rem;
            width: 80%;
            height: 0.2rem;
        }
        & > * {
            display: inline-block;
            /* margin: 0.8rem; */
            width: 2.73rem;
        }
    }

    .score-container {
        padding-top: 1rem;
        display: flex;
        & > div {
            display: inline-block;
        }

        .team-names {
            width: 8rem;
            font-size: 1.3rem;
            font-weight: 500;
            & > div {
                margin: 1rem 0.5rem;
                text-align: right;

                .curr-player {
                    color: #d63031;
                    font-size: 1rem;
                }
            }

            .team-name {
                margin-left: 0.5rem;
                width: 5rem;
            }
        }

        .inning-scores {
            width: 33rem;
            margin-left: 0.7rem;
            & > div {
                margin: 1rem 0;
                & > * {
                    display: inline-block;
                    width: 2.73rem;
                }
            }
        }

        .total-score {
            color: #d63031;
            & > div {
                margin: 1rem 0;
                width: 2.73rem;
            }
        }
    }
`