package vue;

import java.sql.SQLException;

import controleur.ControleurVue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import modele.Armateur;

public class PanneauItemListe extends Region
{
	private HBox itemBoite;
	private String nomItem;
	
	public PanneauItemListe(Armateur armateur)
	{
		super();
		this.nomItem = armateur.getNom();
		
		ConstruirePanneau(armateur);
	}

	private void ConstruirePanneau(Armateur armateur) 
	{
		itemBoite = new HBox();
		
		Label label = new Label(this.nomItem);
		itemBoite.getChildren().add(label);
		
		Button btnActionModifier = new Button("Modifier");
		btnActionModifier.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				try {
					ControleurVue.getInstance().actionModifierItem(armateur);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		itemBoite.getChildren().add(btnActionModifier);

		Button btnActionSupprimer = new Button("Supprimer");
		btnActionSupprimer.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				try {
					ControleurVue.getInstance().actionSupprimerItem(armateur.getIdArmateur());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		itemBoite.getChildren().add(btnActionSupprimer);
		
		this.getChildren().add(itemBoite);
	}

}
