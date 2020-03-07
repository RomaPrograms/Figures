package entity;

import java.awt.*;
import java.util.List;
import javafx.scene.paint.Color;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:05 PM
 */
public class SymmetricFigure extends Polygon {

	private int numberSides;

	public SymmetricFigure(Color borderColor, Point center, Color innerColor,
						   List<Point> points, int numberSides) {
		super(borderColor, center, innerColor, points);
		this.numberSides = numberSides;
	}

	public int getNumberSides() {
		return numberSides;
	}

	public void setNumberSides(int numberSides) {
		this.numberSides = numberSides;
	}
}