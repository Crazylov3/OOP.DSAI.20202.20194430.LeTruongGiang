package hust.soict.dsai.aims.disc;


import hust.soict.dsai.aims.cart.Cart;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */
public class DigitalVideoDisc {
    private String title=null;
    private String category=null;
    private String director=null;
    private int length=-1;
    private float cost=-1;
    private static int nbDigitalVideoDiscs=0;
    public int id;
    public String getTitle(){
        return title;
    }
    public String getCategory(){
        return category;
    }
    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }
    public float getCost(){
        return cost;
    }
    public void setTitle(String t){
        this.title = t;
    }
    public DigitalVideoDisc(){
        DigitalVideoDisc.nbDigitalVideoDiscs+=1;
        this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
        
    }
    public DigitalVideoDisc(String title){
        this.title = title;
        DigitalVideoDisc.nbDigitalVideoDiscs+=1;
        this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
        
    }
    public DigitalVideoDisc(String category,String title , float cost){
        this.category = category;
        this.title = title;
        this.cost  = cost;
        DigitalVideoDisc.nbDigitalVideoDiscs+=1;
        this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
        
        
    }
    public DigitalVideoDisc(String director,String category,String title , float cost){
        this.category = category;
        this.title = title;
        this.cost  = cost;
        this.director = director;
        DigitalVideoDisc.nbDigitalVideoDiscs+=1;
        this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
        
           
    }
    public DigitalVideoDisc(String title, String category, String director, int length,float cost){
        this.category = category;
        this.title = title;
        this.cost  = cost;
        this.director = director;
        this.length = length;
        DigitalVideoDisc.nbDigitalVideoDiscs+=1;
        this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
        
    }
    public static void getDetail(int id){
        DigitalVideoDisc[] list = Cart.getOrdered();
       
        for (int i = 0 ;i <  Cart.qtyOrdered;i++){
            if (list[i].id == id){
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
                System.err.println();    
                return;         
            }
             
        }System.out.println("ID not match with any DVD");
    }
    public static void getDetail(String title){
        DigitalVideoDisc[] list = Cart.getOrdered();
       
        for (int i = 0 ;i <  Cart.qtyOrdered;i++){
            if (list[i].getTitle().equals(title)){
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
                System.err.println();  
                return;           
            }
            
        } System.out.println("Title not match with any DVD");
    }

    
}
