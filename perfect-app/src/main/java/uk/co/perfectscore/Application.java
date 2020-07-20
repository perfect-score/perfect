package uk.co.perfectscore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

/**
 * A class containing the entry point to launch the Spring Boot application.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Slf4j
@SpringBootApplication
@EnableScheduling
public class Application {

   /**
    * The method that is called to launch the Spring Boot application.
    * @param args The arguments passed to the main method when launching the application.
    */
   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
      log.info("Application perfect-app initialised");
   }

}
