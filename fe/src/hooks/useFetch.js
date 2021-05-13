import { useEffect, useState } from 'react';

const useFetch = (url, method, value = '') => {
  const [data, setData] = useState(null);

  const fetchData = async (url, method, value) => {
    try {
      if (method === 'get') {
        const res = await fetch(url);
        const data = await res.json();
        setData(data);
      } else if (method === 'post') {
        console.log('post', value);
        const res = await fetch(url, {
          method: 'post',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(value),
        });
        const data = await res.json();
        console.log(res, data);
      } else if (method === 'put') {
        console.log('put', value);
        const res = await fetch(url, {
          method: 'put',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(value),
        });
        const data = await res.json();
        console.log(res, data);
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
