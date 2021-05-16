package javafx;

import com.sun.glass.ui.Screen;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;
    @FXML
    private Slider sizeChange;
    @FXML
    private ColorPicker colorPicker;

    private boolean penStatus = true;

    public void drawAreaMouseDragged(javafx.scene.input.MouseEvent event) {
        int size = (int) sizeChange.getValue();
        Color color = colorPicker.getValue();
        if (penStatus) {

            Circle newCircle = new Circle(event.getX(), event.getY(), size,color);
            drawingAreaPane.getChildren().add(newCircle);
        } else {
            Circle newCircle = new Circle(event.getX(), event.getY(), size, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

    public void clearButtonPressed(javafx.event.ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    public void penClick(javafx.event.ActionEvent actionEvent) {
        penStatus = true;
    }

    public void eraserClick(javafx.event.ActionEvent actionEvent) {
        penStatus = false;
    }
}
