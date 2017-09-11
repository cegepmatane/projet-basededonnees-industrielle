package controleur;

import java.sql.SQLException;

import modele.Armateur;
import vue.VuePrincipale;

public class ControleurVue 
{
	protected static ControleurVue instance;
	private VuePrincipale vuePrincipale = null;
	
	public ControleurVue() {}
	
	public static ControleurVue getInstance() throws ClassNotFoundException, SQLException
	{
		if(instance == null) instance = new ControleurVue();
		return instance;
	}
	
	public void setVuePrincipale(VuePrincipale vuePrincipale)
	{
		this.vuePrincipale = vuePrincipale;
	}

	public void actionModifierItem(Armateur armateur) 
	{
		System.out.println(armateur.getIdArmateur());
		this.vuePrincipale.construirePanneauModifierListe(armateur);
	}

	public void actionSupprimerItem(int id){
		this.vuePrincipale.construirePanneauSupprimerItem(id);
	}

	public void actionRetourEnArriere() throws SQLException 
	{
		this.vuePrincipale.construirePanneauListe();
	}

	public void actionAjouterItem() 
	{
		this.vuePrincipale.construirePanneauAjouterItem();
	}
	
}
