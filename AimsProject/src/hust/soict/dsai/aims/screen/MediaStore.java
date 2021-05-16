package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.PlayerException;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.screen.playingWindow.playingWindow;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;
    public JPanel container = new JPanel();


    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton addMedia = new JButton("Add to cart");
        addMedia.setFocusable(false);


        JButton added = new JButton("Added to cart");
        added.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(new JFrame(),"This item have already added", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        added.setFocusable(false);

        JButton button = new JButton("Play");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    media.play();
                } catch (PlayerException playerException) {
                    playerException.printStackTrace();
                }

            }
        });
        addMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JFXPanel();
                Platform.runLater(new Runnable() {
                    public void run() {
                        cart.addMedia(media);
                        container.remove(addMedia);
                        try{
                            container.remove(button);
                            container.add(added);
                            if (media instanceof Playable) {
                                MediaStore.this.container.add(button);
                            }
                        }catch(Exception e){container.add(added);}finally{container.revalidate();
                            container.repaint();}
                        JOptionPane.showMessageDialog(null, "The item is added to cart", "Message", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
            }
        });
        if (!cart.getOrdered().contains(media)) {
            this.container.add(addMedia);
        }else{this.container.add(added);}
        if (media instanceof Playable) {
            this.container.add(button);
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(this.container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
