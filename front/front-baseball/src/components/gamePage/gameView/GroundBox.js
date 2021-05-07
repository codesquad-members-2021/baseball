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
list-style: none;
display:felx;
/* font-size: 20px; */
`;
const StrikeView = styled(HorizonList)`
/* font-size: 20px; */
`;
const BallView = styled(HorizonList)``;
const OutView = styled(HorizonList)``;
const StrikeList = styled.li`
/* padding: 10px; */
font-size: 40px;
`;
const BallList = styled.li`
/* padding: 10px; */
font-size: 40px;
`;
const OutList = styled.li`
/* padding: 10px; */
font-size: 40px;
`;
const StrikeCircle = styled.div`
width:50px;
height:50px;
border-radius:50%;
background-color:yellow;
padding: 10 0px;
`;
const BallCircle = styled.div`
width:50px;
height:50px;
border-radius:50%;
background-color:green;
padding: 0 10px;
`;
const OutCircle = styled.div`
width:50px;
height:50px;
border-radius:50%;
background-color:red;
padding: 0 10px;
`;
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
                return addBall();
            case 'Hits':
                return console.log('H');
            default:
                throw new Error();
        }
        // pitchArr[]
    }
    const [strikeCnt, setStrikeCnt] = useState([]);
    const [ballCnt, setBallCnt] = useState([]);
    const [outCnt, setOutCnt] = useState([]);
    const addStrike = () => {
        if(strikeCnt.length > 2) return;
        setStrikeCnt([...strikeCnt, {
            id: strikeCnt.length,
            value: 0
        }])
        console.log(strikeCnt);
        if(strikeCnt.length === 2) {
            setTimeout(() => {
                setBallCnt([]);
                setStrikeCnt([]);
                return addOut();
            }, 2000);
        }
    }
    const addOut = () => {
        if(outCnt.length > 2) return;
        setOutCnt([...outCnt, {
            id: outCnt.length,
            value: 0
        }])
        if(outCnt.length === 2) {
            console.log('공수전환');
            setTimeout(() => {
                setOutCnt([]);
                return;
            }, 2000)
        }
    }
    const addBall = () => {
        if(ballCnt.length > 3) return;
        setBallCnt([...ballCnt, {
            id: ballCnt.length,
            value: 0
        }])
        if(ballCnt.length === 3) {
            console.log('4볼');
            setTimeout(() => {
                setStrikeCnt([]);
                setBallCnt([]);
                return;
            }, 2000)
        }
    }
    return (
        <PlayCotainer>
            <SBOState>
                <StrikeView>
                    <StrikeList>S</StrikeList>
                    {strikeCnt.map(item => (
                        <li key={item.id}><StrikeCircle></StrikeCircle></li>
                    ))}
                </StrikeView>
                <BallView>
                    <BallList>B</BallList>
                    {ballCnt.map(item => (
                        <li key={item.id}><BallCircle></BallCircle></li>
                    ))}
                </BallView>
                <OutView>
                    <OutList>O</OutList>
                    {outCnt.map(item => (
                        <li key={item.id}><OutCircle></OutCircle></li>
                    ))}
                </OutView>
            </SBOState>
            {pitchState && <PitchBtn onClick={createPitchResult}>PITCH</PitchBtn> }

            <button onClick={ConvertPosition}>공수전환</button>
        </PlayCotainer>
    );
}

export default GroundBox;
