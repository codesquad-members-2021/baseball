import {
	useState,
	useEffect,
	createContext,
	useContext,
	useReducer,
} from 'react';

export const GameStateContext = createContext();
const DispatchContext = createContext();

//useReducer에 useEffect적용해보기
const gameReducer = (state, action) => {
	if (action.type === 'init') {
		return action.data;
	}
};
export function GameProvider({ children, gameData }) {
	const [state, dispatch] = useReducer(gameReducer, gameData);
	useEffect(() => {
		dispatch({ type: 'init', data: gameData });
	}, [gameData]);
	return (
		<GameStateContext.Provider value={{ state }}>
			<DispatchContext.Provider value={dispatch}>
				{children}
			</DispatchContext.Provider>
		</GameStateContext.Provider>
	);
}
export function useGameState() {
	const context = useContext(GameStateContext);
	if (!context) {
		throw new Error('Cannot find GameProvider');
	}
	return context;
}
export function useDispatch() {
	const context = useContext(DispatchContext);
	if (!context) {
		throw new Error('Cannot find GameProvider');
	}
	return context;
}
