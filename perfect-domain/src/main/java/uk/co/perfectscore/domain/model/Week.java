package uk.co.perfectscore.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity for database table weeks.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Entity
@Table(name = "weeks")
public class Week implements Serializable {
   
   private static final long serialVersionUID = 8752306236550003L;

   @EmbeddedId
   private WeekPK id;

   @Column(name = "week_name", length = 30, nullable = false)
   private String weekName = "";

   public Week() {
      setId(new WeekPK());
   }

   public Week(final int leagueSeasonId, final int weekNo, final String weekName) {
      setId(new WeekPK(leagueSeasonId, weekNo));
      setWeekName(weekName);
   }

   public void setId(final WeekPK id) {
      this.id = id;
   }

   public WeekPK getId() {
      return id;
   }

   public void setWeekName(final String weekName) {
      this.weekName = weekName;
   }

   public String getWeekName() {
      return weekName;
   }

   /**
    * Display the details.
    * 
    * @return String containing the details loaded.
    */
   public String displayDetails() {
      return "Week " + "[LeagueSeasonId=" + getId().getLeagueSeasonId() + "]" + "[WeekNo="
            + getId().getWeekNo() + "]" + "[WeekName=" + getWeekName() + "]";
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
   public Week getEntity() {
      Week week = new Week();

      week.setId(new WeekPK(getId().getLeagueSeasonId(), getId().getWeekNo()));
      week.setWeekName(this.weekName);

      return week;
   }
}
