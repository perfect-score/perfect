package uk.co.perfectscore.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller exposing requests for the table page.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Slf4j
@Controller
public class TablesController {

   @RequestMapping(value = {"/tables"}, method = RequestMethod.GET)
   public String tables(Model model) {
      log.info("Tables controller accessed");

      return "tables";
   }
}
