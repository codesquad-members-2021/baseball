import { useEffect, useState } from 'react';

const useFetch = (url, method, value) => {
  const [data, setData] = useState(null);

  const fetchData = async (url, method, value) => {
    try {
      if (method === 'get') {
        const res = await fetch(url);
        const data = await res.json();
        setData(data);
      } else if (method === 'put') {
        const res = await fetch(url, {
          method: 'put',
          headers: '',
        });
      }
    } catch (err) {
      console.log(err);
    }
  };

  useEffect(() => {
    fetchData(url, method, value);
  }, []);

  return { data };
};

export default useFetch;
