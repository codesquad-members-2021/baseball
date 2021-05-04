import styled, {css} from 'styled-components';

const SelectGameItem = ({ home, away, idx }) => {
    return home && away && (
        <StyledSelectGameItem>
            <GameNumParagraph>Game {idx}</GameNumParagraph>
            <TeamInfo>
                <TeamInfoSpan type="team">{away}</TeamInfoSpan> 
                <TeamInfoSpan>VS</TeamInfoSpan>
                <TeamInfoSpan type="team">{home}</TeamInfoSpan>
            </TeamInfo>
        </StyledSelectGameItem>
    );
};

export default SelectGameItem;

// --- Styled Components ---
const StyledSelectGameItem = styled.li`
    border-radius: 16px;
    padding: 24px;
    background-color: ${({ theme }) => theme.colors.gray4};
    cursor: pointer;

    & + & {
        margin-top: 20px;
    }
`;

const GameNumParagraph = styled.p`
    text-align: center;
    color: ${({theme}) => theme.colors.red};
    font-weight: ${({theme}) => theme.fontWeight.bold};
    font-size: ${({theme}) => theme.fontSize.XL};
`;

const TeamInfo = styled.div`
    display: flex;
    justify-content: space-around;
    align-items: center;
    ${GameNumParagraph} + & {
        margin-top: 20px;
    }
`;

const TeamInfoSpan = styled.span`
    font-size: ${({type, theme}) => (type === 'team') ? theme.fontSize.XXXL : theme.fontSize.XXL};
    font-weight: ${({type, theme}) => (type === 'team') ? theme.fontWeight.bold2 : theme.fontWeight.bold};
    color: ${({type, theme}) => (type === 'team') ? theme.colors.black : theme.colors.gray3};

    ${({ type }) =>
        type === 'team' &&
        css`
            &:hover {
                color: ${({ theme }) => theme.colors.red};
            }
        `};
`;