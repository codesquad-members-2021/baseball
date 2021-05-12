import { useEffect, createContext, useContext, useReducer } from 'react';

const GameStateContext = createContext();
const DispatchContext = createContext();

const gameReducer = (state, action) => {
	switch (action.type) {
		case 'init':
			return action.data;
		case 'pitch':
			return action.payload;
		default:
			return;
	}
};
function GameProvider({ children, gameData }) {
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
function useGameState() {
	const context = useContext(GameStateContext);
	if (!context) {
		throw new Error('Cannot find GameProvider');
	}
	return context;
}
function useDispatch() {
	const context = useContext(DispatchContext);
	if (!context) {
		throw new Error('Cannot find GameProvider');
	}
	return context;
}

export { GameStateContext, GameProvider, useGameState, useDispatch };
