import styled from 'styled-components';

const ListTable = () => {
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
                {[...Array(9)].map((_, i) => (
                    <tr key={i}>
                        <td>김광진</td>
                        <td>1</td>
                        <td>1</td>
                        <td>0</td>
                        <td>1.000</td>
                    </tr>
                ))}
            </tbody>

            <tfoot>
                <tr>
                    <th>Totals</th>
                    <th>9</th>
                    <th>4</th>
                    <th>5</th>
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
