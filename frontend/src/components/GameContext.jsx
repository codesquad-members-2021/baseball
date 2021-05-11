import {
	useState,
	useEffect,
	createContext,
	useContext,
	useReducer,
} from 'react';

export const GameStateContext = createContext();
const DispatchContext = createContext();

const gameReducer = () => {};
export function GameProvider({ children, gameData }) {
	console.log(gameData);
	const [state, dispatch] = useReducer(gameReducer, gameData);
	return (
		<GameStateContext.Provider value={state}>
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
