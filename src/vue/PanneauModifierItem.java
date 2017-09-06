package vue;

import controleur.ControleurVue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class PanneauModifierItem extends Region
{
	public PanneauModifierItem()
	{
		super();
		
		ConstruirePanneau();
	}

	private void ConstruirePanneau() 
	{
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Label labelTitreModifierItem = new Label("Modifier");
		
		Button btnActionRetourEnArriere = new Button("Retour");
		btnActionRetourEnArriere.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				ControleurVue.getInstance().actionRetourEnArriere();
			}
		});
		
		Button BtnActionSauvegardeeModification = new Button("Sauvegarde");
		BtnActionSauvegardeeModification.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				//TODO: a faire Sauvegarde;
			}
		});
		
		grid.add(labelTitreModifierItem, 0, 0);
		grid.add(btnActionRetourEnArriere, 0, 1);
		grid.add(BtnActionSauvegardeeModification, 2, 1);
		
		this.getChildren().add(grid);
	}
}
