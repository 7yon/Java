import java.util.Scanner;

/**
 * Created by Дарья on 09.09.2016.
 */
public class lab_2_5 {

    public static void Comparator(float f1, float f2){
        int i1 = Float.floatToIntBits(f1);
        int i2 = Float.floatToIntBits(f2);

        System.out.println("true - равны\nfalse - не равны\n"+(i1 == i2));
    }
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        float f1 = in.nextFloat();
        float f2 = in.nextFloat();

        Comparator(f1, f2);
    }
}
