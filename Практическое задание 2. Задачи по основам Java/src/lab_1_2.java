/**
 * Created by Дарья on 09.09.2016.
 */
public class lab_1_2 {

    public static void main(String[] args) {

        int a, b, calc = 0;
        String str;

        a = Integer.parseInt(args[0]);
        b = Integer.parseInt(args[2]);

        char sign = args[1].charAt(0);

        if (sign == '*')
            calc = a*b;
        if (sign == '/')
            calc = a/b;
        if (sign == '-')
            calc = a-b;
        if (sign == '+')
            calc = a+b;
        System.out.printf("%d", calc);
    }
}
