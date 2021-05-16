package hust.soict.dsai.aims.screen.addbooks;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.screen.addCDs.addcd;
import hust.soict.dsai.aims.screen.adddvds.adddvd;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class addbookcontroller {
    public addbookcontroller(Store store, Cart cart) {
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
    private TextField author;
    @FXML
    private TextField cost;

    @FXML
    void submit(ActionEvent e) {
        try {
            ArrayList<String> authors = new ArrayList<String>();
            for (String au : author.getText().split(",",0)){
                authors.add(au);
            }

            Book newbook = new Book(category.getText(), title.getText(),Float.valueOf(cost.getText()),authors);
            store.addMedia(newbook);
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
    void addcd(ActionEvent e){new addcd(store,cart);}
    @FXML
    void adddvd(ActionEvent e){new adddvd(store,cart);}

}
