import styled, { css } from 'styled-components';

const SBO = () => {
    return (
        <StyledSBO>
            <SBOList type="strike">
                {[...Array(3)].map((_, i) => (<span key={i} />))}
            </SBOList>
            <SBOList type="ball">
                {[...Array(3)].map((_, i) => (<span key={i} />))}
            </SBOList>
            <SBOList type="out">
                {[...Array(3)].map((_, i) => (<span key={i} />))}
            </SBOList>
        </StyledSBO>
    );
};

export default SBO;

// --- Styled Components ---
const StyledSBO = styled.ul`
    font-size: ${({ theme }) => theme.fontSize.XL};
    font-weight: ${({ theme }) => theme.fontWeight.bold};
`;

const SBOList = styled.li`
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    align-items: center;
    &:before {
        ${({ type }) => {
            switch (type) {
                case 'strike':
                    return css`
                        content: 'S';
                    `;
                case 'ball':
                    return css`
                        content: 'B';
                    `;
                case 'out':
                    return css`
                        content: 'O';
                    `;
                default:
                    break;
            }
        }};
    }

    span {
        display: inline-block;
        width: 24px;
        height: 24px;
        border: 1px solid transparent;
        border-radius: 50%;
        background-color: ${({ type, theme }) =>
            type === 'strike'
                ? theme.colors.yellow
                : type === 'ball'
                ? theme.colors.green
                : theme.colors.red};
        margin-left: 4px;
    }
`;