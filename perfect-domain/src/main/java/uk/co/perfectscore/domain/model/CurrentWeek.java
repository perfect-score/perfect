package uk.co.perfectscore.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for database view selecting current weeks.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Entity
@Table(name = "v_current_weeks")
public class CurrentWeek implements Serializable {
   
   private static final long serialVersionUID = -6251510167595469457L;

   @Id
   @Column(name = "league_season_id", nullable = false)
   private int leagueSeasonId;

   @Column(name = "week_no", nullable = false)
   private int weekNo;

   public CurrentWeek() {}

   public CurrentWeek(int leagueSeasonId, int weekNo) {
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

   /**
    * Display the details.
    * 
    * @return String containing the details loaded.
    */
   public String displayDetails() {
      return "CurrentWeek " + "[LeagueSeasonId=" + getLeagueSeasonId() + "]" + "[weekNo=" + getWeekNo() + "]";
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
   public CurrentWeek getEntity() {
      CurrentWeek schedule = new CurrentWeek();

      schedule.setLeagueSeasonId(this.leagueSeasonId);
      schedule.setWeekNo(this.weekNo);

      return schedule;
   }
}
