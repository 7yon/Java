import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;


public class ListOfPurchase {
	private ArrayList<Purchase> allPurchase = new ArrayList<Purchase>();
	
	public void addPurchaseToList(String namePurchase, int count, BigDecimal price, Date date){
		Purchase purchase = new Purchase(namePurchase, count, price, date);
		
		this.allPurchase.add(purchase);
	}
	
	public void deletePurchaseFromList(int index){
		this.allPurchase.remove(index);
	}	
	
	public ArrayList<Purchase> GetAllPurchase(){
		return allPurchase;
	}
	
	public BigDecimal totalCost(){
		BigDecimal cost = new BigDecimal(0);
		
		for(int i = 0; i < this.allPurchase.size(); i++){
			cost = cost.add(this.allPurchase.get(i).getPurchaseAmount());
		}
		return cost;
	}	
	
	public static void main(String[] args) throws IOException{
		ListOfPurchase list = new ListOfPurchase();	
		Input_OutputData data = new Input_OutputData();
		
		data.ActionSelection(list);
	}
	

}
