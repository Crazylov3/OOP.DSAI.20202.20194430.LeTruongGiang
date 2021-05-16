package hust.soict.dsai.aims.media;


import hust.soict.dsai.aims.PlayerException;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.screen.playingWindow.playingWindow;

import java.util.ArrayList;


public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;
    private String id;


    public DigitalVideoDisc() {
        super();
        this.id = "DVD" + (++nbDigitalVideoDiscs);

    }

    public DigitalVideoDisc(String title) {
        super(title);
        this.id = "DVD" + (++nbDigitalVideoDiscs);

    }

    public DigitalVideoDisc(String category, String title, float cost) throws Exception {
        super(category, title, cost);
        this.id = "DVD" + (++nbDigitalVideoDiscs);


    }

    public DigitalVideoDisc(String director, String category, String title, float cost) throws  Exception {
        super(director, category, title, cost);
        this.id = "DVD" + (++nbDigitalVideoDiscs);


    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) throws  Exception {
        super(title, category, director, length, cost);
        this.id = "DVD" + (++nbDigitalVideoDiscs);

    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.getId()+" : "+this.getTitle()+" : "+this.getCategory()+" : "+this.getCost()+" : "+this.getLength()+" : "+this.getDate();
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: DVD's length is non-postive", "Can not play this DVD");
        } else {
            super.play();
        }

    }


}
