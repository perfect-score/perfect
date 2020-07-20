package uk.co.perfectscore.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uk.co.perfectscore.domain.model.CurrentWeek;

/**
 * Repository for accessing the database table storing current_weeks data.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Repository
public interface CurrentWeekRepository extends CrudRepository<CurrentWeek, Integer> {
}
