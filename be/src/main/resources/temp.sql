
/*게임 정보*/
SELECT id, round, in_progress FROM GAME;

/*구식: 내부결합 */
SELECT TEAM.id, TEAM.is_home, GAME.in_progress, GAME.id
FROM TEAM,GAME
WHERE TEAM.game_id = GAME.id
AND GAME.id = 1;

/*최근: 내부결합*/
SELECT T.id, T.is_home, G.in_progress, G.id
FROM TEAM AS T
INNER JOIN GAME AS G ON T.game_id = G.id
WHERE T.game_id = 1;

/*m 팀 정보 */
SELECT TEAM.id, TEAM_SCORE.round AS inning_number, TEAM_SCORE.score, TEAM.selected
FROM TEAM INNER JOIN TEAM_SCORE ON TEAM.id = TEAM_SCORE.team_id
WHERE TEAM.id = 1;

/*m 선수 성적 */
SELECT PLAYER.team_id,  PLAYER.is_pitcher, PLAYER.name, PLAYER_SCORE.plate_appearance, PLAYER_SCORE.hits, PLAYER_SCORE.outs
FROM PLAYER INNER JOIN PLAYER_SCORE ON PLAYER.id = PLAYER_SCORE.player_id
WHERE PLAYER.team_id = 1;

/*m 중계 영역 */
SELECT PLAYER.name, PLAYER_HISTORY.record
FROM PLAYER INNER JOIN PLAYER_HISTORY ON PLAYER.ID = PLAYER_HISTORY.player_id;

/*게임이 끝났을 때 초기화는 어떻게할지 생각해보기*/
