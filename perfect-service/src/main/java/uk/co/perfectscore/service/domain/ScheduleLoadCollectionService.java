package uk.co.perfectscore.service.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uk.co.perfectscore.domain.model.Schedule;
import uk.co.perfectscore.domain.repository.ScheduleRepository;

/**
 * Provide a service for loading the schedule collections.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Service
@Slf4j
public class ScheduleLoadCollectionService extends GenericCollection<Schedule> {

   private final ScheduleRepository scheduleRepository;

   @Autowired
   public ScheduleLoadCollectionService(ScheduleRepository scheduleRepository) {
      
      this.scheduleRepository = scheduleRepository;
      
      collection = new ArrayList<Schedule>();
   }

   public List<Schedule> loadByLeagueSeasonIdAndWeekNo(int leagueSeasonId, int weekNo) {
      
      Sort sort = Sort.by("id.leagueSeasonId", "id.weekNo", "gameDate", "homeTeamName");

      List<Schedule> list = scheduleRepository.findByIdLeagueSeasonIdAndIdWeekNo(leagueSeasonId, weekNo, sort);

      setCollection(list);

      if (log.isDebugEnabled()) {
        for (Schedule l : list) {
          log.debug("Schedule Collection Load [{}]", l.toString());
        }
      }

      return list;
   }
   
   public List<Schedule> loadAll() {

      Sort sort = Sort.by("id.leagueSeasonId", "id.weekNo", "gameDate", "homeTeamNo");
      
      List<Schedule> list = scheduleRepository.findAll(sort);

      setCollection(list);
      
      if (log.isDebugEnabled()) {
        for (Schedule l : list) {
          log.debug("Schedule Collection Load Null Results [{}]", l.toString());
        }
      }

      return list;
   }

   @Override
   protected Schedule getInstance() {
      return new Schedule();
   }
}
