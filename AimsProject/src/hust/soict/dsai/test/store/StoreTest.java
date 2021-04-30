package hust.soict.dsai.test.store;


import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Book;
import java.util.Collections;
import java.util.ArrayList;




public class StoreTest {
    public static void main(String[]args) {
        Store store =new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction","George Lucas",87,24.85f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aldain","Animation",18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aldain","Animation",18.99f);
        Book bk1 = new Book("Giang", Collections.singletonList("Tung, Phu"));
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(bk1);

        ArrayList<Media> list = new ArrayList<Media>();
        list.add(dvd1);
        list.add(dvd2);
        list.add(dvd3);
        list.add(bk1);


        Media.COMPARE_BY_COST_TITLE.sort(list);


        for(Media media :list){
            System.out.println(media.toString());
        }








        
    }
    
}
