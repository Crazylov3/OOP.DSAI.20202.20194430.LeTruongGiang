package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MediaComparatorByCostTitle{
    public static void sort(ArrayList<Media> list){
        Collections.sort(list,Comparator.comparing(Media::getCost,Collections.reverseOrder()).thenComparing(Media::getTitle));
    }

}
