package uk.co.perfectscore.service.domain;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uk.co.perfectscore.domain.model.ContactMessage;
import uk.co.perfectscore.domain.repository.ContactMessageRepository;

/**
 * Provide a service for saving contact messages.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Service
@Slf4j
public class ContactMessageSaveService {

   @Autowired
   private ContactMessageRepository contactMessageRepository;

   public void save(ContactMessage contactMessage) {
      try {
         ContactMessage savedEntity = contactMessageRepository.save(contactMessage);

         if (log.isDebugEnabled()) {
            log.debug("ContactMessage saved [{}]", savedEntity.toString());
         }
      } catch (RuntimeException e) {
         log.error("ContactMessage save error {}", e);
         throw (e);
      }
   }

   public void save(Timestamp createdDate, String name, String emailAddress, String message) {

      ContactMessage contactMessage = new ContactMessage();

      contactMessage.setCreatedDate(createdDate);
      contactMessage.setName(name);
      contactMessage.setEmailAddress(emailAddress);
      contactMessage.setMessage(message);

      save(contactMessage);
   }
}
