package entity;


import java.awt.*;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:04 PM
 */
public abstract class Figure2D extends Figure {

    private Color innerColor;
    private Point center;

    public Figure2D() {
    }

    public Figure2D(Color borderColor, Point center, Color innerColor) {
        super(borderColor);
        this.innerColor = innerColor;
        this.center = center;
    }

    public Color getInnerColor() {
        return innerColor;
    }

    public void setInnerColor(Color innerColor) {
        this.innerColor = innerColor;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }
}