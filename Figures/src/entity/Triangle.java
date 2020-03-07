package entity;

import java.awt.*;
import java.util.List;
import javafx.scene.paint.Color;

public class Triangle extends Polygon {
    public Triangle(Color borderColor, Point center,
                    Color innerColor, List<Point> points) {
        super(borderColor, center, innerColor, points);
        if(points.size() != 3) {
            System.out.println("Incorrect number of points!!!!!!!!");
        }
    }
}
