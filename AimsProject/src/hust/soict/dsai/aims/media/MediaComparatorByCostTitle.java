package hust.soict.dsai.aims.media;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MediaComparatorByCostTitle{
    public static void sort(ObservableList<Media> list){
        Collections.sort(list,Comparator.comparing(Media::getCost,Collections.reverseOrder()).thenComparing(Media::getTitle));
    }

}
