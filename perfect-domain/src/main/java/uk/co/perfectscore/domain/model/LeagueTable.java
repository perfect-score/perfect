package uk.co.perfectscore.domain.model;

import java.sql.Date;

import java.sql.Timestamp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity for database view selecting league tables.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Entity
@Table(name = "v_league_tables")
public class LeagueTable implements Serializable {

   private static final long serialVersionUID = 1504687187210001L;

   @EmbeddedId
   private LeagueTablePK id;

   @Column(name = "game_date", nullable = false)
   private Date gameDate;

   @Column(name = "played", nullable = false)
   private Integer played = 0;

   @Column(name = "won", nullable = false)
   private Integer won = 0;

   @Column(name = "drawn", nullable = false)
   private Integer drawn = 0;

   @Column(name = "lost", nullable = false)
   private Integer lost = 0;

   @Column(name = "goals_for", nullable = false)
   private Integer goalsFor = 0;

   @Column(name = "goals_against", nullable = false)
   private Integer goalsAgainst = 0;

   @Column(name = "points", nullable = false)
   private Integer points = 0;

   @Column(name = "form", nullable = false)
   private Integer form = 0;

   @Column(name = "home_won", nullable = false)
   private Integer homeWon = 0;

   @Column(name = "home_drawn", nullable = false)
   private Integer homeDrawn = 0;

   @Column(name = "home_lost", nullable = false)
   private Integer homeLost = 0;

   @Column(name = "home_goals_for", nullable = false)
   private Integer homeGoalsFor = 0;

   @Column(name = "home_goals_against", nullable = false)
   private Integer homeGoalsAgainst = 0;

   @Column(name = "home_points", nullable = false)
   private Integer homePoints = 0;

   @Column(name = "home_form", nullable = false)
   private Integer homeForm = 0;

   @Column(name = "away_won", nullable = false)
   private Integer awayWon = 0;

   @Column(name = "away_drawn", nullable = false)
   private Integer awayDrawn = 0;

   @Column(name = "away_lost", nullable = false)
   private Integer awayLost = 0;

   @Column(name = "away_goals_for", nullable = false)
   private Integer awayGoalsFor = 0;

   @Column(name = "away_goals_against", nullable = false)
   private Integer awayGoalsAgainst = 0;

   @Column(name = "away_points", nullable = false)
   private Integer awayPoints = 0;

   @Column(name = "away_form", nullable = false)
   private Integer awayForm = 0;

   @Column(name = "updated_date", nullable = true)
   private Timestamp updatedDate;

   @Column(name = "team_name", length = 40, nullable = true)
   private String teamName = "";

   public LeagueTable() {
      setId(new LeagueTablePK());
   }

   public LeagueTable(int leagueSeasonId,
           int teamNo,
           Boolean predicted,
           int weekNo,
           Date gameDate,
           int played,
           int won,
           int drawn,
           int lost,
           int goalsFor,
           int goalsAgainst,
           int points,
           int form,
           int homeWon,
           int homeDrawn,
           int homeLost,
           int homeGoalsFor,
           int homeGoalsAgainst,
           int homePoints,
           int homeForm,
           int awayWon,
           int awayDrawn,
           int awayLost,
           int awayGoalsFor,
           int awayGoalsAgainst,
           int awayPoints,
           int awayForm,
           Timestamp updatedDate,
           String teamName) {
      setId(new LeagueTablePK(leagueSeasonId, teamNo, predicted, weekNo));
      setGameDate(gameDate);
      setPlayed(played);
      setWon(won);
      setDrawn(drawn);
      setLost(lost);
      setGoalsFor(goalsFor);
      setGoalsAgainst(goalsAgainst);
      setPoints(points);
      setForm(form);
      setHomeWon(homeWon);
      setHomeDrawn(homeDrawn);
      setHomeLost(homeLost);
      setHomeGoalsFor(homeGoalsFor);
      setHomeGoalsAgainst(homeGoalsAgainst);
      setHomePoints(homePoints);
      setHomeForm(homeForm);
      setAwayWon(awayWon);
      setAwayDrawn(awayDrawn);
      setAwayLost(awayLost);
      setAwayGoalsFor(awayGoalsFor);
      setAwayGoalsAgainst(awayGoalsAgainst);
      setAwayPoints(awayPoints);
      setAwayForm(awayForm);
      setUpdatedDate(updatedDate);
      setTeamName(teamName);
   }

   public void setId(LeagueTablePK id) {
      this.id = id;
   }

   public LeagueTablePK getId() {
      return id;
   }

   public void setGameDate(Date gameDate) {
      this.gameDate = gameDate;
   }

   public Date getGameDate() {
      return gameDate;
   }

   public void setPlayed(Integer played) {
      this.played = played;
   }

   public Integer getPlayed() {
      return played;
   }

   public void setWon(Integer won) {
      this.won = won;
   }

   public Integer getWon() {
      return won;
   }

   public void setDrawn(Integer drawn) {
      this.drawn = drawn;
   }

   public Integer getDrawn() {
      return drawn;
   }

   public void setLost(Integer lost) {
      this.lost = lost;
   }

   public Integer getLost() {
      return lost;
   }

   public void setGoalsFor(Integer goalsFor) {
      this.goalsFor = goalsFor;
   }

   public Integer getGoalsFor() {
      return goalsFor;
   }

   public void setGoalsAgainst(Integer goalsAgainst) {
      this.goalsAgainst = goalsAgainst;
   }

   public Integer getGoalsAgainst() {
      return goalsAgainst;
   }

   public void setPoints(Integer points) {
      this.points = points;
   }

   public Integer getPoints() {
      return points;
   }

   public void setForm(Integer form) {
      this.form = form;
   }

   public Integer getForm() {
      return form;
   }

   public void setHomeWon(Integer homeWon) {
      this.homeWon = homeWon;
   }

   public Integer getHomeWon() {
      return homeWon;
   }

   public void setHomeDrawn(Integer homeDrawn) {
      this.homeDrawn = homeDrawn;
   }

   public Integer getHomeDrawn() {
      return homeDrawn;
   }

   public void setHomeLost(Integer homeLost) {
      this.homeLost = homeLost;
   }

   public Integer getHomeLost() {
      return homeLost;
   }

   public void setHomeGoalsFor(Integer homeGoalsFor) {
      this.homeGoalsFor = homeGoalsFor;
   }

   public Integer getHomeGoalsFor() {
      return homeGoalsFor;
   }

   public void setHomeGoalsAgainst(Integer homeGoalsAgainst) {
      this.homeGoalsAgainst = homeGoalsAgainst;
   }

   public Integer getHomeGoalsAgainst() {
      return homeGoalsAgainst;
   }

   public void setHomePoints(Integer homePoints) {
      this.homePoints = homePoints;
   }

   public Integer getHomePoints() {
      return homePoints;
   }

   public void setHomeForm(Integer homeForm) {
      this.homeForm = homeForm;
   }

   public Integer getHomeForm() {
      return homeForm;
   }

   public void setAwayWon(Integer awayWon) {
      this.awayWon = awayWon;
   }

   public Integer getAwayWon() {
      return awayWon;
   }

   public void setAwayDrawn(Integer awayDrawn) {
      this.awayDrawn = awayDrawn;
   }

   public Integer getAwayDrawn() {
      return awayDrawn;
   }

   public void setAwayLost(Integer awayLost) {
      this.awayLost = awayLost;
   }

   public Integer getAwayLost() {
      return awayLost;
   }

   public void setAwayGoalsFor(Integer awayGoalsFor) {
      this.awayGoalsFor = awayGoalsFor;
   }

   public Integer getAwayGoalsFor() {
      return awayGoalsFor;
   }

   public void setAwayGoalsAgainst(Integer awayGoalsAgainst) {
      this.awayGoalsAgainst = awayGoalsAgainst;
   }

   public Integer getAwayGoalsAgainst() {
      return awayGoalsAgainst;
   }

   public void setAwayPoints(Integer awayPoints) {
      this.awayPoints = awayPoints;
   }

   public Integer getAwayPoints() {
      return awayPoints;
   }

   public void setAwayForm(Integer awayForm) {
      this.awayForm = awayForm;
   }

   public Integer getAwayForm() {
      return awayForm;
   }

   public void setUpdatedDate(Timestamp updatedDate) {
      this.updatedDate = updatedDate;
   }

   public Timestamp getUpdatedDate() {
      return updatedDate;
   }

   public void setTeamName(String teamName) {
      this.teamName = teamName;
   }

   public String getTeamName() {
      return teamName;
   }

   /**
    * Display the details.
    * @return String containing the details loaded.
    */
   public String displayDetails() {
      return "LeagueTable " + 
             "[LeagueSeasonId="   + getId().getLeagueSeasonId()+ "]" +
             "[TeamNo="           + getId().getTeamNo()     + "]" +
             "[Predicted="        + getId().getPredicted()  + "]" +
             "[WeekNo="           + getId().getWeekNo()     + "]" +
             "[GameDate="         + getGameDate()           + "]" +
             "[Played="           + getPlayed()             + "]" +
             "[Won="              + getWon()                + "]" +
             "[Drawn="            + getDrawn()              + "]" +
             "[Lost="             + getLost()               + "]" +
             "[GoalsFor="         + getGoalsFor()           + "]" +
             "[GoalsAgainst="     + getGoalsAgainst()       + "]" +
             "[Points="           + getPoints()             + "]" +
             "[Form="             + getForm()               + "]" +
             "[HomeWon="          + getHomeWon()            + "]" +
             "[HomeDrawn="        + getHomeDrawn()          + "]" +
             "[HomeLost="         + getHomeLost()           + "]" +
             "[HomeGoalsFor="     + getHomeGoalsFor()       + "]" +
             "[HomeGoalsAgainst=" + getHomeGoalsAgainst()   + "]" +
             "[HomePoints="       + getHomePoints()         + "]" +
             "[HomeForm="         + getHomeForm()           + "]" +
             "[AwayWon="          + getAwayWon()            + "]" +
             "[AwayDrawn="        + getAwayDrawn()          + "]" +
             "[AwayLost="         + getAwayLost()           + "]" +
             "[AwayGoalsFor="     + getAwayGoalsFor()       + "]" +
             "[AwayGoalsAgainst=" + getAwayGoalsAgainst()   + "]" +
             "[AwayPoints="       + getAwayPoints()         + "]" +
             "[AwayForm="         + getAwayForm()           + "]" +
             "[UpdatedDate="      + getUpdatedDate()        + "]" +
             "[TeamName="         + getTeamName()           + "]";
   }

   @Override
   public String toString() {
      return displayDetails();
   }

   /**
    * Return a new version of the entity - this may act as an aid to persistence.
    * 
    * @return Entity comprised of data within this entity.
    */
   public LeagueTable getEntity() {
      LeagueTable leagueTable = new LeagueTable();

      leagueTable.setId(new LeagueTablePK(getId().getLeagueSeasonId(), getId().getTeamNo(),
            getId().getPredicted(), getId().getWeekNo()));
      leagueTable.setGameDate(this.gameDate);
      leagueTable.setPlayed(this.played);
      leagueTable.setWon(this.won);
      leagueTable.setDrawn(this.drawn);
      leagueTable.setLost(this.lost);
      leagueTable.setGoalsFor(this.goalsFor);
      leagueTable.setGoalsAgainst(this.goalsAgainst);
      leagueTable.setPoints(this.points);
      leagueTable.setForm(this.form);
      leagueTable.setHomeWon(this.homeWon);
      leagueTable.setHomeDrawn(this.homeDrawn);
      leagueTable.setHomeLost(this.homeLost);
      leagueTable.setHomeGoalsFor(this.homeGoalsFor);
      leagueTable.setHomeGoalsAgainst(this.homeGoalsAgainst);
      leagueTable.setHomePoints(this.homePoints);
      leagueTable.setHomeForm(this.homeForm);
      leagueTable.setAwayWon(this.awayWon);
      leagueTable.setAwayDrawn(this.awayDrawn);
      leagueTable.setAwayLost(this.awayLost);
      leagueTable.setAwayGoalsFor(this.awayGoalsFor);
      leagueTable.setAwayGoalsAgainst(this.awayGoalsAgainst);
      leagueTable.setAwayPoints(this.awayPoints);
      leagueTable.setAwayForm(this.awayForm);
      leagueTable.setUpdatedDate(this.updatedDate);
      leagueTable.setTeamName(this.teamName);

      return leagueTable;
   }
}
