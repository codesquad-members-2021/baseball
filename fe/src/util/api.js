const fetchPUT = async (data) => {
  // 현재 미사용
  console.log(data);
  if (true) return;
  const result = await fetch('/path', {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  });
  console.log(result);
};

export { fetchPUT };
