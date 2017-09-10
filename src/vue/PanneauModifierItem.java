package vue;

import java.sql.SQLException;

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
import modele.Modele;

public class PanneauModifierItem extends Region
{
	Armateur armateur;
	
	TextField nomArmateur = new TextField();
	
	public PanneauModifierItem(Armateur armateur)
	{
		super();
		this.armateur = armateur;
		ConstruirePanneau();
	}

	private void ConstruirePanneau() 
	{
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		this.nomArmateur.setText(armateur.getNom());
		
		Label labelTitreModifierItem = new Label("Modifier");
		
		Button btnActionRetourEnArriere = new Button("Retour");
		btnActionRetourEnArriere.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				try {
					ControleurVue.getInstance().actionRetourEnArriere();
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Button BtnActionSauvegardeeModification = new Button("Sauvegarde");
		BtnActionSauvegardeeModification.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				//set de l'armateur
				armateur.setNom(nomArmateur.getText());
				
				//TODO: a faire Sauvegarde;
				System.out.println(armateur.getIdArmateur() + " Sauvegarder");
				try {
					ControleurVue.getInstance().actionSauvegarderArmateur(armateur);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		grid.add(labelTitreModifierItem, 0, 0);
		grid.add(btnActionRetourEnArriere, 0, 1);
		grid.add(BtnActionSauvegardeeModification, 2, 1);
		
		addTextField(grid, nomArmateur, "Nom : ", 0, 2);
		
		this.getChildren().add(grid);
	}
	
	
    private void addTextField(GridPane grid, TextField textField,String texteLabel, int colonne, int ligne){
        grid.add(new Label(texteLabel), colonne, ligne);
        grid.add(textField, colonne+1, ligne);
    }
}
