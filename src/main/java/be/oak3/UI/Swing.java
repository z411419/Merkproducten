package be.oak3.UI;

import be.oak3.model.Product;
import be.oak3.persistence.Data;

import javax.swing.*;
import java.awt.*;

public class Swing extends JFrame {

    private JLabel lblTitel, lblResultaatInvoer, lblResultaatButton;
    //    private JTextField txtInvoer;
    private JList<Product> lstProducten;
    private JButton btnResultaat;

    public Swing() {

        initComponents();
        layoutComponents();
        initListeners();

        //add(new JLabel("Hello world"), BorderLayout.NORTH);
    }

    private void initComponents() {

        setTitle("1ste swing app");
        setSize(500, 500);
        setLocation(100, 100);

        lblTitel = new JLabel("Swing applicatie");

//        txtInvoer = new JTextField(5);
//        txtInvoer.setBackground(Color.GRAY);
        lstProducten = new JList<>();
        lstProducten.setListData(Data.artikels);
        btnResultaat = new JButton("Doe iets");

        lblResultaatButton = new JLabel();
        lblResultaatInvoer = new JLabel();


        setVisible(true);

    }

    private void layoutComponents() {
        //setLayout(new FlowLayout());
        JPanel southPanel = new JPanel();

        add(lblTitel, BorderLayout.NORTH);
        add(lstProducten, BorderLayout.CENTER);


        southPanel.add(btnResultaat);
        southPanel.add(lblResultaatButton);
        southPanel.add(lblResultaatInvoer);
        add(southPanel, BorderLayout.SOUTH);


    }

    private void initListeners() {
        btnResultaat.addActionListener(e -> {
            lblResultaatButton.setText("Gewijzigde tekst");
            lblResultaatInvoer.setText(lstProducten.getToolTipText());
            lblResultaatButton.setOpaque(true);
            lblResultaatButton.setBackground(Color.green);
        });
    }

    public static void main(String[] args) {
        new Swing();
    }

}
