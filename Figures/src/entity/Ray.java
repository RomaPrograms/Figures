package entity;

import java.awt.*;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:04 PM
 */
public class Ray extends Buffer {

	public Ray(){
	}

    public Ray(Point firstPoint, Point secondPoint, Color borderColor) {
        super(firstPoint, secondPoint, borderColor);
    }

    @Override
    public void draw() {
    }
}