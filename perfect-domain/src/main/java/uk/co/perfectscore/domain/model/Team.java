package uk.co.perfectscore.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity for database table teams.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Entity
@Table(name = "teams")
public class Team implements Serializable {
   
   private static final long serialVersionUID = 8752308772130004L;

   @EmbeddedId
   private TeamPK id;

   @Column(name = "team_name", length = 30, nullable = false)
   private String teamName = "";

   @Column(name = "team_short_name", length = 30, nullable = false)
   private String teamShortName = "";

   @Column(name = "team_abbreviated_name", length = 30, nullable = false)
   private String teamAbbreviatedName = "";

   public Team() {
      setId(new TeamPK());
   }

   public Team(final int leagueNo, final int teamNo, final String teamName) {
      setId(new TeamPK(leagueNo, teamNo));
      setTeamName(teamName);
   }

   public void setId(final TeamPK id) {
      this.id = id;
   }

   public TeamPK getId() {
      return id;
   }

   public void setTeamName(final String teamName) {
      this.teamName = teamName;
   }

   public String getTeamName() {
      return teamName;
   }

   public String getTeamShortName() {
      return teamShortName;
   }

   public void setTeamShortName(String teamShortName) {
      this.teamShortName = teamShortName;
   }

   public String getTeamAbbreviatedName() {
      return teamAbbreviatedName;
   }

   public void setTeamAbbreviatedName(String teamAbbreviatedName) {
      this.teamAbbreviatedName = teamAbbreviatedName;
   }

   /**
    * Display the details.
    * 
    * @return String containing the details loaded.
    */
   public String displayDetails() {
      return "Team " + 
             "[LeagueNo="            + getId().getLeagueNo()    + "]" +
             "[TeamNo="              + getId().getTeamNo()      + "]" +
             "[TeamName="            + getTeamName()            + "]" +
             "[TeamShortName="       + getTeamShortName()       + "]" +
             "[TeamAbbreviatedName=" + getTeamAbbreviatedName() + "]";
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
   public Team getEntity() {
      Team team = new Team();

      team.setId(new TeamPK(getId().getLeagueNo(), getId().getTeamNo()));
      team.setTeamName(this.teamName);

      return team;
   }
}
