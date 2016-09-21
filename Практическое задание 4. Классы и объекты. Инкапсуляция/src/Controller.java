/**
 * Created by Дарья on 20.09.2016.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private int pointsCount;
    private BrokenLine brokenLine = new BrokenLine();

    Scanner in = new Scanner(System.in);

    public void setPointsCount() {
        this.pointsCount = in.nextInt();
    }
    public void addCoordinatePoints(){
        brokenLine.getPoints().clear();

        System.out.printf("\nВведите количество координат ломаной: ");
        this.pointsCount = in.nextInt();

        for (int i = 0; i < pointsCount; i++){
            Point point = new Point();

            System.out.printf("\nВведите через пробел координату X и координату Y: ");
            point.set_x(in.nextFloat());
            point.set_y(in.nextFloat());

            brokenLine.addPoint(point);
        }
    }
    public void outInformationAboutString(){
        String information = "";

        information = brokenLine.getCoordinates();
        System.out.printf(information);
    }
    public void outLineLength(){
        String length = "";

        length = Double.toString(brokenLine.calculateLength());
        System.out.printf(length);
    }
    public void outMatchingTops(){
        System.out.printf("Введите координату X и координату Y для поиска вершин: ");
        float _x = in.nextFloat();
        float _y = in.nextFloat();

        ArrayList<Point> matchingTops = brokenLine.findTops(_x, _y);
        String coordinates, tops = "";

        for (int i = 0; i < matchingTops.size(); i++) {
            coordinates = '(' + Float.toString(matchingTops.get(i).get_x()) + ';' + Float.toString(matchingTops.get(i).get_y()) + ") ";
            tops += coordinates;
        }
        System.out.printf(tops);
    }
    public void interfaceStep1(){
        System.out.printf("1 - Ввести количество точек ломаной линии\n2 - Выход из программы\n");

        int i = in.nextInt();

        if (i == 1) {
            interfaceStep2();
        }
        if(i == 2)
            return;
    }
    public void interfaceStep2(){

        while(true) {
            System.out.printf("\n1 - Ввод координат ломаной\n2 - Вывод информации о линии\n3 - Вывод суммарной длины всех звеньев\n4 - Вывод вершин ломаной, координаты которых совпадают с координатами заданной " +
                    "точки\n5 - Выход из программы\n");

            int i = in.nextInt();

            if (i == 1)
                addCoordinatePoints();
            if (i == 2)
                outInformationAboutString();
            if (i == 3)
                outLineLength();
            if (i == 4)
                outMatchingTops();
            if (i == 5){
                break;
            }
        }
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.interfaceStep1();
    }
}