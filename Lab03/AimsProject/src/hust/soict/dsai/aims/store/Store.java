package hust.soict.dsai.aims.store;


import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS = 100;
    public static int qtyDVD = 0 ;
    public static DigitalVideoDisc itemInStore[] = new DigitalVideoDisc[MAX_NUMBERS];
    public void addDVDs(DigitalVideoDisc disc){
        if (qtyDVD <= MAX_NUMBERS){
            Store.itemInStore[qtyDVD] = disc;
            qtyDVD+=1;
            System.out.println("The disc has been added.");
        }else System.out.println("The store is almost full.");
        
    }
    public void removeDVDs(DigitalVideoDisc disc){
        int i=0;
        while (0 == 0){
            if (disc == itemInStore[i]){
                itemInStore[i] = null;
                itemInStore[i] = itemInStore[qtyDVD-1] ;
                qtyDVD-=1;
                System.out.println("The disc have been romved");
                break; 
                
             }i+=1;
        }
    }
    public void print(){
        for (int i = 0; i < Store.qtyDVD; i++){
            System.out.print(Store.itemInStore[i].id);
            System.out.print(" - ");
            System.out.print(Store.itemInStore[i].getTitle());
            System.out.print(" - ");
            System.out.print(Store.itemInStore[i].getCategory());
            System.out.print(" - ");
            System.out.print(Store.itemInStore[i].getDirector());
            System.out.print(" - ");
            System.out.print(Store.itemInStore[i].getLength());
            System.out.print(" - ");
            System.out.print(Store.itemInStore[i].getCost());
            System.out.println();
        }
    }    
}