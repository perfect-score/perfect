package uk.co.perfectscore.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Entity for primary key of the league_table table. 
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Embeddable
public class LeagueTablePK implements Serializable {
   
   private static final long serialVersionUID = 1504688494840001L;

   @Column(name = "league_season_id", nullable = false)
   private int leagueSeasonId;

   @Column(name = "team_no", nullable = false)
   private int teamNo;

   @Column(name = "predicted", nullable = false)
   private Boolean predicted;

   @Column(name = "week_no", nullable = false)
   private int weekNo;

   public LeagueTablePK() {}

   public LeagueTablePK(final int leagueSeasonId, final int teamNo, final Boolean predicted,
         final int weekNo) {
      setLeagueSeasonId(leagueSeasonId);
      setTeamNo(teamNo);
      setPredicted(predicted);
      setWeekNo(weekNo);
   }

   public void setLeagueSeasonId(final int leagueSeasonId) {
      this.leagueSeasonId = leagueSeasonId;
   }

   public int getLeagueSeasonId() {
      return leagueSeasonId;
   }

   public void setTeamNo(final int teamNo) {
      this.teamNo = teamNo;
   }

   public int getTeamNo() {
      return teamNo;
   }

   public void setPredicted(final Boolean predicted) {
      this.predicted = predicted;
   }

   public Boolean getPredicted() {
      return predicted;
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

      if (!(obj instanceof LeagueTablePK)) {
         return false;
      }

      LeagueTablePK other = (LeagueTablePK) obj;

      return (this.leagueSeasonId == other.leagueSeasonId) && (this.teamNo == other.teamNo)
            && (this.predicted == other.predicted) && (this.weekNo == other.weekNo);
   }

   @Override
   public int hashCode() {
      
      final int prime = 31;
      int hash = 17;
      
      hash = hash * prime + this.leagueSeasonId;
      hash = hash * prime + this.teamNo;
      hash = hash * prime + this.predicted.hashCode();
      hash = hash * prime + this.weekNo;

      return hash;
   }
}
