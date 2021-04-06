package hust.soict.dsai.test.disc;


import hust.soict.dsai.other.wrapper;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[]args){
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("cinderella");
        wrapper jWrapper=new wrapper(jungleDVD);
        wrapper cindWrapper =new wrapper(cinderellaDVD);
        swap(jWrapper,cindWrapper);
        
        System.out.println("Jungle dvd title: "+jWrapper.tmp.getTitle() );
        System.out.println("cinderella dvd title: "+cindWrapper.tmp.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: "+jungleDVD.getTitle());   
    }
    public static void swap(wrapper o1, wrapper o2){
        DigitalVideoDisc a = o1.tmp;
        o1.tmp = o2.tmp;
        o2.tmp = a;

    }
    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle("haha");
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);

    }
}
