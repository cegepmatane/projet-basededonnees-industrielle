package vue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import controleur.ControleurVue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class PanneauAjouterItem extends Region {

    private TextField nomArmateur;

    static final String DB_URL = "jdbc:mysql://localhost/portmatane";

    static final String USER = "root";
    static final String PASS = "";

    public PanneauAjouterItem() {
        super();

        ConstruirePanneau();
    }

    private void ConstruirePanneau() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label labelTitreAjouterItem = new Label("Ajouter");

        nomArmateur = new TextField();

        Button btnActionRetourEnArriere = new Button("Retour");
        btnActionRetourEnArriere.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    ControleurVue.getInstance().actionRetourEnArriere();
                } catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        Button BtnActionSauvegardeeModification = new Button("Sauvegarde");
        BtnActionSauvegardeeModification.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Supprimer ici
                Connection conn = null;
                Statement stmt = null;
                try {
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    //STEP 4: Execute a query
                    System.out.println("Creating statement...");
                    stmt = conn.createStatement();
                    String sqlAjouter;
                    sqlAjouter = "INSERT INTO `armateur` (`idArmateur`, `nom`) VALUES (NULL, '"+ nomArmateur.getText() + "');";
                    stmt.executeUpdate(sqlAjouter); //updateQuery

                    //STEP 6: Clean-up environment
                    //rs.close();
                    stmt.close();
                    conn.close();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    ControleurVue.getInstance().actionRetourEnArriere();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        grid.add(labelTitreAjouterItem, 0, 0);
        grid.add(btnActionRetourEnArriere, 0, 2);
        grid.add(BtnActionSauvegardeeModification, 2, 2);

        this.getChildren().add(grid);
        grid.add(nomArmateur,0,1);
    }
}
