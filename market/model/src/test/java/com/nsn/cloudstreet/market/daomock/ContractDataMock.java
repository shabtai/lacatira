package com.nsn.cloudstreet.market.daomock;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.nsn.cloudstreet.common.BasicDaoMok;
import com.nsn.cloudstreet.market.dao.ContractDataDao;
import com.nsn.cloudstreet.market.model.ContractData;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 6/5/12
 * Time: 9:26 AM
 * To change this template use File | Settings | File Templates.
 */
@Ignore
public class ContractDataMock<T extends ContractData>  extends BasicDaoMok<T> implements ContractDataDao<T>{
    @Override
    public T getContractDataByCContractId(final Long cContractId) {
        for (T c :map.values()){
            if (c.getId().equals(cContractId)){
                return c;
            }
        }
        return null;
    }

    @Override
    public Long getCContractIdByContractId(Long contractId) {
        final T contractDataByCContractId = getContractDataByCContractId(contractId);
        return contractDataByCContractId !=null?contractDataByCContractId.getId():null;
    }

    @Override
    public List<T> getContractDataByProductId(final Long productId) {
         Collection<T> collection = new ArrayList<T>();

        try{{ collection = Collections2.filter(map.values(), new Predicate<T>() {
            @Override
            public boolean apply(T input) {
                return input.getConsignmentContract().getProduct().getId().equals(productId);
            }
        });
    } } catch (Exception e){

        }

       return new ArrayList<T>(collection);

}

}
