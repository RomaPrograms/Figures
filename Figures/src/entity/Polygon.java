package entity;

import java.awt.*;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:04 PM
 */
public class Polygon extends Figure2D {

    private Point[] points;

    public Polygon() {
    }

    public Polygon(Color borderColor, Point center,
                   Color innerColor, Point[] points) {
        super(borderColor, center, innerColor);
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public void draw() {
    }

    @Override
    public Point[] location() {
        return new Point[0];
    }

    public int getPointAmount() {
        return points.length;
    }

    public void move(Point newPoint) {

    }

}