package entity;

import java.awt.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
    public void draw(Canvas canvas) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setLineWidth(4);
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.strokeLine(getFirstPoint().getX(), getFirstPoint().getY(), getSecondPoint().getX(), getSecondPoint().getY());
    }
}