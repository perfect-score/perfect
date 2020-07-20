package uk.co.perfectscore.service.predict.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model class to store the (cumulative) data for a teams results. This data is used when
 * calculating result predictions.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class PredictionsModel {
   private String teamName;

   private Integer gamesHome = 0;
   private Integer totalScoreHomeFor = 0;
   private Integer totalScoreHomeAgainst = 0;
   private String scoringStringHomeFor = ""; // Space delimited string of results (e.g. '1 0 0 2 3')
   private String scoringStringHomeAgainst = "";

   private Integer gamesAway = 0;
   private Integer totalScoreAwayFor = 0;
   private Integer totalScoreAwayAgainst = 0;
   private String scoringStringAwayFor = "";
   private String scoringStringAwayAgainst = "";

   /**
    * Add the score to the predictions model.
    * 
    * @param home Processing the home team's data.
    * @param scoreHome Home team's score.
    * @param scoreAway Away team's score.
    */
   public void addScore(boolean home, String scoreHome, String scoreAway) {

      if (home) {
         gamesHome++;
         totalScoreHomeFor += Integer.parseInt(scoreHome);
         totalScoreHomeAgainst += Integer.parseInt(scoreAway);

         scoringStringHomeFor += scoreHome + " ";
         scoringStringHomeAgainst += scoreAway + " ";

      } else {

         gamesAway++;
         totalScoreAwayFor += Integer.parseInt(scoreAway);
         totalScoreAwayAgainst += Integer.parseInt(scoreHome);

         scoringStringAwayFor += scoreAway + " ";
         scoringStringAwayAgainst += scoreHome + " ";
      }
   }

}
