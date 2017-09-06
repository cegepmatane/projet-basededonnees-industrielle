package vue;

import controleur.ControleurVue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class PanneauItemListe extends Region
{
    private HBox itemBoite;
    private String nomItem;

    public PanneauItemListe(String nomItem)
    {
        super();
        this.nomItem = nomItem;

        ConstruirePanneau();
    }

    private void ConstruirePanneau()
    {
        itemBoite = new HBox();
        itemBoite.setSpacing(15);

        Label label = new Label(this.nomItem);
        itemBoite.getChildren().add(label);

        Button btnActionModifier = new Button("Modifier");
        btnActionModifier.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                ControleurVue.getInstance().actionModifierItem();
            }
        });
        itemBoite.getChildren().add(btnActionModifier);


        //Bouton pour supprimer un bateau contenue dans la liste
        Button btnActionSupprimer = new Button("Supprimer");
        btnActionSupprimer.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                ControleurVue.getInstance().actionSupprimerItem();
            }
        });
        itemBoite.getChildren().add(btnActionSupprimer);

        this.getChildren().add(itemBoite);
    }

}