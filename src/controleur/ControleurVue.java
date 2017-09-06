package controleur;

import vue.VuePrincipale;

public class ControleurVue 
{
	protected static ControleurVue instance;
	private VuePrincipale vuePrincipale = null;
	
	public static ControleurVue getInstance()
	{
		if(instance == null) instance = new ControleurVue();
		return instance;
	}
	
	public void setVuePrincipale(VuePrincipale vuePrincipale)
	{
		this.vuePrincipale = vuePrincipale;
	}

	public void actionModifierItem() 
	{
		this.vuePrincipale.construirePanneauModifierListe();
	}

	public void actionRetourEnArriere() 
	{
		this.vuePrincipale.construirePanneauListe();
	}

	public void actionAjouterItem() 
	{
		this.vuePrincipale.construirePanneauAjouterItem();
	}
	
	
}
