import { useState } from 'react';

const useTogglePopup = (initialValue = { top: true, bottom: true }) => {
  const [state, setState] = useState(initialValue);

  const onToggle = (location) => {
    if (location === 'all') return setState(initialValue);
    return setState((state) => ({ ...state, [location]: !initialValue[location] }));
  };

  return [state, onToggle];
}

export default useTogglePopup;