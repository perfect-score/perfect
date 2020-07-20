package uk.co.perfectscore.app.controllers.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * A test for the {@link ControllerHelpers} class.
 *
 * @author Chris Reason
 * @version 1.0
 */
public class ControllerHelpersTest {

   private final String SUCCESS = "btn-success";
   private final String WARNING = "btn-warning";
   private final String DANGER  = "btn-danger";
   private final String NONE    = "";
   
   private ControllerHelpers ch;
   
   private String pct;
   private String expected;
   private String actual;

   @BeforeEach
   public void before() {
      ch = new ControllerHelpers();
   }

   @Test
   @DisplayName("Test RAG values [none]")
   void testNone() {

      pct = null; expected = NONE; actual = ch.getRag(pct); assertEquals(expected, actual);
      pct = "";   expected = NONE; actual = ch.getRag(pct); assertEquals(expected, actual);
   }
   
   @Test
   @DisplayName("Test RAG values [danger]")
   void testDanger() {
   
      pct = "10.5"; expected = DANGER; actual = ch.getRag(pct); assertEquals(expected, actual);
      pct = "0";    expected = DANGER; actual = ch.getRag(pct); assertEquals(expected, actual);
      pct = "-1";   expected = DANGER; actual = ch.getRag(pct); assertEquals(expected, actual);
      pct = "29.9"; expected = DANGER; actual = ch.getRag(pct); assertEquals(expected, actual);
   }
   
   @Test
   @DisplayName("Test RAG values [warning]")
   void testWarning() {
      
      pct = "30";   expected = WARNING; actual = ch.getRag(pct); assertEquals(expected, actual);
      pct = "30.0"; expected = WARNING; actual = ch.getRag(pct); assertEquals(expected, actual);
      pct = "40";   expected = WARNING; actual = ch.getRag(pct); assertEquals(expected, actual);
      pct = "49.9"; expected = WARNING; actual = ch.getRag(pct); assertEquals(expected, actual);
   }
   
   @Test
   @DisplayName("Test RAG values [success]")
   void testSuccess() {
      
      pct = "50";    expected = SUCCESS; actual = ch.getRag(pct); assertEquals(expected, actual);
      pct = "50.0";  expected = SUCCESS; actual = ch.getRag(pct); assertEquals(expected, actual);
      pct = "99.9";  expected = SUCCESS; actual = ch.getRag(pct); assertEquals(expected, actual);
      pct = "100";   expected = SUCCESS; actual = ch.getRag(pct); assertEquals(expected, actual);
      pct = "100.0"; expected = SUCCESS; actual = ch.getRag(pct); assertEquals(expected, actual);
      pct = "110";   expected = SUCCESS; actual = ch.getRag(pct); assertEquals(expected, actual);
   }
   
   @Test
   @DisplayName("Test RAG values [override upper/lower values]")
   void testValues() {
      
      int upper = 90;
      int lower = 80;
      
      pct = "90"; expected = SUCCESS; actual = ch.getRag(pct, upper, lower); assertEquals(expected, actual);
      pct = "80"; expected = WARNING; actual = ch.getRag(pct, upper, lower); assertEquals(expected, actual);
      pct = "70"; expected = DANGER;  actual = ch.getRag(pct, upper, lower); assertEquals(expected, actual);
   }
}
