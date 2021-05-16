package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));
        cp.add(new JLabel("Enter an integer: "));
        tfInput = new JTextField();
        tfInput.addActionListener(new TFInputListner());
        cp.add(tfInput);

        cp.add(new JLabel("The Accumulated Sum is: "));
        tfOutput = new JTextField();
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        setTitle("Swing Accumulator");
        setSize(350, 120);
        setVisible(true);


    }
    public static void main(String[] args){
        new SwingAccumulator();
    }
    private class TFInputListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt){
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }


    }


}

