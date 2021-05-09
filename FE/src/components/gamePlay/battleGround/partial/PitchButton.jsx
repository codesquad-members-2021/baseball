import styled from 'styled-components';
import { cssTranslate } from '../../../utilComponent/CommonStyledCSS';

const PitchButton = () => {
    return (
        <StyledPitchButton onClick={() => alert('PitchButton (임시)')}>
            PITCH
        </StyledPitchButton>
    );
};

export default PitchButton;

// --- Styled Components ---
const StyledPitchButton = styled.button`
    ${cssTranslate};
    cursor: pointer;
    padding: 12px 24px;
    color: ${({theme}) => theme.colors.white};
    font-size: ${({theme}) => theme.fontSize.XXXL};
    font-weight: ${({theme}) => theme.fontWeight.bold};
    background-color: ${({theme}) => theme.colors.black1};
    border: 2px solid ${({theme}) => theme.colors.white};
    border-radius: 4px;

    &:hover {
        background-color: ${({theme}) => theme.colors.black2 };
    }
`;