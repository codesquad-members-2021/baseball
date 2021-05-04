drop table if exists team;
create table team
(
    id   int auto_increment primary key,
    name varchar(64) unique not null
);

drop table if exists team_game_score;
create table team_game_score
(
    id       int auto_increment primary key,
    inning   int,
    score    int,
    team     bigint(20) references team(id),
    team_key int
);

drop table if exists player;
create table player
(
    id       bigint(20) auto_increment primary key,
    name     varchar(50),
    team     bigint(20) references team (id),
    team_key int
);

drop table if exists player_game_info;
create table player_game_info
(
    id               bigint(20) auto_increment primary key,
    batting_order    int,
    role             varchar(20),
    plate_appearance int,
    hits             int,
    `out`            int,
    average          bigint(20),
    player           bigint(20) references player(id)
);

drop table if exists history;
create table history
(
    id          bigint(20) auto_increment primary key,
    action_name varchar(30),
    strike      int,
    ball        int,
    `out`       int,
    team        bigint(20) references team(id),
    team_key    int,
    player      bigint(20) references player(id)
);

drop table if exists `match`;
create table `match`
(
    id              bigint(20) auto_increment primary key,
    my_team_id      bigint(20),
    counter_team_id bigint(20),
    is_home         boolean
);


