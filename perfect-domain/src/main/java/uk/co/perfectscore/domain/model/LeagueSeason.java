package uk.co.perfectscore.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for database table league seasons.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Entity
@Table(name = "league_seasons")
public class LeagueSeason implements Serializable {
   
   private static final long serialVersionUID = 8752302456860002L;

   @Id
   @Column(name = "id", nullable = false)
   private Integer id = 0;

   @Column(name = "league_no", nullable = false)
   private Integer leagueNo = 0;

   @Column(name = "season_name", length = 30, nullable = false)
   private String seasonName = "";

   public LeagueSeason() {}

   public LeagueSeason(final int id, final int leagueNo, final String seasonName) {
      setId(id);
      setLeagueNo(leagueNo);
      setSeasonName(seasonName);
   }

   public void setId(final Integer id) {
      this.id = id;
   }

   public Integer getId() {
      return id;
   }

   public void setLeagueNo(final Integer leagueNo) {
      this.leagueNo = leagueNo;
   }

   public Integer getLeagueNo() {
      return leagueNo;
   }

   public void setSeasonName(final String seasonName) {
      this.seasonName = seasonName;
   }

   public String getSeasonName() {
      return seasonName;
   }

   /**
    * Display the details.
    * 
    * @return String containing the details loaded.
    */
   public String displayDetails() {
      return "LeagueSeason " + "[Id=" + getId() + "]" + "[LeagueNo=" + getLeagueNo() + "]"
            + "[SeasonName=" + getSeasonName() + "]";
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
   public LeagueSeason getEntity() {
      LeagueSeason leagueSeason = new LeagueSeason();

      leagueSeason.setId(this.id);
      leagueSeason.setLeagueNo(this.leagueNo);
      leagueSeason.setSeasonName(this.seasonName);

      return leagueSeason;
   }
}
