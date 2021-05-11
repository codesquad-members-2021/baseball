INSERT INTO `team`(name, is_home, is_playable) VALUES ('Captain', 1, 1), ('Marvel', 0, 0), ('Tigers', 1, 1), ('Giants', 0, 1), ('team5', 1, 1), ('team6', 0, 1);

INSERT INTO `game`(home_team_id, away_team_id) VALUES (1, 2), (3, 4), (5, 6);

INSERT INTO `player`(name, team, batting_order, back_number, is_pitcher)
VALUES ('p1', 1, 1, 1, 1), ('p2', 1, 2, 2, 0), ('p3', 1, 3, 3, 0), ('p4', 2, 4, 4, 0), ('p5', 2, 5, 5, 0), ('p6', 2, 6, 6, 0);
