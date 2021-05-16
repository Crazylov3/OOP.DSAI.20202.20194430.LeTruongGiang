package hust.soict.dsai.aims.store;


import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Store {
    private List<Media> itemInStore = new ArrayList<Media>();

    public List<Media> getItemInStore() {
        return itemInStore;
    }

    public void addMedia(Media item) {
        if (itemInStore.contains(item)) {
            System.out.println("This Media have already existed!");
            return;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        item.setDate(dtf.format(LocalDateTime.now()));
        this.itemInStore.add(item);
        System.out.println("The Media have been added successfully!");
    }

    public void removeMedia(Media item) {
        if (!itemInStore.contains(item)) {
            System.out.println("This Media doesn't existed!");
            return;
        }
        itemInStore.remove(item);
        System.out.println("The Media have just removed successfully");
    }

    public void getDetailById(String id){
        List<Media> list = this.getItemInStore();
        for (Media item : list){
            if (item.getId().equals(id)){
                item.toString();
            }
        }
        System.out.println("ID not match with any Media");
        return;
    }

    public void getDetailByTitle(String title){
        List<Media> list = this.getItemInStore();
        for (Media item : list){
            if (item.getTitle().equals(title)){
                item.toString();

            }
        }
        System.out.println("Title not match with any Media");
        return;

    }
    public Media getMediaById(String id){
        List<Media> list = this.getItemInStore();
        for (Media item : list){
            if (item.getId().equals(id)){
                return item;
            }
        }
        return null;

    }
    public Media getMediaByTitle(String str){
        List<Media> list = this.getItemInStore();
        for (Media item : list){
            if (item.getTitle().equals(str)){
                return item;
            }
        }
        return null;
    }


    public void print(){
        for (Media item : this.getItemInStore()){
            System.out.println(item.toString());
        }
    }


}