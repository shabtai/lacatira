package com.nsn.cloudstreet.market.model;

import javax.persistence.*;
import java.util.Calendar;


@MappedSuperclass
public abstract class BasicConsignmentContract<P extends Product, PR extends Price<U>,U extends Unit,Q extends Quantity> extends BasicContract<P , PR ,U ,Q>  implements ConsignmentContract<P,PR,U,Q> {
    private Calendar expirationDate;

    public void setExpirationDate(Calendar date) {
        this.expirationDate=date;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }
}
