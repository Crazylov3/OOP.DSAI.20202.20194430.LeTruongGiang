package hust.soict.dsai.aims.media;

import com.sun.media.jfxmedia.Media;
import hust.soict.dsai.aims.PlayerException;
import hust.soict.dsai.aims.screen.playingWindow.playingWindow;

import java.util.Map;

public class Track implements Playable {
    private String title;
    private int length = 0;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) throws Exception {
        if (length >= 0) {
            this.length = length;
        } else {
            throw new PlayerException("Track's length is negative","ERROR");
        }
    }

    public Track(String title, int length) throws Exception {
        this.title = title;
        if (length >= 0) {
            this.length = length;
        } else {
            throw new PlayerException("Track's length is negative","ERROR");
        }
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


    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: Track's length is non-postive", "Can not play this track");
        } else {
            new playingWindow(this);
        }
    }
}

