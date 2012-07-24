package com.nsn.cloudstreet.market.engines;

import com.nsn.cloudstreet.market.dao.ContractDataDao;
import com.nsn.cloudstreet.market.model.ContractData;

import javax.inject.Inject;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 5/21/12
 * Time: 9:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReservationEngine<T extends  Number> {

    @Inject
    private ContractDataDao<? extends ContractData<T,?,?,?> > contractDataDao;




    public  T getAvailabilityForCContract(Long cContractId) {
        ContractData<T,?,?,?> contractData = contractDataDao.getContractDataByCContractId(cContractId);
        return contractData.getAvailability();

    }



    public void setContractDataDao(ContractDataDao contractDataDao) {
       this.contractDataDao = contractDataDao;
    }
}
