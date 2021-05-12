import styled from 'styled-components';
import ListTable from './partial/ListTable';
import PopupFrame from '../utilComponent/popupFrame/PopupFrame';

const PlayerListPopup = ({ visible }) => {

    const popupOptions = {
        zIndex: 10,
        isBottom: true,
        visible,
    };

    return (
        <PopupFrame options={popupOptions}>
            <StyledPlayerListPopup>
                <ListTable />
                <ListTable />
            </StyledPlayerListPopup>
        </PopupFrame>
    );
};

export default PlayerListPopup;

// --- Styled Components ---
// 나중에 z-index도 context + reducer 관리해야할듯
const StyledPlayerListPopup = styled.div`
    display: grid;
    grid-template-columns: repeat(2, 1fr);

    margin: 12px;
    border: 3px solid ${({ theme }) => theme.colors.white};
    background-color: ${({ theme }) => theme.colors.black1};

    table:nth-child(1) {
        border-right: 3px solid ${({ theme }) => theme.colors.white};
    }
`;
