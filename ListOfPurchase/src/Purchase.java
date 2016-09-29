import java.math.BigDecimal;
import java.util.Date;


public class Purchase {

	private String namePurchase;
	private int count;
	private BigDecimal price;
	private BigDecimal purchaseAmount;
	private Date date;
	
	public Purchase(String namePurchase, int count, BigDecimal price, Date date){
		this.namePurchase = namePurchase;
		this.count = count;
		this.price = price;
		this.date = date;
		
		calculationPurchaseAmount();
	}
	
	public String getNamePurchase(){
		return this.namePurchase;
	}
	
	public int getCount(){
		return this.count;
	}
	
	public BigDecimal getPrice(){
		return this.price;
	}
	
	public BigDecimal getPurchaseAmount(){
		return this.purchaseAmount;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	private void calculationPurchaseAmount(){
		this.purchaseAmount = this.price.multiply(new BigDecimal(this.count));
	}
	
}
