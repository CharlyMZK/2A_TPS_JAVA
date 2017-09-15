package employes;

import java.util.Date;

public abstract class Employe {
	private String nom;
	private Date dateNaissance;
	private String adresse;
	private int codePostal;
	private int salaire;
	private String prenom;
	private String email;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employe(String nom, Date dateNaissance, String adresse, int codePostal, int salaire, String prenom,
			String email) {
		super();
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.salaire = salaire;
		this.prenom = prenom;
		this.email = email;
	}

	@Override
	public String toString() {
		return "\nEmploye [nom=" + nom + ", dateNaissance=" + dateNaissance + ", adresse=" + adresse + ", codePostal="
				+ codePostal + ", salaire=" + salaire + ", prenom=" + prenom + ", email=" + email + "]";
	}

}
