package hust.soict.dsai.aims.media;
import java.util.List;
import java.util.ArrayList;

public class Book extends Media {
    private static int nbBook = 0;
    private String id;
    private List<String> authors = new ArrayList<String>();

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Book(List<String> authors) {
        this.id = "BK" + ++nbBook;
        this.authors = authors;
    }

    public Book(String title,List<String> authors) {
        super(title);
        this.id = "BK" + ++nbBook;
        this.authors = authors;
    }



    public Book(String category, String title, float cost, List<String> authors) throws Exception {
        super(category, title, cost);
        this.id = "BK" + ++nbBook;;
        this.authors = authors;
    }
    @Override
    public String toString() {
        return this.getId()+" : "+ this.getTitle()+" : "+this.getCategory()+" : "+this.getCost()+" : "+this.getAuthors().toString()+" : "+this.getDate();
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public List<String> getAuthors() {
        return authors;
    }


}
