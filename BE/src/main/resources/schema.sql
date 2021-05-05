DROP TABLE IF EXISTS `player`;
DROP TABLE IF EXISTS `team`;
DROP TABLE IF EXISTS `inning`;
DROP TABLE IF EXISTS `playing_log`;
DROP TABLE IF EXISTS `game`;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema baseball
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema baseball
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `baseball` DEFAULT CHARACTER SET utf8;
USE `baseball`;

-- -----------------------------------------------------
-- Table `baseball`.`team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baseball`.`team`
(
    `team_id`   INT         NOT NULL,
    `name`      VARCHAR(45) NOT NULL,
    `isPlaying` TINYINT(1)  NOT NULL,
    PRIMARY KEY (`team_id`),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baseball`.`player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baseball`.`player`
(
    `player_id` INT         NOT NULL,
    `name`      VARCHAR(45) NOT NULL,
    `position`  VARCHAR(45) NOT NULL,
    `pitch`     INT         NULL,
    `pa`        INT         NULL,
    `hit`       INT         NULL,
    `out`       INT         NULL,
    `average`   INT         NULL,
    `team_id`   INT         NOT NULL,
    PRIMARY KEY (`player_id`, `team_id`),
    INDEX `fk_player_team_idx` (`team_id` ASC) VISIBLE,
    CONSTRAINT `fk_player_team`
        FOREIGN KEY (`team_id`)
            REFERENCES `baseball`.`team` (`team_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baseball`.`game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baseball`.`game`
(
    `game_id`    INT         NOT NULL AUTO_INCREMENT,
    `home`       VARCHAR(45) NOT NULL,
    `away`       VARCHAR(45) NOT NULL,
    `home_score` INT         NULL,
    `away_score` INT         NULL,
    PRIMARY KEY (`game_id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baseball`.`playing_log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baseball`.`playing_log`
(
    `log_id`      INT         NOT NULL AUTO_INCREMENT,
    `player_name` VARCHAR(45) NOT NULL,
    `pitch`       INT         NULL,
    `pa`          INT         NULL,
    `hit`         INT         NULL,
    `action`      VARCHAR(45) NULL,
    `total_count` INT         NULL,
    `game_id`     INT         NOT NULL,
    PRIMARY KEY (`log_id`, `game_id`),
    INDEX `fk_playing_log_game1_idx` (`game_id` ASC) VISIBLE,
    CONSTRAINT `fk_playing_log_game1`
        FOREIGN KEY (`game_id`)
            REFERENCES `baseball`.`game` (`game_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baseball`.`inning`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `baseball`.`inning`
(
    `inning_id`    INT         NOT NULL AUTO_INCREMENT,
    `offense_team` VARCHAR(45) NOT NULL,
    `inning`       INT         NOT NULL,
    `score`        INT         NULL,
    `ball`         INT         NULL,
    `strike`       INT         NULL,
    `out`          INT         NULL,
    `hitter`       INT         NULL,
    `first_base`   INT         NULL,
    `second_base`  INT         NULL,
    `third_base`   INT         NULL,
    `game_id`      INT         NOT NULL,
    PRIMARY KEY (`inning_id`, `game_id`),
    INDEX `fk_inning_game1_idx` (`game_id` ASC) VISIBLE,
    CONSTRAINT `fk_inning_game1`
        FOREIGN KEY (`game_id`)
            REFERENCES `baseball`.`game` (`game_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
