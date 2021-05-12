import { useCallback, useState } from 'react';

const useToggle = (initialState = true) => {
  const [state, setState] = useState(initialState);
  const toggle = useCallback(() => setState((state) => !state), []);

  return [state, toggle];
};

export default useToggle;
