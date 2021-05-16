package hust.soict.dsai.aims;

import javax.swing.*;

public class CostException extends Exception{
    public CostException(){
        super();
        JOptionPane.showMessageDialog(new JFrame(), "Negative Cost Is Provided", "ERROR",
                JOptionPane.ERROR_MESSAGE);
    }
}
