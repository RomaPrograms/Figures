package entity;

import java.awt.*;
import java.util.List;
import javafx.scene.paint.Color;

public class Rectangle extends Polygon {
    public Rectangle(Color borderColor, Point center,
                     Color innerColor) {
        super(borderColor, center, innerColor);
    }
}
