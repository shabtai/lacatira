package com.nsn.cloudstreet.rest.impl;

import com.nsn.cloudstreet.rest.Scenario;
import com.nsn.cloudstreet.specialevents.management.SpecialEventManager;
import com.nsn.cloudstreet.specialevents.model.SpecialEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 5/16/12
 * Time: 10:38 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("scenario")
public class ScenarioImpl implements Scenario {
     private final static int LONDON =1;
    private final static int MUNCHEN =2;

    @Autowired
    private SpecialEventManager specialEventManager;

    @Override
    public void addScenario(int name) throws Exception {
        double longitude1 = 0;
        double latitude1;
        double radius;
        int nr;
        String eventName;
        switch (name) {
            case MUNCHEN: {

                longitude1 = 11.577;
                latitude1 = 48.137;
                radius = 0.05;
                nr = 100;
                eventName = "MUNCHEN";
                 break;
            }
            case LONDON: {
                longitude1 = -0.128;
                latitude1 = 51.508;
                radius = 0.05;
                nr = 100;
                eventName = "LONDON";
                 break;

            }
            default: {
                longitude1 = 11.13684;
                latitude1 = 48.13684;
                radius = 0.5;
                nr = 100;
                eventName = "";
                break;

            }


        }


        creatCircle(longitude1, latitude1, radius, nr, eventName);
    }

    private void creatCircle(final double longitude1, final double latitude1, double radius, int nr, String eventName) throws Exception {
        for (int i = 0; i < nr; i++) {

            // this code drows 1/4 circle
            final double v = (radius / nr) * i;
            double marklong = longitude1 + v;
            double marklat = Math.sqrt(Math.pow(radius, 2) - Math.pow(v, 2)) + latitude1;

            // this code draws arbitrary events in circle
             marklong = longitude1 + Math.pow(-1d,new Random().nextInt(6))*Math.random()* radius ;
             marklat = latitude1 + Math.pow(-1d,new Random().nextInt(6))*Math.random()* radius;



            specialEventManager.createSpecialEvent(createEvent(eventName + i, marklong, marklat));

        }
    }




    private SpecialEvent createEvent(String eventName, Double longitude1,
                                     Double latitude1) throws Exception {

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


        event1 = createEvent(eventName, address1, category1,
                description1, userId1, startTime1, endTime1, radius1, url1,
                summary1, iconLink1, latitude1, longitude1);

        return event1;
    }

    private SpecialEvent createEvent(String name, String address,
                                     String category, String description, Long userId,
                                     Calendar
                                             startTime, Calendar
            endTime, Double radius, String url,
                                     String summary, String iconLink, Double latitude, Double longitude) {
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
}
