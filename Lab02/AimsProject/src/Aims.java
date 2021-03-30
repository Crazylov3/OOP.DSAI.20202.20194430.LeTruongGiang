/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */
public class Aims {
    public static void main(String[]args){
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("haha","ad",30.3f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("haha","ad",40.5f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("haha","ad",50.6f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("haha","ad",60);
        cart.addDVDs(dvd1);
        cart.addDVDs(dvd2);
        cart.addDVDs(dvd3);
        cart.addDVDs(dvd4);
        System.out.println(cart.totalCost());
        cart.removeDVDs(dvd3);
        System.out.println(cart.totalCost());
        
    }
    
}
