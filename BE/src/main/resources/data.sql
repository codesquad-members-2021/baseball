INSERT INTO `baseball`.`game` (`game_id`, `home`, `away`, `home_score`) VALUES ('1', 'Captain', 'Marvel', '1');

INSERT INTO `baseball`.`inning` (`inning_id`, `offense_team`, `inning`, `score`, `ball`, `strike`, `out`, `hitter`, `first_base`, `second_base`, `game_id`) VALUES ('1', 'Captain', '1', '1', '2', '2', '1', '6', '5', '4', '1');

INSERT INTO `baseball`.`team` (`team_id`, `name`, `isPlaying`) VALUES ('1', 'Captain', '1');
INSERT INTO `baseball`.`team` (`team_id`, `name`, `isPlaying`) VALUES ('2', 'Marvel', '0');
