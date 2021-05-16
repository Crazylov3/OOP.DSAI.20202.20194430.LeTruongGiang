package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;



import javax.swing.*;
import java.util.Collections;
import java.util.Scanner;

public class Aims {


    public static void main(String[] args)  {
       try {
            Scanner sc = new Scanner(System.in);
            Store store = new Store();
            Cart cart = new Cart();

            DigitalVideoDisc dvd1 = new DigitalVideoDisc("End Game", "Science Fiction", "Iron Man", 150, 20.64f);
            DigitalVideoDisc dvd2 = new DigitalVideoDisc("Harry Potter", "Horror", "Roger Allers", 87, 19.95f);
            DigitalVideoDisc dvd3 = new DigitalVideoDisc("Cái Này length = 0", "Bi kịch", "KoNhoTen", 0, 20f);

            Book bk1 = new Book("Ngôn tình","World Trigger ss1",10f, Collections.singletonList("Tung, Phu"));
            Book bk2 = new Book("Ngôn tình","World Trigger ss2",12f, Collections.singletonList("Tung, Phu"));
            Book bk3 = new Book("Ngôn tình","World Trigger ss3",12.9f, Collections.singletonList("Tung, Phu"));

            CompactDisc cd1 = new CompactDisc("Cái này cũng có length = 0 này","Anime","Emiri",30f,"Black Sperm");
            CompactDisc cd2 = new CompactDisc("One Punch Man","Anime","Suzuhara",30f,"Big Bang");
            CompactDisc cd3 = new CompactDisc("Assassination Classroom","Anime","Hitochi",30f,"BlackPink In Your Areaaa");
            Track track1 = new Track("HelloWord",0);
            Track track2 = new Track("HelloWord",0);
            Track track3 = new Track("HelloWord",3);
            cd1.addTrack(track1);
            cd1.addTrack(track2);
            cd2.addTrack(track3);
            cd3.addTrack(track1);
            cd3.addTrack(track2);
            cd3.addTrack(track3);


            store.addMedia(cd1);
            store.addMedia(cd2);
            store.addMedia(cd3);

            store.addMedia(dvd1);
            store.addMedia(dvd2);
            store.addMedia(dvd3);

            store.addMedia(bk3);
            store.addMedia(bk2);
            store.addMedia(bk1);


            new StoreScreen(store, cart);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
