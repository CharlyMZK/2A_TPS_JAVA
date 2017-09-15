package visiteurs;

import java.util.Date;

import animaux.Secteur;

public abstract class Visiteur {
	private int id;
	private int codePostal;
	private Date dateNaissance;
	private Date dateVisite;
	private Secteur secteur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Date getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}

	public Visiteur(int id, int codePostal, Date dateNaissance, Date dateVisite) {
		super();
		this.id = id;
		this.codePostal = codePostal;
		this.dateNaissance = dateNaissance;
		this.dateVisite = dateVisite;
	}

}
