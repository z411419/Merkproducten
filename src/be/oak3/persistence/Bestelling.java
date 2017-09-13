package be.oak3.persistence;

public interface Bestelling extends Berekenbaar {
    void voegProductenToe();

    void sorteer();

    void sorteerOpMerk();

    void sorteerOpVolume();

    void toonPerMerk();

    void toonGoedkopeProducten();

    void zoekDuursteProduct();


}
