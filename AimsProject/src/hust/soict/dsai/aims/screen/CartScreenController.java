package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.PlayerException;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.screen.addCDs.addcd;
import hust.soict.dsai.aims.screen.addbooks.addbook;
import hust.soict.dsai.aims.screen.adddvds.adddvd;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;


public class CartScreenController extends JFrame {
    public Cart cart;
    public Store store;

    public CartScreenController(Store store, Cart cart) {
        super();
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private BorderPane Pane;
    @FXML
    private Label totalcost;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediacategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private TableColumn<Media, String> colID;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private MenuItem viewStoreId;

    @FXML
    private void initialize() {

        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colID.setCellValueFactory(new PropertyValueFactory<Media, String>("id"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        ObservableList<Media> itemInCart = this.cart.getOrdered();
        tblMedia.setItems(itemInCart);
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        totalcost.setText(this.cart.totalCost() + " $");

        cart.getOrdered().addListener(new ListChangeListener<Media>() {
            @Override
            public void onChanged(Change<? extends Media> change) {
                while (change.next()) {
                    if (change.wasAdded() || change.wasRemoved()) {
                        totalcost.setText(CartScreenController.this.cart.totalCost() + " $");
                    }
                }

            }
        });

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media olbValue,
                                        Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                }
        );
    }

    @FXML
    void addbk(ActionEvent e) {
        new addbook(store, cart);
    }
    @FXML
    void addcd(ActionEvent e) {
        new addcd(store, cart);
    }
    @FXML
    void adddvd(ActionEvent e) {
        new adddvd(store, cart);
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);

        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);

    }

    @FXML
    void viewStoreBtn(ActionEvent e) {
        new StoreScreen(store, cart);


    }


    @FXML
    void playMedia(ActionEvent e) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        media.play();


    }

    @FXML
    void placeOrder(ActionEvent e){
        int option = JOptionPane.showConfirmDialog(null, "Are You Sure To Place Order With The Cost Is " + this.cart.totalCost() + "$" );
        JOptionPane.showMessageDialog(null,""+
                (option == JOptionPane.YES_OPTION ? "Successful Payment!" : "Payment Cancelled!"));
        if (option == JOptionPane.YES_OPTION){
            this.cart.clearCart();
        }

    }

}

