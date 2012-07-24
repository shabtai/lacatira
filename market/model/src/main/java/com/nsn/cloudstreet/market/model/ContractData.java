package com.nsn.cloudstreet.market.model;

import com.nsn.cloudstreet.common.BusinessModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * User: dovlaviati
 * Date: 5/2/12, at 11:53 AM
 *
 * This class contains all the back office details data / operations related to contracts
 */
@MappedSuperclass
public abstract class ContractData<N extends Number, Q extends Quantity<?,N> , C extends Contract<? , ?,?, Q >, CC extends ConsignmentContract<? , ?,?, Q >> implements BusinessModel{
    /**
     * Consignment contract
     */
    private CC consignmentContract;

    /**
     * Contracts based on the consignment contract
     */
    private Set<C> contracts = new HashSet<C>();

    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    @OneToMany(fetch = FetchType.EAGER)
    public Set<C> getContracts() {
        return contracts;
    }

    public void setContracts(Set<C> contracts) {
        this.contracts = contracts;
    }

    /**
     * Add a contract to the set of contracts
     * @param contract Contract to add
     */
    public void addContract(C contract) {
        this.contracts.add(contract);
    }

    @OneToOne()
    public CC getConsignmentContract() {
        return consignmentContract;
    }

    public void setConsignmentContract(CC consignmentContract) {
        this.consignmentContract = consignmentContract;
    }


    @Transient
     public abstract  N getAvailability();
}
