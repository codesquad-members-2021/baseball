//gameLog
import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import { theme, Span } from '../Style/Theme';
import Scroll from '../Style/Scroll';
import { useLogState } from '../GameContext';

const GameLog = () => {
  const { logState } = useLogState();

  let processedLog = [];

	logState.map((log, i) => {
		processedLog[i] = {
			hitter: `${log.gameStatusDTO.currentHitter + 1}번 타자 ${
				log.awayTeam.players[log.gameStatusDTO.currentHitter].name
			}`,
			fragment: (
				<>
					<Log>{log.pitchResult.playType}</Log>
					<AccLog>{`S${log.gameStatusDTO.strikeCount} B${log.gameStatusDTO.ballCount}`}</AccLog>
				</>
			),
		};
	});


  const LogGroupedByHitter = processedLog.reduce((acc, obj) => {
    if (!acc[obj.hitter]) {
      acc[obj.hitter] = [];
    }
    acc[obj.hitter].push(obj.fragment);
    return acc;
  }, {});

	return (
		<ScrollDiv>
			<GameLogScroll>
				{Object.entries(LogGroupedByHitter).map(([key, value]) => {
					const logList = value.map((log, i) => {
						return (
							<div>
								<LogWrapper>
									<Number>{i + 1}</Number>
									{log}
								</LogWrapper>
							</div>
						);
					});
					return (
						<PlayersWrapper>
							<div>
								<PlayerWrapper>
									<Player>{key}</Player>
								</PlayerWrapper>
								<LogByPlayer>{logList}</LogByPlayer>
							</div>
						</PlayersWrapper>
					);
				})}
			</GameLogScroll>
		</ScrollDiv>
	);
};

const ScrollDiv = styled(Scroll)`
	display: flex;
	justify-content: flex-end;
`;
const GameLogScroll = styled.div`
	display: flex;
	flex-direction: column-reverse;
	padding: 20px;
`;

const PlayersWrapper = styled.div`
	display: flex;
`;


const PlayerWrapper = styled.div`
  padding-left: 20px;
`;

const LogByPlayer = styled.div`
  display: flex;
  flex-direction: column-reverse;
`;

const LogWrapper = styled.div`

	margin: 10px;
	width: fit-content;
	display: grid;
	grid-template-columns: 20px 130px 100px;
`;
const Player = styled.div`
	margin-top: 10px 0;
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
  background-color: #0073b1;
  border-radius: 10px;
  text-align: center;
`;
const Log = styled(Span)`
  color: ${theme.colors.white};
`;
const AccLog = styled(Span)`
  text-align: left;
  color: ${theme.colors.grey};
`;

export default GameLog;
