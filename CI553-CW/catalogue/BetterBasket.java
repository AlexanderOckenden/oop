package catalogue;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

import middle.StockException;

/**
 * Write a description of class BetterBasket here.
 * 
 * @author  Your Name 
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable, Comparator<Product>
{
  private static final long serialVersionUID = 1L;
  
  /**
   * Adding a product to the basket
   * @param p1 a product
   * @see #equals(Object)
   * @see #setQuantity(int aQuantity)
   */
  @Override
  public boolean add( Product p1 )
  {   
	  this.totalPrice += p1.getPrice();
	  
	  for(Product p2 : this) {
		  if(p1.equals(p2)) {
			  p2.setQuantity(p2.getQuantity() + p1.getQuantity());
			  return true;
		  }
	  }
	  
    super.add( p1 ); // Call add in ArrayList
    Collections.sort(this, this);
    return true;
  }

  /**
   * Compares its two arguments for order. 
   * Returns a negative integer,zero, or a positive integer as the first argument is less than, equalto, 
   * or greater than the second.
   * @param p1 a product
   * @param p2 a second product
   */
  @Override
  public int compare(Product o1, Product o2) {
	  return o1.getProductNum().compareTo(o2.getProductNum());

  }

  /**
   * Removes an item from the basket if there is 1 quantity only.
   * If the quantity is greater it will remove 1 at a time
   */
  public void removeItem() throws StockException {
	  
	  int index = this.size() -1;
	  Product lastElement = this.get(index);
		  
	  lastElement.setQuantity(lastElement.getQuantity() -1);
	  this.setTotalPrice(this.getTotalPrice() - lastElement.getPrice());
		
	  if(lastElement.getQuantity() == 0){
		  this.remove(lastElement);
	  }
        
	}

}
