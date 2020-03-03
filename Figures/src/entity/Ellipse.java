package entity;

import java.awt.*;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:04 PM
 */
public class Ellipse extends Circle {

    private Point secondPoint;

    public Ellipse() {
    }

    public Ellipse(Color borderColor, Point center,
                   Color innerColor, Point secondPoint) {
        super(borderColor, center, innerColor);
        this.secondPoint = secondPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    @Override
    public void draw() {

    }

    @Override
    public Point[] location() {
        return new Point[1];
    }

    @Override
    public void move(Point newPoint) {

    }
}