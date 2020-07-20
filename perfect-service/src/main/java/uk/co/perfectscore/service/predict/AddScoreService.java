package uk.co.perfectscore.service.predict;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uk.co.perfectscore.domain.model.Schedule;
import uk.co.perfectscore.service.predict.model.PredictionsModel;

/**
 * Service that cumulates results data for each game. This store is used when calculating predictions.
 * 
 * @author Chris Reason
 * version 1.0
 */
@Service
@Slf4j
public class AddScoreService {
   private Map<Integer, PredictionsModel> resultsStore = new HashMap<>(20); // Store results model-data for each team

   public void clearResultsStore() {
      resultsStore.clear();
   }

   /**
    * Add the results for the provided schedule (match) for both home and away team.
    *
    * @param schedule Schedule (match) data to use to add to the results store.
    */
  public void storeResult(Schedule schedule) {

     PredictionsModel resultsModel;

     /*********************
      * Process home team *
      *********************/

     resultsModel = resultsStore.get(schedule.getHomeTeamNo());

     if (resultsModel == null) {
        resultsModel = new PredictionsModel();
        resultsModel.setTeamName(schedule.getHomeTeamName());
     }

     resultsModel.addScore(true, schedule.getHomeTeamScore(), schedule.getAwayTeamScore());

     resultsStore.put(schedule.getHomeTeamNo(), resultsModel);

     /*********************
      * Process away team *
      *********************/

    resultsModel = resultsStore.get(schedule.getAwayTeamNo());

    if (resultsModel == null) {
       resultsModel = new PredictionsModel();
       resultsModel.setTeamName(schedule.getAwayTeamName());
    }

    resultsModel.addScore(false, schedule.getHomeTeamScore(), schedule.getAwayTeamScore());

    resultsStore.put(schedule.getAwayTeamNo(), resultsModel);
 }

  /**
   * Provides facility for debugging the results store.  
   */
  public void display() {

     if (log.isDebugEnabled()) {
        Iterator<Entry<Integer, PredictionsModel>> resultsStoreIterator = resultsStore.entrySet().iterator();

        while (resultsStoreIterator.hasNext()) {
           Entry<Integer, PredictionsModel> mapEntry = resultsStoreIterator.next();

           log.debug("Score prediction [Key={}] [Values={}]", mapEntry.getKey(), mapEntry.getValue().toString());
        }
     }
  }

  public PredictionsModel getIndex(int i) {
     return resultsStore.get(i);
  }

}
