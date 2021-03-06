package be.oak3.persistence;

import be.oak3.model.BestellingDAO;
import be.oak3.model.BestellingImpl;
import be.oak3.model.Parfum;
import be.oak3.model.Product;

import java.util.List;

public class TestApp {
    public static void main(String[] args) {
        System.out.printf("Oplossing van %s %s\n", "Tom Claes ",
                "Java Instructeur");

        Bestelling bestelling = new BestellingImpl();
        List<Product> lijst = Data.getData();

        for (Product artikel : lijst) {
            bestelling.voegProductToe(artikel);
        }

        System.out.println("Lijst gesorteerd op natuurlijke volgorde: ");
        bestelling.sorteer();


        System.out.println("\nLijst gesorteerd op merknaam: ");
        bestelling.sorteerOpMerk();

        System.out.println("\nLijst gesorteerd op volume: ");
        bestelling.sorteerOpVolume();

        System.out.println("\nVan het merk Georgio Armani:");
        //bestelling.toonPerMerk("Georgio Armani");

        System.out.println("\nAlle Parfums:");
        //bestelling.toonParfums();

        System.out.println("\nAlle producten onder €50; ");
        //bestelling.toonGoedkopeProducten();

        Product product = bestelling.zoekDuursteProduct();
        System.out.println("\nDuurste product:\n" + product);

        System.out.printf("\nTotale prijs: €%.2f", bestelling.totalePrijs());

        Bestelling test = new BestellingDAO();
        test.voegProductToe(new Parfum(0, "TOM", "T", 50, 57));


    }
}
