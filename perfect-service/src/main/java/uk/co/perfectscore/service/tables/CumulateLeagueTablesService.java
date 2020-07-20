package uk.co.perfectscore.service.tables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Class that drives the cumulation of league table data.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Slf4j
@Component
public class CumulateLeagueTablesService {

   @Autowired
   private CumulateLeagueTableService cumulateLeagueTableService;

   public void cumulateLeagueTable() {
      log.info("Cumulate league tables service has been invoked");

      int leagueSeasonId = 1;
      int startWeek = 6; // Process from game week 6
      int endWeek = 38; // Process to game week 38

      // Loop through results and add to the league table for each week
      for (int i = startWeek; i <= endWeek; i++) {
         cumulateLeagueTableService.cumulate(leagueSeasonId, i);
      }

   }

}
