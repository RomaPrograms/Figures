package entity;

import java.awt.*;
import java.util.List;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:04 PM
 */
public class Polygon extends Figure2D {

    private List<Point> points;

    public Polygon() {
    }

    public Polygon(Color borderColor, Point center,
                   Color innerColor, List<Point> points) {
        super(borderColor, center, innerColor);
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void draw() {
    }

    public void move(Point newPoint) {

    }
}