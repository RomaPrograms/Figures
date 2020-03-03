package entity;

import java.awt.*;
import java.util.List;

/**
 * @author ������������
 * @version 1.0
 * @created 01-Mar-2020 3:05:04 PM
 */
public class MultiLine extends Figure1D {
    private List<Section> sections;

    public MultiLine() {
    }

    public MultiLine(List<Section> sections) {
        this.sections = sections;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
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