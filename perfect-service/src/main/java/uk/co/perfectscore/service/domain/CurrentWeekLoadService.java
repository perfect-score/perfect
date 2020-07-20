package uk.co.perfectscore.service.domain;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uk.co.perfectscore.domain.model.CurrentWeek;
import uk.co.perfectscore.domain.repository.CurrentWeekRepository;

/**
 * Provide a service for loading the current game week.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Service
@Slf4j
public class CurrentWeekLoadService {

   private CurrentWeek currentWeek;
   private boolean loaded = false;

   @Autowired
   private CurrentWeekRepository currentWeekRepository;

   public CurrentWeek getCurrentWeek() {
      return currentWeek;
   }
   public void setCurrentWeek(CurrentWeek currentWeek) {
      this.currentWeek = currentWeek;
   }
   public final void setLoaded(final boolean loaded) {
      this.loaded = loaded;
   }
   public final boolean isLoaded() {
      return loaded;
   }

   public void load(int leagueSeasonId) {
      Optional<CurrentWeek> optinalEntity = currentWeekRepository.findById(leagueSeasonId);
      loaded = optinalEntity.isPresent();

      if (loaded) {
         setCurrentWeek(optinalEntity.get());

         if (log.isDebugEnabled()) {
            log.debug("CurrentWeek loaded [Id={}]", getCurrentWeek().toString());
         }
      }
   }
}
