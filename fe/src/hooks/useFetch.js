import { useEffect, useState } from 'react';

const useFetch = (url, method) => {
  const [data, setData] = useState(null);

  const fetchData = async (url, method) => {
    try {
      if (method === 'get') {
        const res = await fetch(url);
        const data = await res.json();
        setData(data);
      }
    } catch (err) {
      console.log(err);
    }
  };

  useEffect(() => {
    if (method === 'get') {
      fetchData(url, method);
    }
  }, []);

  return { data };
};

export default useFetch;
