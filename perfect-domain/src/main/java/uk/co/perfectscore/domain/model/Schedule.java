package uk.co.perfectscore.domain.model;

import java.sql.Date;

import java.sql.Timestamp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity for database view selecting schedules.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Entity
@Table(name = "v_schedules")
public class Schedule implements Serializable {
   
   private static final long serialVersionUID = 8752310805970005L;

   @EmbeddedId
   private SchedulePK id;

   @Column(name = "home_team_no", nullable = false)
   private Integer homeTeamNo = 0;

   @Column(name = "away_team_no", nullable = false)
   private Integer awayTeamNo = 0;

   @Column(name = "game_date", nullable = false)
   private Date gameDate;

   @Column(name = "home_team_score", nullable = true)
   private Integer homeTeamScore;

   @Column(name = "away_team_score", nullable = true)
   private Integer awayTeamScore;

   @Column(name = "result", nullable = true)
   private Integer result = 0;

   @Column(name = "home_team_score_predict", nullable = true)
   private Integer homeTeamScorePredict = 0;

   @Column(name = "away_team_score_predict", nullable = true)
   private Integer awayTeamScorePredict = 0;

   @Column(name = "home_team_score_predict_diff", nullable = true)
   private Double homeTeamScorePredictDiff = 0.0;

   @Column(name = "away_team_score_predict_diff", nullable = true)
   private Double awayTeamScorePredictDiff = 0.0;

   @Column(name = "predict_home_pct", nullable = true)
   private Integer predictHomePct = 0;

   @Column(name = "predict_away_pct", nullable = true)
   private Integer predictAwayPct = 0;

   @Column(name = "predict_draw_pct", nullable = true)
   private Integer predictDrawPct = 0;

   @Column(name = "updated_date", nullable = true)
   private Timestamp updatedDate;

   @Column(name = "season_name", nullable = false)
   private String seasonName;

   @Column(name = "home_team_name", nullable = false)
   private String homeTeamName;

   @Column(name = "away_team_name", nullable = false)
   private String awayTeamName;

   @Column(name = "home_team_short_name", nullable = false)
   private String homeTeamShortName;

   @Column(name = "away_team_short_name", nullable = false)
   private String awayTeamShortName;

   @Column(name = "result_prediction", nullable = true)
   private Integer resultPrediction = 0;

   @Column(name = "week_name", nullable = false)
   private String weekName;

   public Schedule() {
      setId(new SchedulePK());
   }

   public Schedule(int leagueSeasonId,
           int weekNo,
           int gameNo,
           int homeTeamNo,
           int awayTeamNo,
           Date gameDate,
           Integer homeTeamScore,
           Integer awayTeamScore,
           Integer result,
           Integer homeTeamScorePredict,
           Integer awayTeamScorePredict,
           Double homeTeamScorePredictDiff,
           Double awayTeamScorePredictDiff,
           Integer predictHomePct,
           Integer predictAwayPct,
           Integer predictDrawPct,
           Timestamp updatedDate,
           String seasonName,
           String homeTeamName,
           String awayTeamName,
           String homeTeamShortName,
           String awayTeamShortName,
           final Integer resultPrediction,
           String weekName) {
      setId(new SchedulePK(leagueSeasonId, weekNo, gameNo));
      setHomeTeamNo(homeTeamNo);
      setAwayTeamNo(awayTeamNo);
      setGameDate(gameDate);
      setHomeTeamScore(homeTeamScore);
      setAwayTeamScore(awayTeamScore);
      setResult(result);
      setHomeTeamScorePredict(homeTeamScorePredict);
      setAwayTeamScorePredict(awayTeamScorePredict);
      setHomeTeamScorePredictDiff(homeTeamScorePredictDiff);
      setAwayTeamScorePredictDiff(awayTeamScorePredictDiff);      
      setPredictHomePct(predictHomePct);
      setPredictAwayPct(predictAwayPct);
      setPredictDrawPct(predictDrawPct);
      setUpdatedDate(updatedDate);
      setSeasonName(seasonName);
      setHomeTeamName(homeTeamName);
      setAwayTeamName(awayTeamName);
      setHomeTeamShortName(homeTeamShortName);
      setAwayTeamShortName(awayTeamShortName);
      setResultPrediction(resultPrediction);
      setWeekName(weekName);
   }

   public void setId(final SchedulePK id) {
      this.id = id;
   }

   public SchedulePK getId() {
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

   public String getHomeTeamScore() {
      String s;

      if (homeTeamScore == null) {
         s = "";
      } else {
         s = Integer.toString(homeTeamScore);
      }
      return s;
   }

   public void setAwayTeamScore(final Integer awayTeamScore) {
      this.awayTeamScore = awayTeamScore;
   }

   public String getAwayTeamScore() {
      String s;

      if (awayTeamScore == null) {
         s = "";
      } else {
         s = Integer.toString(awayTeamScore);
      }
      return s;
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

   public void setUpdatedDate(final Timestamp updatedDate) {
      this.updatedDate = updatedDate;
   }

   public Timestamp getUpdatedDate() {
      return updatedDate;
   }

   public String getSeasonName() {
      return seasonName;
   }

   public void setSeasonName(String seasonName) {
      this.seasonName = seasonName;
   }

   public String getHomeTeamName() {
      return homeTeamName;
   }

   public void setHomeTeamName(String homeTeamName) {
      this.homeTeamName = homeTeamName;
   }

   public String getAwayTeamName() {
      return awayTeamName;
   }

   public void setAwayTeamName(String awayTeamName) {
      this.awayTeamName = awayTeamName;
   }

   public String getHomeTeamShortName() {
      return homeTeamShortName;
   }

   public void setHomeTeamShortName(String homeTeamShortName) {
      this.homeTeamShortName = homeTeamShortName;
   }

   public String getAwayTeamShortName() {
      return awayTeamShortName;
   }

   public void setAwayTeamShortName(String awayTeamShortName) {
      this.awayTeamShortName = awayTeamShortName;
   }

   public Integer getResultPrediction() {
      return resultPrediction;
   }

   public void setResultPrediction(Integer resultPrediction) {
      this.resultPrediction = resultPrediction;
   }

   public String getWeekName() {
      return weekName;
   }

   public void setWeekName(String weekName) {
      this.weekName = weekName;
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
             "[UpdatedDate="              + getUpdatedDate()              + "]" +
             "[seasonName="               + getSeasonName()               + "]" +
             "[homeTeamName="             + getHomeTeamName()             + "]" +
             "[awayTeamName="             + getAwayTeamName()             + "]" +
             "[homeTeamShortName="        + getHomeTeamShortName()        + "]" +
             "[awayTeamShortName="        + getAwayTeamShortName()        + "]" +
             "[resultPrediction="         + getResultPrediction()        + "]" +
             "[weekName="                 + getWeekName()                 + "]";
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
   public Schedule getEntity() {
      Schedule schedule = new Schedule();

      schedule.setId(new SchedulePK(getId().getLeagueSeasonId(), getId().getWeekNo(), getId().getGameNo()));
      schedule.setHomeTeamNo(this.homeTeamNo);
      schedule.setAwayTeamNo(this.awayTeamNo);
      schedule.setGameDate(this.gameDate);
      schedule.setHomeTeamScore(this.homeTeamScore);
      schedule.setAwayTeamScore(this.awayTeamScore);
      schedule.setResult(this.result);
      schedule.setHomeTeamScorePredict(this.homeTeamScorePredict);
      schedule.setAwayTeamScorePredict(this.awayTeamScorePredict);
      schedule.setHomeTeamScorePredictDiff(this.homeTeamScorePredictDiff);
      schedule.setAwayTeamScorePredictDiff(this.awayTeamScorePredictDiff);
      schedule.setPredictHomePct(this.predictHomePct);
      schedule.setPredictAwayPct(this.predictAwayPct);
      schedule.setPredictDrawPct(this.predictDrawPct);
      schedule.setUpdatedDate(this.updatedDate);
      schedule.setSeasonName(this.seasonName);
      schedule.setHomeTeamName(this.homeTeamName);
      schedule.setAwayTeamName(this.awayTeamName);
      schedule.setHomeTeamShortName(this.homeTeamShortName);
      schedule.setAwayTeamShortName(this.awayTeamShortName);
      schedule.setResultPrediction(this.resultPrediction);
      schedule.setWeekName(this.weekName);

      return schedule;
   }
}
