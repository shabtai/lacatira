package com.nsn.cloudstreet.dao.inheritance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 4/22/12
 * Time: 5:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Y {
    long id;
     @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
