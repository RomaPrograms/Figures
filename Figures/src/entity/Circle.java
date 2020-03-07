package entity;

import java.awt.*;
import javafx.scene.paint.Color;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:04 PM
 */
public class Circle extends Ellipse {
    public Circle(Color borderColor, Point center, Color innerColor, double widthX) {
        super(borderColor, center, innerColor, widthX, widthX);
    }
}