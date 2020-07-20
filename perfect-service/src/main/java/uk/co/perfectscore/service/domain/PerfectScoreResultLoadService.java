package uk.co.perfectscore.service.domain;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uk.co.perfectscore.domain.model.PerfectScoreResult;
import uk.co.perfectscore.domain.model.PerfectScoreResultPK;
import uk.co.perfectscore.domain.repository.PerfectScoreResultRepository;

/**
 * Provide a service for loading the perfect score results for a given league and week.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Service
@Slf4j
public class PerfectScoreResultLoadService {

   private PerfectScoreResult perfectScoreResult;
   private boolean loaded = false;

   @Autowired
   private PerfectScoreResultRepository perfectScoreResultRepository;

   public PerfectScoreResult getPerfectScoreResult() {
      return perfectScoreResult;
   }
   public void setPerfectScoreResult(PerfectScoreResult perfectScoreResult) {
      this.perfectScoreResult = perfectScoreResult;
   }
   public final void setLoaded(final boolean loaded) {
      this.loaded = loaded;
   }
   public final boolean isLoaded() {
      return loaded;
   }

   public void load(int leagueSeasonId, int weekNo) {
      Optional<PerfectScoreResult> optinalEntity = perfectScoreResultRepository.findById(new PerfectScoreResultPK(leagueSeasonId, weekNo));
      loaded = optinalEntity.isPresent();

      if (loaded) {
         setPerfectScoreResult(optinalEntity.get());

         if (log.isDebugEnabled()) {
            log.debug("PerfectScoreResult loaded [Id={}]", getPerfectScoreResult().toString());
         }
      }
   }
}
