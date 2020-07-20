package uk.co.perfectscore.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller exposing requests for the about page.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Slf4j
@Controller
public class AboutController {

   @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
   public String about(Model model) {
      log.info("About controller accessed");
      return "about";
   }

}
