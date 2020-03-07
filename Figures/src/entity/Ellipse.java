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
public class Ellipse extends Figure2D {

    private double widthX;
    private double widthY;

    public Ellipse() {
    }

    public Ellipse(Color borderColor, Point center, Color innerColor,
                   double widthX, double widthY) {
        super(borderColor, center, innerColor);
        this.widthX = widthX;
        this.widthY = widthY;
    }

    public double getWidthX() {
        return widthX;
    }

    public void setWidthX(double widthX) {
        this.widthX = widthX;
    }

    public double getWidthY() {
        return widthY;
    }

    public void setWidthY(double widthY) {
        this.widthY = widthY;
    }

    @Override
    public void draw(Canvas canvas) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setLineWidth(6);
        graphicsContext.setStroke(this.getBorderColor());
        graphicsContext.setFill(this.getInnerColor());
        graphicsContext.fillOval(getCenter().getX(), getCenter().getY(), widthX*2, widthY*2);
    }

    @Override
    public void move(Point newPoint) {

    }
}