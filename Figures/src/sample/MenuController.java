package sample;

import entity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

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
    private static final String CONGRATULATION_WITH_DRAWED_FIGURE
            = "Congratulation! You drew cool figure!";
    @FXML
    public ColorPicker borderColorPicker;
    @FXML
    public ColorPicker innerColorPicker;
    @FXML
    Canvas canvas;
    @FXML
    Label label;
    private FigureType figureType;
    private Figure figure;
    private Step step;
    private Point startingPoint;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        step = Step.FIRST_STEP;
        startingPoint = new Point();
        borderColorPicker.setValue(Color.BLACK);
        innerColorPicker.setValue(Color.BLACK);
        canvas.setOnMouseClicked(e -> {
            if (figureType != null) {
                switch (figureType) {
                    case ELLIPSE: {
                        selectEllipseParameters(e);
                        break;
                    }
                    case CIRCLE: {
                        selectCircleParameters(e);
                    }
                }
            } else {
                label.setText(CHOOSE_SOME_FIGURE);
            }
        });
    }

    public void ellipseItemClicked() {
        figureType = FigureType.ELLIPSE;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_CENTER_TEXT);
        cleanCanvas();
    }

    public void circleItemClicked() {
        figureType = FigureType.CIRCLE;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_CENTER_TEXT);
        cleanCanvas();
    }

    public void selectEllipseParameters(final MouseEvent e) {
        switch (step) {
            case FIRST_STEP: {
                figure = new Ellipse();
                startingPoint.setLocation(e.getX(), e.getY());
                label.setText(CHOOSE_WIDTH_BY_X_DISTANCE_TEXT);
                step = Step.SECOND_STEP;
                break;
            }
            case SECOND_STEP: {
                double distanceX = e.getX() - startingPoint.getX();
                double distanceY = e.getY() - startingPoint.getY();
                ((Ellipse) figure).setWidthX(Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2)));
                label.setText(CHOOSE_WIDTH_BY_Y_DISTANCE_TEXT);
                step = Step.THIRD_STEP;
                break;
            }
            case THIRD_STEP: {
                double distanceX = e.getX() - startingPoint.getX();
                double distanceY = e.getY() - startingPoint.getY();
                ((Ellipse) figure).setWidthY(Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2)));
                Point center = new Point();
                center.setLocation(
                        startingPoint.getX() - ((Ellipse) figure).getWidthX()/2,
                        startingPoint.getY() - ((Ellipse) figure).getWidthY()/2);
                ((Ellipse) figure).setCenter(center);
                figure.setBorderColor(borderColorPicker.getValue());
                ((Ellipse) figure).setInnerColor(innerColorPicker.getValue());
                figure.draw(canvas);
                label.setText(CONGRATULATION_WITH_DRAWED_FIGURE);
                step = Step.FORTH_STEP;
                break;
            }
            default: {
                label.setText(DEFAULT_TEXT);
            }
        }
    }

    public void selectCircleParameters(final MouseEvent e) {
        switch (step) {
            case FIRST_STEP: {
                startingPoint.setLocation(e.getX(), e.getY());
                label.setText(CHOOSE_WIDTH_BY_X_DISTANCE_TEXT);
                step = Step.SECOND_STEP;
                break;
            }
            case SECOND_STEP: {
                double distanceX = e.getX() - startingPoint.getX();
                double distanceY = e.getY() - startingPoint.getY();
                Point center = new Point();
                double diameter = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
                center.setLocation(
                        startingPoint.getX() - diameter/2,
                        startingPoint.getY() - diameter/2);
                figure = new Circle(borderColorPicker.getValue(), center,
                        innerColorPicker.getValue(), diameter);
                step = Step.THIRD_STEP;
                figure.draw(canvas);
                label.setText(CONGRATULATION_WITH_DRAWED_FIGURE);
                break;
            }
            default: {
                label.setText(DEFAULT_TEXT);
            }
        }
    }

    public void borderColorPicked(ActionEvent event) {
        if(figure != null) {
            figure.setBorderColor(borderColorPicker.getValue());
            cleanCanvas();
            figure.draw(canvas);
        }
    }

    public void innerColorPicked(ActionEvent event) {
        if(figure != null) {
            switch(figureType) {
                case ELLIPSE:
                case CIRCLE:
                case POLYGON:
                case TRIANGLE:
                case RECTANGLE:
                case SYMMETRIC_FIGURE:
                    ((Figure2D) figure).setInnerColor(innerColorPicker.getValue());
                    cleanCanvas();
                    figure.draw(canvas);
                    break;
            }
        }
    }

    public void cleanCanvas() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getWidth());
    }
}
