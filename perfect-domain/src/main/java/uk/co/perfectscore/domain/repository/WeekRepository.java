package uk.co.perfectscore.domain.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uk.co.perfectscore.domain.model.Week;
import uk.co.perfectscore.domain.model.WeekPK;

/**
 * Repository for accessing the database view storing week data. 
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Repository
public interface WeekRepository extends CrudRepository<Week, WeekPK> {

   /**
    * Derive a collection of all the data from the week table for a given league/season, using the provided sort.
    */
   List<Week> findByIdLeagueSeasonId(int leagueSeasonId, Sort sort);

}
