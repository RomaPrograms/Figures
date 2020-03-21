package entity;

import java.awt.*;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import static java.lang.Math.cos;
import static java.lang.StrictMath.sin;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:05 PM
 */
public class SymmetricFigure extends Polygon {

    private int numberSides;
    private double distance;

    public SymmetricFigure(Color borderColor, Point center, Color innerColor, int numberSides) {
        super(borderColor, center, innerColor);
        this.numberSides = numberSides;
    }

    public int getNumberSides() {
        return numberSides;
    }

    public void setNumberSides(int numberSides) {
        this.numberSides = numberSides;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public void draw(AnchorPane root) {
        double angle;
        for (int i = 1; i <= numberSides; i++) {
            angle = 2 * Math.PI * i / numberSides;
            getPoints().add(distance * cos(angle) + getCenter().getX());
            getPoints().add(distance * sin(angle) + getCenter().getY());
        }

        super.draw(root);
    }
}