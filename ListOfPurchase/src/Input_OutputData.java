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
		System.out.println("�������� ��������:");
		System.out.println("1 - ����������� ������ �������");
		System.out.println("2 - �������� �������");
		System.out.println("3 - ������� �������");
		System.out.println("4 - ����� �� ������ �������");
		
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
				
				System.out.println("�����: " + String.valueOf(i) + " - " + "�������: " + purchase.getNamePurchase() + " - " + String.valueOf(purchase.getCount())+ " ��." + " - " + " ����: " + String.valueOf(purchase.getPrice() + "�."+ 
						" - " + "�����: "+ String.valueOf(purchase.getPurchaseAmount() + "�."+ " - " + "����: "+ String.valueOf(dateFormat.format(purchase.getDate())))));
			}
			System.out.println("�������� ��������� ���� �������: " + String.valueOf(list.totalCost()) + "\n");
			break;
		case 2: 
			System.out.println("��������: ");
			String namePurchase = reader.readLine();
			System.out.println("����������: ");
			int count = Integer.parseInt(reader.readLine()); 
			System.out.println("����: ");
			BigDecimal price = new BigDecimal(reader.readLine().replaceAll(",", "")); 

			Date date = new Date();
			
			list.addPurchaseToList(namePurchase, count, price, date);
			System.out.println("������� ������� ���������!");
			break;
		case 3:
			System.out.println("������� ����� ��������� �������: ");
			int index = Integer.parseInt(reader.readLine());
			list.deletePurchaseFromList(index);
			break;

		}
	}
}
