package uk.co.perfectscore.service.predict;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import uk.co.perfectscore.domain.model.Schedule;
import uk.co.perfectscore.domain.repository.ScheduleBaseRepository;
import uk.co.perfectscore.service.domain.PerfectScoreResultSaveService;
import uk.co.perfectscore.service.domain.ScheduleBaseLoadWeekCollectionService;
import uk.co.perfectscore.service.domain.ScheduleLoadWeekRangeCollectionService;

/**
 * Class that coordinates the calculation of game predictions.
 *
 * ** This class has been largely obscured. **
 */
@Slf4j
@Component
public class ProcessPredictions
{
   private final int WEEK_BACK_END = 1;
   private final int WEEK_BACK_START = 5;
	   
   @Autowired
   private ScheduleLoadWeekRangeCollectionService scheduleLoadWeekRangeCollectionService;
   
   @Autowired
   private ScheduleBaseRepository scheduleBaseRepository;

   @Autowired
   private ScheduleBaseLoadWeekCollectionService scheduleBaseLoadWeekCollectionService;
   
   @Autowired
   private PerfectScoreResultSaveService perfectScoreResultSaveService;
   
   @Autowired
   private AddScoreService addScoreService;
   
   private int leagueSeasonId;
   private int currentWeek;
   
   public int getLeagueSeasonId()
   {
      return leagueSeasonId;
   }
   public void setLeagueSeasonId(int leagueSeasonId)
   {
      this.leagueSeasonId = leagueSeasonId;
   }
   public int getCurrentWeek()
   {
      return currentWeek;
   }
   public void setCurrentWeek(int currentWeek)
   {
      this.currentWeek = currentWeek;
   }

   private void storeResultsForWeekRange() {

      int startWeekNo = currentWeek - WEEK_BACK_START;
      int endWeekNo = currentWeek - WEEK_BACK_END;
      
      // Clear the results store for the next run
      addScoreService.clearResultsStore();

      // For the league/season, get all the schedules between week-start and week-end
      scheduleLoadWeekRangeCollectionService.loadByTeamNoAndStartWeekAndEndWeek(leagueSeasonId, startWeekNo, endWeekNo);

      while (scheduleLoadWeekRangeCollectionService.hasNext()) {
         
         Schedule schedule = scheduleLoadWeekRangeCollectionService.getNext();
         
         if (schedule.getHomeTeamScore() != null && schedule.getHomeTeamScore().length() > 0 &&
               schedule.getAwayTeamScore() != null && schedule.getAwayTeamScore().length() > 0) {
            addScoreService.storeResult(schedule);
         }
      }
      
      if (log.isDebugEnabled()) { 
         addScoreService.display();
      }
   }
   
   private void updatePredictions() {
      // Obscured 
   }

   private void updatePredictionsCollection() {
      // Obscured
   }
   
   @Transactional
   public void runPredictions(int leagueSeasonId, int currentWeek) {
      
      setLeagueSeasonId(leagueSeasonId);
      setCurrentWeek(currentWeek);

      // Store the scores for for each team for a given weekly range
      storeResultsForWeekRange();
      
      // Perform the calculations and save
      updatePredictions();
      
     // Update the weekly score summary
      updatePredictionsCollection();
   }

}
