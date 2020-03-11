package entity;

import java.awt.*;
import java.awt.Rectangle;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:04 PM
 */
public class Ray extends Buffer {

	public Ray(){
	}

    @Override
    public void setSecondPoint(Point endPoint) {
        if(endPoint.x>0 && endPoint.x<Toolkit.getDefaultToolkit().getScreenSize().getWidth() &&
                endPoint.y>0 && endPoint.y<Toolkit.getDefaultToolkit().getScreenSize().getHeight())
            endPoint = getOutScreenPoint(endPoint);
        super.setSecondPoint(endPoint);
    }

    public Ray(Point firstPoint, Point secondPoint, Color borderColor) {
        super(firstPoint, secondPoint, borderColor);
    }

    public Point getOutScreenPoint(Point pt) {
        Point theCenter = location();
        Point result = new Point();
        double deltaX = pt.x - theCenter.x;
        double deltaY = pt.y - theCenter.y;
        if (deltaX==0 && deltaY==0)
            return pt;
        if (Math.abs(deltaX) < Math.abs(deltaY)) {
            double height;
            if (deltaY < 0)
                height = -1;
            else
                height = Toolkit.getDefaultToolkit().getScreenSize().getHeight() + 1;
            result.setLocation(deltaX / deltaY * (height - theCenter.y) + theCenter.x, height);
        } else {
            double width;
            if (deltaX < 0)
                width = -1;
            else
                width = Toolkit.getDefaultToolkit().getScreenSize().getWidth() + 1;
            result.setLocation(width, deltaY / deltaX * (width - theCenter.x) + theCenter.y);
        }
        return result;
    }

    @Override
    public void draw(Canvas canvas) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setLineWidth(4);
        graphicsContext.setStroke(Color.BLACK);




        Rectangle rect = graphics.getClipBounds();
        int x,y;
        if (point.x < 0)
            x = 0;
        else if (point.x > 0)
            x = (int)rect.getWidth();
        else
            x = theCenter.x;

        int d = x - theCenter.x;
        if (d != 0)
            y = theCenter.y + d * point.y / point.x;
        else
            y = (point.y > 0) ? (int)rect.getHeight() : 0;
        graphics.drawLine(theCenter.x,theCenter.y,x,y);
    }
}