package com.nsn.cloudstreet.market.dao;

import com.lacatira.common.GenericDao;
import com.nsn.cloudstreet.market.model.ConsignmentContract;

/**
 * User: dovlaviati
 * Date: 5/2/12, at 11:58 AM
 */
public  interface CContractDao<T extends ConsignmentContract> extends GenericDao< T , Long> {


}
