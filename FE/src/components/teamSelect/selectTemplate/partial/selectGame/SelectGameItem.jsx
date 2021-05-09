import styled, {css} from 'styled-components';
import {Link} from "react-router-dom";

const SelectGameItem = ({ home, away, idx, to}) => {
    return home && away && (
        <StyledSelectGameItem>
            <SelectGameLink to = {to}>
                <GameNumParagraph>Game {idx}</GameNumParagraph>
                <TeamInfo>
                    <TeamInfoSpan type="team">{away}</TeamInfoSpan> 
                    <TeamInfoSpan>VS</TeamInfoSpan>
                    <TeamInfoSpan type="team">{home}</TeamInfoSpan>
                </TeamInfo>
            </SelectGameLink>
        </StyledSelectGameItem>
    );
};

export default SelectGameItem;

// --- Styled Components ---
const StyledSelectGameItem = styled.li`
    border-radius: 16px;
    padding: 12px;
    background-color: ${({ theme }) => theme.colors.gray4};
    cursor: pointer;

    & + & {
        margin-top: 20px;
    }
`;

const SelectGameLink = styled(Link)`
    text-decoration: none;
`;

const GameNumParagraph = styled.p`
    text-align: center;
    color: ${({theme}) => theme.colors.red};
    font-weight: ${({theme}) => theme.fontWeight.bold};
    font-size: ${({theme}) => theme.fontSize.L};
`;

// TeamInfo
const TeamInfo = styled.div`
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    align-items: center;
    ${GameNumParagraph} + & {
        margin-top: 20px;
    }
`;

const TeamInfoSpan = styled.span`
    font-size: ${({type, theme}) => (type === 'team') ? theme.fontSize.XXL : theme.fontSize.XL};
    font-weight: ${({type, theme}) => (type === 'team') ? theme.fontWeight.bold2 : theme.fontWeight.bold};
    color: ${({type, theme}) => (type === 'team') ? theme.colors.black1 : theme.colors.gray3};

    ${({ type }) =>
        type === 'team' &&
        css`
            &:hover {
                color: ${({ theme }) => theme.colors.red};
            }
        `};
`;