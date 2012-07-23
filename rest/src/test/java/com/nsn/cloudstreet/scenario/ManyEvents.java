package com.nsn.cloudstreet.scenario;

import com.nsn.cloudstreet.rest.SpecialEventService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 5/16/12
 * Time: 10:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class ManyEvents {

    @Autowired
    @Qualifier("specialEventService")
    private SpecialEventService specialEventService;
    private String eventName = "ruto";


//    @Test
//    public void createManyEvents() throws Exception{
//        login("manager","manager");
//               final double longitude1 = 11.13684 + 0.01;
//        double radius = 3;
//        final double latitude1 = 48.13684 + 0.01;
//        int nr =100;
//        for (int i=0;i<nr;i++){
//
//         final double marklong = latitude1 + radius / nr * i;
//         double marklat =  Math.sqrt(Math.pow(radius,2)-Math.pow(marklong,2)) +latitude1;
//        specialEventService.addSpecialEvent(SpecialEventTestUtil.createEvent(eventName + i, marklong, marklat));
//        }


//    }

     @Test
       public void circlec(){
             final double longitude1 = 11.13684 + 0.01;
        double radius = 3;
        final double latitude1 = 48.13684 + 0.01;
        int nr =100;
        for (int i=0;i<nr;i++){

            final double v = (radius / nr) * i;
            final double marklong = longitude1 + v;
            double marklat = Math.sqrt(Math.pow(radius, 2) - Math.pow(v, 2)) + latitude1;
         marklat++;
        }
     }
}
