INSERT INTO team (name) VALUES ('코드쓰쿼드');
INSERT INTO player (team_id, name, uniform_number) VALUES (1, '아이작', 1);
INSERT INTO player (team_id, name, uniform_number) VALUES (1, '쏭', 2);
INSERT INTO player (team_id, name, uniform_number) VALUES (1, '쑤', 3);
INSERT INTO player (team_id, name, uniform_number) VALUES (1, '쿠퍼', 4);
INSERT INTO player (team_id, name, uniform_number) VALUES (1, '우디', 5);

INSERT INTO team (name) VALUES ('마스터');
INSERT INTO player (team_id, name, uniform_number) VALUES (2, '호눅스', 1);
INSERT INTO player (team_id, name, uniform_number) VALUES (2, 'JK', 2);
INSERT INTO player (team_id, name, uniform_number) VALUES (2, '크롱', 3);
INSERT INTO player (team_id, name, uniform_number) VALUES (2, '세라', 4);
INSERT INTO player (team_id, name, uniform_number) VALUES (2, '헤드', 5);

INSERT INTO `user` (email) VALUES ('isaac@naver.com');
INSERT INTO `user` (email) VALUES ('soo@naver.com');
INSERT INTO `user` (email) VALUES ('song@naver.com');

INSERT INTO `baseball`.`game` (`id`, `away_team_id`, `home_team_id`, `current_inning`, `current_halves`, `pitcher_uniform_number`, `batter_uniform_number`, `strike_count`, `ball_count`, `out_count`, `status`) VALUES ('1', '1', '2', '1', 'TOP', '1', '1', '0', '0', '0', 'WAITING');
UPDATE `baseball`.`user` SET `current_game_id` = '1', `current_game_venue` = 'AWAY' WHERE (`id` = '2');
