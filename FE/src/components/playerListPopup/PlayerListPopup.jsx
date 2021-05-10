import styled from 'styled-components';
import ListTable from './partial/ListTable';
import OpacityBackground from "../utilComponent/OpacityBackground";
import { cssFullAbsolutePosition } from '../utilComponent/CommonStyledCSS';

const PlayerListPopup = () => {
    return (
        <>
            <OpacityBackground zIndex={10}/>
            <StyledPlayerListPopup>
                <ListWrapper>
                    <ListTable />
                    <ListTable />
                </ListWrapper>
            </StyledPlayerListPopup>
        </>
    );
};

export default PlayerListPopup;

// --- Styled Components ---
    // 나중에 z-index도 context + reducer 관리해야할듯
const StyledPlayerListPopup = styled.div`
    ${cssFullAbsolutePosition};
    top: auto;
    z-index: 10;
`;

const ListWrapper = styled.div`
    display: grid;
    grid-template-columns: repeat(2, 1fr);

    margin: 12px;
    border: 3px solid ${({ theme }) => theme.colors.white};
    background-color: ${({ theme }) => theme.colors.black1};

    table:nth-child(1) {
        border-right: 3px solid ${ ({ theme }) => theme.colors.white };
    }
`;