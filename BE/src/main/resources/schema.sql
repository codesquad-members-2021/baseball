DROP TABLE IF EXISTS `inning`;
DROP TABLE IF EXISTS `playing`;
DROP TABLE IF EXISTS `game`;
DROP TABLE IF EXISTS `player`;
DROP TABLE IF EXISTS `team`;

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
    `id`        INT         NOT NULL,
    `name`      VARCHAR(45) NOT NULL,
    `isPlaying` TINYINT(1)  NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baseball`.`player`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `baseball`.`player`;

CREATE TABLE IF NOT EXISTS `baseball`.`player`
(
    `id`      INT         NOT NULL,
    `number`  INT         NOT NULL,
    `name`    VARCHAR(45) NOT NULL,
    `pa`      INT         NULL,
    `hit`     INT         NULL,
    `out`     INT         NULL,
    `average` DOUBLE      NULL,
    `team_id` INT         NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_player_team1_idx` (`team_id` ASC) VISIBLE,
    CONSTRAINT `fk_player_team1`
        FOREIGN KEY (`team_id`)
            REFERENCES `baseball`.`team` (`id`)
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
    `id`         INT        NOT NULL AUTO_INCREMENT,
    `home_score` INT        NULL,
    `away_score` INT        NULL,
    `isEnd`      TINYINT(1) NOT NULL,
    `home_id`    INT        NOT NULL,
    `away_id`    INT        NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_game_team1_idx` (`home_id` ASC) VISIBLE,
    INDEX `fk_game_team2_idx` (`away_id` ASC) VISIBLE,
    CONSTRAINT `fk_game_team1`
        FOREIGN KEY (`home_id`)
            REFERENCES `baseball`.`team` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_game_team2`
        FOREIGN KEY (`away_id`)
            REFERENCES `baseball`.`team` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baseball`.`playing`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `baseball`.`playing`;

CREATE TABLE IF NOT EXISTS `baseball`.`playing`
(
    `id`            INT         NOT NULL AUTO_INCREMENT,
    `team_id`       VARCHAR(45) NOT NULL,
    `player_number` INT         NOT NULL,
    `player_name`   VARCHAR(45) NOT NULL,
    `pa`            INT         NULL,
    `hit`           INT         NULL,
    `out`           INT         NULL,
    `average`       DOUBLE      NULL,
    `game_id`       INT         NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `player_number_UNIQUE` (`player_number` ASC) VISIBLE,
    UNIQUE INDEX `team_name_UNIQUE` (`team_id` ASC) VISIBLE,
    INDEX `fk_playing_game1_idx` (`game_id` ASC) VISIBLE,
    CONSTRAINT `fk_playing_game1`
        FOREIGN KEY (`game_id`)
            REFERENCES `baseball`.`game` (`id`)
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
    `id`      INT NOT NULL,
    `team_id` INT NOT NULL,
    `score`   INT NULL,
    `game_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `team_id_UNIQUE` (`team_id` ASC) VISIBLE,
    INDEX `fk_inning_game1_idx` (`game_id` ASC) VISIBLE,
    CONSTRAINT `fk_inning_game1`
        FOREIGN KEY (`game_id`)
            REFERENCES `baseball`.`game` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
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
    `id`        INT         NOT NULL,
    `name`      VARCHAR(45) NOT NULL,
    `isPlaying` TINYINT(1)  NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baseball`.`player`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `baseball`.`player`;

CREATE TABLE IF NOT EXISTS `baseball`.`player`
(
    `id`      INT         NOT NULL,
    `number`  INT         NOT NULL,
    `name`    VARCHAR(45) NOT NULL,
    `pa`      INT         NULL,
    `hit`     INT         NULL,
    `out`     INT         NULL,
    `average` DOUBLE      NULL,
    `team_id` INT         NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_player_team1_idx` (`team_id` ASC) VISIBLE,
    CONSTRAINT `fk_player_team1`
        FOREIGN KEY (`team_id`)
            REFERENCES `baseball`.`team` (`id`)
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
    `id`         INT        NOT NULL AUTO_INCREMENT,
    `home_score` INT        NULL,
    `away_score` INT        NULL,
    `isEnd`      TINYINT(1) NOT NULL,
    `home_id`    INT        NOT NULL,
    `away_id`    INT        NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_game_team1_idx` (`home_id` ASC) VISIBLE,
    INDEX `fk_game_team2_idx` (`away_id` ASC) VISIBLE,
    CONSTRAINT `fk_game_team1`
        FOREIGN KEY (`home_id`)
            REFERENCES `baseball`.`team` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_game_team2`
        FOREIGN KEY (`away_id`)
            REFERENCES `baseball`.`team` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `baseball`.`playing`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `baseball`.`playing`;

CREATE TABLE IF NOT EXISTS `baseball`.`playing`
(
    `id`            INT         NOT NULL AUTO_INCREMENT,
    `team_id`       VARCHAR(45) NOT NULL,
    `player_number` INT         NOT NULL,
    `player_name`   VARCHAR(45) NOT NULL,
    `pa`            INT         NULL,
    `hit`           INT         NULL,
    `out`           INT         NULL,
    `average`       DOUBLE      NULL,
    `game_id`       INT         NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `player_number_UNIQUE` (`player_number` ASC) VISIBLE,
    UNIQUE INDEX `team_name_UNIQUE` (`team_id` ASC) VISIBLE,
    INDEX `fk_playing_game1_idx` (`game_id` ASC) VISIBLE,
    CONSTRAINT `fk_playing_game1`
        FOREIGN KEY (`game_id`)
            REFERENCES `baseball`.`game` (`id`)
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
    `id`      INT NOT NULL,
    `team_id` INT NOT NULL,
    `number`  INT NULL,
    `score`   INT NULL,
    `game_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `team_id_UNIQUE` (`team_id` ASC) VISIBLE,
    INDEX `fk_inning_game1_idx` (`game_id` ASC) VISIBLE,
    CONSTRAINT `fk_inning_game1`
        FOREIGN KEY (`game_id`)
            REFERENCES `baseball`.`game` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
