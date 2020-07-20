package uk.co.perfectscore.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Entity for primary key of the team table.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Embeddable
public class TeamPK implements Serializable {
   
   private static final long serialVersionUID = 8752309691520004L;

   @Column(name = "league_no", nullable = false)
   private int leagueNo;

   @Column(name = "team_no", nullable = false)
   private int teamNo;

   public TeamPK() {}

   public TeamPK(final int leagueNo, final int teamNo) {
      setLeagueNo(leagueNo);
      setTeamNo(teamNo);
   }

   public void setLeagueNo(final int leagueNo) {
      this.leagueNo = leagueNo;
   }

   public int getLeagueNo() {
      return leagueNo;
   }

   public void setTeamNo(final int teamNo) {
      this.teamNo = teamNo;
   }

   public int getTeamNo() {
      return teamNo;
   }

   @Override
   public boolean equals(final Object obj) {
      if (this == obj) {
         return true;
      }

      if (obj == null) {
         return false;
      }

      if (!(obj instanceof TeamPK)) {
         return false;
      }

      TeamPK other = (TeamPK) obj;

      return (this.leagueNo == other.leagueNo) && (this.teamNo == other.teamNo);
   }

   @Override
   public int hashCode() {
      
      final int prime = 31;
      int hash = 17;
      
      hash = hash * prime + this.leagueNo;
      hash = hash * prime + this.teamNo;

      return hash;
   }
}
