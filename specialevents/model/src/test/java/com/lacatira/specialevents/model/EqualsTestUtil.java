package com.lacatira.specialevents.model;


import com.lacatira.common.BusinessModel;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 4/24/12
 * Time: 12:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class EqualsTestUtil {

      public static <T extends BusinessModel> void equalsAndHashIdProfile(T a, T b, T aDuplicated, T empty1,T empty2 , T empty3) {
        assertFalse(a.equals(b));
        assertFalse(b.equals(a));
        assertTrue(a.equals(a));
        assertTrue(b.equals(b));

        assertFalse(b.equals(null));
        assertFalse(b.equals(new Object()));


        assertFalse(a.equals(empty1));

        empty1.setId(1L);
        assertTrue("Equals test", empty1.equals(a));
        assertTrue("Equals test", a.equals(empty1));

        assertEquals(a.hashCode(),
                empty1.hashCode());

        Set<T> set = new HashSet<T>();
        set.add(a);
        assertEquals(1, set.size());
        set.add(aDuplicated);
        assertEquals(1, set.size());
        set.add(b);
        assertEquals(2, set.size());

        set.add(empty2);
        set.add(empty3);

        assertEquals(4, set.size());
    }
}
