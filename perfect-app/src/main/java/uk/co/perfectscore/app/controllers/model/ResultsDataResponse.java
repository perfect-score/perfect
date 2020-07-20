package uk.co.perfectscore.app.controllers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Model object containing the results response details.
 */
@Data
@AllArgsConstructor
public class ResultsDataResponse {

   private String status;
   private Object data;

}
