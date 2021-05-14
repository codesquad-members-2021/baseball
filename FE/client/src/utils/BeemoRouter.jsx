import React, { useContext, useEffect, useState } from 'react';

const HistoryContext = React.createContext();

export default function BeemoRouter() {

  const { history, location: { pathname } } = window;
  const [currentPath, setCurrentPath] = useState(pathname);

  const Router = ({ children }) => {
    useEffect(() => {
      //popstate 이벤트 등록.  
      //setCurrentPath 실행
      window.addEventListener('popstate', e => {
        if (e.state !== null) {
          setCurrentPath(e.state.to);
        }
      });
    }, []);

    return (
      <HistoryContext.Provider value={{ history, currentPath, setCurrentPath }} >
        {children}
      </HistoryContext.Provider>
    );
  };

  const Route = ({ path, children }) => {
    //useContext 를 사용해서 currentPath를 얻어오고 path와 일치하는치 확인 후 렌더링
    const { currentPath } = useContext(HistoryContext);
    return (
      <>
        {path === currentPath && children}
      </>
    );
  };

  const Link = ({ to, children }) => {
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

  const push = (to) => {
    setCurrentPath(to);
    history.pushState({ to }, '', to);
  }

  //Switch 있으나 마나~
  const Switch = (props) => {
    return (
      <>
        {props.children}
      </>
    );
  };

  return {
    Router, Route, Link, Switch, push
  }
}