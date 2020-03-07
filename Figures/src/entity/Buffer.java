package entity;

import java.awt.*;
import javafx.scene.paint.Color;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:04 PM
 */
public abstract class Buffer extends Figure1D {
    private Point firstPoint;
    private Point secondPoint;

    public Buffer() {
    }

    public Buffer(Point firstPoint, Point secondPoint, Color borderColor) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.borderColor = borderColor;
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
    public void move(Point newPoint) {
    }

    @Override
    public Point location() {
        return null;
    }
}