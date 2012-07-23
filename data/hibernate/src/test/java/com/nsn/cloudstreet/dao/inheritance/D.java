package com.nsn.cloudstreet.dao.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 4/22/12
 * Time: 2:10 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@DiscriminatorValue("C")
public class D extends Basic<Y>{
}
