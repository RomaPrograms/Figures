package entity;

import javafx.scene.paint.Color;
import java.util.List;

public class Triangle extends Polygon {
    public Triangle(Color borderColor, List<Double> points,
                    Color innerColor) {
        super(borderColor, points, innerColor);
    }
}
