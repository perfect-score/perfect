package uk.co.perfectscore.app.schedules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import uk.co.perfectscore.service.predict.PredictService;

/**
 * A schedule class that calls the prediction service.
 */
@Slf4j
@Component
public class PerfectScheduler {
   
   @Autowired
   private PredictService predictService;

   /**
    * Runs the prediction service, periodically (based on the application property
    * schedule.run.predictions).
    */
   @Scheduled(fixedRateString = "${schedule.run.predictions}")
   public void runSynchronisation() {
      log.info("Perfect Scheduler running");
      predictService.runPredict();
   }
}
