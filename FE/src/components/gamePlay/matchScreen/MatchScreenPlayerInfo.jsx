import styled from 'styled-components';

const MatchPlayerInfo = ({ type }) => {
    return (
        <StyledMatchPlayerInfo>
            <Position>{type === 'attack' ? '타자' : '투수'}</Position>
            <Info>
                <span className="name">{type === 'attack' ? '류현진' : '최동원'}</span>
                <span className="info">{type === 'attack' ? '1타석 0안타' : '#39'}</span>
            </Info>
        </StyledMatchPlayerInfo>
    );
};

export default MatchPlayerInfo;

// --- Styled Components ---
const StyledMatchPlayerInfo = styled.div``;

const Position = styled.p`
    font-size: ${({ theme }) => theme.fontSize.L};
    font-weight: ${({ theme }) => theme.fontWeight.bold2};
`;

const Info = styled.div`
    font-size: ${({ theme }) => theme.fontSize.S};
    font-weight: ${({ theme }) => theme.fontWeight.bold};

    ${Position} + & {
        margin-top: 16px;
    }

    .name {
        color: ${({ theme }) => theme.colors.gray5};
    }

    .info {
        color: ${({ theme }) => theme.colors.gray3};
    }

    span + span { margin-left: 16px; }
`;
