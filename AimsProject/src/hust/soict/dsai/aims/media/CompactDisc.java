package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private static int nCd =0;
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    private String id;

    public String getId() {
        return id;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }
    @Override
    public int getLength() {
        int len = 0;
        for (Track i : tracks) {
            len += i.getLength();
        }
        return len;

    }

    public CompactDisc(String title, String category, String director, float cost, String artist) {
        super(director, category, title, cost);
        this.artist = artist;
        this.id = "CD"+ ++nCd;

    }

    public void addTrack(Track t) {
        for (Track i : tracks) {
            if (t.getTitle().equals(i.getTitle()) && t.getLength() == i.getLength()) {
                System.out.println("This track have already existed at list");
                return;
            }
        }
        this.tracks.add(t);
        System.out.println("This track have just added!");
    }

    public void removeTrack(Track t) {
        for (Track i : tracks) {
            if (t.getTitle().equals(i.getTitle()) && t.getLength() == i.getLength()) {
                this.tracks.remove(i);
                return;
            }
        }
        System.out.println("this track doesn't exist at list");

    }

    @Override
    public String toString() {
        return this.getId()+" : "+this.getTitle()+" : "+this.getCategory()+" : "+this.getCost()+" : "+this.getLength()+" : "+this.getArtist()+":"+this.getDirector()+" : "+this.getDate();
    }

    public void play() {
        for (Track i : tracks) {
            i.play();
            System.out.println("Playing Track " + i.getTitle());
        }
    }


}