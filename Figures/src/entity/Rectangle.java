package entity;

import java.awt.*;
import java.util.List;

public class Rectangle extends Polygon {
    public Rectangle(Color borderColor, Point center,
                     Color innerColor, List<Point> points) {
        super(borderColor, center, innerColor, points);
        if(points.size() != 4) {
            System.out.println("Incorrect number of points!!!!!!!!");
        }
    }
}
