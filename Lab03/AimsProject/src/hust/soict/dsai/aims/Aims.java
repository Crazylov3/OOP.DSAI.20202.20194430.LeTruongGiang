package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class Aims {
    public static void main(String[]args){
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction","George Lucas",87,24.85f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aldain","Animation",18.99f);
        cart.addDVDs(dvd1);
        cart.addDVDs(dvd2);
        cart.addDVDs(dvd3);
        
        System.out.println(cart.totalCost());
        cart.removeDVDs(dvd3);
        System.out.println(cart.totalCost());
    
        
    }
    
}
