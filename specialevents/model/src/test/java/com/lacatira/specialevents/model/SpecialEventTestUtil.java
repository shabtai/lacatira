package com.lacatira.specialevents.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpecialEventTestUtil {
	//event1 
	String name1;
	String address1;
	String category1;
	String description1;
	Long userId1;
	Calendar startTime1;
	Calendar endTime1;
	Double radius1;
	String url1;
	String summary1;
	String iconLink1;
	Double longitude1;
	Double latitude1;

	
	
	//event2 
	String name2;
	String address2;
	String category2;
	String description2;
	Long userId2;
	Calendar startTime2;
	Calendar endTime2;
	Double radius2;
	String url2;
	String summary2;
	String iconLink2;
	Double longitude2;
	Double latitude2;
	
	
	public static SpecialEvent createEvent(String name, String address,
			String category, String description, Long userId,
			Calendar startTime, Calendar endTime, Double radius, String url,
			String summary, String iconLink, Double latitude, Double longitude ) {
		SpecialEvent event = new SpecialEvent();
		event.setName(name);
		event.setAddress(address);
		event.setCategory(category);
		event.setUserId(userId);
		event.setStartTime(startTime);
		event.setEndTime(endTime);
		event.setDescription(description);
		event.setRadius(radius);
		event.setUrl(url);
		event.setSummary(summary);
		event.setIconLink(iconLink);
		event.setLatitude(latitude);
		event.setLongitude(longitude);
		return event;
	}
	
	public static SpecialEvent createEvent(String eventName) throws Exception {
        SpecialEvent event1;
        String address1;
        String category1;
        String description1;
        Long userId1;
        Calendar startTime1;
        Calendar endTime1;
        Double radius1;
        String url1;
        String summary1;
        String iconLink1;
        Double longitude1;
        Double latitude1;

        address1 = "USA California palo alto 7876 ";
        category1 = "my category ";
        description1 = "my description ";
        userId1 = 3L;
        startTime1 = new GregorianCalendar(2014, 2, 1);
        endTime1 = new GregorianCalendar(2014, 2, 2);

        radius1 = (double) 100;
        url1 = "www.url1.com";
        summary1 = "my summery ";
        iconLink1 = "www.url1.com/icon1";

        longitude1 = 11.13684 + 0.01;
        latitude1 = 48.13684 + 0.01;

        event1 = createEvent(eventName, address1, category1,
                description1, userId1, startTime1, endTime1, radius1, url1,
                summary1, iconLink1, latitude1, longitude1);

        return event1;
    }

	public SpecialEvent generateDummyEvent1()
	{
		// event 1;
		name1 = "my event 1";
		address1 = "my address 1";
		category1 = "my category 1";
		description1 = "my description 1";
		userId1 = 1001L;
		startTime1 = new GregorianCalendar(2015, 2, 1);
		endTime1 = new GregorianCalendar(2015, 2, 2);
		

		radius1 = (double) 100;
		url1 = "www.url1.com";
		summary1 = "my summery 1";
		iconLink1 = "www.url1.com/icon1";
		longitude1 = 100.1;
		latitude1 = 10.1;
		return  createEvent(name1, address1, category1, description1, userId1,
				startTime1, endTime1, radius1, url1, summary1, iconLink1,
				latitude1, longitude1);


	}
	
	public SpecialEvent generateDummyEvent2()
	{
		// event 1;
		name2 = "my event 2";
		address2 = "my address 2";
		category2 = "my category 2";
		description2 = "my description 2";
		userId2 =1002L;
		startTime2 = new GregorianCalendar(2012, 2, 1);
		endTime2 = new GregorianCalendar(2012, 2, 2);
		
		radius2 = (double) 100;
		url2 = "www.url2.com";
		summary2 = "my summery 2";
		iconLink2 = "www.url1.com/icon2";
		longitude2 = 200.1;
		latitude2 = 20.1;
		return  createEvent(name2, address2, category2, description2, userId2,
				startTime2, endTime2, radius2, url2, summary2, iconLink2,
				latitude2, longitude2);


	}
	
	public void verifyEventAttr(SpecialEvent event)
	{
			assertTrue(new Long(1).equals(event.getId()));
			assertEquals(name1, event.getName());
			assertEquals(address1, event.getAddress());
			assertEquals(category1, event.getCategory());
			assertEquals(userId1, event.getUserId());
			assertEquals(description1, event.getDescription());
			assertEquals(startTime1, event.getStartTime());
			assertEquals(endTime1, event.getEndTime());
			assertEquals(radius1, event.getRadius());
			assertEquals(url1, event.getUrl());
			assertEquals(summary1, event.getSummary());
			assertEquals(iconLink1, event.getIconLink());
			assertEquals(latitude1, event.getLatitude());
			assertEquals(longitude1, event.getLongitude());

	}
}
