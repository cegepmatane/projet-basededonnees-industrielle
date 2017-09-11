package vue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import controleur.ControleurVue;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modele.Armateur;
import modele.ArmateurDAO;

public class VuePrincipale extends Application
{
	private PanneauHeader panneauHeader;
	private PanneauListe panneauListe;
	private PanneauModifierItem panneauModifierItem;
	private PanneauSupprimerItem panneauSupprimerItem;
	private BorderPane panneauPrincipale;
	private PanneauAjouterItem panneauAjouterItem;
	
	
	
	@Override
	public void start(Stage scenePrincipale) throws SQLException, ClassNotFoundException
	{
		ControleurVue.getInstance().setVuePrincipale(this);
		
		panneauHeader = new PanneauHeader();
		panneauListe = new PanneauListe(ArmateurDAO.getInstance().recupererListeArmateur());
		
		panneauPrincipale = new BorderPane();
		
		Scene scene = new Scene(panneauPrincipale, 400, 600);
		
		panneauHeader.setPrefSize(scene.getWidth(), 30);
		panneauHeader.setStyle("-fx-background-color: #40A497");
		panneauListe.setPrefSize(scene.getWidth(), (scene.getHeight() - 30));
		panneauListe.setStyle("-fx-background-color: #279385");
		
		panneauPrincipale.setPrefSize(scene.getWidth(), scene.getHeight());
		panneauPrincipale.setTop(panneauHeader);
		panneauPrincipale.setCenter(panneauListe);
		
		scenePrincipale.setScene(scene);
		scenePrincipale.show();
	}
	
	public void construirePanneauModifierListe(Armateur armateur)
	{
		panneauModifierItem = new PanneauModifierItem(armateur);
		
		panneauPrincipale.setCenter(panneauModifierItem);
	}

	public void construirePanneauSupprimerItem(int id){
		panneauSupprimerItem = new PanneauSupprimerItem(id);

		panneauPrincipale.setCenter(panneauSupprimerItem);
	}

	public void construirePanneauListe(){
		panneauListe = new PanneauListe(ArmateurDAO.getInstance().recupererListeArmateur());
		
		panneauPrincipale.setCenter(panneauListe);
	}

	public void construirePanneauAjouterItem() 
	{
		panneauAjouterItem = new PanneauAjouterItem();
		
		panneauPrincipale.setCenter(panneauAjouterItem);
	}

}
