import { css } from 'styled-components';

const cssFlexAlignCenter = css`
    display: flex;
    justify-content: center;
    align-items: center;
`;

const cssFullAbsolutePosition = css`
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
`;

const cssTranslate = css`
    background-color: transparent;
    background-repeat: no-repeat;
    overflow: hidden;
    outline: none;
    border: none;
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

// cssOpacityBackground, 전체화면을 약간 투명한 검은색으로 변경
const cssOpacityBackground = css`
    ${cssFullAbsolutePosition};
    ${cssFlexAlignCenter};
    height: inherit;
    background-color: #010101e8;
`;


export { cssFlexAlignCenter, cssFullAbsolutePosition, cssTranslate, cssScrollbar, cssOpacityBackground };