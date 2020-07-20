package uk.co.perfectscore.service.predict.helper;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 * A test for the {@link CalculateScore} class.
 *
 * @author Chris Reason
 * @version 1.0
 */
@DisplayName("Score calculation tests")
public class CalculateScoreTest {

   private final String INVALID_VAL_DESC = "Expected score calculated incorrectly";

   private CalculateScore cs;

   @BeforeEach
   public void before() {
      cs = new CalculateScore();
   }

   @Test
   @DisplayName("Score calculation [expected value 0]")
   void testExpectedValues0() {

      final double expected = 0;

      assertAll(
            () -> assertEquals(expected, cs.getBestScore("0 0 0 "), INVALID_VAL_DESC),
            () -> assertEquals(expected, cs.getBestScore("1 0 0 "), INVALID_VAL_DESC),
            () -> assertEquals(expected, cs.getBestScore("1 0 0 "), INVALID_VAL_DESC)
      );
   }
   
   @Test
   @DisplayName("Score calculation [expected value 1]")
   void testExpectedValues1() {

      final double expected = 1;

      assertAll(
            () -> assertEquals(expected, cs.getBestScore("1 1 1 1 1 1"), INVALID_VAL_DESC),
            () -> assertEquals(expected, cs.getBestScore("1 1 1"), INVALID_VAL_DESC),
            () -> assertEquals(expected, cs.getBestScore("1"), INVALID_VAL_DESC)
      );
   }

   @Test
   @DisplayName("Score calculation [expected value 2]")
   void testExpectedValues2() {

      final double expected = 2;

      assertAll(
            () -> assertEquals(expected, cs.getBestScore("1 2 3 "), INVALID_VAL_DESC),
            () -> assertEquals(expected, cs.getBestScore("2 2 2 2 2 "), INVALID_VAL_DESC),
            () -> assertEquals(expected, cs.getBestScore("0 2 2 2 0 "), INVALID_VAL_DESC),
            () -> assertEquals(expected, cs.getBestScore("3 2 2 2 3 "), INVALID_VAL_DESC),
            () -> assertEquals(expected, cs.getBestScore("4 2 2 2 10 "), INVALID_VAL_DESC));
   }

   @Test
   @DisplayName("Score calculation [expected value 3]")
   void testExpectedValues3() {

      final double expected1 = 3;
      final double expected2 = (9.0 + 1.0 + 0.0 - 5.0) / 3.0;

      assertAll(
            () -> assertEquals(expected1, cs.getBestScore("4 4 2 2 "), INVALID_VAL_DESC),
            () -> assertEquals(expected1, cs.getBestScore("3"), INVALID_VAL_DESC),
            () -> assertEquals(expected2, cs.getBestScore("9 1 0 "), 0.1, INVALID_VAL_DESC)
      );
   }
}
