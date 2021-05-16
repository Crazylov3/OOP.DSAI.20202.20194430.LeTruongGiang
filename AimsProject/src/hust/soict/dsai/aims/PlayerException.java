package hust.soict.dsai.aims;

import javax.swing.*;

public class PlayerException extends Exception{
    public PlayerException(String message,String title){
        super();
        JOptionPane.showMessageDialog(new JFrame(), message, title,
                JOptionPane.ERROR_MESSAGE);
    }
}
