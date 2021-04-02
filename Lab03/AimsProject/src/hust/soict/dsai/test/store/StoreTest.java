package hust.soict.dsai.test.store;


import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[]args) {
        Store store =new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction","George Lucas",87,24.85f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aldain","Animation",18.99f);
        store.addDVDs(dvd1);
        store.addDVDs(dvd2);
        store.addDVDs(dvd3);
        store.print();
        store.removeDVDs(dvd2);
        store.print();


        
    }
    
}
