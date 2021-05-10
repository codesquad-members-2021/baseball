import styled from "styled-components";
import { cssOpacityBackground } from './CommonStyledCSS';

const OpacityBackground = ({zIndex}) => (<StyledOpacityBackground zIndex={zIndex} />);

export default OpacityBackground;

// --- Styled Components ---

const StyledOpacityBackground = styled.div`
    ${cssOpacityBackground};
    z-index: ${({zIndex}) => zIndex || 0};
`;