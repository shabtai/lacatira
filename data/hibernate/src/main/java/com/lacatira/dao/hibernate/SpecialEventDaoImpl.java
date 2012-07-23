package com.lacatira.dao.hibernate;

import com.lacatira.specialevents.dao.SpecialEventDao;
import com.lacatira.specialevents.model.SpecialEvent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Repository("specialEventDao")
public class SpecialEventDaoImpl extends GenericDaoHibernate<SpecialEvent, Long> implements
        SpecialEventDao {
	
	protected final Log LOG = LogFactory.getLog(getClass());

    public SpecialEventDaoImpl() {
        super(SpecialEvent.class);
    }

    
    
    public List<SpecialEvent> findEventsbyParameters(Long userId, List<Long> ids, Long fromStartTime, Long toStartTime, String eventName) {
    	
    	DetachedCriteria criteria =   DetachedCriteria.forClass(SpecialEvent.class);
    	
	    if (userId != null) {
	    	criteria.add(Restrictions.eq("userId",userId));
	    	
	    }
//	    if (!CollectionUtils.(ids)) {
//	    	criteria.add(Restrictions.in("id",ids));
//	    }
	    
	    if (fromStartTime != null) {
	    	Calendar fromTime = new GregorianCalendar();
	    	fromTime.setTimeInMillis(fromStartTime);
	    	criteria.add(Restrictions.ge("startTime",fromTime));
    	
	    }
	    
	    if (toStartTime != null) {
	    	Calendar toTime = new GregorianCalendar();
	    	toTime.setTimeInMillis(toStartTime);
	    	criteria.add(Restrictions.lt("startTime",toTime));
    	
	    }

        if (eventName != null) {
            criteria.add(Restrictions.eq("name",eventName));
        }

	    List<SpecialEvent> events =  getHibernateTemplate().findByCriteria(criteria);
	    return events;
    }


  
}
