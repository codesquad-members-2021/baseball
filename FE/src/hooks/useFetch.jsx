import { useState, useEffect } from 'react';

const useFetch = (
    url,
    {
        callback = null,
        isExecuteFunc = false,
        options = {},
        addProps = [],
        returnType = '',
    } = {
        callback: null,
        isExecuteFunc: false,
        options: {},
        addProps: [],
        returnType: '',
    },
) => {
    const [response, setResponse] = useState();
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState('');

    const fetchData = async () => {
        try {
            if (!url) setError(`Error: URL IS NULL`);
            console.log(url)
            const res = await fetch(url, options);
            if (!res.ok) return setError(`Error: code ${res.status}`);

            let result = null;
            if (returnType)
                result = res[returnType]
            else
                result = await res.json();

            if (!result) return setError(`Error: NO DATA`);
            console.log(result);
            setResponse(result);
        } catch (e) {
            setError(e);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        if (!addProps || !url) return;
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
