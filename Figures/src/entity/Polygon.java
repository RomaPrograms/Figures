package entity;

import java.awt.*;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

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

    @Override
    public void draw(Canvas canvas) {
    }

    @Override
    public void move(Point newPoint) {

    }
}