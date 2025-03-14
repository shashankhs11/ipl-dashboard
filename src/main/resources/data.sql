-- Drop tables if they already exist
DROP TABLE IF EXISTS team;
DROP TABLE IF EXISTS match;

CREATE TABLE match (
    id BIGINT PRIMARY KEY,
    season VARCHAR(10),
    city VARCHAR(255),
    date DATE,
    match_type VARCHAR(50),
    player_of_match VARCHAR(255),
    venue VARCHAR(255),
    team1 VARCHAR(255),
    team2 VARCHAR(255),
    toss_winner VARCHAR(255),
    toss_decision VARCHAR(10),
    winner VARCHAR(255),
    result VARCHAR(10),
    result_margin VARCHAR(10),
    target_runs INT,
    target_overs DECIMAL(10,2),
    super_over VARCHAR(1),
    method VARCHAR(10),
    umpire1 VARCHAR(255),
    umpire2 VARCHAR(255)
);

-- Import Data into Match Table from CSV
INSERT INTO match (id, season, city, date, match_type, player_of_match, venue, team1, team2, toss_winner, toss_decision, winner, result, result_margin, target_runs,
                                                                                                                                                            target_overs,
                                                                                                                                                            super_over,
                                                                                                                                                            method,
                                                                                                                                                            umpire1,
                                                                                                                                                            umpire2)
SELECT * FROM CSVREAD('/home/karthiktiwari/Documents/Playground/ipl-dashboard/src/main/resources/match-data.csv');

-- Create Team Table
CREATE TABLE team (
    team_name VARCHAR(255) PRIMARY KEY,
    total_matches BIGINT DEFAULT 0,
    total_wins BIGINT DEFAULT 0
);

-- Insert teams with total matches played as team1
INSERT INTO team (team_name, total_matches, total_wins)
SELECT team1, COUNT(*), 0 FROM match GROUP BY team1;

-- Update total matches for teams where they played as team2
-- Update total_matches for each team
UPDATE team t
SET total_matches = (
    SELECT COUNT(*)
    FROM match m
    WHERE m.team2 = t.team_name
);

-- Update total_wins for each team
UPDATE team t
SET total_wins = (
    SELECT COUNT(*)
    FROM match m
    WHERE m.winner = t.team_name
    AND m.winner IS NOT NULL
);
