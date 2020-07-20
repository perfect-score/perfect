package uk.co.perfectscore.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uk.co.perfectscore.domain.model.PerfectScoreResult;
import uk.co.perfectscore.domain.model.PerfectScoreResultPK;

/**
 * Repository for accessing the database table storing perfect_score_results data.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Repository
public interface PerfectScoreResultRepository extends CrudRepository<PerfectScoreResult, PerfectScoreResultPK> {
}
