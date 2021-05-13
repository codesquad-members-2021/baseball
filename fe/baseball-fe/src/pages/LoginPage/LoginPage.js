import styled from 'styled-components';
import { useState, useEffect, useContext } from 'react';
import { GlobalContext } from 'util/context.js';
import { GlobalAction } from 'util/action.js';
import API from 'util/API.js';

function LoginPage() {
  const { globalDispatch } = useContext(GlobalContext);
  const [id, setId] = useState('');

  const handleChange = (evt) => {
    setId(evt.target.value);
  }

  const handleClick = () => {
    // TODO: authentication logic

    globalDispatch({ type: GlobalAction.LOGIN, payload: { userId: id }});
  }

  return (
    <StyledLoginPage>
      <label>
        ID 
        <input type='text' value={id} onChange={handleChange}/>
      </label>
      <button onClick={handleClick}>Login</button>
    </StyledLoginPage>
  )
}

export default LoginPage;

const StyledLoginPage = styled.div`
  width: 100%;
  height: 100%;
  background-color: gray;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 1.5rem;

  &.login-false {
    background-color: #555555;
  }
  
  &:disabled {
    opacity: 0.7;
  }

  input, button {
    font-size: inherit;
    margin-left: 0.5rem;
  }

  input {
    width: 10rem;
    padding-left: 0.5rem;
  }
`;
