package hust.soict.dsai.aims.screen.addbooks;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.screen.CartScreenController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class addbook extends JFrame {
    public Cart cart;
    public Store store;
    public addbook(Store store, Cart cart) {
        super();
        this.cart = cart;
        this.store = store;
        JFXPanel fxPanel = new JFXPanel();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/addbooks/addBook.fxml"));
                    addbookcontroller controller = new addbookcontroller(store, cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root, 1024, 800));

                    add(fxPanel);
                    setTitle("Adding Book");
                    setSize(410, 290);
                    setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
