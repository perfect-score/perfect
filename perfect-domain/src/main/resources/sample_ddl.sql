-- -------------------------------------------------------------------------------------------------
-- Sample Tables
-- -------------------------------------------------------------------------------------------------

-- -------------------------------------------------------------------------------------------------
-- PERFECT_SCORE_RESULTS
-- -------------------------------------------------------------------------------------------------

CREATE TABLE perfect_score_results
(
  league_season_id               INTEGER    NOT NULL,
  week_no                        INTEGER    NOT NULL,
  home_scores                    INTEGER    NOT NULL,
  away_scores                    INTEGER    NOT NULL,
  home_scores_pct                VARCHAR(5) NOT NULL,
  away_scores_pct                VARCHAR(5) NOT NULL,
  home_wins                      INTEGER    NOT NULL,
  away_wins                      INTEGER    NOT NULL,
  draws                          INTEGER    NOT NULL,
  home_wins_pct                  VARCHAR(5) NOT NULL,
  away_wins_pct                  VARCHAR(5) NOT NULL,
  draws_pct                      VARCHAR(5) NOT NULL,
  result                         INTEGER    NOT NULL,
  result_pct                     VARCHAR(5) NOT NULL,
  perfect_result                 INTEGER    NOT NULL,
  perfect_result_pct             VARCHAR(5) NOT NULL,
  updated_date                   TIMESTAMP,
  PRIMARY KEY (league_season_id, week_no)
);

-- -------------------------------------------------------------------------------------------------
-- CONTACT_MESSAGES
-- -------------------------------------------------------------------------------------------------

CREATE SEQUENCE contact_messages_seq START WITH 1 MAXVALUE 999999999999999999 INCREMENT BY 1 NO CYCLE;

CREATE TABLE contact_messages
(
  id                             INTEGER       NOT NULL,
  created_date                   TIMESTAMP     NOT NULL,
  name                           VARCHAR(60)   NOT NULL,
  email_address                  VARCHAR(60)   NOT NULL,
  message                        VARCHAR(4000) NOT NULL,
  PRIMARY KEY (id)
);

-- -------------------------------------------------------------------------------------------------
-- COUNTRIES
-- -------------------------------------------------------------------------------------------------

CREATE TABLE countries
(
  iso_code                       VARCHAR(2) NOT NULL,
  PRIMARY KEY (iso_code)
);

-- -------------------------------------------------------------------------------------------------
-- LEAGUES
-- -------------------------------------------------------------------------------------------------

CREATE TABLE leagues
(
  league_no                      INTEGER      NOT NULL,
  league_name                    VARCHAR(100) NOT NULL,
  iso_code                       VARCHAR(2)   NOT NULL,
  PRIMARY KEY (league_no)
);

...
