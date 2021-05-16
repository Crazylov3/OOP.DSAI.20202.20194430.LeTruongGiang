package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.cart.Cart;

import java.util.ArrayList;
import java.util.Scanner;



public class CartTest {
    public static void main(String[]args) throws  Exception{
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction","George Lucas",87,24.85f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Star Wars", "Science Fiction","George Lucas",87,24.85f);

        ArrayList<Media> list = new ArrayList<Media>();
        list.add(dvd1);
        list.add(dvd2);
        list.add(dvd3);



    }
    
}
