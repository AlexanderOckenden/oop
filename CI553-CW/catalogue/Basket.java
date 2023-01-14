package catalogue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Formatter;
import java.util.Locale;

import middle.StockException;
import middle.StockReadWriter;

/**
 * A collection of products from the CatShop.
 *  used to record the products that are to be/
 *   wished to be purchased.
 * @author  Mike Smith University of Brighton
 * @version 2.2
 *
 */
public class Basket extends ArrayList<Product> implements Serializable
{
  private static final long serialVersionUID = 1;
  private int    theOrderNum; // Order number
  protected double totalPrice; // Total Basket price
  protected final double DISCOUNT = 10.00; // Total discount amount
  protected double savings; // Total amount saved
  
  
  /**
   * Constructor for a basket which is
   *  used to represent a customer order/ wish list
   */
  public Basket()
  {
	savings = 0;
	totalPrice = 0;
    theOrderNum  = 0;
  }
  
  /**
   * Set the customers unique order number
   * Valid order Numbers 1 .. N
   * @param anOrderNum A unique order number
   */
  public void setOrderNum( int anOrderNum )
  {
    theOrderNum = anOrderNum;
  }

  /**
   * Returns the customers unique order number
   * @return the customers order number
   */
  public int getOrderNum()
  {
    return theOrderNum;
  }
  
  /**
   * Returns the customers total savings
   * @return the customers savings
   */
  public double getSavings() {
	  return this.savings;
  }
  
  /**
   * Returns the customers total basket price
   * @return the total basket price
   */
  public double getTotalPrice() {
	  return this.totalPrice;
  }
  
  /**
   * Sets the total price of the basket
   * @param newPrice used when removing items from the basket to calculate new total
   * 
   * 
   */
  public void setTotalPrice(double newPrice) {
	  this.totalPrice = newPrice;
  }
  
  
  /**
   * Add a product to the Basket.
   * Product is appended to the end of the existing products
   * in the basket.
   * @param p1 A product to be added to the basket
   * @return true if successfully adds the product
   */
  public boolean add( Product p1 ){ 
    return super.add( p1 );     // Call add in ArrayList
    
  }
  
  /**
   * Calculates the customers discount
   * 
   */
  public void calculateDiscount() {
	  this.savings = this.totalPrice * DISCOUNT / 100;
	  this.totalPrice =  this.totalPrice - this.savings;
  }

  /**
   * Returns a description of the products in the basket suitable for printing.
   * @return a string description of the basket products
   */
  public String getDetails()
  {
    Locale uk = Locale.UK;
    StringBuilder sb = new StringBuilder(256);
    Formatter     fr = new Formatter(sb, uk);
    String csign = (Currency.getInstance( uk )).getSymbol();
    if ( theOrderNum != 0 )
      fr.format( "Order number: %03d\n", theOrderNum );
      
    if ( this.size() > 0 )
    {
      for ( Product pr: this )
      {
        int number = pr.getQuantity();
        fr.format("%-7s",       pr.getProductNum() );
        fr.format("%-14.14s ",  pr.getDescription() );
        fr.format("(%3d) ",     number );
        fr.format("%s%7.2f",    csign, pr.getPrice() * number );
        fr.format("\n");
      }
      fr.format("----------------------------\n");
      fr.format("Total                       ");
      fr.format("%s%7.2f\n",    csign, this.totalPrice );
      fr.format("Discount savings            ");
      fr.format("%s%7.2f\n",    csign, savings );
      fr.close();
    }
    return sb.toString();
  }
  
  /**
   * Removes an item from the list in this "simple" Basket
   * @return the customers order number
   * @see #setTotalPrice(double newprice)
   * @see #getTotalPrice()
   * @see #getPrice()
   */
  public void removeItem() throws StockException {
	  int index = this.size() -1;
	  Product lastElement = this.get(index);
	  
	  this.setTotalPrice(this.getTotalPrice() - lastElement.getPrice());
		  
	  this.remove(lastElement);
        
	}

}
