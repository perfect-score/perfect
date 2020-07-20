package uk.co.perfectscore.domain.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity for database table schedules base.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Entity
@Table(name = "schedules_base")
public class ScheduleBase implements Serializable {
   
   private static final long serialVersionUID = 8752310805970005L;

   @EmbeddedId
   private ScheduleBasePK id;

   @Column(name = "home_team_no", nullable = false)
   private Integer homeTeamNo = 0;

   @Column(name = "away_team_no", nullable = false)
   private Integer awayTeamNo = 0;

   @Column(name = "game_date", nullable = false)
   private Date gameDate;

   @Column(name = "home_team_score", nullable = true)
   private Integer homeTeamScore = 0;

   @Column(name = "away_team_score", nullable = true)
   private Integer awayTeamScore = 0;

   @Column(name = "result", nullable = true)
   private Integer result = 0;

   @Column(name = "home_team_score_predict", nullable = true)
   private Integer homeTeamScorePredict = 0;

   @Column(name = "away_team_score_predict", nullable = true)
   private Integer awayTeamScorePredict = 0;

   @Column(name = "predict_home_pct", nullable = true)
   private Integer predictHomePct = 0;

   @Column(name = "predict_away_pct", nullable = true)
   private Integer predictAwayPct = 0;

   @Column(name = "predict_draw_pct", nullable = true)
   private Integer predictDrawPct = 0;

   @Column(name = "home_team_score_predict_diff", nullable = true)
   private Double homeTeamScorePredictDiff = 0.0;

   @Column(name = "away_team_score_predict_diff", nullable = true)
   private Double awayTeamScorePredictDiff = 0.0;

   @Column(name = "result_prediction", nullable = true)
   private Integer resultPrediction = 0;

   @Column(name = "updated_date", nullable = true)
   private Timestamp updatedDate;

   public ScheduleBase() {
      setId(new ScheduleBasePK());
   }

   public ScheduleBase(final int leagueSeasonId,
           final int weekNo,
           final int gameNo,
           final int homeTeamNo,
           final int awayTeamNo,
           final Date gameDate,
           final Integer homeTeamScore,
           final Integer awayTeamScore,
           final Integer result,
           final Integer homeTeamScorePredict,
           final Integer awayTeamScorePredict,
           final Integer predictHomePct,
           final Integer predictAwayPct,
           final Integer predictDrawPct,
           final Double homeTeamScorePredictDiff,
           final Double awayTeamScorePredictDiff,
           final Integer resultPrediction,
           final Timestamp updatedDate) {
      setId(new ScheduleBasePK(leagueSeasonId, weekNo, gameNo));
      setHomeTeamNo(homeTeamNo);
      setAwayTeamNo(awayTeamNo);
      setGameDate(gameDate);
      setHomeTeamScore(homeTeamScore);
      setAwayTeamScore(awayTeamScore);
      setResult(result);
      setHomeTeamScorePredict(homeTeamScorePredict);
      setAwayTeamScorePredict(awayTeamScorePredict);
      setPredictHomePct(predictHomePct);
      setPredictAwayPct(predictAwayPct);
      setPredictDrawPct(predictDrawPct);
      setHomeTeamScorePredictDiff(homeTeamScorePredictDiff);
      setAwayTeamScorePredictDiff(awayTeamScorePredictDiff);
      setResultPrediction(resultPrediction);
      setUpdatedDate(updatedDate);
   }

   public void setId(final ScheduleBasePK id) {
      this.id = id;
   }

   public ScheduleBasePK getId() {
      return id;
   }

   public void setHomeTeamNo(final Integer homeTeamNo) {
      this.homeTeamNo = homeTeamNo;
   }

   public Integer getHomeTeamNo() {
      return homeTeamNo;
   }

   public void setAwayTeamNo(final Integer awayTeamNo) {
      this.awayTeamNo = awayTeamNo;
   }

   public Integer getAwayTeamNo() {
      return awayTeamNo;
   }

   public void setGameDate(final Date gameDate) {
      this.gameDate = gameDate;
   }

   public Date getGameDate() {
      return gameDate;
   }

   public void setHomeTeamScore(final Integer homeTeamScore) {
      this.homeTeamScore = homeTeamScore;
   }

   public Integer getHomeTeamScore() {
      return homeTeamScore;
   }

   public void setAwayTeamScore(final Integer awayTeamScore) {
      this.awayTeamScore = awayTeamScore;
   }

   public Integer getAwayTeamScore() {
      return awayTeamScore;
   }

   public void setResult(final Integer result) {
      this.result = result;
   }

   public Integer getResult() {
      return result;
   }

   public void setHomeTeamScorePredict(final Integer homeTeamScorePredict) {
      this.homeTeamScorePredict = homeTeamScorePredict;
   }

   public Integer getHomeTeamScorePredict() {
      return homeTeamScorePredict;
   }

   public void setAwayTeamScorePredict(final Integer awayTeamScorePredict) {
      this.awayTeamScorePredict = awayTeamScorePredict;
   }

   public Integer getAwayTeamScorePredict() {
      return awayTeamScorePredict;
   }

   public void setPredictHomePct(final Integer predictHomePct) {
      this.predictHomePct = predictHomePct;
   }

   public Integer getPredictHomePct() {
      return predictHomePct;
   }

   public void setPredictAwayPct(final Integer predictAwayPct) {
      this.predictAwayPct = predictAwayPct;
   }

   public Integer getPredictAwayPct() {
      return predictAwayPct;
   }

   public void setPredictDrawPct(final Integer predictDrawPct) {
      this.predictDrawPct = predictDrawPct;
   }

   public Integer getPredictDrawPct() {
      return predictDrawPct;
   }

   public Double getHomeTeamScorePredictDiff() {
      return homeTeamScorePredictDiff;
   }

   public void setHomeTeamScorePredictDiff(Double homeTeamScorePredictDiff) {
      this.homeTeamScorePredictDiff = homeTeamScorePredictDiff;
   }

   public Double getAwayTeamScorePredictDiff() {
      return awayTeamScorePredictDiff;
   }

   public void setAwayTeamScorePredictDiff(Double awayTeamScorePredictDiff) {
      this.awayTeamScorePredictDiff = awayTeamScorePredictDiff;
   }

   public Integer getResultPrediction() {
      return resultPrediction;
   }

   public void setResultPrediction(Integer resultPrediction) {
      this.resultPrediction = resultPrediction;
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
      return "Schedule " + 
             "[LeagueSeasonId="           + getId().getLeagueSeasonId()   + "]" +
             "[WeekNo="                   + getId().getWeekNo()           + "]" +
             "[GameNo="                   + getId().getGameNo()           + "]" +
             "[HomeTeamNo="               + getHomeTeamNo()               + "]" +
             "[AwayTeamNo="               + getAwayTeamNo()               + "]" +
             "[GameDate="                 + getGameDate()                 + "]" +
             "[HomeTeamScore="            + getHomeTeamScore()            + "]" +
             "[AwayTeamScore="            + getAwayTeamScore()            + "]" +
             "[Result="                   + getResult()                   + "]" +
             "[HomeTeamScorePredict="     + getHomeTeamScorePredict()     + "]" +
             "[AwayTeamScorePredict="     + getAwayTeamScorePredict()     + "]" +
             "[HomeTeamScorePredictDiff=" + getHomeTeamScorePredictDiff() + "]" +
             "[AwayTeamScorePredictDiff=" + getAwayTeamScorePredictDiff() + "]" +
             "[PredictHomePct="           + getPredictHomePct()           + "]" +
             "[PredictAwayPct="           + getPredictAwayPct()           + "]" +
             "[PredictDrawPct="           + getPredictDrawPct()           + "]" +
             "[ResultPrediction="         + getResultPrediction()         + "]" +
             "[UpdatedDate="              + getUpdatedDate()              + "]";
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
   public ScheduleBase getEntity() {
      ScheduleBase schedule = new ScheduleBase();

      schedule.setId(new ScheduleBasePK(getId().getLeagueSeasonId(), getId().getWeekNo(),
            getId().getGameNo()));
      schedule.setHomeTeamNo(this.homeTeamNo);
      schedule.setAwayTeamNo(this.awayTeamNo);
      schedule.setGameDate(this.gameDate);
      schedule.setHomeTeamScore(this.homeTeamScore);
      schedule.setAwayTeamScore(this.awayTeamScore);
      schedule.setResult(this.result);
      schedule.setHomeTeamScorePredict(this.homeTeamScorePredict);
      schedule.setAwayTeamScorePredict(this.awayTeamScorePredict);
      schedule.setPredictHomePct(this.predictHomePct);
      schedule.setPredictAwayPct(this.predictAwayPct);
      schedule.setPredictDrawPct(this.predictDrawPct);
      schedule.setHomeTeamScorePredictDiff(this.homeTeamScorePredictDiff);
      schedule.setAwayTeamScorePredictDiff(this.awayTeamScorePredictDiff);
      schedule.setResultPrediction(this.resultPrediction);
      schedule.setUpdatedDate(this.updatedDate);

      return schedule;
   }
}
