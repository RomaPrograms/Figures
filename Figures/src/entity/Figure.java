package entity;

import java.awt.*;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:04 PM
 */
public abstract class Figure {

    protected Color borderColor;

    public Figure() {
    }

    public Figure(Color borderColor) {
        this.borderColor = borderColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public abstract void draw();

    public abstract Point location();

    public abstract void move(Point newPoint);

}