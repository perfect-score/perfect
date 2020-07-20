package uk.co.perfectscore.service.domain;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uk.co.perfectscore.domain.model.PerfectScoreResult;
import uk.co.perfectscore.domain.model.PerfectScoreResultPK;
import uk.co.perfectscore.domain.repository.PerfectScoreResultRepository;

/**
 * Provide a service for saving perfect score results.
 *
 * @author Chris Reason
 * @version 1.0
 */
@Service
@Slf4j
public class PerfectScoreResultSaveService {

   @Autowired
   private PerfectScoreResultRepository perfectScoreResultRepository;

   public void save(PerfectScoreResult perfectScoreResult) {
      try {
         PerfectScoreResult savedEntity = perfectScoreResultRepository.save(perfectScoreResult);

         if (log.isDebugEnabled()) {
            log.debug("PerfectScoreResult saved [Id={}]", savedEntity.toString());
         }
      } catch (RuntimeException e) {
         log.error("PerfectScoreResult save error {}", e);
      }
   }

   public void save(int leagueSeasonId,
      int weekNo,
      int homeScores,
      int awayScores,
      String homeScoresPct,
      String awayScoresPct,
      int homeWins,
      int awayWins,
      int draws,
      String homeWinsPct,
      String awayWinsPct,
      String drawsPct,
      int result,
      String resultPct,
      Timestamp updatedDate) {

      PerfectScoreResult perfectScoreResult = new PerfectScoreResult();

      perfectScoreResult.setId(new PerfectScoreResultPK(leagueSeasonId, weekNo));
      perfectScoreResult.setHomeScores(homeScores);
      perfectScoreResult.setAwayScores(awayScores);
      perfectScoreResult.setHomeScoresPct(homeScoresPct);
      perfectScoreResult.setAwayScoresPct(awayScoresPct);
      perfectScoreResult.setHomeWins(homeWins);
      perfectScoreResult.setAwayWins(awayWins);
      perfectScoreResult.setDraws(draws);
      perfectScoreResult.setHomeWinsPct(homeWinsPct);
      perfectScoreResult.setAwayWinsPct(awayWinsPct);
      perfectScoreResult.setDrawsPct(drawsPct);
      perfectScoreResult.setResult(result);
      perfectScoreResult.setResultPct(resultPct);
      perfectScoreResult.setUpdatedDate(updatedDate);

      save(perfectScoreResult);
   }
}
