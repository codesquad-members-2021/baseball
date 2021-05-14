import styled, { css } from 'styled-components';

const BaseballIcon = () => (<StyledBaseballIcon>⚾️</StyledBaseballIcon>);
const ScoreTable = () => {
    return (
        <StyledScoreTable>

            <Table type={"turn"}>
                <thead><tr><th>{/* 공백 */}</th></tr></thead>
                <tbody>
                    <tr>
                        <td>
                            {true && <BaseballIcon />}
                            <span className="team__name">Rano</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            {false && <BaseballIcon />}
                            <span className="team__name">Pengdori</span>
                        </td>
                    </tr>
                </tbody>
            </Table>
            <Table cellLength={12}>
                <thead>
                    <tr>{[...Array(12)].map((_, idx) => (<th key={idx}>{idx + 1}</th>))}</tr>
                </thead>
                <tbody>
                    <tr>{[...Array(5)].map((_, idx) => ( <td key={idx}>{0}</td> ))}</tr>
                    <tr>{[...Array(8)].map((_, idx) => ( <td key={idx}>{0}</td> ))}</tr>
                </tbody>
            </Table>
            <Table type={"round"}>
                <thead>
                    <tr><th>R</th></tr>
                </thead>
                <tbody>
                    <tr><td>{0}</td></tr>
                    <tr><td>{0}</td></tr>
                </tbody>
            </Table>
        </StyledScoreTable>
    );
};

export default ScoreTable;

// --- Styled Components ---

// [1] BaseballIcon
const StyledBaseballIcon = styled.span`

`;

// [2] ScoreTable
const StyledScoreTable = styled.div`
    display: grid;
    grid-template-columns: 15% 80% 5%;
    margin: 12px;
    border: 3px solid ${({ theme }) => theme.colors.white};
    background-color: ${({ theme }) => theme.colors.black1};
`;

const Table = styled.table`
    font-size: ${({ theme }) => theme.fontSize.M};
    color: ${({ theme }) => theme.colors.white};
    border-left: 3px solid ${({ theme }) => theme.colors.white};

    th, td {
        padding: 12px 0;
        text-align: center;
        width: ${({ cellLength }) => cellLength ? `calc(100% / ${cellLength} )` : "100%"};
    }

    thead tr th {
        border-bottom: 2px solid ${({ theme }) => theme.colors.white};

        &:last-child {
            border-right: none;
        }
    }

    ${({ theme, type }) =>
        type === "round" &&
        css`
            tbody tr td {
                font-weight: ${theme.fontWeight.bold};
                color: ${theme.colors.red};
            }
        `};

    ${({ theme, type }) =>
        type === "turn" &&
        css`
            border-left: none;
            thead tr th:first-child {
                height: ${theme.fontSize.L};
                border-bottom: none;
            }
            tbody tr td {
                font-weight: ${theme.fontWeight.bold};
                text-align: right;
                padding-right: 14px;

                .team__name {
                    width: 100%;
                    border-bottom: 1px solid ${theme.colors.red};// player일 때 밑줄 쫙!
                }
            }
            font-size: ${theme.fontSize.S};
        `};
`;