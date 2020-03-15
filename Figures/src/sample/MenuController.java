package sample;

import entity.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.List;

public class MenuController implements Initializable {
    private static final String CHOOSE_CENTER_TEXT
            = "Choose startingPoint: ";
    private static final String CHOOSE_WIDTH_BY_X_DISTANCE_TEXT
            = "Choose width by X distance: ";
    private static final String CHOOSE_WIDTH_BY_Y_DISTANCE_TEXT
            = "Choose width by Y distance: ";
    private static final String DEFAULT_TEXT
            = "You did everything with this figure, choose another!";
    private static final String CHOOSE_SOME_FIGURE
            = "Choose some figure from menu!";
    private static final String CONGRATULATION_WITH_DREW_FIGURE
            = "Congratulation! You drew cool figure!";
    private static final String CHOOSE_FIRST_POINT
            = "Choose first point: ";
    @FXML
    public ColorPicker borderColorPicker;
    @FXML
    public ColorPicker innerColorPicker;
    @FXML
    Label label;
    @FXML
    CheckBox checkbox;
    @FXML
    AnchorPane anchorPane;
    private FigureType figureType;
    private Figure figure;
    private Step step;
    private Point center;
    private List<Figure> figures;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        step = Step.FIRST_STEP;
        center = new Point();
        figures = new ArrayList<>();
        borderColorPicker.setValue(Color.BLACK);
        innerColorPicker.setValue(Color.BLACK);
        anchorPane.setOnMouseClicked(e -> {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                if (figureType != null) {
                    switch (figureType) {
                        case ELLIPSE:
                            selectEllipseParameters(e);
                            break;
                        case CIRCLE:
                            selectCircleParameters(e);
                            break;
                        default:
                    }
                } else {
                    label.setText(CHOOSE_SOME_FIGURE);
                }
            }
        });
    }

    public void ellipseItemClicked() {
        figureType = FigureType.ELLIPSE;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_CENTER_TEXT);
    }

    public void circleItemClicked() {
        figureType = FigureType.CIRCLE;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_CENTER_TEXT);
    }

    public void rayItemClicked() {
        figureType = FigureType.LINE;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_FIRST_POINT);
    }

    public void multilineItemClicked() {
        figureType = FigureType.LINE;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_FIRST_POINT);
    }

    public void lineItemClicked() {
        figureType = FigureType.LINE;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_FIRST_POINT);
    }

    private void selectEllipseParameters(final MouseEvent e) {
        switch (step) {
            case FIRST_STEP:
                figure = new Ellipse();
                center.setLocation(e.getX(), e.getY());
                ((Ellipse) figure).setCenter(center);
                label.setText(CHOOSE_WIDTH_BY_X_DISTANCE_TEXT);
                step = Step.SECOND_STEP;
                break;
            case SECOND_STEP:
                double distanceX = e.getX() - center.getX();
                double distanceY = e.getY() - center.getY();
                ((Ellipse) figure).setWidthX(Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2)));
                label.setText(CHOOSE_WIDTH_BY_Y_DISTANCE_TEXT);
                step = Step.THIRD_STEP;
                break;
            case THIRD_STEP:
                distanceX = e.getX() - center.getX();
                distanceY = e.getY() - center.getY();
                ((Ellipse) figure).setWidthY(Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2)));
                figure.setBorderColor(borderColorPicker.getValue());
                ((Ellipse) figure).setInnerColor(innerColorPicker.getValue());
                figures.add(figure);
                figure.draw(anchorPane);
                label.setText(CONGRATULATION_WITH_DREW_FIGURE);
                step = Step.FIGURE_DREW;
                break;
            default:
                label.setText(DEFAULT_TEXT);
        }
    }

    private void selectCircleParameters(final MouseEvent e) {
        switch (step) {
            case FIRST_STEP:
                center.setLocation(e.getX(), e.getY());
                label.setText(CHOOSE_WIDTH_BY_X_DISTANCE_TEXT);
                step = Step.SECOND_STEP;
                break;
            case SECOND_STEP:
                double distanceX = e.getX() - center.getX();
                double distanceY = e.getY() - center.getY();
                double diameter = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
                figure = new Circle(borderColorPicker.getValue(), center,
                        innerColorPicker.getValue(), diameter);
                step = Step.FIGURE_DREW;
                figures.add(figure);
                figure.draw(anchorPane);
                label.setText(CONGRATULATION_WITH_DREW_FIGURE);
                break;
            default:
                label.setText(DEFAULT_TEXT);
        }
    }
}
