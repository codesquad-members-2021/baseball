import { useState, useEffect } from 'react';
import API from './API';
function useFetch(method, type, value = null) {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);

  useEffect(() => {
    async function fetchUrl() {
      setLoading(true);
      try {
        const res = await API[method][type](value ? value : '');
        setError(false);
        setData(res);
      } catch (err) {
        setError(true);
        console.error('요청주소에 문제가 있어요😯', err.response);
      } finally {
        setLoading(false);
      }
    }
    fetchUrl();
    return () => {
      setData([]);
      setLoading(true);
      setError(false);
    };
  }, []);

  return [data, loading, error];
}
export default useFetch;
