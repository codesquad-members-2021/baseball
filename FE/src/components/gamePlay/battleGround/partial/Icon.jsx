import { useContext } from 'react';
import styled from 'styled-components';
import { GamePlayContext } from '../../../utilComponent/context/GamePlayProvider';
// import { BattleGroundContext } from '../BattleGround';

const Icon = () => {
    // const { test } = useContext(GamePlayContext);
    const {
        gamePlayOptionsState: { ryanIconStatus },
    } = useContext(GamePlayContext);

    return ryanIconStatus && (
        <StadiumPlayer>
            {ryanIconStatus.map((v) => {
                return <Player key={v[1]} Player={v[0]} />;
            })}
        </StadiumPlayer>
    );
};

export default Icon;

const StadiumPlayer = styled.div`
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
    transition: all 1s ease-in-out;
`;
