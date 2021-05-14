import styled from 'styled-components';

const ListTable = ({team}) => {
    const playerList = team.players;
    const allHit = playerList.reduce((acc,cur) => acc+cur.hits, 0);
    const allBat = playerList.reduce((acc,cur) => acc+cur.at_bat,0);
    const allOut = playerList.reduce((acc,cur) => acc+cur.out,0);
    console.log(playerList)
    return (
        <StyledListTable>
            <thead>
                <tr>
                    <th>타자</th>
                    <th>타석</th>
                    <th>안타</th>
                    <th>아웃</th>
                    <th>평균</th>
                </tr>
            </thead>

            <tbody>
                {playerList.map((_, i) => (
                    <tr key={i}>
                        <td>{_.name}</td>
                        {/* 타석 */}
                        <td>{_.at_bat}</td> 
                        {/* 안타 */}
                        <td>{_.hits}</td>
                        {/* 아웃 */}
                        <td>{_.out}</td>
                        <Average>{_.average.toFixed(2)}</Average>
                    </tr>
                ))}
            </tbody>

            <tfoot>
                <tr>
                    <th>Totals</th>
                    <th>{allBat}</th>
                    <th>{allHit}</th>
                    <th>{allOut}</th>
                    <th></th>
                </tr>
            </tfoot>
        </StyledListTable>
    );
};

export default ListTable;

// --- Styled Components ---
const StyledListTable = styled.table`
    font-size: ${({ theme }) => theme.fontSize.M};
    color: ${({ theme }) => theme.colors.white};
    width: 100%;

    th,
    td {
        padding: 20px 0;
        text-align: center;
        border-bottom: 3px solid ${({ theme }) => theme.colors.gray4};
    }

    thead tr th {
        color: ${({ theme }) => theme.colors.gray3};
        border-bottom: 3px solid ${({ theme }) => theme.colors.gray3};
    }

    tfoot tr th {
        border-bottom: none;
    }
`;

const Average = styled.td`

`;
