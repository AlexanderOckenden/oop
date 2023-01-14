package clients.cashier;

import catalogue.Basket;
import catalogue.BetterBasket;
import middle.MiddleFactory;

public class BetterCashierModel extends CashierModel {
	
	  public BetterCashierModel(MiddleFactory mf) {
		super(mf);
		
	}

	/**
	   * return an instance of a new Basket
	   * @return an instance of a new Basket
	   */
	  protected Basket makeBasket()
	  {
	    return new BetterBasket();
	  }
}
