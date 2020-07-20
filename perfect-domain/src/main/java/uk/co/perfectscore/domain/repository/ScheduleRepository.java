package uk.co.perfectscore.domain.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uk.co.perfectscore.domain.model.Schedule;
import uk.co.perfectscore.domain.model.SchedulePK;

/**
 * Repository for accessing the database view storing schedules data.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, SchedulePK> {

   /**
    * Derive a collection from the schedules view based on league/season and week, using the provided sort.
    */
   List<Schedule> findByIdLeagueSeasonIdAndIdWeekNo(int leagueSeasonId, int weekNo, Sort sort);

   /**
    * Derive a collection of all the data from the schedules view, using the provided sort.
    */
   List<Schedule> findAll(Sort sort);

   /**
    * Derive a collection from the schedules view based on league/season and a given week range, using the provided sort.
    */
   @Query("SELECT sb FROM Schedule sb WHERE id.leagueSeasonId =?1 AND id.weekNo BETWEEN ?2 AND ?3 ORDER BY id.leagueSeasonId, id.weekNo, id.gameNo")
   List<Schedule> findByWeekRange(int leagueSeasonId, int startWeek, int endWeek);

}
