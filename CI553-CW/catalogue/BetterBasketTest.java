package catalogue;

import static org.junit.Assert.*;

import org.junit.Test;

import middle.StockException;

public class BetterBasketTest {
	
	BetterBasket Betterbasket = new BetterBasket();
	Product p1 = new Product("0004", "40 inch tv", 200.0, 1 );
	Product p2 = new Product("0001", "Toaster", 36.0, 1 );

	// Checking that the betterBasket has been created.
	@Test
	public void testAddProduct() {
		Betterbasket.add(p1);
		if(Betterbasket.contains(p1)) {
			assert(true);
		}else {
			assert(false);
		}
	}

	// Testing the BetterBasket removeItem() method. Items quantity should be decreased
	// by 1, when the item quantity reaches 0 it should be removed from the basket.
	@Test
	public void testRemoveItem() throws StockException {
		Betterbasket.add(p1);
		Betterbasket.add(p2);
		Betterbasket.add(p1);
		assertEquals(2, Betterbasket.size());
		Betterbasket.removeItem();
		assertEquals(2, Betterbasket.size());
		
	}


}
