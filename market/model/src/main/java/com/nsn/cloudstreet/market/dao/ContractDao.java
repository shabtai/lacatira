package com.nsn.cloudstreet.market.dao;

import com.nsn.cloudstreet.common.GenericDao;
import com.nsn.cloudstreet.market.model.Contract;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 5/23/12
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ContractDao <T extends Contract> extends GenericDao< T , Long> {

}
