package entity;

import java.awt.*;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:05 PM
 */
public class SymmetricFigure extends Figure2D {

	private int numberSides;

	public SymmetricFigure(){
	}

	public SymmetricFigure(Color borderColor, Point center,
						   Color innerColor, int numberSides) {
		super(borderColor, center, innerColor);
		this.numberSides = numberSides;
	}

	public int getNumberSides() {
		return numberSides;
	}

	public void setNumberSides(int numberSides) {
		this.numberSides = numberSides;
	}

	@Override
	public void draw() {

	}

	@Override
	public Point[] location() {
		return new Point[0];
	}

	@Override
	public void move(Point newPoint) {

	}
}