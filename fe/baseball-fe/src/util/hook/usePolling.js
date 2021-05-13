import { useState, useEffect } from 'react';

function usePolling({ URL, options = {}, delay = 1000, completeFn = () => false }) {
  const [timeoutId, setTimeoutId] = useState();
  const [response, setResponse] = useState();
  const [error, setError] = useState();
  const [isLoading, setIsLoading] = useState(false);
  const [polling, setPolling] = useState(false);

  const stopPolling = () => {
    if (timeoutId) clearTimeout(timeoutId);
    setTimeoutId(null);
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

    const repeatFn = () => {
      fetchData();

      const newTimeoutId = setTimeout(() => {
        repeatFn();
      }, delay);

      setTimeoutId(newTimeoutId);
      console.log('polling');
    }

    repeatFn();
  }, [polling]);

  return { response, error, isLoading, setPolling };
}

export default usePolling;