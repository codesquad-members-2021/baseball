import styled from 'styled-components';
import { Span, theme } from '../Style/Theme';
import { useGameState } from '../GameContext';

const GamePlayersList = () => {
  const {
    state: { awayTeam, homeTeam },
  } = useGameState();

  const Contents = ({ team }) => {
    let totalPlateAppearances = 0;
    let totalHitCount = 0;
    let totalAvg = 0;

    return (
      <>
        {team.players.map(player => {
          totalPlateAppearances += player.plateAppearances;
          totalHitCount += player.hitCount;
          totalAvg += player.outCount;
          console.log(totalPlateAppearances, totalHitCount, totalAvg);
          return (
            <tr>
              <td>{player.name}</td>
              <td>{player.plateAppearances}</td>
              <td>{player.hitCount}</td>
              <td>{player.outCount}</td>
              <td>{player.avg}</td>
            </tr>
          );
        })}
        <tr>
          <td>Totals</td>
          <td>{totalPlateAppearances}</td>
          <td>{totalHitCount}</td>
          <td>{totalAvg}</td>
          <td></td>
        </tr>
      </>
    );
  };

  const Table = ({ children, teamName }) => {
    return (
      <table>
        <thead>
          <tr>
            <th colSpan={5}> {teamName}</th>
          </tr>
          <tr>
            <th>타자</th>
            <th>타석</th>
            <th>안타</th>
            <th>아웃</th>
            <th>평균</th>
          </tr>
        </thead>
        <tbody>{children}</tbody>
      </table>
    );
  };

  return (
    <DetailWrapper>
      <ContentsWrapper>
        <TableWrapper>
          <Table teamName={awayTeam.teamName}>
            <Contents team={awayTeam} />
          </Table>
        </TableWrapper>
        <TableWrapper>
          <Table teamName={homeTeam.teamName}>
            <Contents team={homeTeam} />
          </Table>
        </TableWrapper>
      </ContentsWrapper>
    </DetailWrapper>
  );
};

const DetailWrapper = styled.div`
  width: 100%;
  height: 60%;
  background-color: black;
  color: white;
  position: absolute;
  bottom: 0;
  z-index: 10000;
  box-sizing: border-box;
  display: flex;
`;
const TableWrapper = styled.table`
  margin: 40px;
  font-size: ${theme.fontSize.medium};
  th,
  td {
    border: 2px solid white;
    border-collapse: collapse;
    padding: 10px;
    text-align: center;
  }
`;

const ContentsWrapper = styled.div`
  width: 100%;
  display: flex;
  justify-content: center;
`;
export default GamePlayersList;
