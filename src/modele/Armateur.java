package modele;

public class Armateur 
{
	public int idArmateur;
	public String nom;

	public Armateur(){

	}

	public Armateur(int idArmateur, String nom) {
		this.idArmateur = idArmateur;
		this.nom = nom;
	}

	public int getIdArmateur() {
		return idArmateur;
	}
	public void setIdArmateur(int idArmateur) {
		this.idArmateur = idArmateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
