package entity;

import java.awt.*;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:04 PM
 */
public class Circle extends Figure2D {

    private Point firstPoint;

    public Circle() {
    }

    public Circle(Color borderColor, Point center, Color innerColor) {
        super(borderColor, center, innerColor);
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    @Override
    public void draw() {

    }

    @Override
    public Point[] location() {
        return new Point[0];
    }

    @Override
    public void move(Point newPoint) {

    }
}