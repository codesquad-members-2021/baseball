import { useState, useEffect } from 'react';

const useFetch = (
    url,
    { callback = null, isExecuteFunc = false, options = {}, addProps = [], } = {
        callback: null,
        isExecuteFunc: false,
        options: {},
        addProps: [],
    },
) => {
    const [response, setResponse] = useState();
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState('');

    const fetchData = async () => {
        try {
            const res = await fetch(url, options);
            if (!res.ok) {
                setError(`Error: code ${res.status}`);
                return;
            }
            console.log(url);
            console.log(res,options);
            const result = await res.json();
            if (!result) {
                setError(`Error: NO JSON DATA`);
                return;
            }
            setResponse(result);
        } catch (e) {
            setError(e);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        if (!addProps) return;
        if (addProps.length > 0) {
            const flag = addProps.some((v) => !v);
            if (flag) {
                isExecuteFunc && callback && callback();
                return;
            }
        }

        fetchData();
        isExecuteFunc && callback && callback();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [...addProps]);

    return { response, loading, error };
};

export default useFetch;
