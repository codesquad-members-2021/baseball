import { css } from 'styled-components';

const cssFlexAlignCenter = css`
    display: flex;
    justify-content: center;
    align-items: center;
`;

const cssScrollbar = css`
    height: inherit;
    overflow-y: scroll;

    &::-webkit-scrollbar {
        width: 10px;
    }
    &::-webkit-scrollbar-thumb {
        background-color: #01010180;
        border-radius: 4px;
        background-clip: padding-box;
        border: 1px solid transparent;
    }
    &::-webkit-scrollbar-track {
        background-color: #808080;
        border-radius: 10px;
        box-shadow: inset 0px 0px 5px #fff;
    }
`;

export { cssFlexAlignCenter, cssScrollbar };
