package com.lacatira.rest.impl;

import com.lacatira.rest.SpecialEventService;
import com.lacatira.specialevents.management.SpecialEventManager;
import com.lacatira.specialevents.model.SpecialEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("specialEventService")
public class SpecialEventServiceImpl implements SpecialEventService {

    @Autowired
    private SpecialEventManager specialEventManager;

    public SpecialEvent addSpecialEvent(SpecialEvent specialEvent) throws Exception {
        return specialEventManager.createSpecialEvent(specialEvent);
    }

	public List<SpecialEvent> getEvents(Long sellerId, List<Long> ids, Long fromStartTime, Long toStartTime, String eventName) throws Exception {
		return specialEventManager.getSpecialEvents(sellerId, ids, fromStartTime, toStartTime, eventName);
	}

	public SpecialEvent getEventById(Long eventId) throws Exception {
		return specialEventManager.getSpecialEventById(eventId);
	}
}
