package com.nsn.cloudstreet.dao.inheritance;

import com.nsn.cloudstreet.common.GenericDao;
import com.nsn.cloudstreet.dao.BaseDaoTestCase;
import com.nsn.cloudstreet.dao.hibernate.GenericDaoHibernate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 4/22/12
 * Time: 2:20 PM
 * include C,D,Y in
 * hibernate-configuration
 */
@Ignore
public class InheritanceTest  extends BaseDaoTestCase {
    Log log = LogFactory.getLog(InheritanceTest.class);
    GenericDao<C, Long> genericDao;
    @Autowired
        SessionFactory sessionFactory;

       @Before
       public void setUp() {
           genericDao = new GenericDaoHibernate<C, Long>(C.class, sessionFactory);
       }

      @Test
      public void welovehudson(){
          assertTrue(true);
      }

      @Test
    public void saveC() {

        C c = new C();
          c.setUncle(new Y());
        C savedC = genericDao.save(c);
        assertNotNull(savedC);
    }


}
