drop table if exists game;
drop table if exists team;
drop table if exists member;
drop table if exists record;
drop table if exists score;

create table game
(
    id   int primary key auto_increment,
    home_team_id int,
    away_team_id int
);

create table team
(
    id   int primary key auto_increment,
    name varchar(45)
);

create table member
(
    id       int primary key auto_increment,
    name     varchar(45),
    position varchar(45),
    team     int references team (id)
);

create table record
(
    at_bat    int,
    hit      int,
    `out`    int,
    average  double,
    member int references member (id)
);

create table score
(
    inning_number int,
    score        int,
    team       int references team (id)
);




