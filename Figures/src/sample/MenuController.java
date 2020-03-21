package sample;

import entity.*;
import entity.Polygon;
import entity.Rectangle;
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
    private static final String CHOOSE_DISTANCE
            = "Choose distance: ";
    private static final String CHOOSE_LOWER_LEFT_CORNER_POINT
            = "Choose lower left corner: ";
    private static final String CHOOSE_UPPER_RIGHT_CORNER_POINT
            = "Choose upper right corner: ";
    private static final String CHOOSE_THIRD_POINT
            = "Choose third point: ";
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
    private List<Point> points;
    private List<Double> pointsCoordinates;
    private Figure figure;
    private Step step;
    private Point center;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        step = Step.FIRST_STEP;
        center = new Point();
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
                        case SYMMETRIC_FIGURE:
                            selectSymmetricFigureParameters(e);
                            break;
                        case TRIANGLE:
                            selectTriangleFigureParameters(e);
                            break;
                        case RECTANGLE:
                            selectRectangleFigureParameters(e);
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

    public void symmetricFigureItemClicked() {
        figureType = FigureType.SYMMETRIC_FIGURE;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_CENTER_TEXT);
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

    public void triangleItemClicked() {
        figureType = FigureType.TRIANGLE;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_FIRST_POINT);
    }

    public void rectangleItemClicked() {
        figureType = FigureType.RECTANGLE;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_LOWER_LEFT_CORNER_POINT);
    }

    private void selectTriangleFigureParameters(final MouseEvent e) {
        switch (step) {
            case FIRST_STEP:
                pointsCoordinates = new ArrayList<>();
                pointsCoordinates.add(e.getX());
                pointsCoordinates.add(e.getY());
                label.setText(CHOOSE_SECOND_POINT);
                step = Step.SECOND_STEP;
                break;
            case SECOND_STEP:
                pointsCoordinates.add(e.getX());
                pointsCoordinates.add(e.getY());
                label.setText(CHOOSE_THIRD_POINT);
                step = Step.THIRD_STEP;
                break;
            case THIRD_STEP:
                pointsCoordinates.add(e.getX());
                pointsCoordinates.add(e.getY());
                figure = new Triangle(borderColorPicker.getValue(), pointsCoordinates,
                        innerColorPicker.getValue());
                figure.draw(anchorPane);
                label.setText(CONGRATULATION_WITH_DREW_FIGURE);
                step = Step.FORTH_STEP;
                break;
            default:
                label.setText(DEFAULT_TEXT);
        }
    }

    private void selectRectangleFigureParameters(final MouseEvent e) {
        switch (step) {
            case FIRST_STEP:
                pointsCoordinates = new ArrayList<>();
                pointsCoordinates.add(e.getX());
                pointsCoordinates.add(e.getY());
                label.setText(CHOOSE_UPPER_RIGHT_CORNER_POINT);
                step = Step.SECOND_STEP;
                break;
            case SECOND_STEP:
                pointsCoordinates.add(pointsCoordinates.get(0));
                pointsCoordinates.add(e.getY());
                pointsCoordinates.add(e.getX());
                pointsCoordinates.add(e.getY());
                pointsCoordinates.add(e.getX());
                pointsCoordinates.add(pointsCoordinates.get(1));
                figure = new Rectangle(borderColorPicker.getValue(), pointsCoordinates,
                        innerColorPicker.getValue());
                figure.draw(anchorPane);
                label.setText(CONGRATULATION_WITH_DREW_FIGURE);
                step = Step.THIRD_STEP;
                break;
            default:
                label.setText(DEFAULT_TEXT);
        }
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

    private void selectSymmetricFigureParameters(final MouseEvent e) {
        switch (step) {
            case FIRST_STEP:
                center.setLocation(e.getX(), e.getY());
                label.setText(CHOOSE_DISTANCE);
                figure = new SymmetricFigure(borderColorPicker.getValue(), center,
                        innerColorPicker.getValue(), 0);
                step = Step.SECOND_STEP;
                break;
            case SECOND_STEP:
                double distanceX = e.getX() - center.getX();
                double distanceY = e.getY() - center.getY();
                double distance = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
                ((SymmetricFigure) figure).setDistance(distance);
                ((SymmetricFigure) figure).setNumberSides((((SymmetricFigure) figure).getNumberSides()) + 1);
                label.setText("Click one more time if you want to add a point!");
                step = Step.THIRD_STEP;
                break;
            case THIRD_STEP:
                ((SymmetricFigure) figure).setNumberSides((((SymmetricFigure) figure).getNumberSides()) + 1);
                if(((SymmetricFigure) figure).getNumberSides() > 2) {
                    anchorPane.getChildren().remove(((SymmetricFigure) figure).getJavafxPolygon());
                    if(((SymmetricFigure) figure).getJavafxPolygon() != null) {
                        ((SymmetricFigure) figure).getJavafxPolygon().getPoints().clear();
                    }
                    figure.draw(anchorPane);
                }
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
                points = new ArrayList<>();
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
