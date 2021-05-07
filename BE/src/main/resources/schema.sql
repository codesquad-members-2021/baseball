DROP TABLE IF EXISTS `player`;
DROP TABLE IF EXISTS `team`;
DROP TABLE IF EXISTS `inning`;
DROP TABLE IF EXISTS `playing`;
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
DROP TABLE IF EXISTS `baseball`.`team`;

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
DROP TABLE IF EXISTS `baseball`.`player`;

CREATE TABLE IF NOT EXISTS `baseball`.`player`
(
    `player_id` INT         NOT NULL,
    `number`    INT         NOT NULL,
    `name`      VARCHAR(45) NOT NULL,
    `pa`        INT         NULL,
    `hit`       INT         NULL,
    `out`       INT         NULL,
    `average`   DOUBLE      NULL,
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
DROP TABLE IF EXISTS `baseball`.`game`;

CREATE TABLE IF NOT EXISTS `baseball`.`game`
(
    `game_id`    INT         NOT NULL AUTO_INCREMENT,
    `home`       VARCHAR(45) NOT NULL,
    `away`       VARCHAR(45) NOT NULL,
    `home_score` INT         NULL,
    `away_score` INT         NULL,
    `isEnd`      TINYINT(1)  NOT NULL,
    PRIMARY KEY (`game_id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baseball`.`playing`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `baseball`.`playing`;

CREATE TABLE IF NOT EXISTS `baseball`.`playing`
(
    `log_id`        INT         NOT NULL AUTO_INCREMENT,
    `team_id`       VARCHAR(45) NOT NULL,
    `player_number` INT         NOT NULL,
    `player_name`   VARCHAR(45) NOT NULL,
    `pa`            INT         NULL,
    `hit`           INT         NULL,
    `out`           INT         NULL,
    `average`       DOUBLE      NULL,
    `game_id`       INT         NOT NULL,
    PRIMARY KEY (`log_id`, `game_id`),
    INDEX `fk_playing_log_game1_idx` (`game_id` ASC) VISIBLE,
    UNIQUE INDEX `player_number_UNIQUE` (`player_number` ASC) VISIBLE,
    UNIQUE INDEX `team_name_UNIQUE` (`team_id` ASC) VISIBLE,
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
DROP TABLE IF EXISTS `baseball`.`inning`;

CREATE TABLE IF NOT EXISTS `baseball`.`inning`
(
    `inninig_id` INT NOT NULL,
    `team_id`    INT NOT NULL,
    `score`      INT NULL,
    `game_id`    INT NOT NULL,
    PRIMARY KEY (`inninig_id`, `game_id`),
    UNIQUE INDEX `team_id_UNIQUE` (`team_id` ASC) VISIBLE,
    INDEX `fk_inninig_game1_idx` (`game_id` ASC) VISIBLE,
    CONSTRAINT `fk_inninig_game1`
        FOREIGN KEY (`game_id`)
            REFERENCES `baseball`.`game` (`game_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
