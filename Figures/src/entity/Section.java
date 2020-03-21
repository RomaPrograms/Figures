package entity;

import java.awt.*;

import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Section extends StraightFigures {

    private javafx.scene.shape.Line javaFxLine;
    private double orgSceneX;
    private double orgSceneY;
    private double orgTranslateX;
    private double orgTranslateY;

    public Section() {
    }

    public Section(Point firstPoint, Point secondPoint, Color borderColor) {
        super(firstPoint, secondPoint, borderColor);
    }

    public Line getJavaFxLine() {
        return javaFxLine;
    }

    public void setJavaFxLine(Line javaFxLine) {
        this.javaFxLine = javaFxLine;
    }

    @Override
    public void draw(AnchorPane root) {
        javaFxLine = new javafx.scene.shape.Line();
        javaFxLine.setStartX(getFirstPoint().getX());
        javaFxLine.setStartY(getFirstPoint().getY());
        javaFxLine.setEndX(getSecondPoint().getX());
        javaFxLine.setEndY(getSecondPoint().getY());
        javaFxLine.setStroke(this.borderColor);
        javaFxLine.setStrokeWidth(10);
        root.getChildren().add(javaFxLine);
        move();
    }

    @Override
    public void move() {
        javaFxLine.setOnMousePressed(t -> {
            if(t.getButton().equals(MouseButton.SECONDARY)) {
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((javafx.scene.shape.Line) (t.getSource())).getTranslateX();
                orgTranslateY = ((javafx.scene.shape.Line) (t.getSource())).getTranslateY();
            }
        });

        javaFxLine.setOnMouseDragged(t -> {
            if(t.getButton().equals(MouseButton.SECONDARY)) {
                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                ((javafx.scene.shape.Line) (t.getSource())).setTranslateX(newTranslateX);
                ((javafx.scene.shape.Line) (t.getSource())).setTranslateY(newTranslateY);
            }
        });

        javaFxLine.setOnMouseClicked(t -> {
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
        return getFirstPoint();
    }
}
