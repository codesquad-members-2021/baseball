import { useReducer, useEffect } from 'react';

const reducer = (state, action) => {
  switch (action.type) {
    case 'LOADING':
      return {
        loading: true,
        data: null,
        error: null
      };
    case 'SUCCESS':
      return {
        loading: false,
        data: action.data,
        error: null
      };
    case 'ERROR':
      return {
        loading: false,
        data: null,
        error: action.error
      };
    default:
      throw new Error(`Unhandled action type: ${action.type}`);
  }
};

const reducerInitialState = {
  loading: false,
  data: null,
  error: null
};

const useAsync = (apiFunction, deps = [], skip = false) => {
  const [state, dispatch] = useReducer(reducer, reducerInitialState);

  const fetchData = (addParam, addData) => async () => {
    dispatch({ type: 'LOADING' });
    try {
      const data = await apiFunction(addParam);
      dispatch({ type: 'SUCCESS', data: { ...data, ...addData } });
    } catch (e) {
      dispatch({ type: 'ERROR', error: e });
    }
  }

  useEffect(() => {
    if (skip) return;
    fetchData()();
  }, deps);

  return [state, fetchData];
}

export default useAsync;