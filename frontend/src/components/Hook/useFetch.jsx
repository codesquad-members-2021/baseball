import { useState, useEffect } from 'react';
import API from './API';
function useFetch(method, type, value = null) {
	console.log(method, type, value);
	const [state, setState] = useState({ data: [], loading: true, error: null });
	const { data, loading, error } = state;

	useEffect(() => {
		async function fetchUrl() {
			try {
				const response = await API[method][type](value ? String(value) : '');
				setState({ ...state, loading: false, data: response });
			} catch (err) {
				setState({ ...state, loading: false, error: err });
				console.error('요청주소에 문제가 있어요😯', err);
			}
		}
		fetchUrl();
		return () => {
			setState({ data: [], loading: true, error: null });
		};
	}, [value]);

	return [data, loading, error];
}
export default useFetch;
