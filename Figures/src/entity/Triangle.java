package entity;

import java.awt.*;
import java.util.List;
import javafx.scene.paint.Color;

public class Triangle extends Polygon {
    public Triangle(Color borderColor, Point center,
                    Color innerColor) {
        super(borderColor, center, innerColor);
    }
}
