import styled from 'styled-components';

const BoardItemHistory = ({ B, S, idx, type, playerName }) => {
  if (type == '안타' || type === '아웃') return null;
  return (
    <Lists>
      <Number>{idx + 1}</Number>
      <span>{type}</span>
      <span>
        S{S} B{B}
      </span>
    </Lists>
  );
};

export default BoardItemHistory;

const Lists = styled.li`
  display: flex;
`;

const Number = styled.div`
  background-color: ${({ theme }) => theme.colors.white};
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 50%;
  width: 1.5rem;
  height: 1.5rem;
  color: ${({ theme }) => theme.colors.black};
`;
