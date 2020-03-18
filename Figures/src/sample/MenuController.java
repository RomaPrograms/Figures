package sample;

import entity.*;
import entity.Polygon;
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
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.List;

public class MenuController implements Initializable {
    private static final String CHOOSE_CENTER_TEXT
            = "Choose startingPoint: ";
    private static final String CHOOSE_SECOND_POINT
            = "Choose second point: ";
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
    private static final String CHOOSE_ANOTHER_POINT
            = "Choose one more point: ";
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
    private List<Point> points = new ArrayList<>();
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
                        case POLYGON:
                            selectPolygonParameters(e);
                            break;
                        case RAY:
                            selectRayParameters(e);
                            break;
                        case LINE:
                            selectLineParameters(e);
                            break;
                        case SECTION:
                            selectSectionParameters(e);
                            break;
                        case MULTILINE:
                            selectMultilineParameters(e);
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

    public void polygonItemClicked() {
        figureType = FigureType.POLYGON;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_FIRST_POINT);
    }

    public void rayItemClicked() {
        figureType = FigureType.RAY;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_FIRST_POINT);
    }

    public void sectionItemClicked() {
        figureType = FigureType.SECTION;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_FIRST_POINT);
    }

    public void multilineItemClicked() {
        figureType = FigureType.MULTILINE;
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

    private void selectPolygonParameters(final MouseEvent e) {
        switch (step) {
            case FIRST_STEP:
                figure = new Polygon();
                ((Polygon) figure).getPoints().add(e.getX());
                ((Polygon) figure).getPoints().add(e.getY());
                label.setText(CHOOSE_ANOTHER_POINT);
                step = Step.SECOND_STEP;
                break;
            case SECOND_STEP:
                ((Polygon) figure).getPoints().add(e.getX());
                ((Polygon) figure).getPoints().add(e.getY());
                ((Polygon) figure).setInnerColor(innerColorPicker.getValue());
                figure.setBorderColor(borderColorPicker.getValue());
                anchorPane.getChildren().remove(((Polygon) figure).getJavafxPolygon());
                figure.draw(anchorPane);
                break;
        }
    }

    private void selectRayParameters(final MouseEvent e) {
        switch (step) {
            case FIRST_STEP: {
                center.setLocation(e.getX(), e.getY());
                label.setText(CHOOSE_SECOND_POINT);
                step = Step.SECOND_STEP;
                break;
            }
            case SECOND_STEP: {
                Point secondPoint = new Point();
                secondPoint.setLocation(e.getX(), e.getY());
                figure = new Ray(center, secondPoint, borderColorPicker.getValue());
                figure.draw(anchorPane);
                step = Step.FIGURE_DREW;
                label.setText(CONGRATULATION_WITH_DREW_FIGURE);
                break;
            }
            default:
                label.setText(DEFAULT_TEXT);
        }
    }

    private void selectLineParameters(final MouseEvent e) {
        switch (step) {
            case FIRST_STEP: {
                center.setLocation(e.getX(), e.getY());
                label.setText(CHOOSE_SECOND_POINT);
                step = Step.SECOND_STEP;
                break;
            }
            case SECOND_STEP: {
                Point secondPoint = new Point();
                secondPoint.setLocation(e.getX(), e.getY());
                figure = new Line(center, secondPoint, borderColorPicker.getValue());
                figure.draw(anchorPane);
                step = Step.FIGURE_DREW;
                label.setText(CONGRATULATION_WITH_DREW_FIGURE);
                break;
            }
            default:
                label.setText(DEFAULT_TEXT);
        }
    }

    private void selectSectionParameters(final MouseEvent e) {
        switch (step) {
            case FIRST_STEP: {
                center.setLocation(e.getX(), e.getY());
                label.setText(CHOOSE_SECOND_POINT);
                step = Step.SECOND_STEP;
                break;
            }
            case SECOND_STEP: {
                Point secondPoint = new Point();
                secondPoint.setLocation(e.getX(), e.getY());
                figure = new Section(center, secondPoint, borderColorPicker.getValue());
                figure.draw(anchorPane);
                step = Step.FIGURE_DREW;
                label.setText(CONGRATULATION_WITH_DREW_FIGURE);
                break;
            }
            default:
                label.setText(DEFAULT_TEXT);
        }
    }

    private void selectMultilineParameters(final MouseEvent e) {
        switch (step) {
            case FIRST_STEP: {
                center.setLocation(e.getX(), e.getY());
                points.add(center);
                label.setText(CHOOSE_SECOND_POINT);
                step = Step.SECOND_STEP;
                break;
            }
            case SECOND_STEP: {
                Point secondPoint = new Point();
                secondPoint.setLocation(e.getX(), e.getY());
                if (points.get(points.size()-1).equals(secondPoint)) {
                    figure = new MultiLine(points.toArray(new Point[points.size()]), borderColorPicker.getValue());
                    figure.draw(anchorPane);
                    step = Step.FIGURE_DREW;
                    label.setText(CONGRATULATION_WITH_DREW_FIGURE);
                    points.clear();
                } else {
                    points.add(secondPoint);
                    step = Step.SECOND_STEP;
                }
                break;
            }
            default:
                label.setText(DEFAULT_TEXT);
        }
    }
}
