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

            distance += Math.sqrt(Math.pow(points.get(i).getX() - points.get(i + 1).getX(), 2) + Math.pow(points.get(i).getY() - points.get(i + 1).getY(), 2));
        }
        return distance;
    }
    public ArrayList<Point> findTops(float x, float y){
        ArrayList<Point> foundPoints = new ArrayList<Point>();
        Point pointForEquals = new Point(x, y);

        for(int i = 0; i < points.size();  i++){
            if (points.get(i).equals(pointForEquals))
                foundPoints.add(points.get(i));
        }
        return foundPoints;
    }

    @Override
    public String toString() {
        String coordinates = "";

        for(int i = 0; i < points.size();  i++){
            coordinates += '(' + Float.toString(points.get(i).getX()) + ';' + Float.toString(points.get(i).getY()) + ") ";
        }
        return coordinates;
    }
}
