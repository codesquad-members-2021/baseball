// 이 파일은 [7번타자 류현진] 이름과 [안타! 아웃!] 상태를 뜻함
import styled from "styled-components";

const SituationStatus = ({ type, player }) => {
    const { name, id } = player;
    return player && (
        <StyledSituationStatus>
            <Name type={type}>{id}번 타자 {name}</Name>
        </StyledSituationStatus>
    );
};

export default SituationStatus;

// --- Styled Components ---
const StyledSituationStatus = styled.div`
    margin: 8px 0;
    text-align: center;
`;

const Name = styled.p`
    color: ${({theme, type}) => (type === "now") ? theme.colors.red : theme.colors.gray4 };
`;

const Status = styled.p`
    color: ${({theme}) => theme.colors.gray3 };

    ${Name} + & {
        margin-top: 8px;
    }
`;