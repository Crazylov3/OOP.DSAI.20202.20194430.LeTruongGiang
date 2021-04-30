package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Aims {
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("______________________________");
        System.out.println("1. View Store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("______________________________");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options:");
        System.out.println("______________________________");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Exit");
        System.out.println("______________________________");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("______________________________");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Exit");
        System.out.println("______________________________");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Gaihad", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("iodad", "Science Fiction", "George Lucas", 87, 313f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "this is title", 313f);
        Book bk1 = new Book("Giang", Collections.singletonList("Tung, Phu"));
        CompactDisc cd = new CompactDisc("Giang", "Lala", "heheh", 313, "haida");

        store.addMedia(cd);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(bk1);

        while (true) {
            showMenu();
            String str = sc.nextLine();
            if (str.equals("1")) {

                while (true) {
                    storeMenu();

                    str = sc.nextLine();
                    if (str.equals("1")) {
                        System.out.println("Do you want to search with?");
                        System.out.println("1. Id");
                        System.out.println("2. Title");
                        System.out.println("______________________________");
                        System.out.println("0. Exit");

                        while (true) {
                            str = sc.nextLine();
                            if (str.equals("1")) {
                                System.out.print("Enter the ID: ");
                                str = sc.nextLine();
                                store.getDetailById(str);
                                Media item = store.getMediaById(str);
                                if (item instanceof CompactDisc || item instanceof DigitalVideoDisc) {
                                    System.out.print("Do you want to play? Y/N:    ");
                                    str = sc.nextLine().toUpperCase();
                                    if (str.equals("Y")) {
                                        item.play();
                                    }

                                }
                                break;
                            } else if (str.equals("2")) {
                                System.out.print("Enter the title: ");
                                str = sc.nextLine();
                                store.getDetailByTitle(str);
                                Media item = store.getMediaByTitle(str);
                                if (item instanceof CompactDisc || item instanceof DigitalVideoDisc) {
                                    System.out.print("Do you want to play? Y/N:    ");
                                    str = sc.nextLine().toUpperCase();
                                    if (str.equals("Y")) {
                                        item.play();
                                    }
                                }
                                break;
                            } else if (str.equals("0")) {
                                break;
                            }
                            System.out.println("Try again!!!");
                        }
                    } else if (str.equals("2")) {
                        store.print();

                        System.out.print("Enter the title of media:  ");
                        str = sc.nextLine();
                        Media item = store.getMediaByTitle(str);

                        cart.addMedia(item);

                    } else if (str.equals("3")) {
                        store.print();

                        System.out.print("Enter the title of media:  ");
                        str = sc.nextLine();
                        store.getDetailByTitle(str);
                        Media item = store.getMediaByTitle(str);
                        item.play();
                        System.out.println("Playing " + item.getTitle());

                    } else if (str.equals("4")) {
                        while (true) {
                            cartMenu();

                            str = sc.nextLine();
                            if (str.equals("1")) {
                                System.out.println("Do you want to filter with?");
                                System.out.println("1. Id");
                                System.out.println("2. Title");
                                System.out.println("______________________________");
                                System.out.println("0. Exit");

                                while (0 == 0) {
                                    str = sc.nextLine();
                                    if (str.equals("1")) {
                                        System.out.print("Enter the ID: ");
                                        str = sc.nextLine();
                                        store.getDetailById(str);
                                        break;
                                    } else if (str.equals("2")) {
                                        System.out.print("Enter the title: ");
                                        str = sc.nextLine();
                                        store.getDetailByTitle(str);
                                        break;
                                    } else if (str.equals("0")) {
                                        break;
                                    }
                                    System.out.println("Try again!!!");
                                }
                            } else if (str.equals("2")) {
                                if (cart.getOrdered().size() > 0) {
                                    System.out.println("Do you want to sort by?");
                                    System.out.println("1. Title");
                                    System.out.println("2. Cost");
                                    System.out.println("______________________________");
                                    System.out.println("0. Exit");

                                    while (true) {
                                        str = sc.nextLine();
                                        if (str.equals("1")) {
                                            Media.COMPARE_BY_TITLE_COST.sort(cart.getOrdered());
                                            cart.print();
                                            break;
                                        } else if (str.equals("2")) {
                                            Media.COMPARE_BY_COST_TITLE.sort(cart.getOrdered());
                                            cart.print();
                                            break;
                                        } else if (str.equals("0")) {
                                            break;
                                        }
                                        System.out.println("Try again!!!");
                                    }
                                } else {
                                    System.out.println("The cart is empty!");
                                }
                            } else if (str.equals("3")) {
                                cart.print();
                                System.out.print("Enter the ID of media you want to remove:  ");
                                str = sc.nextLine();
                                store.getDetailById(str);
                                Media item = store.getMediaById(str);
                                cart.removeMedia(item);
                                break;
                            } else if (str.equals("4")) {
                                cart.print();
                                System.out.print("Enter the ID of media you want to play:  ");
                                str = sc.nextLine();
                                store.getDetailById(str);
                                Media item = store.getMediaById(str);
                                if (item == null) {
                                    System.out.println("The Media doesn't exist");
                                    break;
                                }
                                item.play();
                                System.out.println("Playing" + item.getTitle());
                                break;

                            } else if (str.equals("5")) {
                                if (cart.getOrdered().size() > 0) {
                                    System.out.println("You need to pay " + cart.totalCost() + "$ to completed this operation");
                                    System.out.print("Do you want to continue: Y/N  :");
                                    str = sc.nextLine().toUpperCase();
                                    if (str.equals("Y")) {
                                        System.out.println("Done");
                                        cart.getOrdered().clear();
                                        System.out.println("The cart is empty");

                                    } else {
                                        System.out.println("Cancel the placing order");
                                    }
                                    break;
                                } else {
                                    System.out.println("You have not ordered any item yet!");
                                }

                            } else if (str.equals("0")) {
                                break;
                            }
                        }
                    } else if (str.equals("0")) {
                        break;
                    }
                }
            }
            else if (str.equals("2")) {
                while (true) {
                    System.out.println("1. Add a new media.");
                    System.out.println("2. Remove a media.");
                    System.out.println("0. Exit.");

                    str = sc.nextLine();
                    if (str.equals("1")) {
                        System.out.println("What kind of media do you want to add.");
                        System.out.println("1. DVD");
                        System.out.println("2. CD");
                        System.out.println("3. Book");
                        str = sc.nextLine();

                        if (str.equals("1")) {
                            System.out.print("Title: ");
                            String title = sc.nextLine();
                            System.out.println();

                            System.out.print("Category: ");
                            String Category = sc.nextLine();
                            System.out.println();

                            System.out.print("Cost: ");
                            Float Cost = sc.nextFloat();
                            System.out.println();

                            System.out.print("Length: ");
                            int Length = sc.nextInt();
                            System.out.println();

                            System.out.print("Director: ");
                            String Director = sc.nextLine();
                            System.out.println();
                            DigitalVideoDisc item = new DigitalVideoDisc(title, Category, Director, Length, Cost);
                            store.addMedia(item);
                        } else if (str.equals("2")) {
                            System.out.print("Title: ");
                            String title = sc.nextLine();
                            System.out.println();

                            System.out.print("Category: ");
                            String Category = sc.nextLine();
                            System.out.println();

                            System.out.print("Cost: ");
                            Float Cost = sc.nextFloat();
                            System.out.println();

                            System.out.print("Artist: ");
                            String Artist = sc.nextLine();
                            System.out.println();

                            System.out.print("Director: ");
                            String Director = sc.nextLine();
                            System.out.println();
                            CompactDisc item = new CompactDisc(title, Category, Director, Cost, Artist);
                            store.addMedia(item);

                        } else if (str.equals("3")) {
                            System.out.print("Title: ");
                            String title = sc.nextLine();
                            System.out.println();

                            System.out.print("Category: ");
                            String Category = sc.nextLine();
                            System.out.println();

                            System.out.print("Cost: ");
                            Float Cost = sc.nextFloat();
                            System.out.println();

                            System.out.print("Enter number of author: ");
                            int n = sc.nextInt();
                            ArrayList<String> author = new ArrayList<String>();
                            for (int i = 0; i < n; i++) {
                                System.out.print("Name of Author " + i + " :");
                                author.add(sc.nextLine());

                            }
                            Book item = new Book(Category, title, Cost, author);
                            store.addMedia(item);

                        }
                    } else if (str.equals("2")) {
                        System.out.print("Enter the title of media: ");
                        str = sc.nextLine();
                        store.removeMedia(store.getMediaByTitle(str));
                    } else if (str.equals("0")) {
                        break;
                    }

                }
            }
            else if (str.equals("3")){
                cart.print();
            }
            else if (str.equals("0")){
                break;
            }

        }
    }
}
