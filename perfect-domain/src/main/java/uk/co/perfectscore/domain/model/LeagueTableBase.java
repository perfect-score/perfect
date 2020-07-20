package uk.co.perfectscore.domain.model;

import java.sql.Date;

import java.sql.Timestamp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity for database table league tables base.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Entity
@Table(name = "league_tables_base")
public class LeagueTableBase implements Serializable {
   
   private static final long serialVersionUID = 1504657979260000L;

   @EmbeddedId
   private LeagueTableBasePK id;

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

   public LeagueTableBase() {
      setId(new LeagueTableBasePK());
   }

   public LeagueTableBase(final int leagueSeasonId,
           final int teamNo,
           final int weekNo,
           final Boolean predicted,
           final Date gameDate,
           final int played,
           final int won,
           final int drawn,
           final int lost,
           final int goalsFor,
           final int goalsAgainst,
           final int points,
           final int form,
           final int homeWon,
           final int homeDrawn,
           final int homeLost,
           final int homeGoalsFor,
           final int homeGoalsAgainst,
           final int homePoints,
           final int homeForm,
           final int awayWon,
           final int awayDrawn,
           final int awayLost,
           final int awayGoalsFor,
           final int awayGoalsAgainst,
           final int awayPoints,
           final int awayForm,
           final Timestamp updatedDate) {
      
      setId(new LeagueTableBasePK(leagueSeasonId, teamNo, predicted, weekNo));
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
   }

   public void setId(final LeagueTableBasePK id) {
      this.id = id;
   }

   public LeagueTableBasePK getId() {
      return id;
   }

   public void setGameDate(final Date gameDate) {
      this.gameDate = gameDate;
   }

   public Date getGameDate() {
      return gameDate;
   }

   public void setPlayed(final Integer played) {
      this.played = played;
   }

   public Integer getPlayed() {
      return played;
   }

   public void setWon(final Integer won) {
      this.won = won;
   }

   public Integer getWon() {
      return won;
   }

   public void setDrawn(final Integer drawn) {
      this.drawn = drawn;
   }

   public Integer getDrawn() {
      return drawn;
   }

   public void setLost(final Integer lost) {
      this.lost = lost;
   }

   public Integer getLost() {
      return lost;
   }

   public void setGoalsFor(final Integer goalsFor) {
      this.goalsFor = goalsFor;
   }

   public Integer getGoalsFor() {
      return goalsFor;
   }

   public void setGoalsAgainst(final Integer goalsAgainst) {
      this.goalsAgainst = goalsAgainst;
   }

   public Integer getGoalsAgainst() {
      return goalsAgainst;
   }

   public void setPoints(final Integer points) {
      this.points = points;
   }

   public Integer getPoints() {
      return points;
   }

   public void setForm(final Integer form) {
      this.form = form;
   }

   public Integer getForm() {
      return form;
   }

   public void setHomeWon(final Integer homeWon) {
      this.homeWon = homeWon;
   }

   public Integer getHomeWon() {
      return homeWon;
   }

   public void setHomeDrawn(final Integer homeDrawn) {
      this.homeDrawn = homeDrawn;
   }

   public Integer getHomeDrawn() {
      return homeDrawn;
   }

   public void setHomeLost(final Integer homeLost) {
      this.homeLost = homeLost;
   }

   public Integer getHomeLost() {
      return homeLost;
   }

   public void setHomeGoalsFor(final Integer homeGoalsFor) {
      this.homeGoalsFor = homeGoalsFor;
   }

   public Integer getHomeGoalsFor() {
      return homeGoalsFor;
   }

   public void setHomeGoalsAgainst(final Integer homeGoalsAgainst) {
      this.homeGoalsAgainst = homeGoalsAgainst;
   }

   public Integer getHomeGoalsAgainst() {
      return homeGoalsAgainst;
   }

   public void setHomePoints(final Integer homePoints) {
      this.homePoints = homePoints;
   }

   public Integer getHomePoints() {
      return homePoints;
   }

   public void setHomeForm(final Integer homeForm) {
      this.homeForm = homeForm;
   }

   public Integer getHomeForm() {
      return homeForm;
   }

   public void setAwayWon(final Integer awayWon) {
      this.awayWon = awayWon;
   }

   public Integer getAwayWon() {
      return awayWon;
   }

   public void setAwayDrawn(final Integer awayDrawn) {
      this.awayDrawn = awayDrawn;
   }

   public Integer getAwayDrawn() {
      return awayDrawn;
   }

   public void setAwayLost(final Integer awayLost) {
      this.awayLost = awayLost;
   }

   public Integer getAwayLost() {
      return awayLost;
   }

   public void setAwayGoalsFor(final Integer awayGoalsFor) {
      this.awayGoalsFor = awayGoalsFor;
   }

   public Integer getAwayGoalsFor() {
      return awayGoalsFor;
   }

   public void setAwayGoalsAgainst(final Integer awayGoalsAgainst) {
      this.awayGoalsAgainst = awayGoalsAgainst;
   }

   public Integer getAwayGoalsAgainst() {
      return awayGoalsAgainst;
   }

   public void setAwayPoints(final Integer awayPoints) {
      this.awayPoints = awayPoints;
   }

   public Integer getAwayPoints() {
      return awayPoints;
   }

   public void setAwayForm(final Integer awayForm) {
      this.awayForm = awayForm;
   }

   public Integer getAwayForm() {
      return awayForm;
   }

   public void setUpdatedDate(final Timestamp updatedDate) {
      this.updatedDate = updatedDate;
   }

   public Timestamp getUpdatedDate() {
      return updatedDate;
   }

   /**
    * Display the details.
    * 
    * @return String containing the details loaded.
    */
   public String displayDetails() {
      return "LeagueTableBase " + 
             "[LeagueSeasonId="   + getId().getLeagueSeasonId()+ "]" +
             "[TeamNo="           + getId().getTeamNo()     + "]" +
             "[WeekNo="           + getId().getWeekNo()     + "]" +
             "[Predicted="        + getId().getPredicted()  + "]" +
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
             "[UpdatedDate="      + getUpdatedDate()        + "]";
   }

   @Override
   public String toString() {
      return displayDetails();
   }

   /**
    * Return a new version of the entity - this may act as an aid to persistence.
    * @return Entity comprised of data within this entity.
    */
   public LeagueTableBase getEntity() {
      LeagueTableBase leagueTable = new LeagueTableBase();

      leagueTable.setId(new LeagueTableBasePK(getId().getLeagueSeasonId(), getId().getTeamNo(), getId().getPredicted(), getId().getWeekNo()));
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

      return leagueTable;
   }
}
