import React from 'react';
import styled from 'styled-components';

function ScorePopup() {
    return (
        <StyledScorePopup>
            점수판 들어올 예정...
        </StyledScorePopup>
    )
}

export default ScorePopup;

const StyledScorePopup = styled.div`
    color: #fff;
    border: 3px solid #fff;
    height: 10rem;
`