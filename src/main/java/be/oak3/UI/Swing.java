package be.oak3.UI;

import javax.swing.*;

public class Swing extends JFrame {

    public Swing() {
        setTitle("1ste swing app");
        setSize(500, 500);
        setLocation(100, 100);
        setVisible(true);

        add(new JLabel("Hello world"));


    }

    public static void main(String[] args) {
        new Swing();
    }

}
