package OV;

import OV.DAO.AdresDAO;
import OV.DAO.AdresDAOpsql;
import OV.DAO.ReizigerDAO;
import OV.DAO.ReizigerDAOpsql;
import OV.Domein.Adres;
import OV.Domein.Reiziger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/ovchip";
        String user = "postgres";
        String password = "";

        try {

            Class.forName("org.postgresql.Driver");


            Connection conn = DriverManager.getConnection(url, user, password);

            AdresDAO adao = new AdresDAOpsql(conn);
            ReizigerDAO rdao = new ReizigerDAOpsql(conn, adao);


            Reiziger reiziger1 = new Reiziger(1, "G", "van", "Rijn", new Date(102, 8, 17));
            Adres adres1 = new Adres(1, "3511 LX", "37", "Oudegracht", "Utrecht");
            reiziger1.setAdres(adres1);
            adres1.setReiziger(reiziger1);
            adao.save(adres1);
            rdao.save(reiziger1);

            Reiziger reiziger2 = new Reiziger(2, "B", "van", "Rijn", new Date(102, 9, 22));
            Adres adres2 = new Adres(2, "3521 AL", "6A", "Vismarkt", "Utrecht");
            reiziger2.setAdres(adres2);
            adres2.setReiziger(reiziger2);
            adao.save(adres2);
            rdao.save(reiziger2);

            Reiziger reiziger3 = new Reiziger(3, "H", "", "Lubben", new Date(98, 7, 11));
            Adres adres3 = new Adres(3, "6707 AA", "375", "Hoofdstraat", "Wageningen");
            reiziger3.setAdres(adres3);
            adres3.setReiziger(reiziger3);
            adao.save(adres3);
            rdao.save(reiziger3);

            Reiziger reiziger4 = new Reiziger(4, "F", "", "Memari", new Date(102, 11, 3));
            Adres adres4 = new Adres(4, "3817 CH", "4", "Koningstraat", "Amersfoort");
            reiziger4.setAdres(adres4);
            adres4.setReiziger(reiziger4);
            adao.save(adres4);
            rdao.save(reiziger4);

            Reiziger reiziger5 = new Reiziger(5, "G", "", "Piccardo", new Date(102, 11, 3));
            Adres adres5 = new Adres(5, "3572 WP", "22", "Maliebaan", "Utrecht");
            reiziger5.setAdres(adres5);
            adres5.setReiziger(reiziger5);
            adao.save(adres5);
            rdao.save(reiziger5);


            List<Reiziger> allReizigers = rdao.findAll();
            System.out.println("All reizigers: ");
            for (Reiziger reiziger : allReizigers) {
                System.out.println(reiziger);
            }


            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}