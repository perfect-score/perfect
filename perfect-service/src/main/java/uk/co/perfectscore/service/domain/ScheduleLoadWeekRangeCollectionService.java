package uk.co.perfectscore.service.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uk.co.perfectscore.domain.model.Schedule;
import uk.co.perfectscore.domain.repository.ScheduleRepository;

/**
 * Provide a service for loading the schedule collection for a given start and end week range.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Service
@Slf4j
public class ScheduleLoadWeekRangeCollectionService extends GenericCollection<Schedule> {

   @Autowired
   private ScheduleRepository scheduleRepository;

   public ScheduleLoadWeekRangeCollectionService() {
      collection = new ArrayList<Schedule>();
   }
   
   public List<Schedule> loadByTeamNoAndStartWeekAndEndWeek(int leagueSeasonId, int startWeekNo, int endWeekNo) {

      List<Schedule> list = scheduleRepository.findByWeekRange(leagueSeasonId, startWeekNo, endWeekNo); 
      
      setCollection(list);

      if (log.isDebugEnabled()) {
        for (Schedule l : list) {
          log.debug("Schedule load week range collection [{}]", l.toString());
        }
      }

      return list;
   }

   @Override
   protected Schedule getInstance() {
      return new Schedule();
   }
}
