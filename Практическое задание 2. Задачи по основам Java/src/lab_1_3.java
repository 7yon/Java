/**
 * Created by Дарья on 09.09.2016.
 */
public class lab_1_3 {
    public static void main(String[] args) {
        String initialValue;
        int endingCc, initialCc;

        initialValue = args[0];
        initialCc = Integer.parseInt(args[1]);
        endingCc = Integer.parseInt(args[2]);

        System.out.println(initialValue + '(' + initialCc + ')');
        System.out.println(Integer.valueOf("-FE", initialCc) + "(10)");
        System.out.println(Integer.toString(Integer.parseInt(initialValue, initialCc), endingCc) + '(' + endingCc + ')');


    }
}
