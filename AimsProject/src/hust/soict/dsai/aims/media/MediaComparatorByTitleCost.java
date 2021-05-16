package hust.soict.dsai.aims.media;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MediaComparatorByTitleCost {
    public static void sort(ObservableList<Media> list){
        Collections.sort(list,Comparator.comparing(Media::getTitle).thenComparing(Media::getCost,Collections.reverseOrder()));
    }

}
