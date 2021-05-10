import React from 'react';
import styled from 'styled-components';

function PlayerListPopup() {
    return (
        <StyledPlayerListPopup>
            플레이어 리스트가 들어올 예정...
        </StyledPlayerListPopup>
    )
}

export default PlayerListPopup;

const StyledPlayerListPopup = styled.div`
    color: #fff;
    border: 3px solid #fff;
    height: 30rem;
`