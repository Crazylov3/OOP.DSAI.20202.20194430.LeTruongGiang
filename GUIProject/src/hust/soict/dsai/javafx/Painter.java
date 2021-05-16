package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;

public class Painter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
        URL url = new File("src/hust/soict/dsai/javafx/Painter.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Painter");
        Image img = new Image("src/hust/soict/dsai/javafx/icon.jpg");
        primaryStage.getIcons().add(img);
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
