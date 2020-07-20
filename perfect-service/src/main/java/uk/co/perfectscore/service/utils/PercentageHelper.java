package uk.co.perfectscore.service.utils;

import java.math.BigDecimal;

/**
 * Helper class to provide percentage calculations and support.
 * 
 * @author Chris Reason
 * @version 1.0
 */
public class PercentageHelper {
   final int    DEFAULT_DECIMAL_PLACES = 1;          // Default number of places to round to
   final double DEFAULT_ZERO_DOUBLE    = 0.00000000; // Default zero double number

   /**
    * Return a double number rounded to the specified number of places as a string.
    * @param number Number to round.
    * @param places Number of decimal places to round to.
    * @return Formatted number as a string.
    */
   public String getRoundedString(final double number, final int places) {
      return new BigDecimal(number).setScale(places, BigDecimal.ROUND_HALF_UP).toString();
   }
   
   /**
    * Return a double number rounded to the default number of places as a string.
    * @param number Number to round.
    * @return Formatted number as a string.
    */
   public String getRoundedString(final double number) {
      return getRoundedString(number, DEFAULT_DECIMAL_PLACES);
   }
   
   /**
    * Return the percentage value for a given numerator and divisor. The result is returned to the specified number of
    * decimal place as a string.
    * @param numerator Top part of the fraction.
    * @param divisor Bottom part of the fraction.
    * @param places Number of decimal places to round to.
    * @return Formatted percentage string.
    */
   public String getPercentage(final int numerator, final int divisor, final int places) {
      if (numerator == 0 || divisor == 0) {
         return getRoundedString(DEFAULT_ZERO_DOUBLE, places);
      }

      return getRoundedString(((double) numerator * 100 / divisor), places);
   }

   /**
    * Return the percentage value for a given numerator and divisor. The result is returned to the default number of
    * decimal place as a string.
    * @param numerator Top part of the fraction.
    * @param divisor Bottom part of the fraction.
    * @return Formatted percentage string.
    */
   public String getPercentage(final int numerator, final int divisor) {
      return getPercentage(numerator, divisor, DEFAULT_DECIMAL_PLACES);
   }
   
}
