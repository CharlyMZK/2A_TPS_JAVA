package animaux;

import java.util.Date;

public abstract class Animal {
	private Date dateNaissance;
	private String nom;
	private int poids;
	private int taille;
	private int rationJournaliere;
	private char sexe;

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getRationJournaliere() {
		return rationJournaliere;
	}

	public void setRationJournaliere(int rationJournaliere) {
		this.rationJournaliere = rationJournaliere;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public Animal(Date dateNaissance, String nom, int poids, int taille, int rationJournaliere, char sexe) {
		super();
		this.dateNaissance = dateNaissance;
		this.nom = nom;
		this.poids = poids;
		this.taille = taille;
		this.rationJournaliere = rationJournaliere;
		this.sexe = sexe;
	}

	@Override
	public String toString() {
		return "\n			-	Animal [dateNaissance=" + dateNaissance + ", nom=" + nom + ", poids=" + poids
				+ ", taille=" + taille + ", rationJournaliere=" + rationJournaliere + ", sexe=" + sexe + " ("
				+ this.getClass().getName() + ") ]";
	}

}
