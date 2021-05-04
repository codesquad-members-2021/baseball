drop table if exists team;
drop table if exists member;
drop table if exists record;
drop table if exists score;

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
    team   int references team (id)
);

create table record
(
    atBat    int,
    hit      int,
    `out`    int,
    average  int,
    memberId int references member (id),
    teamId   int references team (id)
);

create table score
(
    inningNumber int,
    score        int,
    teamId       int references team (id)
);




