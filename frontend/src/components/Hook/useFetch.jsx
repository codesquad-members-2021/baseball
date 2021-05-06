import { useState, useEffect } from 'react';
import API from './API';
function useFetch(method, type, value = null) {
	console.log(method, type, value);
	const [data, setData] = useState([]);
	const [loading, setLoading] = useState(true);
	const [error, setError] = useState(false);

	useEffect((value) => {
		async function fetchUrl(value) {
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
	}, []);

	return [data, loading, error];
}
export default useFetch;
