//gameLog
import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import { theme, Span } from '../Style/Theme';
import Scroll from '../Style/Scroll';
import { useLogState } from '../GameContext';

const GameLog = () => {
	const { logState } = useLogState();
	const SingleLog = () => {
		return logState.map((log, i) => (
			// console.log(log.pitchResult.playType, log.gameStatusDTO.strikeCount);

			<Foo key={i}>
				<span>{i}</span>
				<span>{`${log.gameStatusDTO.currentHitter + 1}번 타자 ${
					log.awayTeam.players[log.gameStatusDTO.currentHitter + 1].name
				}`}</span>
				<span>{log.pitchResult.playType}</span>
				<span>{`S${log.gameStatusDTO.strikeCount} B${log.gameStatusDTO.ballCount}`}</span>
			</Foo>
		));
	};

	return (
		<GameLogScroll>
			<SingleLog />
			<PlayerWrapper>
				<Player now={true}>7번 타자 류진</Player>
				<LogWrapper>
					<Number>&#9316;</Number>
					<Log>스트라이크</Log>
					<AccLog>S2 B3</AccLog>
				</LogWrapper>
				<LogWrapper>
					<Number>&#9315;</Number>
					<Log>볼</Log>
					<AccLog>S1 B3</AccLog>
				</LogWrapper>
				<LogWrapper>
					<Number>&#9314;</Number>
					<Log>볼</Log>
					<AccLog>S1 B2</AccLog>
				</LogWrapper>
				<LogWrapper>
					<Number>&#9313;</Number>
					<Log>볼</Log>
					<AccLog>S1 B1</AccLog>
				</LogWrapper>
				<LogWrapper>
					<Number>&#9312;</Number>
					<Log> 스트라이크</Log>
					<AccLog>S1 B0</AccLog>
				</LogWrapper>
			</PlayerWrapper>
		</GameLogScroll>
	);
};
const GameLogScroll = styled(Scroll)``;

const PlayerWrapper = styled.div`
	padding-left: 20px;
`;
const LogWrapper = styled.div`
	width: fit-content;
	padding-top: 10px;
	display: grid;
	grid-template-columns: 20px 130px 100px;
`;
const Player = styled.div`
	margin: 15px 0;
	font-size: ${theme.fontSize.medium};
	font-weight: ${theme.fontWeight.medium};
	color: ${(props) =>
		props.now ? theme.colors.red_log : theme.colors.skyblue_log};
`;
const Result = styled(Span)`
	width: 150px;
	color: ${theme.colors.blue_log};
`;
const Number = styled(Span)`
	color: ${theme.colors.white};
`;
const Log = styled(Span)`
	color: ${theme.colors.white};
`;
const AccLog = styled(Span)`
	color: ${theme.colors.grey};
`;

const Foo = styled(Span)`
	color: ${theme.colors.white};
`;

export default GameLog;
