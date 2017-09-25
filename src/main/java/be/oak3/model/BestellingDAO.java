package be.oak3.model;

import be.oak3.persistence.Bestelling;
import com.google.common.collect.Lists;

import java.sql.*;
import java.util.List;

import static be.oak3.connection.jdbcConnection.getConnection;
import static be.oak3.model.AfterShave.Soort;
import static be.oak3.model.Deodorant.DeoType;

public class BestellingDAO implements Bestelling {

    private List<Product> bestelling = Lists.newArrayList();

    public BestellingDAO() {
        String sql = "select * from producten";
        addToList(sql);
    }

    private void addToList(String sql) {
        bestelling.clear();
        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int productNummer = rs.getInt("ProductNr");
                String merk = rs.getString("Merk");
                String naam = rs.getString("naam");
                int volume = rs.getInt("volume");
                double prijs = rs.getDouble("prijs");
                int soortId = rs.getInt("soortId");
                int typeId = rs.getInt("typeId");

                Product p;
                switch (soortId) {
                    case 1:
                        p = new Parfum(productNummer, merk, naam, volume, prijs);
                        bestelling.add(p);
                        break;
                    case 2:
                        DeoType type;
                        type = typeId == 1 ? DeoType.VAPO : DeoType.STICK;

                        p = new Deodorant(productNummer, merk, naam, volume, prijs, type);
                        bestelling.add(p);
                        break;
                    case 3:
                        Soort soort;
                        soort = typeId == 1 ? Soort.VAPO : Soort.GEL;
                        p = new AfterShave(productNummer, merk, naam, volume, prijs, soort);
                        bestelling.add(p);
                        break;

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getBestelling() {

        return bestelling;
    }

    @Override
    public void voegProductToe(Product product) {

        int soort = 1;
        Integer type = null;

        if (product instanceof Deodorant) {
            Deodorant p = (Deodorant) product;
            soort = 2;
            type = p.getSoort().ordinal();
            System.out.println(type);
        } else if (product instanceof AfterShave) {
            AfterShave p = (AfterShave) product;
            soort = 3;
            type = p.getSoort().ordinal();
        } else {

            Parfum p = (Parfum) product;
        }
        String merk = product.getMerk();
        String naam = product.getNaam();
        int volume = product.getVolume();
        double prijs = product.getPrijs();
        String code = product.getProductCode();


        String sql = "insert into producten values (null,?,?,?,?,?,?,?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, merk);
            stmt.setString(2, naam);
            stmt.setInt(3, volume);
            stmt.setDouble(4, prijs);
            stmt.setString(5, code);
            stmt.setInt(6, soort);

            if (type != null) {
                stmt.setInt(7, type);
            } else stmt.setNull(7, Types.INTEGER);
            System.out.println(stmt);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sorteer() {
        String sql = "Select * from producten order by ProductNr";
        addToList(sql);
    }

    @Override
    public void sorteerOpMerk() {
        String sql = "Select * from producten order by Merk";
        addToList(sql);
    }

    @Override
    public void sorteerOpVolume() {
        String sql = "Select * from producten order by Volume";
        addToList(sql);
    }

    @Override
    public Product zoekDuursteProduct() {
        String sql = "SELECT *, max(prijs) FROM producten";
        addToList(sql);
        return bestelling.get(0);
    }

    @Override
    public Double totalePrijs() {
        String sql = "SELECT sum(prijs) FROM producten";
        double result = 0;

        try (Connection con = getConnection(); Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                result = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;

    }

    @Override
    public List<Product> lijstVanBepaaldMerk(String merk) {
        String sql = "SELECT * FROM producten where Merk = '" + merk + "'";
        addToList(sql);
        return bestelling;
    }

    @Override
    public List<Product> lijstVanParfums() {
        String sql = "SELECT * FROM producten where soortId = 1";
        addToList(sql);
        return bestelling;
    }

    @Override
    public List<Product> lijstVanGoedkopeProducten() {
        String sql = "SELECT * FROM producten where prijs < 50";
        addToList(sql);
        return bestelling;
    }

}
