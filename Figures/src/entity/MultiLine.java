package entity;

import java.awt.*;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

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
    public void draw(AnchorPane root) {
    }

    @Override
    public Point location() {
        return null;
    }

    @Override
    public void move() {
    }
}