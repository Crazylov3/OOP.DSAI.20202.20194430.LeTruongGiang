package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public boolean equals(Track a) {

        if (a == this) {
            return true;
        }
        if (!a.getClass().equals(this.getClass())) {
            return false;
        }
        Track c = (Track) a;
        return this.title.equals(c.title) && this.getLength() == c.getLength();
    }



    public void play() {
    }
}
