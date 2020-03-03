package entity;

import java.awt.*;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:04 PM
 */
public class Section extends Buffer {
    public Section() {
    }

    public Section(Point firstPoint, Point secondPoint, Color borderColor) {
        super(firstPoint, secondPoint, borderColor);
    }

    @Override
    public void draw() {
    }

    @Override
    public Point[] location() {
        return new Point[0];
    }
}