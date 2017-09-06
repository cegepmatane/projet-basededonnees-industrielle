package vue;

import controleur.ControleurVue;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VuePrincipale extends Application
{
	private PanneauHeader panneauHeader;
	private PanneauListe panneauListe;
	private PanneauModifierItem panneauModifierItem;
	private BorderPane panneauPrincipale;
	private PanneauAjouterItem panneauAjouterItem;
	
	@Override
	public void start(Stage scenePrincipale)
	{
		ControleurVue.getInstance().setVuePrincipale(this);
		
		panneauHeader = new PanneauHeader();
		panneauListe = new PanneauListe();
		
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
	
	public void construirePanneauModifierListe()
	{
		panneauModifierItem = new PanneauModifierItem();
		
		panneauPrincipale.setCenter(panneauModifierItem);
	}

	public void construirePanneauListe() 
	{
		panneauListe = new PanneauListe();
		
		panneauPrincipale.setCenter(panneauListe);
	}

	public void construirePanneauAjouterItem() 
	{
		panneauAjouterItem = new PanneauAjouterItem();
		
		panneauPrincipale.setCenter(panneauAjouterItem);
	}

}
