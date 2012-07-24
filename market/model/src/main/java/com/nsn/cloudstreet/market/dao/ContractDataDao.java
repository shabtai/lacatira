package com.nsn.cloudstreet.market.dao;

import com.nsn.cloudstreet.common.GenericDao;
import com.nsn.cloudstreet.market.model.ContractData;

import java.util.List;

/**
 * User: dovlaviati
 * Date: 5/2/12, at 11:58 AM
 */
public  interface  ContractDataDao<T extends ContractData> extends GenericDao< T, Long> {

    /**
     * Get a contract data object by its consignment contract ID
     * @param cContractId           ID to look by
     * @return                      Contract data object of the given consignment contract ID
     */
    public T getContractDataByCContractId(Long cContractId);
    public Long getCContractIdByContractId(Long contractId);
    List<T> getContractDataByProductId(Long productId);
}
