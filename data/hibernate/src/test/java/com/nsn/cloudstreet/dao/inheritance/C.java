package com.nsn.cloudstreet.dao.inheritance;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 4/22/12
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@DiscriminatorValue("C")
public class C extends  Basic<Y>{

}
