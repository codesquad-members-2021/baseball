const fetchPUT = async (url, data) => {
  const result = await fetch(url, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  });
  console.log(result);
};

const fetchGET = async (url) => {
  const result = await fetch(url);
  const data = await result.json();
  return data;
};

const fetchPOST = async (url, data) => {
  console.log(data);
  const result = await fetch(url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  });
  console.log(result);
};

export { fetchPUT, fetchGET, fetchPOST };
