-- -------------------------------------------------------------------------------------------------
-- Sample Data
-- -------------------------------------------------------------------------------------------------

DELETE FROM countries;
INSERT INTO countries (iso_code) VALUES
('GB'); -- United Kingdom

DELETE FROM leagues;
INSERT INTO leagues (league_no, league_name, iso_code) VALUES
('1', 'English Premier League', 'GB');

DELETE FROM league_seasons;
INSERT INTO league_seasons (id, league_no, season_name) VALUES
('1', '1', '2019-2020');

DELETE FROM weeks;
INSERT INTO weeks (league_season_id, week_no, week_name) VALUES
('1',  '1', 'Game Week 1'),
('1',  '2', 'Game Week 2'),
('1',  '3', 'Game Week 3'),
('1',  '4', 'Game Week 4'),
('1',  '5', 'Game Week 5'),
('1',  '6', 'Game Week 6'),
('1',  '7', 'Game Week 7'),
('1',  '8', 'Game Week 8'),
('1',  '9', 'Game Week 9'),
('1', '10', 'Game Week 10'),
('1', '11', 'Game Week 11'),
('1', '12', 'Game Week 12'),
('1', '13', 'Game Week 13'),
('1', '14', 'Game Week 14'),
('1', '15', 'Game Week 15'),
('1', '16', 'Game Week 16'),
('1', '17', 'Game Week 17'),
('1', '18', 'Game Week 18'),
('1', '19', 'Game Week 19'),
('1', '20', 'Game Week 20'),
('1', '21', 'Game Week 21'),
('1', '22', 'Game Week 22'),
('1', '23', 'Game Week 23'),
('1', '24', 'Game Week 24'),
('1', '25', 'Game Week 25'),
('1', '26', 'Game Week 26'),
('1', '27', 'Game Week 27'),
('1', '28', 'Game Week 28'),
('1', '29', 'Game Week 29'),
('1', '30', 'Game Week 30'),
('1', '31', 'Game Week 31'),
('1', '32', 'Game Week 32'),
('1', '33', 'Game Week 33'),
('1', '34', 'Game Week 34'),
('1', '35', 'Game Week 35'),
('1', '36', 'Game Week 36'),
('1', '37', 'Game Week 37'),
('1', '38', 'Game Week 38');

...
