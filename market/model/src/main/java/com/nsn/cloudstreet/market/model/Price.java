package com.nsn.cloudstreet.market.model;

import javax.persistence.Entity;
import java.util.Currency;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 4/17/12
 * Time: 9:46 AM
 */
@Entity
public class Price<U extends Unit> {
   private double val;
   private Currency  currency;
   private U  unit;

   
   public Price() {
      
   }
    public Price(double value, Currency currency, U unit) {
        this.val = value;
        this.currency = currency;
        this.unit = unit;
    }

    public double getVal() {
        return val;
    }

    public Currency getCurrency() {
        return currency;
    }
    
    public U getUnit() {
        return unit;
    }
    
    public void setUnit(U unit) {
    	this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price<U> price = (Price<U>) o;

        if (Double.compare(price.val, val) != 0) return false;
        if (currency != null ? !currency.equals(price.currency) : price.currency != null) return false;
        if (unit != null ? !unit.equals(price.unit) : price.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = val != +0.0d ? Double.doubleToLongBits(val) : 0L;
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
	@Override
	public String toString() {
		return "Price [val=" + val + ", currency=" + currency + ", unit="
				+ unit + "]";
	}
    
    

}
