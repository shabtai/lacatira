package com.lacatira.specialevents.model;
/**
 * This test class generates Json files for client test
 * Run this test before running the client tests
 * N.K
 */

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Ignore
public class SpecialEventToJsonTest {
	private static final String JSON_PATH = "../../lacatira-lte-gui/src/main/webapp/test/json/generated/";
	private static final int NUM_OF_EVENTS = 10;
	SpecialEvent event1;
	SpecialEvent event1Duplicated;

	// event1
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

	@Test
	public void goodEvents()throws IOException{
		List<SpecialEvent> eventList = new ArrayList<SpecialEvent>();

		for (int i = 0; i < NUM_OF_EVENTS; i++) {

			name1 = new String("my event " + i);
			address1 = new String("USA California palo alto 7876 " + i);
			category1 = new String("my category " + i);
			description1 = new String("my description " + i);
			userId1 = 1001L;
			startTime1 = new GregorianCalendar(2012, 2, 1);
			endTime1 = new GregorianCalendar(2012, 2, 2);

			radius1 = new Double(100);
			url1 = new String("www.url1.com");
			summary1 = new String("my summery " + i);
			iconLink1 = new String("www.url1.com/icon1");
			longitude1 = new Double(100.1);
			latitude1 = new Double(10.1);

			event1 = SpecialEventTestUtil.createEvent(name1, address1, category1,
			        description1, userId1, startTime1, endTime1, radius1, url1,
			        summary1, iconLink1, latitude1, longitude1);
			eventList.add(event1);
		}
        //add id to the first event and to the second event
        eventList.get(0).setId(new Long(1));
        eventList.get(1).setId(new Long(2));


        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(new File(JSON_PATH + "events.json"), eventList);




	}

	@Test
	public void eventsWithMissingParams() throws IOException{
		List<SpecialEvent> eventList = new ArrayList<SpecialEvent>();

		for (int i = 0; i < NUM_OF_EVENTS; i++) {
			int j = 0;
			name1 = new String("my event " + i);

			if ((i + (j++)) % NUM_OF_EVENTS == 0) {
				address1 = new String("Germany " + i);
			}
			if ((i + (j++)) % NUM_OF_EVENTS == 0) {
				category1 = new String("my category " + i);
			}
			if ((i + (j++)) % NUM_OF_EVENTS == 0) {
				description1 = new String("my description " + i);
			}
			if ((i + (j++)) % NUM_OF_EVENTS == 0) {
				userId1 = 1001L;
			}
			if ((i + (j++)) % NUM_OF_EVENTS == 0) {
				startTime1 = new GregorianCalendar(2012, 2, 1);
			}
			if ((i + (j++)) % NUM_OF_EVENTS == 0) {
				endTime1 = new GregorianCalendar(2012, 2, 2);
			}
			if ((i + (j++)) % NUM_OF_EVENTS == 0) {
				radius1 = new Double(100);
			}
			if ((i + (j++)) % NUM_OF_EVENTS == 0) {
				url1 = new String("www.url1.com");
			}
			if ((i + (j++)) % NUM_OF_EVENTS == 0) {
				summary1 = new String("my summery " + i);
			}
			if ((i + (j++)) % NUM_OF_EVENTS == 0) {
				iconLink1 = new String("www.url1.com/icon1");
			}

			if ((i + (j++)) % NUM_OF_EVENTS == 0) {
				longitude1 = new Double(100.1);
			}
			if ((i + (j++)) % NUM_OF_EVENTS == 0) {
				latitude1 = new Double(10.1);
			}
			event1 = SpecialEventTestUtil.createEvent(name1, address1, category1,
			        description1, userId1, startTime1, endTime1, radius1, url1,
			        summary1, iconLink1, latitude1, longitude1);
			eventList.add(event1);
		}

        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(new File(JSON_PATH +"eventsWithMissingParams" ), eventList);


	}

}
