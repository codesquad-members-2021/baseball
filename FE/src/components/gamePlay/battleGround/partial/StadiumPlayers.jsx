import { useContext } from 'react';
import styled from 'styled-components';
import { GamePlayContext } from '../../../utilComponent/context/GamePlayProvider';

const StadiumPlayers = () => {
    const {
        gamePlayOptionsState: { ryanIconStatus },
    } = useContext(GamePlayContext);

    return ryanIconStatus && (
        <StyledStadiumPlayers>
            {ryanIconStatus.map((v) => {
                return <Player key={v[1]} Player={v[0]} />;
            })}
        </StyledStadiumPlayers>
    );
};

export default StadiumPlayers;

const StyledStadiumPlayers = styled.div`
    width: 100%;
    height: inherit;
`;

const PlayerLocation = [
    { Player: 0, left: `40%`, top: `80%` },
    { Player: 1, left: `84%`, top: `38%` },
    { Player: 2, left: `40%`, top: `-5%` },
    { Player: 3, left: `-3%`, top: `38%` },
    { Player: 4, left: `40%`, top: `80%` },
];

const Player = styled.div.attrs(({ Player }) => ({
    style: PlayerLocation[Player],
}))`
    visibility: ${({ Player }) =>
        Player % 4 === 0 || Player > 4 ? 'hidden' : 'visible'};
    z-index: 8;
    position: absolute;
    width: 100px;
    height: 100px;
    background-image: url('/images/라이언.gif');
    background-size: contain;
    transition: all 1s ease-in-out, transform 0s ease-in-out;
    transform: ${({Player}) => Player === 0 ? `rotate(0deg)` : Player === 1 ? `rotate(45deg)` : Player === 2 ? `rotate(0deg)` : Player === 3 ? `rotate(-45deg)` :  Player === 4 ? `rotate(-45deg)` : null};
`;
