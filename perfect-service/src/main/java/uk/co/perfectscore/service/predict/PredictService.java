package uk.co.perfectscore.service.predict;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Class that drives prediction calculation for each week.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Slf4j
@Component
public class PredictService
{
   @Autowired
   private ProcessPredictions processPredictions;

  public void runPredict() {
     log.info("Precict service has been invoked");
     
     int leagueSeasonId = 1;
     int startWeek = 6;      // Process from game week 6
     int endWeek = 38;       // Process to game week 38
     
     // Loop through results and process predictions for each week
     for (int i = startWeek; i <= endWeek; i++) {
       processPredictions.runPredictions(leagueSeasonId, i);
     }
  }

}
