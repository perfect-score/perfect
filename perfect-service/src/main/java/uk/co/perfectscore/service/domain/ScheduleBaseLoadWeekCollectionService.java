package uk.co.perfectscore.service.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uk.co.perfectscore.domain.model.ScheduleBase;
import uk.co.perfectscore.domain.repository.ScheduleBaseRepository;

/**
 * Provide a service for loading the schedule base collection for a given league and week.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Service
@Slf4j
public class ScheduleBaseLoadWeekCollectionService extends GenericCollection<ScheduleBase> {

   @Autowired
   private ScheduleBaseRepository scheduleBaseRepository;

   public ScheduleBaseLoadWeekCollectionService() {
      collection = new ArrayList<ScheduleBase>();
   }

   public List<ScheduleBase> loadByLeagueSeasonIdAndWeekNo(int leagueSeasonId, int weekNo) {

      Sort sort = Sort.by("id.leagueSeasonId", "id.weekNo", "id.gameNo");

      List<ScheduleBase> list = scheduleBaseRepository.findByIdLeagueSeasonIdAndIdWeekNo(leagueSeasonId, weekNo, sort);

      setCollection(list);
      
      if (log.isDebugEnabled()) {
        for (ScheduleBase l : list) {
          log.debug("ScheduleBase Collection Load [{}]", l.toString());
        }
      }
      
      return list;
   }
   
   @Override
   protected ScheduleBase getInstance() {
      return new ScheduleBase();
   }
}
