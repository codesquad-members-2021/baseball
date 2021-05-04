-- schema.sql 파일은 DDL 스크립트
-- data.sql 파일은 DML 스크립트

use baseball;

drop table IF EXISTS `match`;

CREATE TABLE IF NOT EXISTS `baseball`.`match`(
`match_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
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
`game_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
`turn`    VARCHAR(45) NOT NULL,
`strike`  INT NOT NULL, -- 점
`ball`    INT NOT NULL,
`out`     INT NOT NULL,
`point`   INT NOT NULL, -- 득
`pitcher` VARCHAR(45) NOT NULL,
`batter`  VARCHAR(45) NOT NULL
);
ALTER TABLE `board` CONVERT TO character SET utf8;
DESC `board`;


--
--

show tables;
