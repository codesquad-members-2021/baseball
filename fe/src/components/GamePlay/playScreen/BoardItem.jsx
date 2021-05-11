import styled from 'styled-components';

const BoardItem = () => {
  return (
    <Lists>
      {/* 상태관리 해야함 */}
      <Number>{1}</Number>
      <span>{'스트라이크'}</span>
      <span>
        S{1} B{0}
      </span>
    </Lists>
  );
};

export default BoardItem;

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
