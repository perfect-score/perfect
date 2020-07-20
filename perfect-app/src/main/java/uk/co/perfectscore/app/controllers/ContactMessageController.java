package uk.co.perfectscore.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import uk.co.perfectscore.app.controllers.model.ContactMessage;
import uk.co.perfectscore.service.domain.ContactMessageSaveService;

/**
 * Controller exposing requests for the contact page.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Slf4j
@Controller
public class ContactMessageController {

   @Autowired
   private ContactMessageSaveService contactMessageSaveService;

   @RequestMapping(value = {"/contact"}, method = {RequestMethod.GET})
   public String contact(Model model) {
      log.info("ContactMessage controller accessed");

      // Ensure the model is initialised with required objects
      model = setModel(model);

      return "contact";
   }

   @RequestMapping(value = "/contact", method = RequestMethod.POST)
   public String save(@ModelAttribute @Valid ContactMessage contactMessage,
         BindingResult bindingResult, Model model, RedirectAttributes rmodel) {

      log.info("ContactMessage post [ContactMessage={}]", contactMessage.toString());

      // Setup up the redirect data - so the data entered is not lost if there are errors
      rmodel.addFlashAttribute("name", contactMessage.getName());
      rmodel.addFlashAttribute("emailAddress", contactMessage.getEmailAddress());
      rmodel.addFlashAttribute("message", contactMessage.getMessage());
      rmodel.addFlashAttribute("contactMessage", contactMessage);

      if (bindingResult.hasErrors()) {
         // Validation errors occurred - set-up the redirect attributes

         rmodel.addFlashAttribute("param_validation_error", true);
         rmodel.addFlashAttribute("param_error", false);
         rmodel.addFlashAttribute("param_success", false);

         rmodel.addFlashAttribute("org.springframework.validation.BindingResult.contactMessage", bindingResult);
         rmodel.addFlashAttribute("contactMessage", contactMessage);

         log.info("ContactMessage has errors [{}]", contactMessage.toString());

      } else {
         
         // No validation errors were detected, initialise the redirect attributes (message was successfully sent)
         rmodel.addFlashAttribute("contactMessage", new ContactMessage());
         rmodel.addFlashAttribute("param_validation_error", false);
         rmodel.addFlashAttribute("param_error", false);
         rmodel.addFlashAttribute("param_success", true);
         rmodel.addFlashAttribute("name", null);
         rmodel.addFlashAttribute("emailAddress", null);
         rmodel.addFlashAttribute("message", null);

         log.info("Saving contact message={}", contactMessage.toString());

         try {
            // Save the contact message
            contactMessageSaveService.save(contactMessage.getCreatedDate(),
                  contactMessage.getName(), contactMessage.getEmailAddress(),
                  contactMessage.getMessage());

         } catch (RuntimeException e) {
            rmodel.addFlashAttribute("param_error", true);
            rmodel.addFlashAttribute("param_success", false);
            rmodel.addFlashAttribute("contactMessage", contactMessage);
            log.error("Error when saving contact message", e);
         }
      }

      // Use the PRG pattern to avoid refresh errors  
      return "redirect:contact";
   }

   /**
    * Ensure that the contact message page objects are available and are initialised.
    * @param model Current Spring model attributes. 
    * @return Required model attributes (initialised if required).
    */
   private Model setModel(Model model) {

      if (model.getAttribute("contactMessage") == null) {
         // Set up the objects that are required to be in the model
         
         ContactMessage contactMessage = new ContactMessage();
         model.addAttribute("contactMessage", contactMessage);

         model.addAttribute("param_validation_error", false);
         model.addAttribute("param_error", false);
         model.addAttribute("param_success", false);

         if (log.isDebugEnabled()) {
            log.debug("Setting contactMessage initialised");
         }
      }

      if (log.isDebugEnabled()) {
         log.debug("Contact Message model set [name={}] [emailAddress={}], [message={}] [param_validation_error={}] [param_error={}] [param_success={}]",
               model.getAttribute("name"), model.getAttribute("emailAddress"),
               model.getAttribute("message"), model.getAttribute("param_validation_error"),
               model.getAttribute("param_error"), model.getAttribute("param_success"));
      }

      return model;
   }

}
