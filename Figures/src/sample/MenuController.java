package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    Canvas canvasId;

    public void drawLine(ActionEvent event) {
        Parent loader = null;
        try {
            loader = new FXMLLoader().load(getClass()
                    .getResource("/line_drawer/line.fxml"));
            Stage newStage = new Stage();
            newStage.setTitle("Параметры линии");
            newStage.setScene(new Scene(loader));
            newStage.setResizable(false);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
