/**
 * Created by Дарья on 20.09.2016.
 */
public class Point {
    private float x;
    private float y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }
    public  Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }

    public double distanceCalculation(){
        double distance = Math.sqrt(Math.pow(0 - this.x, 2) + Math.pow(0 - this.y, 2));
        return  distance;
    }
    public double distanceCalculation(float x, float y){
        double distance;

        distance = Math.sqrt(Math.pow(y - this.x, 2) + Math.pow(x - this.x, 2));
        return  distance;
    }
    public void displacementPoint(float x, float y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return '(' + Float.toString(this.x) + ';' + Float.toString(this.y) + ')';
    }

    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }
}