package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.screen.addCDs.addcd;
import hust.soict.dsai.aims.screen.addbooks.addbook;
import hust.soict.dsai.aims.screen.adddvds.adddvd;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StoreScreen extends JFrame {
    public Store store;
    public Cart cart;
    private JScrollPane centerContainer;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        north.add(createMenuBar());

        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCd = new JMenuItem("Add CD");
        JMenuItem addDvd = new JMenuItem("Add DVD");
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addbook(store, cart);
            }
        });
        
        addCd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new addcd(store,cart);
            }
        });
        addDvd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){new adddvd(store,cart);}
        });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCd);
        smUpdateStore.add(addDvd);
        menu.add(smUpdateStore);


        JMenuItem smViewCart = new JMenuItem("View Cart");

        smViewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(store, cart);
                dispose();
            }
        });
        JMenuItem smViewStore = new JMenuItem("View Store");
        menu.add(smViewCart);
        menu.add(smViewStore);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new

                FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);


        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 25));
        title.setForeground(Color.CYAN);

        JButton vcart = new JButton("View cart");
        vcart.setFocusable(false);
        vcart.setPreferredSize(new Dimension(90, 25));
        vcart.setMaximumSize(new Dimension(100, 50));
        vcart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new CartScreen(store, cart);
                dispose();
            }
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(vcart);
        header.add(Box.createRigidArea((new Dimension(10, 10))));

        return header;
    }

    JScrollPane createCenter() {

        GridLayout grid = new GridLayout(0, 3, 2, 2);
        JPanel center = new JPanel(grid);
        List<Media> mediaInStore = store.getItemInStore();
//        int max;
//        if (mediaInStore.size() < 9) {
//            max = mediaInStore.size();
//        } else {
//            max = 9;
//        }
        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), this.cart);
            center.add(cell);
        }
        centerContainer = new JScrollPane(center,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return centerContainer;

    }

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        add(createNorth(), BorderLayout.NORTH);
        add(createCenter(), BorderLayout.CENTER);
        pack();
        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }
}

