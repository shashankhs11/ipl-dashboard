DROP TABLE IF EXISTS MATCH;

CREATE TABLE IF NOT EXISTS MATCH (
    id BIGINT PRIMARY KEY,
    city varchar(50),
    date varchar(50),
    player_of_match varchar(50),
    venue varchar(200),
    team1 varchar(50),
    team2 varchar(50),
    toss_winner varchar(50),
    toss_decision varchar(50),
    match_winner varchar(50),
    result varchar(50),
    result_margin varchar(50),
    umpire1 varchar(50),
    umpire2 varchar(50)
);

CREATE TABLE IF NOT EXISTS Team (
    id BIGINT PRIMARY KEY,
    team_name VARCHAR(255) NOT NULL UNIQUE,
    total_matches INT DEFAULT 0,
    total_wins INT DEFAULT 0
);
