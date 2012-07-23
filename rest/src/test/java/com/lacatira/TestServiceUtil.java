package com.lacatira;

import com.lacatira.rest.SpecialEventService;
import com.lacatira.specialevents.model.SpecialEvent;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;


@ContextConfiguration(locations = {
		"classpath:/applicationContext-test.xml",
		"classpath:/applicationContext-dao.xml",
		"classpath*:/**/applicationContext.xml",
		"/WEB-INF/securityContext.xml"
})
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class TestServiceUtil {
    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager am;

    @Autowired
    protected ApplicationContext applicationContext;


    @Autowired
    @Qualifier("specialEventService")
    protected SpecialEventService specialEventService;




    protected void login(String name, String password) {
        Authentication auth = new UsernamePasswordAuthenticationToken(name, password);
        SecurityContextHolder.getContext().setAuthentication(am.authenticate(auth));
    }

    @After
    public void clear() {
        SecurityContextHolder.clearContext();
    }
    
    @Before
    public void clearDatabase() throws Exception {
        BasicDataSource ds = (BasicDataSource) applicationContext.getBean("dataSource");

        Connection connection = null;
        try {
            connection = ds.getConnection();
            try {
                Statement stmt = connection.createStatement();
                try {
                    stmt.execute("TRUNCATE SCHEMA public AND COMMIT");
                    connection.commit();
                } finally {
                    stmt.close();
                }
            } catch (SQLException e) {
                connection.rollback();
                throw new Exception(e);
            }
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    protected SpecialEvent getEvent(int eventNumber) throws Exception {
        SpecialEvent event = new SpecialEvent();
        event.setName("testEvent" + eventNumber);
        event.setAddress("testAddress" + eventNumber);
        event.setCategory("testCategory" + eventNumber);
        event.setDescription("testDescription" + eventNumber);
        event.setStartTime(new GregorianCalendar(2015, 2, eventNumber));
        event.setEndTime(new GregorianCalendar(2015, 4, 5 + eventNumber));
        event.setIconLink("testIconLink" + eventNumber);
        event.setLatitude(1.1 * eventNumber);
        event.setLongitude(2.22 * eventNumber);
        event.setRadius(3.333 * eventNumber);
        event.setSummary("testSummary" + eventNumber);
        event.setUrl("testUrl" + eventNumber);
        event.setUserId((long)eventNumber);
        return event;
    }

    protected SpecialEvent addEvent(int eventNumber) throws Exception {
        return specialEventService.addSpecialEvent(getEvent(eventNumber));
    }







}
