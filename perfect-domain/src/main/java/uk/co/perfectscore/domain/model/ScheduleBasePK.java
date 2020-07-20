package uk.co.perfectscore.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Entity for primary key of the schedule_base table.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Embeddable
public class ScheduleBasePK implements Serializable {
   
   private static final long serialVersionUID = 8752311363000005L;

   @Column(name = "league_season_id", nullable = false)
   private int leagueSeasonId;

   @Column(name = "week_no", nullable = false)
   private int weekNo;

   @Column(name = "game_no", nullable = false)
   private int gameNo;

   public ScheduleBasePK() {}

   public ScheduleBasePK(final int leagueSeasonId, final int weekNo, final int gameNo) {
      setLeagueSeasonId(leagueSeasonId);
      setWeekNo(weekNo);
      setGameNo(gameNo);
   }

   public void setLeagueSeasonId(final int leagueSeasonId) {
      this.leagueSeasonId = leagueSeasonId;
   }

   public int getLeagueSeasonId() {
      return leagueSeasonId;
   }

   public void setWeekNo(final int weekNo) {
      this.weekNo = weekNo;
   }

   public int getWeekNo() {
      return weekNo;
   }

   public void setGameNo(final int gameNo) {
      this.gameNo = gameNo;
   }

   public int getGameNo() {
      return gameNo;
   }

   @Override
   public boolean equals(final Object obj) {
      if (this == obj) {
         return true;
      }

      if (obj == null) {
         return false;
      }

      if (!(obj instanceof ScheduleBasePK)) {
         return false;
      }

      ScheduleBasePK other = (ScheduleBasePK) obj;

      return (this.leagueSeasonId == other.leagueSeasonId) && (this.weekNo == other.weekNo)
            && (this.gameNo == other.gameNo);
   }

   @Override
   public int hashCode() {
      
      final int prime = 31;
      int hash = 17;

      hash = hash * prime + this.leagueSeasonId;
      hash = hash * prime + this.weekNo;
      hash = hash * prime + this.gameNo;

      return hash;
   }
}
