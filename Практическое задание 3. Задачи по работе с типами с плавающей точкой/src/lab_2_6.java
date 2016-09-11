import java.math.BigDecimal;

/**
 * Created by Дарья on 09.09.2016.
 */
public class lab_2_6 {
    public static void main(String[] args) {

        float sum = 500; // 500 руб. на счете
        float allP = 0f;
        float percent = 0.00000001f; // 0.000001% ежемесячно

        for (int i = 1; i <= 12; i++) {
            float add;
            add = sum * percent + allP * percent;
            allP += add;
        }
        sum += allP;
        System.out.println("Сумма на счете через год (float): " + sum);

        BigDecimal sumBigDecimal = new BigDecimal(500);
        BigDecimal allPerDecimal = new BigDecimal(0);
        BigDecimal percentDecimal = new BigDecimal(0.00000001); // 0.000001% ежемесячно

        for (int i = 1; i <= 12; i++) {
            BigDecimal addDecimal = new BigDecimal(0);
            addDecimal = addDecimal.add(sumBigDecimal.multiply(percentDecimal));
            addDecimal = addDecimal.add(allPerDecimal.multiply(percentDecimal));
            allPerDecimal = allPerDecimal.add(addDecimal);
        }
        sumBigDecimal = sumBigDecimal.add(allPerDecimal);
        System.out.println("Сумма на счете через год (BigDecimal): " + sumBigDecimal);
    }
}
