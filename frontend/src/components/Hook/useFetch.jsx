import { useState, useEffect } from 'react';
import API from './API';
function useFetch(method, type, value = null) {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  console.log(2, value);
  useEffect(() => {
    async function fetchUrl(value) {
      console.log(1, value);
      setLoading(true);
      try {
        const res = await API[method][type](value ? value : '');
        console.log('USE_FETCH', res);
        // axios({ url, method, code });
        setData(res);
      } catch (err) {
        setError(true);
        console.error('요청주소에 문제가 있어요😯', err.response);
        // if (error.response.status >= 400) {
        // 	setData(error.response.status);
        // 	;
        // }
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
  }, [value]);

  return [data, loading, error];
}
export default useFetch;
