package uk.co.perfectscore.domain.model;

import java.sql.Timestamp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity for database table perfect score results.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Entity
@Table(name = "perfect_score_results")
public class PerfectScoreResult implements Serializable {
   
   private static final long serialVersionUID = 8865260589970000L;

   @EmbeddedId
   private PerfectScoreResultPK id;

   @Column(name = "home_scores", nullable = false)
   private Integer homeScores = 0;

   @Column(name = "away_scores", nullable = false)
   private Integer awayScores = 0;

   @Column(name = "home_scores_pct", length = 4, nullable = false)
   private String homeScoresPct = "";

   @Column(name = "away_scores_pct", length = 4, nullable = false)
   private String awayScoresPct = "";

   @Column(name = "home_wins", nullable = false)
   private Integer homeWins = 0;

   @Column(name = "away_wins", nullable = false)
   private Integer awayWins = 0;

   @Column(name = "draws", nullable = false)
   private Integer draws = 0;

   @Column(name = "home_wins_pct", length = 4, nullable = false)
   private String homeWinsPct = "";

   @Column(name = "away_wins_pct", length = 4, nullable = false)
   private String awayWinsPct = "";

   @Column(name = "draws_pct", length = 4, nullable = false)
   private String drawsPct = "";

   @Column(name = "result", nullable = false)
   private Integer result = 0;

   @Column(name = "result_pct", length = 4, nullable = false)
   private String resultPct = "";

   @Column(name = "perfect_result", nullable = false)
   private Integer perfectResult = 0;

   @Column(name = "perfect_result_pct", length = 4, nullable = false)
   private String perfectResultPct = "";

   @Column(name = "updated_date", nullable = true)
   private Timestamp updatedDate;

   public PerfectScoreResult() {
      setId(new PerfectScoreResultPK());
   }

   public PerfectScoreResult(final int leagueSeasonId,
           final int weekNo,
           final int homeScores,
           final int awayScores,
           final String homeScoresPct,
           final String awayScoresPct,
           final int homeWins,
           final int awayWins,
           final int draws,
           final String homeWinsPct,
           final String awayWinsPct,
           final String drawsPct,
           final int result,
           final String resultPct,
           final int perfectResult,
           final String perfectResultPct,
           final Timestamp updatedDate)
   {
      setId(new PerfectScoreResultPK(leagueSeasonId, weekNo));
      setHomeScores(homeScores);
      setAwayScores(awayScores);
      setHomeScoresPct(homeScoresPct);
      setAwayScoresPct(awayScoresPct);
      setHomeWins(homeWins);
      setAwayWins(awayWins);
      setDraws(draws);
      setHomeWinsPct(homeWinsPct);
      setAwayWinsPct(awayWinsPct);
      setDrawsPct(drawsPct);
      setResult(result);
      setResultPct(resultPct);
      setPerfectResult(perfectResult);
      setPerfectResultPct(perfectResultPct);
      setUpdatedDate(updatedDate);
   }

   public void setId(final PerfectScoreResultPK id) {
      this.id = id;
   }

   public PerfectScoreResultPK getId() {
      return id;
   }

   public void setHomeScores(final Integer homeScores) {
      this.homeScores = homeScores;
   }

   public Integer getHomeScores() {
      return homeScores;
   }

   public void setAwayScores(final Integer awayScores) {
      this.awayScores = awayScores;
   }

   public Integer getAwayScores() {
      return awayScores;
   }

   public void setHomeScoresPct(final String homeScoresPct) {
      this.homeScoresPct = homeScoresPct;
   }

   public String getHomeScoresPct() {
      return homeScoresPct;
   }

   public void setAwayScoresPct(final String awayScoresPct) {
      this.awayScoresPct = awayScoresPct;
   }

   public String getAwayScoresPct() {
      return awayScoresPct;
   }

   public void setHomeWins(final Integer homeWins) {
      this.homeWins = homeWins;
   }

   public Integer getHomeWins() {
      return homeWins;
   }

   public void setAwayWins(final Integer awayWins) {
      this.awayWins = awayWins;
   }

   public Integer getAwayWins() {
      return awayWins;
   }

   public void setDraws(final Integer draws) {
      this.draws = draws;
   }

   public Integer getDraws() {
      return draws;
   }

   public void setHomeWinsPct(final String homeWinsPct) {
      this.homeWinsPct = homeWinsPct;
   }

   public String getHomeWinsPct() {
      return homeWinsPct;
   }

   public void setAwayWinsPct(final String awayWinsPct) {
      this.awayWinsPct = awayWinsPct;
   }

   public String getAwayWinsPct() {
      return awayWinsPct;
   }

   public void setDrawsPct(final String drawsPct) {
      this.drawsPct = drawsPct;
   }

   public String getDrawsPct() {
      return drawsPct;
   }

   public void setResult(final Integer result) {
      this.result = result;
   }

   public Integer getResult() {
      return result;
   }

   public void setResultPct(final String resultPct) {
      this.resultPct = resultPct;
   }

   public String getResultPct() {
      return resultPct;
   }

   public void setPerfectResult(final Integer perfectResult) {
      this.perfectResult = perfectResult;
   }

   public Integer getPerfectResult() {
      return perfectResult;
   }

   public void setPerfectResultPct(final String perfectResultPct) {
      this.perfectResultPct = perfectResultPct;
   }

   public String getPerfectResultPct() {
      return perfectResultPct;
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
      return "PerfectScoreResult " + 
             "[LeagueSeasonId="   + getId().getLeagueSeasonId()+ "]" +
             "[WeekNo="           + getId().getWeekNo()     + "]" +
             "[HomeScores="       + getHomeScores()         + "]" +
             "[AwayScores="       + getAwayScores()         + "]" +
             "[HomeScoresPct="    + getHomeScoresPct()      + "]" +
             "[AwayScoresPct="    + getAwayScoresPct()      + "]" +
             "[HomeWins="         + getHomeWins()           + "]" +
             "[AwayWins="         + getAwayWins()           + "]" +
             "[Draws="            + getDraws()              + "]" +
             "[HomeWinsPct="      + getHomeWinsPct()        + "]" +
             "[AwayWinsPct="      + getAwayWinsPct()        + "]" +
             "[DrawsPct="         + getDrawsPct()           + "]" +
             "[Result="           + getResult()             + "]" +
             "[ResultPct="        + getResultPct()          + "]" +
             "[PerfectResult="    + getPerfectResult()      + "]" +
             "[PerfectResultPct=" + getPerfectResultPct()   + "]" +
             "[UpdatedDate="      + getUpdatedDate()        + "]";
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
   public PerfectScoreResult getEntity() {
      PerfectScoreResult perfectScoreResult = new PerfectScoreResult();

      perfectScoreResult.setId(new PerfectScoreResultPK(getId().getLeagueSeasonId(), getId().getWeekNo()));
      perfectScoreResult.setHomeScores(this.homeScores);
      perfectScoreResult.setAwayScores(this.awayScores);
      perfectScoreResult.setHomeScoresPct(this.homeScoresPct);
      perfectScoreResult.setAwayScoresPct(this.awayScoresPct);
      perfectScoreResult.setHomeWins(this.homeWins);
      perfectScoreResult.setAwayWins(this.awayWins);
      perfectScoreResult.setDraws(this.draws);
      perfectScoreResult.setHomeWinsPct(this.homeWinsPct);
      perfectScoreResult.setAwayWinsPct(this.awayWinsPct);
      perfectScoreResult.setDrawsPct(this.drawsPct);
      perfectScoreResult.setResult(this.result);
      perfectScoreResult.setResultPct(this.resultPct);
      perfectScoreResult.setPerfectResult(this.perfectResult);
      perfectScoreResult.setPerfectResultPct(this.perfectResultPct);
      perfectScoreResult.setUpdatedDate(this.updatedDate);

      return perfectScoreResult;
   }
}
