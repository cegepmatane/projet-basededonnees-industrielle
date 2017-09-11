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
import modele.Armateur;
import modele.ArmateurDAO;

public class PanneauAjouterItem extends Region {

    private TextField nomArmateur;

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
                try {
                    ArmateurDAO.getInstance().ajouterArmateur(nomArmateur.getText());
                    ControleurVue.getInstance().actionRetourEnArriere();
                } catch (ClassNotFoundException | SQLException e) {
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
