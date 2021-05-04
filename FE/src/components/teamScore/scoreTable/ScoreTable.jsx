import React,{} from 'react'
import styled from 'styled-components'

const ScoreTable = () => {
    // score가 배열로 넘어올지... 뭘로 넘어올지..
    // team별 배열로 넘어오면 
    let round = [1,2,3,4,5,6,7,8,9,10,11,12,"R"];
    // let {home,away} = teamInformatin

    
    return (
        <Table>
            <tbody>
                <tr>
                    {round.map(v => {return <TableRound key={v}>{v}</TableRound>})}
                </tr>
                <tr>home score.map</tr>
                <tr>away score.map</tr>
            </tbody>
        </Table>
    )
}

const Table = styled.table`
`;
const TableRound = styled.th`
    padding: 0 15px;
    border-bottom:1px solid white;
`;

export default ScoreTable