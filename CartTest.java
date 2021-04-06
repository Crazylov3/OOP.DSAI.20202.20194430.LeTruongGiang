package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.Cart;
import java.util.Scanner;



public class CartTest {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction","George Lucas",87,24.85f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aldain","Animation",18.99f);
        cart.addDVDs(dvd1);
        cart.addDVDs(dvd2);
        cart.addDVDs(dvd3);
        cart.print();
        cart.totalCost();
        System.out.print("Enter the title: ");
        DigitalVideoDisc.getDetail(sc.nextLine());
        System.out.print("Enter the ID: ");
        DigitalVideoDisc.getDetail(sc.nextInt());
    }
    
}
