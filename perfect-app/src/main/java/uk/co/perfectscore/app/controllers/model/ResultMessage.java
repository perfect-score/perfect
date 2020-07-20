package uk.co.perfectscore.app.controllers.model;

import lombok.Data;

/**
 * Model object containing the results post.
 */
@Data
public class ResultMessage {

   private int leagueSeasonId;
   private int weekNo;
   private int gameNo;
   private String scoreHome;
   private String scoreAway;

}
