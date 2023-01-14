package catalogue;

import static org.junit.Assert.*;

import org.junit.Test;

import middle.StockException;

public class BasketTest {
	
	Basket basket = new Basket();
	Product p1 = new Product("0001", "40 inch tv", 200.00, 1 );
	
	// Testing that the basket has been created, if so it will be not null.
	@Test 
	public void testBasket() {
		assertNotNull(basket);
	}
	
	// Checking that the setorderNumber() method works as expected.
	@Test
	public void testSetOrderNum() {
		basket.setOrderNum(4);
		assertEquals(4, basket.getOrderNum());
	}
	
	// Checking that GetOrderNum() method works as expected.
	@Test
	public void testGetOrderNum() {
		basket.setOrderNum(4);
		assertEquals(4, basket.getOrderNum());
	}

	// Checking that GetSavings() method works as expected.
	@Test
	public void testGetSavings() {
		basket.setTotalPrice(10.0);
		//System.out.println(basket.getTotalPrice());
		
		basket.calculateDiscount();
		//System.out.println(basket.getSavings());
		
		assertEquals(1.0, basket.getSavings(), 1);
	}
	
	// Checking that GetTotalPrice() method works as expected.
	@Test
	public void testGetTotalPrice() {
		basket.setTotalPrice(10.0);
		assertEquals(10, basket.getTotalPrice(), 1);
	}
	
	// Checking that setTotalPrice() method works as expected.
	@Test
	public void testSetTotalPrice() {
		basket.setTotalPrice(50.0);
		assertEquals(50.0, basket.getTotalPrice(), 1);
		
	}
	
	// Checking that adding items to the basket works as expected.
	@Test
	public void testAddProduct() {
		basket.add(p1);
		if(basket.contains(p1)) {
			assert(true);
		}else {
			assert(false);
		}
	}

	// Checking that the discount button applies a discount.
	@Test
	public void testCalculateDiscount() {
		basket.setTotalPrice(10.0);
		//System.out.println(basket.getTotalPrice());
		
		basket.calculateDiscount();
		//System.out.println(basket.getSavings());
		
		assertEquals(1.0, basket.getSavings(), 1);
	}

	// Checking that getDetails() Method works as expected.
	@Test
	public void testGetDetails() {
		basket.getDetails();
	}

	// Checking that the removeItem() method works as expected.
	@Test
	public void testRemoveItem() throws StockException {
		basket.add(p1);
		basket.removeItem();
		assertEquals(0, basket.size());
	}

}
