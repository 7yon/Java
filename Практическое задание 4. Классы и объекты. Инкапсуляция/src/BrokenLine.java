import java.util.*;

/**
 * Created by Дарья on 20.09.2016.
 */
public class BrokenLine {

    private ArrayList<Point> points = new ArrayList<Point>();

    public ArrayList<Point> getPoints() {
        return points;
    }
    public void addPoint(Point point){
        points.add(point);
    }
    public Point getPoint(int index){
        return points.get(index);
    }
    public double calculateLength(){
        double distance = 0;

        for (int i = 0; i < points.size() - 1; i++){

            distance += Math.sqrt(Math.pow(points.get(i).get_x() - points.get(i + 1).get_x(), 2) + Math.pow(points.get(i).get_y() - points.get(i + 1).get_y(), 2));
        }
        return distance;
    }
    public ArrayList<Point> findTops(float _x, float _y){
        ArrayList<Point> foundPoints = new ArrayList<Point>();

        for(int i = 0; i < points.size();  i++){
            if (points.get(i).comparison(_x, _y))
                foundPoints.add(points.get(i));
        }
        return foundPoints;
    }
    public String getCoordinates(){
        String coordinates = "";

        for(int i = 0; i < points.size();  i++){
            coordinates += '(' + Float.toString(points.get(i).get_x()) + ';' + Float.toString(points.get(i).get_y()) + ") ";
        }
        return coordinates;
    }
}
