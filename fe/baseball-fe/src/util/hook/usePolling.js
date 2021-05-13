import { useState, useEffect } from 'react';

function usePolling({ URL, options = {}, delay = 1500, completeFn = () => false }) {
  const [intervalId, setIntervalId] = useState();
  const [response, setResponse] = useState();
  const [error, setError] = useState();
  const [isLoading, setIsLoading] = useState(false);
  const [polling, setPolling] = useState(false);

  const stopPolling = () => {
    if (intervalId) clearInterval(intervalId);
    setIntervalId(null);
    setIsLoading(false);
    setPolling(false);
  }

  useEffect(() => {
    if (polling === false) {
      stopPolling();
      return;
    }
    
    setIsLoading(true);

    const fetchData = async () => {
      try {
        const res = await fetch(URL, options);
        const json = await res.json();
        setResponse(json);
        
        if (completeFn(json))
          stopPolling();
      } catch (err) {
        console.error(err);
        setError(err);
        setPolling(false);
        setIsLoading(false);
      }
    }

    if (intervalId)
      return;

    const newIntervalId = setInterval(() => {
      fetchData();
      console.log('polling');
    }, delay)

    setIntervalId(newIntervalId);

    // const repeatFn = (setintervalId) => {
      

    //   const newTimeoutId = (() => {
    //     repeatFn(setTimeoutId);
    //   }, delay);

    //   setTimeoutId(newTimeoutId);
    //   console.log('polling');
    // }

    // repeatFn(setTimeoutId);

    return () => {
      if (newIntervalId) clearInterval(newIntervalId);
    }
  }, [polling]);

  return { response, error, isLoading, setPolling };
}

export default usePolling;