package controleur;

import java.sql.SQLException;

import modele.Armateur;
import modele.Modele;
import vue.VuePrincipale;

public class ControleurVue 
{
	protected static ControleurVue instance;
	private VuePrincipale vuePrincipale = null;
	private Modele modele;
	
	public ControleurVue() throws ClassNotFoundException, SQLException
	{
		modele = new Modele();
	}
	
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

	public void actionRetourEnArriere() throws SQLException 
	{
		this.vuePrincipale.construirePanneauListe();
	}

	public void actionAjouterItem() 
	{
		this.vuePrincipale.construirePanneauAjouterItem();
	}
	
	public void actionSauvegarderArmateur(Armateur armateur) throws SQLException
	{
		System.out.println("control: sauvegarde");
		modele.sauvegarderArmateur(armateur);
	}
	
	
}
