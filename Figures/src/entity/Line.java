package entity;

import java.awt.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Line extends Ray {

    public Line(){
    }

    public Line(Point firstPoint, Point secondPoint, Color borderColor) {
        super(firstPoint, secondPoint, borderColor);
    }

    @Override
    public void draw(AnchorPane root) {
        double k = (getSecondPoint().getX() - getFirstPoint().getX()) / (getFirstPoint().getY() - getSecondPoint().getY());
//let's find end of ray
        double x;
        if (getSecondPoint().getX() - getFirstPoint().getX() >= 0) {
            x = root.getWidth() * 5;
        } else {
            x = -1 * root.getWidth() * 5;
        }
//finding H
        double height = (x - getFirstPoint().getX()) / k;
        double y = -height + getFirstPoint().getY();
        Point oldPoint = new Point(getFirstPoint());
        setFirstPoint(new Point((int) x, (int) y));
        super.draw(root);
        setFirstPoint(oldPoint);

//        super.draw(root);
//        Point saveFirstPoint = getFirstPoint();
//        Point saveSecondPoint = getSecondPoint();
//        setFirstPoint(saveSecondPoint);
//        setSecondPoint(saveFirstPoint);
//        super.draw(root);
    }
}