/**
 * Created by Дарья on 20.09.2016.
 */
public class Point {
    private float _x;
    private float _y;

    public Point(){
        this._x = 0;
        this._y = 0;
    }
    public  Point(float _x, float _y){
        this._x = _x;
        this._y = _y;
    }

    public float get_x() {
        return _x;
    }
    public void set_x(float _x) {
        this._x = _x;
    }
    public float get_y() {
        return _y;
    }
    public void set_y(float _y) {
        this._y = _y;
    }

    public double distanceCalculation(){
        double distance = Math.sqrt(Math.pow(0 - this._x, 2) + Math.pow(0 - this._y, 2));
        return  distance;
    }
    public double distanceCalculation(float _x, float _y){
        double distance;

        distance = Math.sqrt(Math.pow(_y - this._x, 2) + Math.pow(_x - this._x, 2));
        return  distance;
    }
    public void displacementPoint(float _x, float _y){
        this._x = _x;
        this._y = _y;
    }
    public String outCoordinates(){
        String coordinates;

        coordinates = '(' + Float.toString(this._x) + ';' + Float.toString(this._y) + ')';
        return coordinates;
    }
    public boolean comparison(float _x, float _y){
        if ((this._x == _x)&&(this._y == _y))
            return true;
        else return false;
    }
}