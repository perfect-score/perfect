package uk.co.perfectscore.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uk.co.perfectscore.domain.model.ContactMessage;

/**
 * Repository for accessing the database table storing contact messages.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Repository
public interface ContactMessageRepository extends CrudRepository<ContactMessage, Integer> {
}
