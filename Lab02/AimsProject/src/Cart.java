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
    public int qtyOrdered = 0;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public DigitalVideoDisc[] getOrdered(){
        return this.itemOrdered;
    
    }
    public void addDVDs(DigitalVideoDisc disc){
        if (qtyOrdered <= MAX_NUMBERS_ORDERED){
            this.itemOrdered[qtyOrdered] = disc;
            qtyOrdered+=1;
            System.out.println("The disc has been added.");
        }else System.out.println("The cart is almost full.");
        
    }
    public void removeDVDs(DigitalVideoDisc disc){
        int temp = 0;
        int i=0;
        while (temp == 0){
            if (disc == itemOrdered[i]){
               itemOrdered[i] = null;
               itemOrdered[i] = itemOrdered[qtyOrdered-1] ;
               qtyOrdered-=1;
               System.out.println("The disc have been romved");
               temp = 1;
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
