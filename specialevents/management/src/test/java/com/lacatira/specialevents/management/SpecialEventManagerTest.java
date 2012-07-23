package com.lacatira.specialevents.management;

import com.lacatira.specialevents.dao.SpecialEventDao;
import com.lacatira.specialevents.model.SpecialEvent;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class SpecialEventManagerTest {
    private SpecialEventManager specialEventManager;

    @Before
    public void setUp(){
        specialEventManager = new SpecialEventManager();
        SpecialEventDao specialEventDao = EasyMock.createNiceMock(SpecialEventDao.class);
        specialEventManager.setSeDao(specialEventDao);
    }

    @Test
    public void seManagerTest(){
        specialEventManager.createSpecialEvent(new SpecialEvent());
    }
    
    @Test
    public void getSpecialEventsTest(){
    	specialEventManager.getSpecialEvents(null, null,null,null,null);
    }
    
    @Test
    public void getLTECContractsTest(){
    	specialEventManager.getSpecialEvents((long) 5, new ArrayList<Long>(),null,null,null);
    }
}
