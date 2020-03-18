package entity;

import java.awt.*;
import java.util.List;
import javafx.scene.paint.Color;

public class Rectangle extends Polygon {
    public Rectangle(Color borderColor, Point center,
                     Color innerColor, List<Double> points) {
        super(borderColor, center, innerColor, points);
        if(points.size() != 4) {
            System.out.println("Incorrect number of points!!!!!!!!");
        }
    }
}
