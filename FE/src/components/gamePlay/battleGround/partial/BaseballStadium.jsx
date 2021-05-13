import styled from "styled-components";
import Icon from "./Icon";

const BaseballStadium = () => (
    <StyledBaseballStadium>
        <Icon />
        <svg
            width="527"
            height="535"
            viewBox="0 0 527 535"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
        >
            {/* 홈 */}
            <rect
                x="235"
                y="478.284"
                width="40"
                height="40"
                transform="rotate(-45 235 478.284)"
                fill="white"
            />
            {/* 3루 */}
            <rect
                y="263.355"
                width="50"
                height="50"
                transform="rotate(-45 0 263.355)"
                fill="white"
            />
            {/* 2루 */}
            <rect
                x="228"
                y="35.3553"
                width="50"
                height="50"
                transform="rotate(-45 228 35.3553)"
                fill="white"
            />
            {/* 1루 */}
            <rect
                x="456"
                y="263.355"
                width="50"
                height="50"
                transform="rotate(-45 456 263.355)"
                fill="white"
            />
            <line
                x1="263.354"
                y1="35.3536"
                x2="35.3535"
                y2="263.354"
                stroke="white"
            />
            <line
                x1="490.646"
                y1="263.354"
                x2="262.646"
                y2="35.3535"
                stroke="white"
            />
            <line
                x1="35.343"
                y1="262.636"
                x2="263.343"
                y2="477.636"
                stroke="white"
            />
            <line
                x1="262.657"
                y1="477.636"
                x2="490.657"
                y2="262.636"
                stroke="white"
            />
            {/* 홈-2 (정사각형) */}
            <rect x="234" y="478" width="57" height="57" fill="white" />
        </svg>
    </StyledBaseballStadium>
);

export default BaseballStadium;

// --- Styled Components ---
const StyledBaseballStadium = styled.div`
    position:absolute;
    z-index:-1;
    /* left: 18%;
    top:2%;
    margin: auto 0;
    height: inherit; */
`;