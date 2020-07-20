package uk.co.perfectscore.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.co.perfectscore.service.domain.ScheduleLoadCollectionService;

/**
 * Controller exposing requests for the results page.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Controller
public class ResultsController {

   @Autowired
   private ScheduleLoadCollectionService scheduleLoadCollectionService;

   @RequestMapping(value = {"/results"}, method = RequestMethod.GET)
   public String results(Model model) {

      scheduleLoadCollectionService.loadAll();

      model.addAttribute("schedule", scheduleLoadCollectionService.getCollection());
      model.addAttribute("loaded", scheduleLoadCollectionService.isLoaded());

      return "results";
   }
}
