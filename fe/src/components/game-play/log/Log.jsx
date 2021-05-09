import styled from 'styled-components';

const Log = (props) => {
  const team = props.data.home;
  const { member_list } = team;
  const log_list = member_list.map((member, i) => (
    <div className={'log ' + (member.state === true ? 'active' : '')} key={i}>
      <div className="title">{i + 1}번 타자 {member.name}</div>
      <div className="contents">
        <div className="content">
          <div>1</div>
          <div>볼</div>
          <div>S0 B1</div>
        </div>
        <div className="content">
          <div>2</div>
          <div>스트라이크</div>
          <div>S1 B1</div>
        </div>
        <div className="content">
          <div>3</div>
          <div>스트라이크</div>
          <div>S2 B1</div>
        </div>
        <div className="content result">
          <div></div>
          <div>안타!</div>
          <div></div>
        </div>
      </div>
    </div>
  ));
  return (
    <StyleLog>
      <div className="logs">
        {log_list}
      </div>
    </StyleLog>
  );
};

const StyleLog = styled.div`
  .logs {
    display: flex;
    flex-flow: column-reverse;
    .log:not(:first-child) {
      margin-bottom: 2.5rem;
    }
    font-size: 1.125rem;
  }
  .contents {
    display: flex;
    flex-flow: column-reverse;
  }
  .contents > div {
    margin-bottom: 0.75rem;
  }
  .title {
    color: #cff0f7;
    font-weight: 600;
    margin-bottom: 1rem;
  }
  .content {
    display: grid;
    grid-template-columns: 1.25rem 3fr 1fr;
    text-align: center;
    margin-bottom: 0.5rem;
    *:nth-child(1) {
      color: #000;
      background-color: #f1f1f1;
      border-radius: 50%;
    }
    *:nth-child(2) {
      color: #f1f1f1;
      font-weight: 600;
    }
    *:nth-child(3) {
      color: #aaa;
      font-weight: 600;
    }
  }
  .content.result {
    *:nth-child(1) {
      background-color: transparent;
    }
    *:nth-child(2) {
      color: #79b5ce;
    }
  }
  .active {
    .title {
      color: #ff7878;
    }
    .content.result > * {
      color: #ff4545;
    }
  }
  
`;

export default Log;