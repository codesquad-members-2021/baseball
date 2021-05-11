import styled from "styled-components";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import { useContext } from "react";
import { MainContext } from "../Main";

const Game = ({ id, homeTeam, awayTeam }) => {
	const { setGameId, setTeamId } = useContext(MainContext);
	const clickHandler = (type) => {
		setGameId(() => id);
		setTeamId(() => (type === "AWAY" ? awayTeam.id : homeTeam.id));
	};
	return (
		<StyledGame>
			<Index>GAME {id}</Index>
			<Link to="/ingame" onClick={() => clickHandler("AWAY")}>
				<Team>{awayTeam.name}</Team>
			</Link>
			<Versus>VS</Versus>
			<Link to="/ingame" onClick={() => clickHandler("HOME")}>
				<Team>{homeTeam.name}</Team>
			</Link>
		</StyledGame>
	);
};

const StyledGame = styled.li`
	position: relative;
	width: 720px;
	height: 115px;
	border: 1px solid;
	border-radius: 32px;
	& + & {
		margin-top: 20px;
	}
	display: flex;
	justify-content: space-around;
	align-items: center;
	background-color: #acacac;
`;
const Index = styled.div`
	position: absolute;
	top: 10px;
	left: 330px;
	color: #f00;
`;
const Team = styled.div`
	font-weight: bold;
	font-size: 2rem;
	color: #000;
	&&:hover {
		color: #f00;
	}
`;
const Versus = styled.div`
	position: absolute;
	top: 50px;
	left: 350px;
	font-weight: bold;
	color: #5e5e5e;
`;

export default Game;
