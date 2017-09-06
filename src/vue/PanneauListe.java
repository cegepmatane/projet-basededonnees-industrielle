package vue;

import controleur.ControleurVue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class PanneauListe extends Region
{
	private ListView<PanneauItemListe> panneauListeItem;
	
	public PanneauListe()
	{
		super();
		
		ConstruirePanneau();
	}

	private void ConstruirePanneau() 
	{
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10));
		vBox.setPrefSize(400, (600-30));
		
		Button btnActionAjouterItem = new Button("Ajouter");
		btnActionAjouterItem.setPrefSize(200, 15);
		btnActionAjouterItem.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				ControleurVue.getInstance().actionAjouterItem();
			}
		});
		vBox.getChildren().add(btnActionAjouterItem);
		
		panneauListeItem = new ListView<PanneauItemListe>();
		panneauListeItem.setPrefSize(400, 600 - 30);
		construireVueListeItem();
		
		
		vBox.getChildren().add(panneauListeItem);
		this.getChildren().add(vBox);
	}
	
	private void construireVueListeItem()
	{
		panneauListeItem.getItems().add(new PanneauItemListe("Test1"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test2"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test3"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test4"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test1"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test2"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test3"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test4"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test1"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test2"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test3"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test4"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test1"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test2"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test3"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test4"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test1"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test2"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test3"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test4"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test1"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test2"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test3"));
		panneauListeItem.getItems().add(new PanneauItemListe("Test4"));
		
	}
	
	
}
