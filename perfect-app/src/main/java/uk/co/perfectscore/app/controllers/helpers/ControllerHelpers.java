package uk.co.perfectscore.app.controllers.helpers;

import lombok.extern.slf4j.Slf4j;

/**
 * Provide an abstracted class containing controller helper functions.
 *  
 * @author Chris Reason
 * @version 1.0
 *
 */
@Slf4j
public class ControllerHelpers {

   private final int UPPER = 50; // RAG upper limit
   private final int LOWER = 30; // RAG lower limit
   
   private final String SUCCESS = "btn-success"; // Bootstrap success button colour (green)
   private final String WARNING = "btn-warning"; // Bootstrap warning button colour (amber)
   private final String DANGER = "btn-danger"; // Bootstrap danger button colour (red)
   
   /**
    * Set the RAG Bootstrap class based on the passed in percentage value.
    * @param pct Percentage that will be used to select the RAG CSS class.
    * @param upper Value to be surpassed for RAG success (colour). 
    * @param lower Value to be surpassed for RAG warning (colour).
    * @return The Bootstrap CSS class determined by pct; default to danger if success or warning are not 
    */
   public String getRag(String pct, int upper, int lower) {

      try {
         int pctInt = (int) Double.parseDouble(pct);
         
         if (pctInt >= upper) {
            return SUCCESS;
         } else if (pctInt >= lower) {
            return WARNING;
         } else {
            return DANGER;
         }
      }
      catch (NumberFormatException | NullPointerException e) {
         log.warn("Numberic error raised when deriving RAG [pct={}] [upper={}] [lower={}]", pct,
               upper, lower);
         return "";
      }
   }

   /**
    * Return the RAG CSS class based on default upper and lower values. 
    * @param pct Percentage that will be used to select the RAG css class.
    * @return RAG CSS class.
    */
    public String getRag(String pct) {
       return getRag(pct, UPPER, LOWER);
    }

 }
