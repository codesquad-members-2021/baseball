CREATE TABLE IF NOT EXISTS team (
    team_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    team_name VARCHAR(30) NOT NULL,
    pitcher_number INT NOT NULL
);

CREATE TABLE IF NOT EXISTS player (
    team_id BIGINT,
    team_players_index INT,
    player_name VARCHAR(30) NOT NULL,
    CONSTRAINT player_in_team FOREIGN KEY (team_id) REFERENCES team (team_id)
);

CREATE TABLE IF NOT EXISTS baseball_game (
    game_id BIGINT AUTO_INCREMENT PRIMARY KEY,

    ordinal INT,
    attack_team CHAR(4),

    strike INT,
    ball INT,
    `out` INT,

    first_base BOOLEAN,
    second_base BOOLEAN,
    third_base BOOLEAN,
    home_base BOOLEAN,

    home_user VARCHAR (30),
    home_history_index INT,
    away_user VARCHAR (30),
    away_history_index INT

);

CREATE TABLE IF NOT EXISTS baseball_game_team_information (
    information_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    game_id BIGINT,
    baseball_game_team CHAR(4),

    team_id BIGINT,
    team_name VARCHAR(30),
    batter_number INT,

    pitcher_number INT,
    pitches INT,

    total_score INT,

    CONSTRAINT team_information_team_id FOREIGN KEY (team_id) REFERENCES team (team_id),
    CONSTRAINT team_information_ref_game_id FOREIGN KEY (game_id) REFERENCES baseball_game (game_id)
);

CREATE TABLE IF NOT EXISTS player_statistics (
    information_id BIGINT,
    player_statistics_index INT,
    player_name VARCHAR (30),
    at_bat INT,
    hits INT,
    `out` INT,
    CONSTRAINT player_statistics_ref_information_id FOREIGN KEY (information_id) REFERENCES baseball_game_team_information (information_id)
);

CREATE TABLE IF NOT EXISTS inning_score (
    information_id BIGINT,
    inning INT,
    score INT,
    CONSTRAINT inning_score_ref_information_id FOREIGN KEY (information_id) REFERENCES baseball_game_team_information (information_id)
);

CREATE TABLE IF NOT EXISTS batter_inning_history (
    game_id BIGINT,
    batter_inning_history_index INT,
    pitch CHAR(10),
    `state` CHAR(3),
    CONSTRAINT batter_inning_history_ref_game_id FOREIGN KEY (game_id) REFERENCES baseball_game (game_id)
);
