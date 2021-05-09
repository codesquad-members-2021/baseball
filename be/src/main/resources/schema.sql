DROP TABLE IF EXISTS PLAYER_HISTORY;
DROP TABLE IF EXISTS PLAYER_SCORE;
DROP TABLE IF EXISTS PLAYER;
DROP TABLE IF EXISTS TEAM_SCORE;
DROP TABLE IF EXISTS TEAM;
DROP TABLE IF EXISTS GAME;

CREATE TABLE GAME
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    round       INT,
    in_progress TINYINT(1)
);

CREATE TABLE TEAM
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(50),
    is_home  TINYINT(1),
    selected TINYINT(1),
    game_id  BIGINT,
    FOREIGN KEY (game_id) REFERENCES GAME (id)
);

CREATE TABLE TEAM_SCORE
(
    id      BIGINT PRIMARY KEY AUTO_INCREMENT,
    team_id BIGINT,
    round   INT,
    score   INT,
    FOREIGN KEY (team_id) REFERENCES TEAM (id)
);

CREATE TABLE PLAYER
(
    id               BIGINT PRIMARY KEY AUTO_INCREMENT,
    name             VARCHAR(50),
    is_pitcher       TINYINT(1),
    uniform_number   INT,
    plate_appearance INT DEFAULT 0,
    hits             INT DEFAULT 0,
    outs             INT DEFAULT 0,
    team_id          BIGINT,
    FOREIGN KEY (team_id) REFERENCES TEAM (id)
);


CREATE TABLE PLAYER_HISTORY
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    player_id BIGINT,
    round     INT,
    record    VARCHAR(45),
    FOREIGN KEY (player_id) REFERENCES PLAYER (id)
);
