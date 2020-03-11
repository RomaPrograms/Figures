package line_drawer;

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

public class LineController implements Initializable {

    private static final String CHOOSE_CENTER_TEXT
            = "Choose startingPoint: ";
    private static final String CHOOSE_SECOND_POINT
            = "Choose second point: ";
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

    //    private Button
//
    public void save(ActionEvent event) {
//        Stage stage = (Stage)
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        step = Step.FIRST_STEP;
        startingPoint = new Point();
        borderColorPicker.setValue(Color.BLACK);
        canvas.setOnMouseClicked(e -> {
            if (figureType != null) {
                switch (figureType) {
                    case SECTION: {
                        selectSectionParametr(e);
                        break;
                    }
                    case LINE: {
                        selectLineParametr(e);
                        break;
                    }
                    case MULTILINE: {
                        selectMultiLineParametr(e);
                        break;
                    }
                    case RAY: {
                        selectRayParametr(e);
                        break;
                    }

                }
            } else label.setText(CHOOSE_SOME_FIGURE);

        });

    }

    public void sectionItemClicked() {
        figureType = FigureType.SECTION;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_CENTER_TEXT);
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getWidth());
    }

    public void lineItemClicked() {
        figureType = FigureType.LINE;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_CENTER_TEXT);
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getWidth());
    }

    public void rayItemClicked() {
        figureType = FigureType.RAY;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_CENTER_TEXT);
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getWidth());
    }

    public void multilineItemClicked() {
        figureType = FigureType.MULTILINE;
        step = Step.FIRST_STEP;
        label.setText(CHOOSE_CENTER_TEXT);
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getWidth());
    }

    private void selectMultiLineParametr(MouseEvent e) {
    }

    private void selectLineParametr(MouseEvent e) {
    }

    private void selectRayParametr(final MouseEvent e) {
        switch (step) {
            case FIRST_STEP: {
                startingPoint.setLocation(e.getX(), e.getY());
                label.setText(CHOOSE_SECOND_POINT);
                step = Step.SECOND_STEP;
                break;
            }
            case SECOND_STEP: {
                Point secondPoint = new Point();
                secondPoint.setLocation(e.getX(), e.getY());
                figure = new Ray(startingPoint, secondPoint, borderColorPicker.getValue());
                figure.draw(canvas);
                label.setText(CONGRATULATION_WITH_DRAWED_FIGURE);
                break;
            }
            default:
                label.setText(DEFAULT_TEXT);
        }
    }

    private void selectSectionParametr(final MouseEvent e) {
        switch (step) {
            case FIRST_STEP: {
                startingPoint.setLocation(e.getX(), e.getY());
                label.setText(CHOOSE_SECOND_POINT);
                step = Step.SECOND_STEP;
                break;
            }
            case SECOND_STEP: {
                Point secondPoint = new Point();
                secondPoint.setLocation(e.getX(), e.getY());
                figure = new Section(startingPoint, secondPoint, borderColorPicker.getValue());
                figure.draw(canvas);
                label.setText(CONGRATULATION_WITH_DRAWED_FIGURE);
                break;
            }
            default:
                label.setText(DEFAULT_TEXT);
        }

    }
}
