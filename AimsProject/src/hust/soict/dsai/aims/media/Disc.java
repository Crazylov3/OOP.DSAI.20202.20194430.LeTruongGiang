package hust.soict.dsai.aims.media;


public class Disc extends Media {

    private int length = -1;
    private String director = null;

    public Disc() {
        super();
    }

    public Disc(String title) {
        super(title);
    }

    public Disc(String category, String title, float cost) {
        super(category, title, cost);
    }

    public Disc(String director, String category, String title, float cost) {
        super(category, title, cost);
        this.director = director;
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super(category, title, cost);
        this.length = length;
        this.director = director;
    }

    @Override
    public int getLength() {
        return length;
    }
    @Override
    public void setLength(int length) {
        this.length = length;
    }
    @Override
    public String getDirector() {
        return director;
    }
    @Override
    public void setDirector(String director) {
        this.director = director;
    }

}
