package com.nsn.cloudstreet.market.engines;

import com.google.common.base.Preconditions;
import com.nsn.cloudstreet.market.dao.CContractDao;
import com.nsn.cloudstreet.market.dao.ContractDao;
import com.nsn.cloudstreet.market.dao.ContractDataDao;
import com.nsn.cloudstreet.market.model.ConsignmentContract;
import com.nsn.cloudstreet.market.model.Contract;
import com.nsn.cloudstreet.market.model.ContractData;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 5/21/12
 * Time: 10:29 PM
 * responsible for purchase life cycle
 */
@Repository("purchaseFlowEngine")
public class PurchaseFlowEngine<T extends ConsignmentContract, A extends Contract> {
      @Inject
    private CContractDao<T> cContractDao;

     @Inject
    private ContractDataDao contractDataDao;

    @Inject
    private ContractDao<A> contractDao;

    public CContractDao<T> getcContractDao() {
        return cContractDao;
    }

    public void setcContractDao(CContractDao<T> cContractDao) {
        this.cContractDao = cContractDao;
    }

    public ContractDataDao getContractDataDao() {
        return contractDataDao;
    }

    public void setContractDataDao(ContractDataDao contractDataDao) {
        this.contractDataDao = contractDataDao;
    }

    public ContractDao<A> getContractDao() {
        return contractDao;
    }

    public void setContractDao(ContractDao<A> contractDao) {
        this.contractDao = contractDao;
    }

    public T addCContract(T consignmentContract) {
        ContractData data = consignmentContract.createContractData();
        T savedContract = cContractDao.save(consignmentContract);
        data.setConsignmentContract(savedContract);
        contractDataDao.save(data);
        return savedContract;
    }

    public A startPurchaseFlow(A contract, Long cContractId) {
        ContractData contractData = contractDataDao.getContractDataByCContractId(cContractId);
        A savedcontract = contractDao.save(contract);
        contractData.addContract(savedcontract);
        contractDataDao.save(contractData);
        return savedcontract;
    }
      /*
      start  a purchase flow of an existing product.
       */
    public A startPurchaseFlow(A contract) {
        final Long id = contract.getProduct().getId();
        Preconditions.checkArgument(id != null && id > 0, "product must have an id");
        List<ContractData> contractDatas = contractDataDao.getContractDataByProductId(id);
        ContractData cData;
        if (contractDatas.size() > 1) {
            cData = findBestMatch(contractDatas);
        } else {
            cData = contractDatas.get(0);
        }
        A savedcontract = contractDao.save(contract);
        cData.addContract(savedcontract);
        contractDataDao.save(cData);
        return savedcontract;
    }

    protected ContractData findBestMatch(List<ContractData> contractDatas) {
        throw new RuntimeException("findBestMatch is not implemented");
    }
}
