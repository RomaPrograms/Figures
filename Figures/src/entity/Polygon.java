package entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:04 PM
 */
public class Polygon extends Figure2D {

    private double orgSceneX;
    private double orgSceneY;
    private double orgTranslateX;
    private double orgTranslateY;
    private javafx.scene.shape.Polygon javafxPolygon;
    private List<Double> points;

    public Polygon() {
        points = new ArrayList<>();
    }

    public Polygon(Color borderColor, Point center,
                   Color innerColor) {
        super(borderColor, center, innerColor);
        points = new ArrayList<>();
    }

    public Polygon(Color borderColor, List<Double> points,
                   Color innerColor) {
        setBorderColor(borderColor);
        setInnerColor(innerColor);
        this.points = points;
    }

    public List<Double> getPoints() {
        return points;
    }

    public void setPoints(List<Double> points) {
        this.points = points;
    }

    public javafx.scene.shape.Polygon getJavafxPolygon() {
        return javafxPolygon;
    }

    public void setJavafxPolygon(javafx.scene.shape.Polygon javafxPolygon) {
        this.javafxPolygon = javafxPolygon;
    }

    @Override
    public void draw(AnchorPane root) {
        double[] pointsArray = new double[points.size()];
        for(int i = 0; i < points.size(); i++) {
            pointsArray[i] = points.get(i);
        }
        javafxPolygon = new javafx.scene.shape.Polygon(pointsArray);
        javafxPolygon.setStroke(this.borderColor);
        javafxPolygon.setFill(this.getInnerColor());
        javafxPolygon.setStrokeWidth(6);
        root.getChildren().add(javafxPolygon);
        move();
    }

    @Override
    public void move() {
        javafxPolygon.setOnMousePressed(t -> {
            if(t.getButton().equals(MouseButton.SECONDARY)) {
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((javafx.scene.shape.Polygon) (t.getSource())).getTranslateX();
                orgTranslateY = ((javafx.scene.shape.Polygon) (t.getSource())).getTranslateY();
            }
        });

        javafxPolygon.setOnMouseDragged(t -> {
            if(t.getButton().equals(MouseButton.SECONDARY)) {
                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                ((javafx.scene.shape.Polygon) (t.getSource())).setTranslateX(newTranslateX);
                ((javafx.scene.shape.Polygon) (t.getSource())).setTranslateY(newTranslateY);
            }
        });
    }
}