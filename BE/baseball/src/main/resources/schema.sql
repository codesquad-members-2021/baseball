# use baseball;
DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS player;
DROP TABLE IF EXISTS team;

CREATE TABLE IF NOT EXISTS `baseball`.`team` (
                                                 `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
                                                 `name` VARCHAR(45) NOT NULL,
                                                 `is_home` TINYINT(1) NOT NULL,
                                                 `is_playable` TINYINT(1),
                                                 `pitcher_id` BIGINT
);

CREATE TABLE IF NOT EXISTS `baseball`.`game` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `home_team_id` BIGINT,
    `away_team_id` BIGINT,
    FOREIGN KEY (`home_team_id`) REFERENCES `team`(`id`),
    FOREIGN KEY (`away_team_id`) REFERENCES `team`(`id`)
);

CREATE TABLE IF NOT EXISTS `baseball`.`player` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `at_bat` INT DEFAULT 0,
    `hit` INT DEFAULT 0,
    `out` INT DEFAULT 0,
    `batting_order` INT DEFAULT 0,
    `back_number` INT DEFAULT 0,
    `is_pitcher` TINYINT(1) DEFAULT 0,
    `team` BIGINT,
    FOREIGN KEY (`team`) REFERENCES `team`(`id`)
);
