package uk.co.perfectscore.app.controllers.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Model object containing the contact message post data and validation.
 */
@Data
public class ContactMessage implements Serializable {

   private static final long serialVersionUID = 2104230893995780165L;

   private Integer id;

   private Timestamp createdDate = new Timestamp(System.currentTimeMillis());

   @Size(min = 3, max = 60, message = "{contact.error_name_size}")
   private String name;

   @Size(min = 3, max = 60, message = "{contact.error_email_address_size}")
   @Email(message = "{contact.error_email_address_invalid}")
   private String emailAddress;

   @Size(min = 3, max = 4000, message = "{contact.error_message_size}")
   private String message;

}
