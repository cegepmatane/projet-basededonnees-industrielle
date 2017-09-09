package vue;

import java.sql.*;
import java.util.List;

import controleur.ControleurVue;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modele.Armateur;

public class VuePrincipale extends Application
{
	private PanneauHeader panneauHeader;
	private PanneauListe panneauListe;
	private PanneauModifierItem panneauModifierItem;
	private BorderPane panneauPrincipale;
	private PanneauAjouterItem panneauAjouterItem;
	private Connection conn;
	
	
	
	public VuePrincipale(Connection conn2)
	{
		this.conn = conn2;
	}
	
	@Override
	public void start(Stage scenePrincipale) throws SQLException
	{
		ControleurVue.getInstance().setVuePrincipale(this);
		
		panneauHeader = new PanneauHeader();
		panneauListe = new PanneauListe(this.construireListeArmateur());
		
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
	
	@SuppressWarnings("null")
	public List<Armateur> construireListeArmateur() throws SQLException
	{
		System.out.println("Creating statement...");
	      Statement stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT idArmateur, nom FROM armateur";
	      ResultSet rs = stmt.executeQuery(sql);
	      List<Armateur> listeArmateur = null;
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         int idArmateur  = rs.getInt("idArmateur");
	         String nom = rs.getString("nom");
	         
	         Armateur armateur = new Armateur();
	         armateur.setIdArmateur(idArmateur);
	         armateur.setNom(nom);
	         
	         listeArmateur.add(armateur);
	      }
		
		
		return listeArmateur;
		
	}
	
	public void construirePanneauModifierListe()
	{
		panneauModifierItem = new PanneauModifierItem();
		
		panneauPrincipale.setCenter(panneauModifierItem);
	}

	public void construirePanneauListe() throws SQLException 
	{
		panneauListe = new PanneauListe(this.construireListeArmateur());
		
		panneauPrincipale.setCenter(panneauListe);
	}

	public void construirePanneauAjouterItem() 
	{
		panneauAjouterItem = new PanneauAjouterItem();
		
		panneauPrincipale.setCenter(panneauAjouterItem);
	}

}
