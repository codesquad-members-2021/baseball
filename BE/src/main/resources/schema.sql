use BASEBALL;

drop table if exists team;
drop table if exists player;
drop table if exists record;
drop table if exists game;
drop table if exists score_board;
drop table if exists innings;

create table team(
    id BIGINT auto_increment    primary key,
    name varchar(20)            not null unique
);

create table record(
    id      BIGINT auto_increment   primary key,
    at_bat  int                     not null,
    hits    int                     not null,
    outs     int                    not null,
    average DECIMAL(3,3)            not null
);

create table player(
    id BIGINT auto_increment     primary key,
    name varchar(20)             not null,
    type varchar(20)             not null,
    team BIGINT references team(id),
    record BIGINT references record(id)
);



create table game(
    id BIGINT auto_increment          primary key,
    user_type varchar(20)             not null,
    away_id BIGINT references team(id),
    home_id BIGINT references team(id)
);

create table score_board(
    id BIGINT auto_increment          primary key,
    game BIGINT references game(id),
    team BIGINT references team(id)
);

create table innings(
    id BIGINT auto_increment          primary key,
    score int                         not null,
    score_board BIGINT references score_board(id),
    score_board_key int
);