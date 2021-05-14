import { useState, useEffect } from 'react';

function useFetch(url, options) {
  const [response, setResponse] = useState();
  const [error, setError] = useState();
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setIsLoading(true);

      try {
        const res = await fetch(url, options);
        const json = await res.json();
        setResponse(json);
        setIsLoading(false)
      } catch (error) {
        setError(error);
      }
    }

    fetchData();
  }, []);

  return { response, error, isLoading };
};

export default useFetch;