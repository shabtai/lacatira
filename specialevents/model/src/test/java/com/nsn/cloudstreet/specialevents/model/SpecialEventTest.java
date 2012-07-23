package com.nsn.cloudstreet.specialevents.model;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
@Ignore
public class SpecialEventTest {

	SpecialEvent event1;
	SpecialEvent event2;
	SpecialEvent event1Duplicated;
	SpecialEventTestUtil seUtil = new SpecialEventTestUtil();

	@Before
	public void createEventsForTest() {


		event1 = seUtil.generateDummyEvent1();
		
		event1Duplicated = seUtil.generateDummyEvent1();
		event1.setId(new Long(1));
		event1Duplicated.setId(new Long(1));
		
		// event 2;
		
		event2 = seUtil.generateDummyEvent2();
		event2.setId(new Long(2));
	}
	
	
	@Test
	public void testEventFileds() {

		assertTrue(new Long(1).equals(event1.getId()));
		seUtil.verifyEventAttr(event1);
	}

	@Test
	public void testSimpleEqualsAndHash() {

        EqualsTestUtil.equalsAndHashIdProfile(event1,event2,event1Duplicated,new SpecialEvent(),new SpecialEvent(),new SpecialEvent());

	}


    @Test
	public void testToString() {
		event1.toString();
		event2.toString();
		(new SpecialEvent()).toString();
	}

}
