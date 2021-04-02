package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    public static int qtyOrdered = 0;
    public static DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public void print(){
        for (int i = 0; i < Cart.qtyOrdered; i++){
            System.out.print(Cart.itemOrdered[i].id);
            System.out.print(" - ");
            System.out.print(Cart.itemOrdered[i].getTitle());
            System.out.print(" - ");
            System.out.print(Cart.itemOrdered[i].getCategory());
            System.out.print(" - ");
            System.out.print(Cart.itemOrdered[i].getDirector());
            System.out.print(" - ");
            System.out.print(Cart.itemOrdered[i].getLength());
            System.out.print(" - ");
            System.out.print(Cart.itemOrdered[i].getCost());
            System.out.println();
        }
    }    
    public static DigitalVideoDisc[] getOrdered()   {
        return itemOrdered;
        
    }
    
    public void addDVDs(DigitalVideoDisc disc){
        if (qtyOrdered <= MAX_NUMBERS_ORDERED){
            Cart.itemOrdered[qtyOrdered] = disc;
            qtyOrdered+=1;
            System.out.println("The disc has been added.");
        }else System.out.println("The cart is almost full.");
        
    }
    public void removeDVDs(DigitalVideoDisc disc){
      
        int i=0;
        while (0 == 0){
            if (disc == itemOrdered[i]){
                itemOrdered[i] = null;
                itemOrdered[i] = itemOrdered[qtyOrdered-1] ;
                qtyOrdered-=1;
                System.out.println("The disc have been romved");
               
                break; 
                
             }i+=1;
        }
        
        
    }
    public float totalCost(){
        float sum = 0;
        for ( int i=0;i<qtyOrdered;i++){
            
            sum+= itemOrdered[i].getCost();
            
        }    
        return sum;
        
    }
    
    
}
