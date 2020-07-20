package uk.co.perfectscore.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Entity for primary key of the week table.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Embeddable
public class WeekPK implements Serializable {
   
   private static final long serialVersionUID = 8752307080470003L;

   @Column(name = "league_season_id", nullable = false)
   private int leagueSeasonId;

   @Column(name = "week_no", nullable = false)
   private int weekNo;

   public WeekPK() {}

   public WeekPK(final int leagueSeasonId, final int weekNo) {
      setLeagueSeasonId(leagueSeasonId);
      setWeekNo(weekNo);
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

   @Override
   public boolean equals(final Object obj) {
      if (this == obj) {
         return true;
      }

      if (obj == null) {
         return false;
      }

      if (!(obj instanceof WeekPK)) {
         return false;
      }

      WeekPK other = (WeekPK) obj;

      return (this.leagueSeasonId == other.leagueSeasonId) && (this.weekNo == other.weekNo);
   }

   @Override
   public int hashCode() {
      
      final int prime = 31;
      int hash = 17;

      hash = hash * prime + this.leagueSeasonId;
      hash = hash * prime + this.weekNo;

      return hash;
   }
}
