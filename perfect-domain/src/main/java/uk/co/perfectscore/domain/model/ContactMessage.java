package uk.co.perfectscore.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity for database table storing contact messages.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Entity
@Table(name = "contact_messages")
@SequenceGenerator(name = "contact_messages_id", sequenceName = "contact_messages_seq", allocationSize = 1)
public class ContactMessage implements Serializable {
   
   private static final long serialVersionUID = 2136630099699000L;

   @Id
   @Column(name = "id", nullable = false)
   @GeneratedValue(generator = "contact_messages_id", strategy = GenerationType.SEQUENCE)
   private Integer id;

   @Column(name = "created_date", nullable = false)
   private Timestamp createdDate = new Timestamp(System.currentTimeMillis());

   @Column(name = "name", length = 60, nullable = false)
   private String name = "";

   @Column(name = "email_address", length = 60, nullable = false)
   private String emailAddress = "";

   @Column(name = "message", length = 4000, nullable = false)
   private String message = "";

   public ContactMessage() {}

   public ContactMessage(final int id, final Timestamp createdDate, final String name,
         final String emailAddress, final String message) {
      setId(id);
      setCreatedDate(createdDate);
      setName(name);
      setEmailAddress(emailAddress);
      setMessage(message);
   }

   public void setId(final Integer id) {
      this.id = id;
   }

   public Integer getId() {
      return id;
   }

   public void setCreatedDate(final Timestamp createdDate) {
      this.createdDate = createdDate;
   }

   public Timestamp getCreatedDate() {
      return createdDate;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setEmailAddress(final String emailAddress) {
      this.emailAddress = emailAddress;
   }

   public String getEmailAddress() {
      return emailAddress;
   }

   public void setMessage(final String message) {
      this.message = message;
   }

   public String getMessage() {
      return message;
   }

   /**
    * Display the details.
    * 
    * @return String containing the details loaded.
    */
   public String displayDetails() {
      return "ContactMessage " + "[Id=" + getId() + "]" + "[CreatedDate=" + getCreatedDate() + "]"
            + "[Name=" + getName() + "]" + "[EmailAddress=" + getEmailAddress() + "]" + "[Message="
            + getMessage() + "]";
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
   public ContactMessage getEntity() {
      ContactMessage contactMessage = new ContactMessage();

      contactMessage.setId(this.id);
      contactMessage.setCreatedDate(this.createdDate);
      contactMessage.setName(this.name);
      contactMessage.setEmailAddress(this.emailAddress);
      contactMessage.setMessage(this.message);

      return contactMessage;
   }

}
