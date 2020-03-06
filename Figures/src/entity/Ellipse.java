package entity;

import java.awt.*;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:04 PM
 */
public class Ellipse extends Figure2D {

    private Point firstPoint;
    private Point secondPoint;

    public Ellipse() {
    }

    public Ellipse(Color borderColor, Point center, Color innerColor,
                   Point firstPoint, Point secondPoint) {
        super(borderColor, center, innerColor);
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
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
    public void move(Point newPoint) {

    }
}