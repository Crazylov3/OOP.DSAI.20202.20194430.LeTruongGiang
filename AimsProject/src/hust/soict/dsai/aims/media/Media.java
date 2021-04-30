package hust.soict.dsai.aims.media;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public abstract class Media {
    public static final MediaComparatorByTitleCost COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final MediaComparatorByCostTitle COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    private float cost = -1f;
    private String category = null;
    private String title = null;
    private String date;


    public Media() {
    }

    public Media(String title) {
        this.title = title;
    }

    public Media(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean equals(Object a) {
        if (a == this) {
            return true;
        }
        if (!a.getClass().equals(this.getClass())) {
            return false;
        }
        Media c = (Media) a;
        return this.getTitle().equals(c.getTitle());
    }


    public String toString() {
        return this.getTitle()+" : "+this.getCategory()+" : "+this.getCost()+" : "+this.getDate();
    }

    /* Tạo phương thức sẵn cho các lớp con
       Mục đích : để các lớp con có thể override khi upcasting ở các class aggregation
     */
    public String getId() {
        return null;
    }

    public int getLength() {
        return -1;
    }

    public void setLength(int length) {
        return;
    }

    public String getDirector() {
        return null;
    }

    public void setDirector(String director) {
        return;
    }

    public List<String> getAuthors() {
        return Collections.singletonList("");
    }

    public void setAuthors() {
        return;
    }

    public String getArtist() {
        return null;
    }

    public String setArtist() {
        return null;
    }
    public void getDetailById(){return;}
    public void play(){return;}
}


