package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class Cart {
    private ObservableList<Media> itemOrdered = FXCollections.observableArrayList();
    public ObservableList<Media> getOrdered()   {
        return itemOrdered;
        
    }
    public void clearCart(){
        ObservableList<Media> items = this.itemOrdered;
        items.clear();
    }
    public void addMedia(Media item){
        if (itemOrdered.contains(item)) {
            System.out.println("This Media have already existed!");
            return;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        item.setDate(dtf.format(LocalDateTime.now()));
        this.itemOrdered.add(item);
        System.out.println("The Media have been added successfully!");
    }
    public void removeMedia(Media item) {
        if (!itemOrdered.contains(item)) {
            System.out.println("The Media doesn't exist!");
            return;
        }
        itemOrdered.remove(item);
        System.out.println("The Media have just removed successfully");
    }

    public float totalCost(){
        float sum = 0;
        for (Media item: this.itemOrdered){
            sum+= item.getCost();
        }    
        return sum;
        
    }
    public void getDetailById(String id){
        ObservableList<Media> list = this.getOrdered();
        for (Media item : list){
            if (item.getId().equals(id)){
                item.toString();
                return;
            }
        }
        System.out.println("ID not match with any DVD");
        return;
    }

    public void getDetailByTitle(String title){
        ObservableList<Media> list = this.getOrdered();
        for (Media item : list){
            if (item.getTitle().equals(title)){
                item.toString();
                return;
            }
        }
        System.out.println("Title not match with any DVD");
        return;

    }

    public Media getMediaById(String id){
        ObservableList<Media> list = this.getOrdered();
        for (Media item : list){
            if (item.getId().equals(id)){
                return item;
            }
        }
        return null;

    }
    public Media getMediaByTitle(String str){
        ObservableList<Media> list = this.getOrdered();
        for (Media item : list){
            if (item.getTitle().equals(str)){
                return item;
            }
        }
        return null;
    }
    public void print(){
        for (Media item : this.getOrdered()){
            System.out.println(item.toString());
        }
    }




}
