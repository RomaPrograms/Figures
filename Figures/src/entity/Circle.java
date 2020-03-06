package entity;

import java.awt.*;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:04 PM
 */
public class Circle extends Ellipse {
    public Circle(Color borderColor, Point center, Color innerColor, Point firstPoint) {
        super(borderColor, center, innerColor, firstPoint, firstPoint);
    }
}