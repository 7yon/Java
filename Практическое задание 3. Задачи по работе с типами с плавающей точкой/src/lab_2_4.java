/**
 * Created by Дарья on 09.09.2016.
 * ДОДЕЛАТЬ!!!!!
 */

import java.util.Scanner;

public class lab_2_4 {

    public static void check(float a, float b, float accuracy){

        if (Float.isNaN(a) && Float.isNaN((b))){
            System.out.println("true");
        }
        else System.out.println(Math.abs(a - b) < 1e-6);

    }
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        float a = 2f/0.0f;
        float b = 0.0f/0.0f;
        int accuracy = in.nextInt();

        check(a, b, accuracy);
    }
}
