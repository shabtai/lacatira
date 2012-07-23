package com.lacatira.specialevents.management;


import com.lacatira.specialevents.dao.SpecialEventDao;
import com.lacatira.specialevents.model.SpecialEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialEventManager {

    @Autowired
    SpecialEventDao seDao;

    public void setSeDao(SpecialEventDao seDao) {
        this.seDao = seDao;
    }

    public SpecialEvent createSpecialEvent(SpecialEvent se) {
        return  seDao.save(se);
    }
    
    public List<SpecialEvent> getSpecialEvents(Long  userId, List<Long> ids, Long fromStartTime, Long toStartTime, String eventName) {
        return  seDao.findEventsbyParameters(userId, ids, fromStartTime, toStartTime, eventName);
    }

	public SpecialEvent getSpecialEventById(Long eventId) {
		return seDao.get(eventId);
	}
}
