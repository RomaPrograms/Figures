package entity;

import java.awt.*;
import javafx.scene.paint.Color;

public abstract class StraightFigures extends Figure1D {
    private Point firstPoint;
    private Point secondPoint;

    public StraightFigures() {
    }

    public StraightFigures(Point firstPoint, Point secondPoint, Color borderColor) {
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
    public void move() {
    }

    @Override
    public Point location() {
        return null;
    }
}