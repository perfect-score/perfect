package uk.co.perfectscore.domain.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uk.co.perfectscore.domain.model.ScheduleBase;
import uk.co.perfectscore.domain.model.ScheduleBasePK;

/**
 * Repository for accessing the database table storing schedules_base data. 
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Repository
public interface ScheduleBaseRepository extends CrudRepository<ScheduleBase, ScheduleBasePK> {

   /**
    * Derive a collection of all the data from the schdule_base table for a given league/season and
    * week, using the provided sort.
    */
   List<ScheduleBase> findByIdLeagueSeasonIdAndIdWeekNo(int leagueSeasonId, int weekNo, Sort sort);

   /**
    * Update the schdules_base table - setting home and away scores.
    */
   @Modifying
   @Query("UPDATE ScheduleBase sb SET sb.homeTeamScore = ?4, sb.awayTeamScore = ?5, sb.result = ?6 WHERE sb.id.leagueSeasonId = ?1 AND sb.id.weekNo = ?2 AND sb.id.gameNo = ?3")
   int updateResult(Integer leagueSeasonId, Integer weekNo, Integer gameNo, Integer scoreHome,
         Integer scoreAway, Integer result);

   /**
    * Update the schdules_base table - setting prediction data (various).
    */
   @Modifying
   @Query("UPDATE ScheduleBase sb SET sb.homeTeamScorePredict = ?4, sb.awayTeamScorePredict = ?5, sb.homeTeamScorePredictDiff = ?6, sb.awayTeamScorePredictDiff = ?7, sb.predictHomePct = ?8, sb.predictAwayPct = ?9, sb.predictDrawPct = ?10, sb.resultPrediction = ?11 WHERE sb.id.leagueSeasonId = ?1 AND sb.id.weekNo = ?2 AND sb.id.gameNo = ?3")
   int updateResultPrediction(Integer leagueSeasonId, Integer weekNo, Integer gameNo,
         Integer homeTeamScorePredict, Integer awayTeamScorePredict,
         Double homeTeamScorePredictDiff, Double awayTeamScorePredictDiff, Integer predictHomePct,
         Integer predictAwayPct, Integer predictDrawPct, Integer resultPrediction);
}
