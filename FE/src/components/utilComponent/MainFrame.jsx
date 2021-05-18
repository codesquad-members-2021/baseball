import styled from "styled-components";
import { cssFullAbsolutePosition, cssInheritSize } from "./CommonStyledCSS";

const MainFrame = ({children, ...props}) => {
    return (
        <StyledMainFrame {...props}>
            {children}
        </StyledMainFrame>
    )
};

export default MainFrame;

// --- Styled Components ---
const StyledMainFrame = styled.div`
    ${cssInheritSize};
    ${cssFullAbsolutePosition};
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 10;
`;