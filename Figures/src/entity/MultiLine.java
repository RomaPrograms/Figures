package entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

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

    public MultiLine(Point... points) {
        sections = new ArrayList<>(points.length - 1);
        for (int i = 0; i < points.length - 1;i++)
            sections.add(new Section(points[i],points[i + 1], super.getBorderColor()));
    }

    @Override
    public void draw(Canvas canvas) {
        for (Section section : sections)
            section.draw(canvas);
    }

    @Override
    public Point location() {
        return null;
    }

    @Override
    public void move(Point newPoint) {
    }
}