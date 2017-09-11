package modele;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArmateurDAO {
    private static ArmateurDAO instance;

    public static ArmateurDAO getInstance(){
        if (instance == null) instance = new ArmateurDAO();
        return instance;
    }

    private Connection conn;
    static final String DB_URL = "jdbc:mysql://localhost/matane_port";

    static final String USER = "root";
    static final String PASS = "";

    public ArmateurDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Armateur> recupererListeArmateur(){
        List<Armateur> listeArmateur = new ArrayList<>();

        try{
            System.out.println("Creating statement...");
            Statement stmt = conn.createStatement();
            String sql = "SELECT idArmateur, nom FROM armateur";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int idArmateur = rs.getInt("idArmateur");
                String nom = rs.getString("nom");

                Armateur armateur = new Armateur(idArmateur, nom);

                listeArmateur.add(armateur);
            }

            stmt.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return listeArmateur;
    }

    public void supprimerArmateur(int id){
        try{
            Statement stmt = conn.createStatement();
            String sqlSupprimer = "DELETE FROM armateur WHERE idArmateur = " + id;
            stmt.executeUpdate(sqlSupprimer); //updateQuery
            stmt.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void modifierArmateur(Armateur armateur)
    {
        try{
            Statement stmt = conn.createStatement();
            String sql = "UPDATE `armateur` SET `nom`= \"" + armateur.getNom() + "\" WHERE `idArmateur` = " + armateur.getIdArmateur();
            stmt.executeUpdate(sql);
            stmt.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void ajouterArmateur(String nomArmateur){
        try{
            Statement stmt = conn.createStatement();
            String sqlAjouter = "INSERT INTO `armateur` (`idArmateur`, `nom`) VALUES (NULL, '"+ nomArmateur + "');";
            stmt.executeUpdate(sqlAjouter); //updateQuery
            stmt.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
