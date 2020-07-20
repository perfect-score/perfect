package uk.co.perfectscore.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import uk.co.perfectscore.domain.repository.ScheduleBaseRepository;
import uk.co.perfectscore.service.domain.helpers.FormatResultData;

/**
 * Provide a service for saving schedule base data.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Service
@Slf4j
public class ScheduleBaseSaveService {
   
   @Autowired
   private ScheduleBaseRepository scheduleBaseRepository;

   @Autowired
   private FormatResultData formatResultData;

   @Transactional
   public void save(Integer leagueSeasonId, Integer weekNo, Integer gameNo, String scoreHome,
         String scoreAway) {
      try {
         
         formatResultData.calculateResultFormat(scoreHome, scoreAway);
         
      } catch (NumberFormatException e) {
         log.error("ScheduleBaseSaveService number error [leagueSeasonId={},weekNo={},gameNo={},scoreHome={},scoreAway={}]",
               leagueSeasonId, weekNo, gameNo, scoreHome, scoreAway);
         throw (e);
      }

      try {
         int savedCount = scheduleBaseRepository.updateResult(leagueSeasonId, weekNo, gameNo,
               formatResultData.getScoreHome(), formatResultData.getScoreAway(),
               formatResultData.getResult());

         if (log.isDebugEnabled()) {
            log.info("ScheduleBaseSaveService saved [savedCount={}] [leagueSeasonId={}] [weekNo={}] [gameNo={}] [scoreHomeInt={}] [scoreAwayInt={}] [result={}]",
                  savedCount, leagueSeasonId, weekNo, gameNo, formatResultData.getScoreHome(),
                  formatResultData.getScoreAway(), formatResultData.getResult());
         }
      } catch (RuntimeException e) {
         log.error("ScheduleBaseSaveService save error {}", e);
      }
   }

}
