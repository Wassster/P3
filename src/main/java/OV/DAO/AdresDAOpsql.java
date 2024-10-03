package OV.DAO;

import OV.Domein.Adres;
import OV.Domein.Reiziger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdresDAOpsql implements AdresDAO {

    private Connection con;


    public AdresDAOpsql(Connection con) {
        this.con = con;

    }

    @Override
    public boolean save(Adres adres) {
        try{
            String qeury = "INSERT INTO adres (adres_id , postcode, huisnummer, straat, woonplaats, reiziger_id) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(qeury);
            ps.setInt(1,adres.getId());
            ps.setString(2, adres.getPostcode());
            ps.setString(3, adres.getHuisnummer());
            ps.setString(4, adres.getStraat());
            ps.setString(5, adres.getWoonplaats());
            ps.setInt(6,adres.getReiziger().getId());
            ps.executeUpdate();
            return true;


        } catch (SQLException e) {
            return false;

        }
    }

    @Override
    public boolean update(Adres adres) {
        try {
            String query = "UPDATE adres SET postcode = ?, huisnummer = ?, straat = ?, woonplaats = ?,reiziger_id = ? WHERE adres_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(6,adres.getId());
            ps.setString(1, adres.getPostcode());
            ps.setString(2, adres.getHuisnummer());
            ps.setString(3, adres.getStraat());
            ps.setString(4, adres.getWoonplaats());
            ps.setInt(5,adres.getReiziger().getId());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean delete(Adres adres) {
        try{
            String query = "DELETE FROM adres WHERE adres_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,adres.getId());
            ps.executeUpdate();
            return true;
        }catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Adres findById(int id) {
        return null;
    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) {
        List<Adres> adres;
        try {
            String query = "SELECT * FROM adres WHERE reiziger_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, reiziger.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Adres(
                        rs.getInt("adres_id"),
                        rs.getString("postcode"),
                        rs.getString("huisnummer"),
                        rs.getString("straat"),
                        rs.getString("woonplaats")
                );

            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    @Override
    public List<Adres> findAll() {
        List<Adres> adressen = new ArrayList<>();
        try {
            String query = "SELECT * FROM adres";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Adres adress = new Adres(
                        rs.getInt("adres_id"),
                        rs.getString("postcode"),
                        rs.getString("huisnummer"),
                        rs.getString("straat"),
                        rs.getString("woonplaats")
                );
                adressen.add(adress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adressen;
}}
