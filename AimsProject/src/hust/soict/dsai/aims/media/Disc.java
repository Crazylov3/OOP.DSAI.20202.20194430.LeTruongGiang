package hust.soict.dsai.aims.media;


import hust.soict.dsai.aims.PlayerException;
import hust.soict.dsai.aims.screen.playingWindow.playingWindow;

public class Disc extends Media {

    private int length = -1;
    private String director = null;

    public Disc() {
        super();
    }

    public Disc(String title) {
        super(title);
    }

    public Disc(String category, String title, float cost) throws Exception {
        super(category, title, cost);
    }

    public Disc(String director, String category, String title, float cost) throws Exception {
        super(category, title, cost);
        this.director = director;
    }

    public Disc(String title, String category, String director, int length, float cost) throws Exception {
        super(category, title, cost);
        if (length >= 0) {
            this.length = length;
        } else {
            throw new PlayerException("Disc's length is negative","ERROR");
        }
        this.director = director;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void setLength(int length) throws Exception {
        if (length > 0) {
            this.length = length;
        } else {
            throw new PlayerException("Disc's length is non-postive","ERROR");
        }
    }

    @Override
    public String getDirector() {
        return director;
    }

    @Override
    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public void play() throws PlayerException {
        new playingWindow(this);


    }

}


