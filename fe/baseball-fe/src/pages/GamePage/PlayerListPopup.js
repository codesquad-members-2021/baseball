import { useContext } from 'react';
import styled from 'styled-components';
import { GameContext } from 'util/context.js';
import tempData from './players.json';//임시로 json 데이터 받아옴. 삭제될 예정.

function PlayerListPopup() {
    const { gameState } = useContext(GameContext);
    console.log("gameState", gameState);
    const categories = ["타자", "타석", "안타", "아웃", "평균"];
    const awayPlayers = [...tempData.away.players];
    const homePlayers = [...tempData.home.players];

    const isCurrentPlayer = (playerId) => {
        const result = isCurrentBatter(playerId) || isCurrentPitcher(playerId);
        return result ? 'current-player' : '';
    }

    const isCurrentBatter = (playerId) => {
        return gameState.batter.id === playerId ? true : false;
    }

    const isCurrentPitcher = (playerId) => {
        return gameState.pitcher.id === playerId ? true : false;
    }

    return (
        <StyledPlayerListPopup>
            <div className="away-players">
                <div className="away-team-title">
                    {tempData.away.team_name}
                    <span className="current-playteam"></span>
                </div>
                <div className="categories">
                    {categories.map(category => <span>{category}</span>)}
                </div>
                <ul className="players-list">
                    {awayPlayers.map(player =>
                        <li className={`player ${isCurrentPlayer(Number(player.player_id))}`}>
                            <span>{player.player_name}</span>
                            <span>{player.at_bat}</span>
                            <span>{player.hit}</span>
                            <span>{player.out}</span>
                            <span>{player.average === "-" ? "-" : Number(player.average).toFixed(3)}</span>
                        </li>
                    )}
                    <li className="total">
                        <span>TOTAL</span>
                        <span>{awayPlayers.reduce((acc, player) => acc += Number(player.at_bat), 0)}</span>
                        <span>{awayPlayers.reduce((acc, player) => acc += Number(player.hit), 0)}</span>
                        <span>{awayPlayers.reduce((acc, player) => acc += Number(player.out), 0)}</span>
                        <span>{awayPlayers.reduce((acc, player) => acc += Number(player.at_bat) && Number(player.at_bat), 0).toFixed(3)}</span>
                    </li>
                </ul>
            </div>
            <div className="home-players">
                <div className="home-team-title">
                    {tempData.home.team_name}
                    <span className="current-playteam">&nbsp;Player</span>
                </div>
                <div className="categories">
                    {categories.map(category => <span>{category}</span>)}
                </div>
                <ul className="players-list">
                    {homePlayers.map(player =>
                        <li className={`player ${isCurrentPlayer(Number(player.player_id))}`}>
                            <span>{player.player_name}</span>
                            <span>{player.at_bat}</span>
                            <span>{player.hit}</span>
                            <span>{player.out}</span>
                            <span>{Number(player.average).toFixed(3)}</span>
                        </li>
                    )}
                     <li className="total">
                        <span>TOTAL</span>
                        <span>{homePlayers.reduce((acc, player) => acc += Number(player.at_bat), 0)}</span>
                        <span>{homePlayers.reduce((acc, player) => acc += Number(player.hit), 0)}</span>
                        <span>{homePlayers.reduce((acc, player) => acc += Number(player.out), 0)}</span>
                        <span>{homePlayers.reduce((acc, player) => acc += Number(player.at_bat) && Number(player.at_bat), 0).toFixed(3)}</span>
                    </li>
                </ul>
            </div>
        </StyledPlayerListPopup>
    )
}

export default PlayerListPopup;

const StyledPlayerListPopup = styled.div`
    color: #fff;
    border: 3px solid #fff;
    height: 30rem;

    .away-players,
    .home-players {
        display: inline-block;
        height: 100%;
        width: calc(100% / 2);
        &:after {
            background-color: #fff;
            content: '';
            position:absolute;
            width: 95%;
            height: 0.2rem;
            top: 6rem;
            left: 1.2rem;
        }
    }

    .away-players {
        border-right: 0.2rem solid white;

        .away-team-title {
            text-align: center;
            font-weight: 700;
            font-size: 2rem;

            &:after {
                background-color: #fff;
                content: '';
                position:absolute;
                width: 48%;
                height: 0.2rem;
                top: 3rem;
                left: 1.2rem;
            }

            .current-playteam {
                color: red;
                font-size: 1rem;
                width: 5rem;
            }
        }
    }

    .home-players {
        .home-team-title {
            text-align: center;
            font-weight: 700;
            font-size: 2rem;

            &:after {
                background-color: #fff;
                content: '';
                position:absolute;
                width: 47%;
                height: 0.2rem;
                top: 3rem;
                left: 25rem;
            }

            .current-playteam {
                color: red;
                font-size: 1rem;
                width: 5rem;
            }
        }
    }

    .categories {
        height: 3rem;
        text-align: center;
        display: grid;
        margin: 0 1rem;
        grid-template-columns: 2fr 1fr 1fr 1fr 1.5fr;

        & > span {
            padding-top: 1.5rem;
            font-size: 1.3rem;
            font-weight: 400;
            color: #a5a5a5;

        }

    }

    .players-list {
        padding: 0;

        & > li {
            display: grid;
            grid-template-columns: 2fr 1fr 1fr 1fr 1.5fr;
            margin: 0 1rem;
            text-align: center;
            font-size: 1.2rem;
            height: 2.2rem;
            list-style: none;
        }

        .current-player {
            color: red;
        }

        .player {
            & > span {
                padding-top: 0.3rem;
                border-bottom: 1px solid #a5a5a5;
            }
        }

        .total {
            font-weight: 700;

            & > span {
                padding-top: 0.5rem;
            }
        }
    }
`