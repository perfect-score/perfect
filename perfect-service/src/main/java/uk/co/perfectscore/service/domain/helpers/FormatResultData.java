package uk.co.perfectscore.service.domain.helpers;

import org.springframework.stereotype.Service;

import lombok.Data;

/**
 * Enum containing the result outcome values (draw=0, home-win=1, away-win=2).
 * 
 * @author Chris Reason
 * @version 1.0
 */
enum ResultOutcome {
   RESULT_DRAW(0), RESULT_HOME(1), RESULT_AWAY(2);

   private int outcome;

   public int getOutcome() {
      return this.outcome;
   }

   private ResultOutcome(int outcome) {
      this.outcome = outcome;
   }
}

/**
 * Provide a service for calculating the result of a game given the home and away team's score.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Data
@Service
public class FormatResultData
{
   private Integer scoreHome = null;
   private Integer scoreAway = null;
   private Integer result = null;

   public void calculateResultFormat(String scoreHomeStr, String scoreAwayStr) {

      if (scoreHomeStr == null || scoreHomeStr.isEmpty()) {
         scoreHome = null;
      }
      else {
         try {
            scoreHome = Integer.parseInt(scoreHomeStr.trim());
         } catch (NumberFormatException e) {
            throw (e);
         }
      }

      if (scoreAwayStr == null || scoreAwayStr.isEmpty()) {
         scoreAway = null;
      }
      else {
         try {
            scoreAway = Integer.parseInt(scoreAwayStr.trim());
         } catch (NumberFormatException e) {
            throw (e);
         }
      }

      if (scoreHome != null && scoreAway != null) {
         if (scoreHome.equals(scoreAway)) {
            result = ResultOutcome.RESULT_DRAW.getOutcome();
         } else {
            result = scoreHome > scoreAway ? ResultOutcome.RESULT_HOME.getOutcome()
                  : ResultOutcome.RESULT_AWAY.getOutcome();
         }
      } else {
         result = null;
      }
   }
}
