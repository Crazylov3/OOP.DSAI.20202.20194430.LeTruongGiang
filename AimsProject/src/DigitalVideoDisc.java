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
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
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
    DigitalVideoDisc(String title){
        this.title = title;
        
    }
    DigitalVideoDisc(String title, String category, float cost){
        this.category = category;
        this.title = title;
        this.cost  = cost;
        
    }
    DigitalVideoDisc(String title, String category, float cost, String director){
        this.category = category;
        this.title = title;
        this.cost  = cost;
        this.director = director;
           
    }
    DigitalVideoDisc(String title, String category, float cost, String director, int length){
        this.category = category;
        this.title = title;
        this.cost  = cost;
        this.director = director;
        this.length = length;
    }

    
}
