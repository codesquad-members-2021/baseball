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
    winner CHAR(4),

    strike INT,
    ball INT,
    `out` INT,

    first_base BOOLEAN,
    second_base BOOLEAN,
    third_base BOOLEAN,
    home_base BOOLEAN,

    home_user VARCHAR (30),
    home_history_index INT,

    home_team_id BIGINT,
    home_team_name VARCHAR(30),
    home_score INT,

    home_pitcher_number INT,
    home_pitches INT,

    home_batter_number INT,

    away_user VARCHAR (30),
    away_history_index INT,

    away_team_id BIGINT,
    away_team_name VARCHAR(30),
    away_score INT,

    away_pitcher_number INT,
    away_pitches INT,

    away_batter_number INT
);

CREATE TABLE IF NOT EXISTS home_player_statistics (
    game_id BIGINT,
    player_statistics_index INT,
    player_name VARCHAR (30),
    at_bat INT,
    hits INT,
    `out` INT,
    CONSTRAINT home_player_statistics_ref_information_id FOREIGN KEY (game_id) REFERENCES baseball_game (game_id)
);

CREATE TABLE IF NOT EXISTS home_inning_score (
    game_id BIGINT,
    inning INT,
    score INT,
    CONSTRAINT home_inning_score_ref_information_id FOREIGN KEY (game_id) REFERENCES baseball_game (game_id)
);

CREATE TABLE IF NOT EXISTS away_player_statistics (
    game_id BIGINT,
    player_statistics_index INT,
    player_name VARCHAR (30),
    at_bat INT,
    hits INT,
    `out` INT,
    CONSTRAINT away_player_statistics_ref_information_id FOREIGN KEY (game_id) REFERENCES baseball_game (game_id)
);

CREATE TABLE IF NOT EXISTS away_inning_score (
    game_id BIGINT,
    inning INT,
    score INT,
    CONSTRAINT away_inning_score_ref_information_id FOREIGN KEY (game_id) REFERENCES baseball_game (game_id)
);

CREATE TABLE IF NOT EXISTS batter_inning_history (
    game_id BIGINT,
    batter_inning_history_index INT,
    pitch CHAR(10),
    `state` CHAR(3),
    CONSTRAINT batter_inning_history_ref_game_id FOREIGN KEY (game_id) REFERENCES baseball_game (game_id)
);
