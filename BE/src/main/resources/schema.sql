use
BASEBALL;

drop table if exists team;
drop table if exists player;
drop table if exists record;
drop table if exists game;
drop table if exists score_board;
drop table if exists innings;
drop table if exists users;

create table team
(
    name varchar(20) primary key not null
);

create table player
(
    id   BIGINT auto_increment primary key,
    name varchar(20) not null,
    type varchar(20) not null,
    team varchar(20) references team (name)
);

create table record
(
    id     BIGINT auto_increment primary key,
    at_bat int not null,
    hits   int not null,
    outs   int not null,

    player BIGINT references player (id)
);

create table game
(
    id        BIGINT auto_increment primary key,
    user_type varchar(20) not null,
    home      varchar(20) references team (name),
    away      varchar(20) references team (name)
);

create table score_board
(
    id   BIGINT auto_increment primary key,
    game BIGINT references game (id),
    team varchar(20) references team (name)
);

create table innings
(
    id              BIGINT auto_increment primary key,
    score           int not null,
    score_board     BIGINT references score_board (id),
    score_board_key int
);

create table users
(
    id           BIGINT auto_increment primary key,
    github_id    varchar(64) not null,
    login        varchar(64) not null,
    htmlUrl      varchar(64) not null,
    location     varchar(64) not null,
    followers    int         not null,
    following    int         not null,
    accessToken  varchar(200),
    refreshToken varchar(200)
);

