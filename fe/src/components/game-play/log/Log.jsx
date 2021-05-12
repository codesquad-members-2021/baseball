import styled from 'styled-components';

const TYPE = {
  'strike': '스트라이크',
  'ball': '볼',
  'safety': '안타',
  '4ball': '볼넷',
  'out': '아웃',
}

const Log = ({ logList }) => {
  const logs = logList.map((member, i) => (
    member.history.length > 0 &&
    <div className={'log ' + (member.state === true ? 'active' : '')} key={i}>
      <div className="title">{member.index}번 타자 {member.name}</div>
      <div className="contents">
        { member.history.map((v, i) => 
          v.end 
          ?
          <div className="content result">
            <div></div>
            <div>{TYPE[v.type]}!</div>
            <div></div>
          </div>
          :
          <div className="content">
            <div>{i + 1}</div>
            <div>{TYPE[v.type]}</div>
            <div>S{v.strike} B{v.ball}</div>
          </div>
        )}
      </div>
    </div>
  ));
  return (
    <StyledLog>
      <div className="logs">
        {logs}
      </div>
    </StyledLog>
  );
};

const StyledLog = styled.div`
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