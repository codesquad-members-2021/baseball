import React, { useContext } from 'react';
import { useEffect, useState } from 'react';

const HistoryContext = React.createContext();

export const Router = ({ children }) => {
  const [currentPath, setCurrentPath] = useState('/');
  const history = window.history;

  useEffect(() => {
    //popstate 이벤트 등록.  
    //setCurrentPath 실행
    window.addEventListener('popstate', e => {
      if (e.state !== null) {
        console.log(e.state)
        setCurrentPath(e.state.to)
      }
    });
  }, []);

  return (
    <HistoryContext.Provider value={{ history, currentPath, setCurrentPath }} >
      {children}
    </HistoryContext.Provider>
  );
};

export const Route = ({ path, children }) => {
  //useContext 를 사용해서 currentPath를 얻어오고 path와 일치하는치 확인 후 렌더링
  const { currentPath } = useContext(HistoryContext);
  console.log(path === currentPath)
  return (
    <>
      {path === currentPath && children}
    </>
  );
};


export const Link = ({ to, children }) => {
  //HistoryContext를 useContext 로 가져오기.
  //anchor 태그를 클릭하면, setCurrentPath 를 실행하고, pushState도 실행
  const { history, setCurrentPath } = useContext(HistoryContext);

  const handleClick = (e) => {
    e.preventDefault();
    setCurrentPath(to);
    history.pushState({ to }, '', to);
  };

  return (
    <a onClick={handleClick}>
      {children}
    </a>
  );
};

//Switch 있으나 마나~
export const Switch = (props) => {
  return (
    <>
      {props.children}
    </>
  );
};