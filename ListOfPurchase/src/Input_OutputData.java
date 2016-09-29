import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Input_OutputData {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public void ActionSelection(ListOfPurchase list)throws IOException {
		while (true){
		System.out.println("Выберите действие:");
		System.out.println("1 - Просмотреть список покупок");
		System.out.println("2 - Добавить покупку");
		System.out.println("3 - Удалить покупку");
		System.out.println("4 - Выйти из списка покупок");
		
		int choiceAction = Integer.parseInt(reader.readLine());
		if (choiceAction == 4) break;
		inputOutput(choiceAction, list);
		}
	}
	private void inputOutput(int choiceAction, ListOfPurchase list)throws IOException {
		switch(choiceAction){
		case 1:
			for (int i=0; i < list.GetAllPurchase().size(); i++){
				Purchase purchase = list.GetAllPurchase().get(i);
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				
				System.out.println("Номер: " + String.valueOf(i) + " - " + "Покупка: " + purchase.getNamePurchase() + " - " + String.valueOf(purchase.getCount())+ " шт." + " - " + " Цена: " + String.valueOf(purchase.getPrice() + "р."+ 
						" - " + "Итого: "+ String.valueOf(purchase.getPurchaseAmount() + "р."+ " - " + "Дата: "+ String.valueOf(dateFormat.format(purchase.getDate())))));
			}
			System.out.println("Итоговая стоимость всех покупок: " + String.valueOf(list.totalCost()) + "\n");
			break;
		case 2: 
			System.out.println("Название: ");
			String namePurchase = reader.readLine();
			System.out.println("Количество: ");
			int count = Integer.parseInt(reader.readLine()); 
			System.out.println("Цена: ");
			BigDecimal price = new BigDecimal(reader.readLine().replaceAll(",", "")); 

			Date date = new Date();
			
			list.addPurchaseToList(namePurchase, count, price, date);
			System.out.println("Покупка успешно добавлена!");
			break;
		case 3:
			System.out.println("Введите номер удаляемой покупки: ");
			int index = Integer.parseInt(reader.readLine());
			list.deletePurchaseFromList(index);
			break;

		}
	}
}
