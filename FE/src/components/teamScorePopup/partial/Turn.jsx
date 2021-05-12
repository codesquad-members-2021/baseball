// -- 미사용
import styled from 'styled-components';

const Turn = () => {
    // 자신의 팀이 공격이라는 것을 알려주는 props로 받기
    // 경기를 하는 두개의 팀 이름을 props로 받기
    // 임시로 만든 팀
    let team = ['Rano', 'Pengdori'];
    return (
        <TurnIcon>
            <Icon>⚾️</Icon>
            <TeamName>
                {team.map((v) => (<Name key={v}>{v}</Name>))}
            </TeamName>
        </TurnIcon>
    );
};
export default Turn;

// --- Styled Components ---
const Name = styled.div``;
const TeamName = styled.div`
    position: absolute;
    right: 10px;
    // after 로 props 받아서 player 적어주기
`;
const Icon = styled.div`
    position: absolute;
    left: 0;
`;
const TurnIcon = styled.div`
    position: relative;
    top: 40px;
    width: 140px;
    height: 50px;
`;
