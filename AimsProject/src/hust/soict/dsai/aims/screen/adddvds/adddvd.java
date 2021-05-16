package hust.soict.dsai.aims.screen.adddvds;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class adddvd extends JFrame {
    public Cart cart;
    public Store store;
    public adddvd(Store store, Cart cart) {
        super();
        this.cart = cart;
        this.store = store;
        JFXPanel fxPanel = new JFXPanel();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/adddvds/adddvd.fxml"));
                    adddvdcontroller controller = new adddvdcontroller(store, cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root, 1024, 800));

                    add(fxPanel);
                    setTitle("Adding DVD");
                    setSize(410, 310);
                    setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
