package uk.co.perfectscore.service.domain.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * A test for the {@link FormatResultData} class.
 *
 * @author Chris Reason
 * @version 1.0
 */
@DisplayName("Format result data tests")
public class FormatResultDataTest {

   private FormatResultData formatResultData;
   
   private int actual;
   private int expected;
   
   private String scoreHomeStr;
   private String scoreAwayStr;
   
   @BeforeEach
   public void before() {
      formatResultData = new FormatResultData();
   }

   @Test
   @DisplayName("Check result outcome draw")
   void testCheckOutcomesDraw() {

      expected = 0 /*draw*/;
      
      scoreHomeStr = "0"; scoreAwayStr = "0";
      formatResultData.calculateResultFormat(scoreHomeStr, scoreAwayStr);
      actual = formatResultData.getResult(); assertEquals(expected, actual, "Draw calculation returned incorrect result");

      scoreHomeStr = "2"; scoreAwayStr = "2";
      formatResultData.calculateResultFormat(scoreHomeStr, scoreAwayStr);
      actual = formatResultData.getResult(); assertEquals(expected, actual, "Draw calculation returned incorrect result");
   }
   
   @Test
   @DisplayName("Check result outcome home win")
   void testCheckOutcomesHomeWin() {

      expected = 1 /*home-win*/;

      scoreHomeStr = "1"; scoreAwayStr = "0";
      formatResultData.calculateResultFormat(scoreHomeStr, scoreAwayStr);
      actual = formatResultData.getResult(); assertEquals(expected, actual, "Home calculation returned incorrect result");

      scoreHomeStr = "4"; scoreAwayStr = "2";
      formatResultData.calculateResultFormat(scoreHomeStr, scoreAwayStr);
      actual = formatResultData.getResult();  assertEquals(expected, actual, "Home calculation returned incorrect result");
   }
   
   @Test
   @DisplayName("Check result outcome away win")
   void testCheckOutcomesAwayWin() {

      expected = 2 /*away-win*/;
      
      scoreHomeStr = "0"; scoreAwayStr = "1";
      formatResultData.calculateResultFormat(scoreHomeStr, scoreAwayStr);
      actual = formatResultData.getResult(); assertEquals(expected, actual, "Away calculation returned incorrect result");

      scoreHomeStr = "1"; scoreAwayStr = "3";
      formatResultData.calculateResultFormat(scoreHomeStr, scoreAwayStr);
      actual = formatResultData.getResult(); assertEquals(expected, actual, "Away calculation returned incorrect result");
   }

}
