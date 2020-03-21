package entity;

import java.awt.*;

import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:04 PM
 */
public class Ellipse extends Figure2D {

    private double widthX;
    private double widthY;
    private double orgSceneX;
    private double orgSceneY;
    private double orgTranslateX;
    private double orgTranslateY;
    private javafx.scene.shape.Ellipse javaFxEllipse;

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

    public javafx.scene.shape.Ellipse getJavaFxEllipse() {
        return javaFxEllipse;
    }

    public void setJavaFxEllipse(javafx.scene.shape.Ellipse javaFxEllipse) {
        this.javaFxEllipse = javaFxEllipse;
    }

    @Override
    public void draw(AnchorPane root) {
        javaFxEllipse = new javafx.scene.shape.Ellipse();
        javaFxEllipse.setCenterX(getCenter().getX());
        javaFxEllipse.setCenterY(getCenter().getY());
        javaFxEllipse.setRadiusX(widthX);
        javaFxEllipse.setRadiusY(widthY);
        javaFxEllipse.setStroke(this.borderColor);
        javaFxEllipse.setFill(this.getInnerColor());
        javaFxEllipse.setStrokeWidth(6);
        root.getChildren().add(javaFxEllipse);
        move();
    }

    @Override
    public void move() {
        javaFxEllipse.setOnMousePressed(t -> {
            if(t.getButton().equals(MouseButton.SECONDARY)) {
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((javafx.scene.shape.Ellipse) (t.getSource())).getTranslateX();
                orgTranslateY = ((javafx.scene.shape.Ellipse) (t.getSource())).getTranslateY();
            }
        });

        javaFxEllipse.setOnMouseDragged(t -> {
            if(t.getButton().equals(MouseButton.SECONDARY)) {
                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                ((javafx.scene.shape.Ellipse) (t.getSource())).setTranslateX(newTranslateX);
                ((javafx.scene.shape.Ellipse) (t.getSource())).setTranslateY(newTranslateY);
            }
        });

        javaFxEllipse.setOnMouseClicked(t -> {
            if(t.getButton().equals(MouseButton.SECONDARY)) {
                if(t.getClickCount() == 2) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Location");
                    alert.setHeaderText("Results:");
                    alert.setContentText("X: " + location().getX()
                            + "      Y: " + location().getY());
                    alert.showAndWait();
                }
            }
        });

    }

    @Override
    public Point location() {
        return getCenter();
    }
}