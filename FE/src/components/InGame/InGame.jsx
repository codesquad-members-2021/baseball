import { useContext, useEffect, useState } from "react";
import styled from "styled-components";
import ScoreBoard from "./ScoreBoard/ScoreBoard";
import LineUp from "./LineUp/LineUp";
import Ground from "./Ground/Ground";
import Record from "./Record/Record";

import { MainContext } from "../Main";

const InGame = () => {
	const { gameId, teamId, loginStatus } = useContext(MainContext);

	const [data, setData] = useState();
	const reloadData = async () => {
		// pitch나 (공격시 일정간격으로 polling) 상황 때는 투구 결과, 즉 ball hit strike를 보내줄텐데
		// 그때를 대비해 default parameter로 useEffect때는 결과만 받아오도록 하고
		// 인자로 {result:ball} 따위를 POST나 PUT할 수 있게 만들어주자
		try {
			const response = await fetch(`https://baseball-ahpuh.herokuapp.com/games/${gameId}?teamId=${teamId}`)
			const json = await response.json()
			setData(()=>json)
		} catch (error) {
			console.log("fetch error in InGame : ",error)
		}
	};
	useEffect(() => reloadData(), []);

	const [slideScoreBoard, toggleScoreBoard] = useState(false);
	const [slideLineUp, toggleLineUp] = useState(false);
	const [isDark, setDark] = useState(false);
	const clickMain = () => {
		toggleScoreBoard(false);
		toggleLineUp(false);
		setDark(false);
	};
	return loginStatus && data ? (
		<StyledInGame>
			<ScoreBoard slide={slideScoreBoard} toggle={toggleScoreBoard} isDark={isDark} setDark={setDark} gameId={gameId} />
			<LineUp slide={slideLineUp} toggle={toggleLineUp} isDark={isDark} setDark={setDark} gameId={gameId} />
			<Main onClick={clickMain} isDark={isDark}>
				<Ground reloadData={reloadData} data={data} teamId={teamId} />
				<Record data={data} />
			</Main>
		</StyledInGame>
	) : (
		<WrongApproach>올바르지 않은 접근입니다</WrongApproach>
	);
};

export default InGame;

const StyledInGame = styled.div`
	position: relative;
	overflow: hidden;
	margin-top: 30px;
`;
const Main = styled.div`
	height: 720px;
	filter: ${({ isDark }) => (isDark ? "brightness(20%)" : "")};
	transition: filter 400ms;

	font-size: 5rem;
	color: #fff;
`;
const WrongApproach = styled.div`
	height: 720px;
	display: flex;
	align-items: center;
	justify-content: center;
	font-size: 30px;
	color: #fff;
`;
