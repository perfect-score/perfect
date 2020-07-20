package uk.co.perfectscore.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import uk.co.perfectscore.app.controllers.helpers.ControllerHelpers;
import uk.co.perfectscore.app.controllers.model.HomeFormSubmit;
import uk.co.perfectscore.service.domain.CurrentWeekLoadService;
import uk.co.perfectscore.service.domain.PerfectScoreResultLoadService;
import uk.co.perfectscore.service.domain.ScheduleLoadCollectionService;
import uk.co.perfectscore.service.domain.WeekLoadCollectionService;

/**
 * Controller exposing requests for the home page.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Slf4j
@Controller
@SessionAttributes("weekNo")
public class HomeController {

   @Autowired
   private ScheduleLoadCollectionService scheduleLoadCollectionService;

   @Autowired
   private WeekLoadCollectionService weekLoadCollectionService;

   @Autowired
   private PerfectScoreResultLoadService perfectScoreResultLoadService;

   @Autowired
   private CurrentWeekLoadService currentWeekLoadService;

   @RequestMapping(value = {"/home", ""}, method = RequestMethod.GET)
   public String home(Model model) {
      log.info("Home controller accessed");

      // Ensure the model is initialised with required objects
      model = setModel(model);

      return "home";
   }

   @RequestMapping(value = {"/home"}, method = RequestMethod.POST)
   public String save(HomeFormSubmit homeFormSubmit, BindingResult bindingResult,
         RedirectAttributes rmodel, Model model) {

      if (bindingResult.hasErrors()) {
         log.info("Home page has errors [{}]", homeFormSubmit.toString());
         return "redirect:home";
      }

      if (log.isDebugEnabled()) {
         log.debug("Week submitted [{}]", homeFormSubmit.toString());
      }

      // Ensure the model is initialised with required objects
      model = setModel(model);

      // Add the week to the redirect attributes so the selected week is not lost
      rmodel.addFlashAttribute("weekNo", model.getAttribute("weekNo"));

      return "redirect:home";
   }
   
   private Model setModel(Model model) {

      int leagueSeasonId = 1;
      int weekNo; // Current week number selected on the home page

      if (model.getAttribute("varLeagueSeasonId") != null) {
         leagueSeasonId = (int) model.getAttribute("varLeagueSeasonId");
      }

      if (model.getAttribute("weekNo") != null) {
         weekNo = (int) model.getAttribute("weekNo");
      } else {
         currentWeekLoadService.load(leagueSeasonId);
         weekNo = currentWeekLoadService.getCurrentWeek().getWeekNo();
      }
       
      HomeFormSubmit homeFormSubmit = null;

      if (model.getAttribute("homeFormSubmit") != null) {
         homeFormSubmit = (HomeFormSubmit) model.getAttribute("homeFormSubmit");

         weekNo = Integer.parseInt(homeFormSubmit.getWeekNo());
      }

      scheduleLoadCollectionService.loadByLeagueSeasonIdAndWeekNo(leagueSeasonId, weekNo);
      weekLoadCollectionService.load(leagueSeasonId);

      model.addAttribute("schedule", scheduleLoadCollectionService.getCollection());
      model.addAttribute("week", weekLoadCollectionService.getCollection());
      model.addAttribute("loaded", scheduleLoadCollectionService.isLoaded());

      model.addAttribute("varLeagueSeasonId", leagueSeasonId);
      model.addAttribute("weekNo", weekNo);

      model.addAttribute("homeFormSubmit", new HomeFormSubmit());

      perfectScoreResultLoadService.load(leagueSeasonId, weekNo);

      model.addAttribute("predictionsLoaded", perfectScoreResultLoadService.isLoaded());
      model.addAttribute("predictions", perfectScoreResultLoadService.getPerfectScoreResult());

      if (perfectScoreResultLoadService.isLoaded()) {
         // Set up the class RAG colours for the prediction results
         ControllerHelpers ch = new ControllerHelpers();

         model.addAttribute("card1",ch.getRag(perfectScoreResultLoadService.getPerfectScoreResult().getHomeScoresPct()));
         model.addAttribute("card2",ch.getRag(perfectScoreResultLoadService.getPerfectScoreResult().getAwayScoresPct()));
         model.addAttribute("card3",ch.getRag(perfectScoreResultLoadService.getPerfectScoreResult().getHomeWinsPct()));
         model.addAttribute("card4",ch.getRag(perfectScoreResultLoadService.getPerfectScoreResult().getAwayWinsPct()));
         model.addAttribute("card5",ch.getRag(perfectScoreResultLoadService.getPerfectScoreResult().getDrawsPct()));
         model.addAttribute("card6",ch.getRag(perfectScoreResultLoadService.getPerfectScoreResult().getResultPct()));
         model.addAttribute("card7", ch.getRag(perfectScoreResultLoadService.getPerfectScoreResult().getPerfectResultPct()));
      }

      return model;
   }

   /**
    * Handles post requests when the current week button is selected.
    * @param model Current Spring model attributes. 
    * @return Target page.
    */
   @RequestMapping(value = {"/latestweek"}, method = RequestMethod.POST)
   public String latestWeek(Model model) {

      // Clear the (latest) select week attribute - so it will be set to the latest
      model.addAttribute("weekNo", null);

      // Ensure the model is initialised with required objects
      model = setModel(model);

      return "redirect:home";
   }

}
