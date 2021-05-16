package hust.soict.dsai.aims.screen.playingWindow;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.CartScreenController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class playingWindow extends JFrame {

    public playingWindow(Media media) {
        super();
        JFXPanel fxPanel = new JFXPanel();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/playingWindow/window.fxml"));
                    controller controller = new controller(media);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root, 1024, 800));

                    add(fxPanel);
                    setTitle("Playing Window");
                    setSize(620, 500);
                    setResizable(false);
                    setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public playingWindow(Track track) {
        super();
        JFXPanel fxPanel = new JFXPanel();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/playingWindow/window.fxml"));
                    controller controller = new controller(track);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root, 1024, 800));

                    add(fxPanel);
                    setTitle("Playing Window");
                    setSize(620, 500);
                    setResizable(false);
                    setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
