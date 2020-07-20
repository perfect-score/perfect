package uk.co.perfectscore.service.predict.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * A test for the {@link PredictionsModel} class.
 *
 * @author Chris Reason
 * @version 1.0
 */
@DisplayName("Predicts model  result data tests")
public class PredictionsModelTest {
   
   private PredictionsModel pm;
   
   private boolean home;
   private String scoreHome;
   private String scoreAway;
   
   @BeforeEach
   public void before() {
      pm = new PredictionsModel();
   }
   
   @Test
   @DisplayName("Set home results cumulation")
   void testHomeResultCumulate() {

      home = true;
      scoreHome = "2";
      scoreAway = "1";
            
      pm.addScore(home, scoreHome, scoreAway);
      
      assertAll(
            () -> assertEquals(1, pm.getGamesHome(), "Incorrect home games set"),
            () -> assertEquals(2, pm.getTotalScoreHomeFor(), "Incorrect home for score set"),
            () -> assertEquals(1, pm.getTotalScoreHomeAgainst(), "Incorrect home against score set"),
            () -> assertEquals("2 ", pm.getScoringStringHomeFor(), "Incorrect home for score string set"),
            () -> assertEquals("1 ", pm.getScoringStringHomeAgainst(), "Incorrect home against score string set")
      );
   }
   
   @Test
   @DisplayName("Set away results cumulation")
   void testAwayResultCumulate() {

      home = false;
      scoreHome = "0";
      scoreAway = "3";
            
      pm.addScore(home, scoreHome, scoreAway);
      
      assertAll(
            () -> assertEquals(1, pm.getGamesAway(), "Incorrect away games set"),
            () -> assertEquals(3, pm.getTotalScoreAwayFor(), "Incorrect away for score set"),
            () -> assertEquals(0, pm.getTotalScoreAwayAgainst(), "Incorrect away against score set"),
            () -> assertEquals("3 ", pm.getScoringStringAwayFor(), "Incorrect away for score string set"),
            () -> assertEquals("0 ", pm.getScoringStringAwayAgainst(), "Incorrect away against score string set")
      );
   }

}
