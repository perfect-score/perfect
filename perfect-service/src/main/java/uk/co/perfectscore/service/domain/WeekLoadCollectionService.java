package uk.co.perfectscore.service.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uk.co.perfectscore.domain.model.Week;
import uk.co.perfectscore.domain.repository.WeekRepository;

/**
 * Provide a service for loading the week collection for a given league/season.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Service
@Slf4j
public class WeekLoadCollectionService extends GenericCollection<Week> {

   @Autowired
   private WeekRepository weekRepository;

   public WeekLoadCollectionService() {
      collection = new ArrayList<Week>();
   }

   public List<Week> load(int leagueSeasonId) {

      Sort sort = Sort.by("id.leagueSeasonId", "id.weekNo");
      
      List<Week> list = weekRepository.findByIdLeagueSeasonId(leagueSeasonId, sort);

      setCollection(list);

      if (log.isDebugEnabled()) {
        for (Week l : list) {
          log.debug("Week Collection Load [{}]", l.toString());
        }
      }

      return list;
   }

   @Override
   protected Week getInstance() {
      return new Week();
   }
}
