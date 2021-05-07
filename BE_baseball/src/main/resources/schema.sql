-- schema.sql 파일은 DDL 스크립트
-- data.sql 파일은 DML 스크립트
CREATE DATABASE IF NOT EXISTS `baseball`;

use baseball;

drop table IF EXISTS `match`;

CREATE TABLE IF NOT EXISTS `baseball`.`match`(
`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
`home` VARCHAR(45) NOT NULL,
`away` VARCHAR(45) NOT NULL
);
ALTER TABLE `match` CONVERT TO character SET utf8;

DESC `match`;
--
--

drop table IF EXISTS `board`;

CREATE TABLE IF NOT EXISTS `baseball`.`board`
(
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
`match` BIGINT REFERENCES `match`(id),
`match_id` INT,
`inning`  INT NOT NULL, -- 이닝, 몇회차인지
`turn`    VARCHAR(45) NOT NULL, -- 둘중하나 TOP/AWAY or BOT/HOME
`strike`  INT NOT NULL, -- 스트라이크 갯수
`ball`    INT NOT NULL, -- 볼 갯수
`out`     INT NOT NULL, -- 현 회차에서 아웃한 타자의 수
`home_point`   INT NOT NULL, -- 홈팀의 득점
`away_point`   INT NOT NULL, -- 원정팀의 득점
`pitcher` VARCHAR(45) NOT NULL,
`batter`  VARCHAR(45) NOT NULL
);
ALTER TABLE `board` CONVERT TO character SET utf8;
DESC `board`;


--
--



drop table IF EXISTS `team`;

CREATE TABLE IF NOT EXISTS `baseball`.`team`
(
    `team_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `team_name` VARCHAR(45) NOT NULL,
    `win` INT NOT NULL,
    `lose` INT NOT NULL,
    `draw` INT NOT NULL,
    `victory_point` INT NOT NULL
);

ALTER TABLE `team` CONVERT TO character SET utf8;
DESC `team`;


show tables;
