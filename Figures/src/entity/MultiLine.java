package entity;

import java.awt.*;

import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class MultiLine extends Figure1D {
    private Point[] points;
    private javafx.scene.shape.Polyline javaFxPolyLine;
    private double orgSceneX;
    private double orgSceneY;
    private double orgTranslateX;
    private double orgTranslateY;

    public MultiLine() {
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public MultiLine(Point[] points, Color borderColor) {
        this.points = points;
        this.borderColor = borderColor;
    }

    @Override
    public void draw(AnchorPane root) {
        double[] arrDoubles = new double[points.length * 2];
        for (int i = 0; i < points.length; ++i) {
            arrDoubles[2 * i] = points[i].getX();
            arrDoubles[2 * i + 1] = points[i].getY();
        }
        javaFxPolyLine = new javafx.scene.shape.Polyline(arrDoubles);
        javaFxPolyLine.setStroke(this.borderColor);
        javaFxPolyLine.setStrokeWidth(10);
        root.getChildren().add(javaFxPolyLine);
        move();
    }

    @Override
    public Point location() {
        return points[0];
    }

    @Override
    public void move() {
        javaFxPolyLine.setOnMousePressed(t -> {
            if (t.getButton().equals(MouseButton.SECONDARY)) {
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((javafx.scene.shape.Polyline) (t.getSource())).getTranslateX();
                orgTranslateY = ((javafx.scene.shape.Polyline) (t.getSource())).getTranslateY();
            }
        });

        javaFxPolyLine.setOnMouseDragged(t -> {
            if (t.getButton().equals(MouseButton.SECONDARY)) {
                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                ((javafx.scene.shape.Polyline) (t.getSource())).setTranslateX(newTranslateX);
                ((javafx.scene.shape.Polyline) (t.getSource())).setTranslateY(newTranslateY);
            }
        });
    }
}