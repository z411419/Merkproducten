package be.oak3.UI;

import be.oak3.model.BestellingImpl;
import be.oak3.model.Product;
import be.oak3.persistence.Bestelling;
import be.oak3.persistence.Data;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUI extends JFrame {

    private Bestelling order;
    private JList<Product> lstProducts;
    private JButton btnMerk;
    private JButton btnBepaaldMerk;
    private JButton btnVolume;
    private JButton btnNormaal;
    private JButton btnDuurste;
    private JCheckBox chkParfums;
    private JButton btnGoedkoopste;
    private JTextField txtMerk;

    private JLabel lblList;

    public GUI() {
        initComponents();
        layoutComponents();
        initListeners();
    }

    public static void main(String[] args) {
        new GUI();
    }


    private void initComponents() {

        setTitle("Merkproducten");
        setSize(1000, 500);
        setLocation(100, 100);

        //Data inladen
        List<Product> artikels = Data.getData();
        //System.out.println(artikels);
        order = new BestellingImpl();
        for (Product artikel : artikels) {
            order.voegProductToe(artikel);
        }
        System.out.println(order.getBestelling().toArray());
        lstProducts = new JList<>();
        lstProducts.setListData(order.getBestelling().toArray(new Product[0]));

        //Labels
        lblList = new JLabel("Productenlijst:");
        lblList.setOpaque(true);
        lblList.setBackground(Color.DARK_GRAY);

        //Buttons
        btnMerk = new JButton("Sorteer per merk");
        btnVolume = new JButton("Sorteer op volume");
        btnNormaal = new JButton("Standaard");
        btnDuurste = new JButton("Duurste product");
        btnBepaaldMerk = new JButton("Bepaald merk");
        btnGoedkoopste = new JButton("Producten onder €50");

        // Checkbox
        chkParfums = new JCheckBox("Parfums");
        chkParfums.setSelected(false);

        //Merkveld
        txtMerk = new JTextField(15);

        setVisible(true);
    }

    private void layoutComponents() {
        //setLayout(new FlowLayout());
        JPanel southPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        add(lblList, BorderLayout.NORTH);

        //SouthPanel
        southPanel.add(btnNormaal);
        southPanel.add(btnMerk);
        southPanel.add(btnVolume);
        southPanel.add(btnGoedkoopste);
        southPanel.add(btnBepaaldMerk);
        southPanel.add(btnDuurste);
        southPanel.add(chkParfums);
        add(southPanel, BorderLayout.SOUTH);

        //Center
        centerPanel.add(lstProducts);
        centerPanel.add(txtMerk);
        add(centerPanel, FlowLayout.CENTER);


    }

    private void initListeners() {
        //sorteer
        btnNormaal.addActionListener(e -> {
            order.sorteer();
            lstProducts.setListData(order.getBestelling().toArray(new Product[0]));
        });

        //Volgens merk
        btnMerk.addActionListener(e -> {
            order.sorteerOpMerk();
            lstProducts.setListData(order.getBestelling().toArray(new Product[0]));
        });

        //Volgens volume
        btnVolume.addActionListener(e -> {
            order.sorteerOpVolume();
            lstProducts.setListData(order.getBestelling().toArray(new Product[0]));
        });

        //Goedkoopste
        btnGoedkoopste.addActionListener(e -> {
            List<Product> temp = order.lijstVanGoedkopeProducten();
            lstProducts.setListData(temp.toArray(new Product[0]));
            //btnGoedkoopste.setText("Done");
        });

        //Bepaald merk
        btnBepaaldMerk.addActionListener(e -> {

            List<Product> temp = order.lijstVanBepaaldMerk(txtMerk.getText());
            lstProducts.setListData(temp.toArray(new Product[0]));
            btnBepaaldMerk.setText(txtMerk.getText());
        });

        //Parfums
        chkParfums.addActionListener(e -> {

            if (chkParfums.isSelected()) {
                List<Product> temp = order.lijstVanParfums();
                lstProducts.setListData(temp.toArray(new Product[0]));
                chkParfums.setText("Parfums");


            } else {


                order.sorteer();
                lstProducts.setListData(order.getBestelling().toArray(new Product[0]));

                System.out.println("uit");

            }
            System.out.println("aan");

        });

        //Duurste
        btnVolume.addActionListener(e -> {
            order.zoekDuursteProduct();
            lstProducts.setListData(order.getBestelling().toArray(new Product[0]));
        });

    }


}
