CREATE TABLE team (
    team_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    team_name VARCHAR(30) NOT NULL,
    pitcher_number INT NOT NULL
);

CREATE TABLE player (
    team_id BIGINT,
    team_players_index INT,
    player_name VARCHAR(30) NOT NULL,
    CONSTRAINT player_in_team FOREIGN KEY (team_id) REFERENCES team (team_id)
);
