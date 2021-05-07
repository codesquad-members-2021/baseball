import React, {useState} from 'react';
import styled from 'styled-components';
const PlayCotainer = styled.div`
width: 100%;
height: 75%;
`;
const PitchBtn = styled.button`
    position:absolute;
    top: 60%;
    left: 35%;
    font-size:30px;
    margin-right: 20px;
`;
const SBOState = styled.div``;
const HorizonList = styled.ul`
display:felx;
`;
const StrikeView = styled(HorizonList)``;
const BallView = styled(HorizonList)``;
const OutView = styled(HorizonList)``;
const StrikeList = styled.li``;
const BallList = styled.li``;
const OutList = styled.li``;
const GroundBox = () => {
    const [pitchState, setPitchState] = useState(true);
    const ConvertPosition = () => {
        setPitchState(!pitchState);
    }
    const createPitchResult = () => {
        const pitchArr = ['Strike', 'Ball', 'Hits'];
        switch(pitchArr[Math.floor(Math.random()*pitchArr.length)]) {
            case 'Strike':
                console.log('s');
                return addStrike();
            case 'Ball':
                return console.log('b');
            case 'Hits':
                return console.log('H');
            default:
                throw new Error();
        }
        // pitchArr[]
    }
    const [strikeCnt, setStrikeCnt] = useState([]);
    const addStrike = () => {
        setStrikeCnt([...strikeCnt, {
            id: strikeCnt.length,
            value: 0
        }])

    }
    return (
        <PlayCotainer>
            <SBOState>
                <StrikeView>
                    <StrikeList>S</StrikeList>
                    {strikeCnt.map(item => (
                        <li key={item.id}>{item.value}</li>
                    ))}
                </StrikeView>
                <BallView>
                    <BallList>B</BallList>
                </BallView>
                <OutView>
                    <OutList>O</OutList>
                </OutView>
            </SBOState>
            {pitchState && <PitchBtn onClick={createPitchResult}>PITCH</PitchBtn> }

            <button onClick={ConvertPosition}>공수전환</button>
        </PlayCotainer>
    );
}

export default GroundBox;
