INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('Samsung Lions', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('KIA Tigers', '1');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('NC Dinos', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('Hanwha Eagles', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('Lotte Giants', '1');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('Doosan Bears', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('SSG Landers', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('LG Twins', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('Atlanta Braves', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('Boston Red Sox', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('Chicago Cubs', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('Cleveland Indians', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('Houston Astros', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('Los Angeles Angels', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('Los Angeles Dodgers', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('New York Mets', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('New York Yankees', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('Philadelphia Phillies', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('San Diego Padres', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('San Francisco Giants', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('St. Louis Cardinals', '0');
INSERT INTO `baseball`.`team` (`name`, `is_playing`) VALUES ('Toronto Blue Jays', '0');


INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('1', '1', '강민호', 'pitcher', 'Samsung Lions');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('2', '2', '강한울', 'hitter', 'Samsung Lions');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('3', '3', '구자욱', 'hitter', 'Samsung Lions');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('4', '4', '김상수', 'hitter', 'Samsung Lions');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('5', '5', '김성윤', 'hitter', 'Samsung Lions');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('6', '6', '김현곤', 'hitter', 'Samsung Lions');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('7', '7', '박해민', 'hitter', 'Samsung Lions');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('8', '8', '라이블리', 'hitter', 'Samsung Lions');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('9', '9', '오승환', 'hitter', 'Samsung Lions');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('10', '10', '이승엽', 'hitter', 'Samsung Lions');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('11', '1', '고영창', 'pitcher', 'KIA Tigers');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('12', '2', '권혁경', 'hitter', 'KIA Tigers');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('13', '3', '김규성', 'hitter', 'KIA Tigers');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('14', '4', '김원경', 'hitter', 'KIA Tigers');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('15', '5', '나주환', 'hitter', 'KIA Tigers');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('16', '6', '박건우', 'hitter', 'KIA Tigers');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('17', '7', '박찬호', 'hitter', 'KIA Tigers');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('18', '8', '브룩스', 'hitter', 'KIA Tigers');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('19', '9', '양승철', 'hitter', 'KIA Tigers');
INSERT INTO `baseball`.`player` (`id`, `number`, `name`, `position`, `team_name`) VALUES ('20', '10', '윌리엄스', 'hitter', 'KIA Tigers');


INSERT INTO `baseball`.`game` (`id`, `home_score`, `away_score`, `is_end`, `home_name`, `away_name`) VALUES ('1', '0', '0', '0', 'Samsung Lions', 'KIA Tigers');
INSERT INTO `baseball`.`game` (`id`, `home_score`, `away_score`, `is_end`, `home_name`, `away_name`) VALUES ('2', '0', '0', '0', 'NC Dinos', 'Hanwha Eagles');
INSERT INTO `baseball`.`game` (`id`, `home_score`, `away_score`, `is_end`, `home_name`, `away_name`) VALUES ('3', '0', '0', '0', 'Lotte Giants', 'Doosan Bears');
INSERT INTO `baseball`.`game` (`id`, `home_score`, `away_score`, `is_end`, `home_name`, `away_name`) VALUES ('4', '0', '0', '0', 'SSG Landers', 'LG Twins');
INSERT INTO `baseball`.`game` (`id`, `home_score`, `away_score`, `is_end`, `home_name`, `away_name`) VALUES ('5', '0', '0', '0', 'New York Yankees', 'New York Mets');
INSERT INTO `baseball`.`game` (`id`, `home_score`, `away_score`, `is_end`, `home_name`, `away_name`) VALUES ('6', '0', '0', '0', 'Los Angeles Dodgers', 'Boston Red Sox');
INSERT INTO `baseball`.`game` (`id`, `home_score`, `away_score`, `is_end`, `home_name`, `away_name`) VALUES ('7', '0', '0', '0', 'Atlanta Braves', 'Los Angeles Angels');
INSERT INTO `baseball`.`game` (`id`, `home_score`, `away_score`, `is_end`, `home_name`, `away_name`) VALUES ('8', '0', '0', '0', 'St. Louis Cardinals', 'Chicago Cubs');
INSERT INTO `baseball`.`game` (`id`, `home_score`, `away_score`, `is_end`, `home_name`, `away_name`) VALUES ('9', '0', '0', '0', 'Toronto Blue Jays', 'San Francisco Giants');
INSERT INTO `baseball`.`game` (`id`, `home_score`, `away_score`, `is_end`, `home_name`, `away_name`) VALUES ('10', '0', '0', '0', 'Houston Astros', 'San Diego Padres');
INSERT INTO `baseball`.`game` (`id`, `home_score`, `away_score`, `is_end`, `home_name`, `away_name`) VALUES ('11', '0', '0', '0', 'Philadelphia Phillies', 'Cleveland Indians');

