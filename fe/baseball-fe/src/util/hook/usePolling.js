import { useState, useEffect } from 'react';

function usePolling({ URL, options = {}, delay, completeFn }) {
  const [timeoutId, setTimeoutId] = useState();
  const [response, setResponse] = useState();
  const [error, setError] = useState();
  const [isLoading, setIsLoading] = useState(false);
  const [polling, setPolling] = useState(false);

  useEffect(() => {
    if (!polling) {
      if (timeoutId) clearTimeout(timeoutId);
      setTimeoutId(null);
      setIsLoading(false);
      return;
    }
    
    setIsLoading(true);

    const fetchData = async () => {
      try {
        const res = await fetch(URL, options);
        const json = await res.json();
        setResponse(json);
        
        if (completeFn(json) && timeoutId) {
          clearTimeout(timeoutId);
          setTimeoutId(null);
          setIsLoading(false);
        }
      } catch (err) {
        setError(err);
        setIsLoading(false);
      }
    }

    const repeatFn = () => {
      fetchData();

      const newTimeoutId = setTimeout(() => {
        repeatFn();
      }, delay);

      setTimeoutId(newTimeoutId);
    }

    repeatFn();
  }, [polling]);

  return { response, error, isLoading, setPolling };
}

export default usePolling;