use baseball;

drop table if exists player;
drop table if exists team;
drop table if exists game;
drop table if exists inning;
drop table if exists history;
drop table if exists team_participating_in_game;
drop table if exists player_participating_in_game;

create table player
(
    id             int primary key auto_increment,
    uniform_number int         not null,
    player_name    varchar(20) not null,
    role           varchar(10),
    team           int references team (id)
);

create table team
(
    id        int primary key auto_increment,
    team_name varchar(20) unique not null
);

create table game
(
    id                   int primary key auto_increment,
    game_title           varchar(30) not null,
    current_inning       int         not null,
    is_top               bool        not null,
    current_strike_count int         not null,
    current_out_count    int         not null,
    current_ball_count   int         not null,
    current_pitcher      int references player (id),
    current_hitter       int references player (id),
    is_occupied          bool        not null,
    home_team            int references team_participating_in_game (id),
    away_team            int references team_participating_in_game (id),
    first_base           int references player (id),
    second_base          int references player (id),
    third_base           int references player (id)
);

create table inning
(
    id              int primary key auto_increment,
    game            int references game (id),
    inning_number   int not null,
    home_team_score int not null,
    away_team_score int not null
);

create table history
(
    id           int primary key auto_increment,
    inning       int references inning (id),
    inning_key   int,
    play_type    varchar(10) not null,
    strike_count int         not null,
    ball_count   int         not null,
    pitcher      int references player (id),
    hitter       int references player (id)
);

create table team_participating_in_game
(
    id           int primary key auto_increment,
    team         int references team (id),
    game         int references game (id),
    is_home_team bool not null
);

create table player_participating_in_game
(
    id                         int primary key auto_increment,
    team_participating_in_game int references team_participating_in_game (id),
    bat_order                  int not null,
    player                     int references player (id),
    plate_appearances          int not null,
    hit_count                  int not null,
    out_count                  int not null
);
