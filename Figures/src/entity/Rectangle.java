package entity;

import java.util.List;
import javafx.scene.paint.Color;

public class Rectangle extends Polygon {
    public Rectangle(Color borderColor, List<Double> points,
                     Color innerColor) {
        super(borderColor, points, innerColor);
    }
}
