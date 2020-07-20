package uk.co.perfectscore.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.co.perfectscore.app.controllers.model.ResultMessage;
import uk.co.perfectscore.app.controllers.model.ResultsDataResponse;
import uk.co.perfectscore.service.domain.ScheduleBaseSaveService;

/**
 * REST controller handling AJAX result posts from the results page.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@RestController
@RequestMapping("results/api/results")
public class ResultsRestController {

   private final String SUCCESS = "Success"; // Successful results response status
   private final String FAILED = "Failed"; // Failed results response status
   
   @Autowired
   ScheduleBaseSaveService scheduleBaseSaveService;

   @PostMapping(value = "/save")
   public ResultsDataResponse postResult(@RequestBody ResultMessage result) {

      ResultsDataResponse response;

      try {
         // Save the new result
         scheduleBaseSaveService.save(result.getLeagueSeasonId(), result.getWeekNo(),
               result.getGameNo(), result.getScoreHome(), result.getScoreAway());

         // Create the success response
         response = new ResultsDataResponse(SUCCESS, result);
      } catch (NumberFormatException e) {
         // Create the failed response
         response = new ResultsDataResponse(FAILED, result);
      }

      return response;
   }
}
