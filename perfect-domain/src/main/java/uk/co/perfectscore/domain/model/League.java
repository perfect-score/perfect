package uk.co.perfectscore.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for database table leagues.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Entity
@Table(name = "leagues")
public class League implements Serializable {
   
   private static final long serialVersionUID = 8752300733680001L;

   @Id
   @Column(name = "league_no", nullable = false)
   private Integer leagueNo = 0;

   @Column(name = "league_name", length = 100, nullable = false)
   private String leagueName = "";

   @Column(name = "iso_code", length = 2, nullable = false)
   private String isoCode = "";

   public League() {}

   public League(final int leagueNo, final String leagueName, final String isoCode) {
      setLeagueNo(leagueNo);
      setLeagueName(leagueName);
      setIsoCode(isoCode);
   }

   public void setLeagueNo(final Integer leagueNo) {
      this.leagueNo = leagueNo;
   }

   public Integer getLeagueNo() {
      return leagueNo;
   }

   public void setLeagueName(final String leagueName) {
      this.leagueName = leagueName;
   }

   public String getLeagueName() {
      return leagueName;
   }

   public void setIsoCode(final String isoCode) {
      this.isoCode = isoCode;
   }

   public String getIsoCode() {
      return isoCode;
   }

   /**
    * Display the details.
    * 
    * @return String containing the details loaded.
    */
   public String displayDetails() {
      return "League " + "[LeagueNo=" + getLeagueNo() + "]" + "[LeagueName=" + getLeagueName() + "]"
            + "[IsoCode=" + getIsoCode() + "]";
   }

   @Override
   public String toString() {
      return displayDetails();
   }

   /**
    * Return a new version of the entity - this may act as an aid to persistence.
    * 
    * @return Entity comprised of data within this entity.
    */
   public League getEntity() {
      League league = new League();

      league.setLeagueNo(this.leagueNo);
      league.setLeagueName(this.leagueName);
      league.setIsoCode(this.isoCode);

      return league;
   }
}
