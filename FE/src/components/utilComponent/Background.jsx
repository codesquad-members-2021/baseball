import styled from "styled-components";
import { cssFullAbsolutePosition, cssInheritSize } from "./CommonStyledCSS";

const Background = () => <StyledBackground />;
export default Background;

// --- Styled Components ---
const StyledBackground = styled.div`
    ${cssInheritSize};
    ${cssFullAbsolutePosition};
    z-index: 0;
    background-color: ${({ theme }) => theme.colors.black1};
    opacity: 0.7;
`;