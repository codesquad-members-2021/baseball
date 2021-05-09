// 이 파일은 [5 | 스트라이크 | S2 | B3] 요론 아이템을 뜻함
import styled from 'styled-components';

const SituationRecord = () => {
    return (
        <StyledSituationRecord>
            {[...Array(5)].map((_, i) => (
                <Record>
                    <Num>{i+1}</Num>
                    <Name>{i % 2 === 0 ? '스트라이크' : '아웃'}</Name>
                    <Data>S1 B{i+1}</Data>
                </Record>
            ))}
        </StyledSituationRecord>
    );
};

export default SituationRecord;

// --- Styled Components ---
const StyledSituationRecord = styled.div`
    margin: 12px 0;
    display: flex;
    flex-direction: column-reverse;
`;

const Record = styled.div`
    display: flex;
    justify-content: space-between;
    font-size: ${({ theme }) => theme.fontSize.S};

    & + & {
        margin-bottom: 8px;
    }
`;

const Num = styled.span`
    display: flex;
    align-items: center;

    border-radius: 50%;
    background-color: ${({ theme }) => theme.colors.white};
    padding: 4px 8px;
    color: ${({ theme }) => theme.colors.black};
    font-size: ${({ theme }) => theme.fontSize.XS};
`;

const Name = styled.span``;

const Data = styled.span``;
