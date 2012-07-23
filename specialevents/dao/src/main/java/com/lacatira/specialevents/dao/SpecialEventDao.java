package com.lacatira.specialevents.dao;

import com.lacatira.common.GenericDao;
import com.lacatira.specialevents.model.SpecialEvent;

import java.util.List;

public interface SpecialEventDao extends GenericDao<SpecialEvent, Long> {
	 /**
     * Gets a list of events according to given parameters
     *
     * @return List populated list of events
     */
    List<SpecialEvent> findEventsbyParameters(Long userId, List<Long> ids, Long fromStartTime, Long toStartTime, String eventName);

}
