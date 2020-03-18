package entity;

import java.awt.*;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Ray extends Section {

    public Ray() {
    }

    public Ray(Point firstPoint, Point secondPoint, Color borderColor) {
        super(firstPoint, secondPoint, borderColor);
    }


    @Override
    public void draw(AnchorPane root) {
        double k = (getSecondPoint().getX() - getFirstPoint().getX()) / (getFirstPoint().getY() - getSecondPoint().getY());
        double x;
        if (getSecondPoint().getX() - getFirstPoint().getX() >= 0) {
            x = root.getWidth() * 5;
        } else {
            x = -1 * root.getWidth() * 5;
        }
        double height = (x - getFirstPoint().getX()) / k;
        double y = -height + getFirstPoint().getY();
        Point oldPoint = new Point(getSecondPoint());
        setSecondPoint(new Point((int) x, (int) y));
        super.draw(root);
        setSecondPoint(oldPoint);
    }
}