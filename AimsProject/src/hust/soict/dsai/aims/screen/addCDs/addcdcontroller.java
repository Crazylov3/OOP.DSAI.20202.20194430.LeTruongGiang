package hust.soict.dsai.aims.screen.addCDs;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.screen.addbooks.addbook;
import hust.soict.dsai.aims.screen.adddvds.adddvd;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class addcdcontroller {
    public addcdcontroller(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }
    private Cart cart;
    Stage stage;
    private Store store;
    @FXML
    private Label success;
    @FXML
    private Label failure;
    @FXML
    private TextField title;
    @FXML
    private TextField category;
    @FXML
    private TextField director;
    @FXML
    private TextField cost;
    @FXML
    private TextField artist;
    @FXML
    void submit(ActionEvent e) {
        try {

            CompactDisc newcd= new CompactDisc(title.getText(),category.getText(),director.getText(),Float.valueOf(cost.getText()),artist.getText());
            store.addMedia(newcd);
            failure.setVisible(false);
            success.setVisible(true);


        } catch (Exception event) {
            success.setVisible(false);
            failure.setVisible(true);
            event.printStackTrace();


        }
    }
    @FXML
    void viewstore(ActionEvent e){
        new StoreScreen(store,cart);

    }
    @FXML
    void viewcart(ActionEvent e){
        new CartScreen(store,cart);
    }
    @FXML
    void addbook(ActionEvent e){
        new addbook(store,cart);
    }
    @FXML
    void adddvd(ActionEvent e){new adddvd(store,cart);}

}
