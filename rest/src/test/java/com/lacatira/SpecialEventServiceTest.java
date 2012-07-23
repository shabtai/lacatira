package com.lacatira;

import com.lacatira.specialevents.model.SpecialEvent;
import com.lacatira.specialevents.model.SpecialEventTestUtil;
import org.junit.Test;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class SpecialEventServiceTest extends TestServiceUtil{

    //tests addSpecialEvents  api with no auth / wrong auth
    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void serviceNoAuthTest() throws Exception {
    	SpecialEvent specialEvent = new SpecialEvent();
  		specialEvent.setName("dina31");
   		specialEventService.addSpecialEvent(specialEvent);
    }

    @Test(expected = AccessDeniedException.class)
    public void addEventAccessDenied() throws Exception {
    	login("provider","provider");
    	SpecialEvent specialEvent = new SpecialEvent();
  		specialEvent.setName("dina31");
   		specialEventService.addSpecialEvent(specialEvent);
    }

    @Test(expected = AccessDeniedException.class)
    public void getEventAccessDenied() throws Exception {
    	login("provider","provider");
    	SpecialEvent specialEvent = new SpecialEvent();
  		specialEvent.setName("dina31");
   		specialEventService.getEventById((long)1);
    }


    @Test
    public void addEventTest() throws Exception {
    	login("manager","manager");
        SpecialEvent specialEvent = new SpecialEvent();
        specialEvent.setName("dina30");
        SpecialEvent addedSpesialEvent = specialEventService.addSpecialEvent(specialEvent);
        assertEquals(addedSpesialEvent.getName(), specialEvent.getName());
        assertNotNull(addedSpesialEvent.getId());
    }

    @Test
    public void countEventToZero() throws Exception {
        login("manager","manager");
        List<SpecialEvent> eventList = specialEventService.getEvents(null,null,null,null,null);
        assertEquals(0,eventList.size());

    }




    @Test
    public void getEventByIdTest() throws Exception {
    	login("manager","manager");
        SpecialEvent specialEvent = new SpecialEvent();
        specialEvent.setName("dina30");
        SpecialEvent addedSpesialEvent = specialEventService.addSpecialEvent(specialEvent);
        SpecialEvent fromDBEvent = specialEventService.getEventById(addedSpesialEvent.getId());
        assertEquals(fromDBEvent.getName(), specialEvent.getName());

    }
    
    @Test
    public void getEventsTest() throws Exception {
    	login("manager","manager");
    	Long userId = new Long(2);
    	final SpecialEventTestUtil specialEventTestUtil = new SpecialEventTestUtil();
        final SpecialEvent specialEvent1 = specialEventTestUtil.generateDummyEvent1();
        final SpecialEvent specialEvent2 = specialEventTestUtil.generateDummyEvent2();
        specialEvent1.setUserId(userId);
        
        SpecialEvent addedSpesialEvent1 = specialEventService.addSpecialEvent(specialEvent1);
        SpecialEvent addedSpesialEvent2 = specialEventService.addSpecialEvent(specialEvent2);
        
        List<Long> ids= new ArrayList<Long>();
        ids.add(addedSpesialEvent1.getId());
        ids.add(addedSpesialEvent2.getId());
        List<SpecialEvent> fromDBEvents = specialEventService.getEvents(userId, ids,null,null, null);
        assertEquals(1, fromDBEvents.size());
        
        Calendar fromstartTime = new GregorianCalendar(2016,1,1);
        fromDBEvents = specialEventService.getEvents(userId, ids, fromstartTime.getTimeInMillis(),null, null);
        assertEquals(0, fromDBEvents.size());

        String eventName1 = specialEvent1.getName();
        fromDBEvents = specialEventService.getEvents(userId, ids, null,null, eventName1);
        assertEquals(1, fromDBEvents.size());

        String eventName2 = specialEvent2.getName();
        fromDBEvents = specialEventService.getEvents(userId, ids, null,null, eventName2);
        assertEquals(0, fromDBEvents.size());
    }
    
    @Test
    public void getEventsTestForConsumer() throws Exception {
    	login("manager","manager");
    	Long userId = new Long(2);
    	final SpecialEventTestUtil specialEventTestUtil = new SpecialEventTestUtil();
        final SpecialEvent specialEvent1 = specialEventTestUtil.generateDummyEvent1();
        final SpecialEvent specialEvent2 = specialEventTestUtil.generateDummyEvent2();
        specialEvent1.setUserId(userId);
        
        SpecialEvent addedSpesialEvent1 = specialEventService.addSpecialEvent(specialEvent1);
        SpecialEvent addedSpesialEvent2 = specialEventService.addSpecialEvent(specialEvent2);
        clear();
        login("consumer","consumer");
        List<Long> ids= new ArrayList<Long>();
        ids.add(addedSpesialEvent1.getId());
        ids.add(addedSpesialEvent2.getId());
        List<SpecialEvent> fromDBEvents = specialEventService.getEvents(userId, ids,null,null, null);
        assertEquals(1, fromDBEvents.size());
        
        Calendar fromstartTime = new GregorianCalendar(2016,1,1);
        fromDBEvents = specialEventService.getEvents(userId, ids, fromstartTime.getTimeInMillis(),null, null);
        assertEquals(0, fromDBEvents.size());

        String eventName1 = specialEvent1.getName();
        fromDBEvents = specialEventService.getEvents(userId, ids, null,null, eventName1);
        assertEquals(1, fromDBEvents.size());

        String eventName2 = specialEvent2.getName();
        fromDBEvents = specialEventService.getEvents(userId, ids, null,null, eventName2);
        assertEquals(0, fromDBEvents.size());
    }



}
