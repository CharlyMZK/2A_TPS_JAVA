package domain;

import java.util.ArrayList;
import java.util.List;

import animaux.Secteur;
import employes.Employe;
import magasin.StockNourriture;
import magasin.StockSouvenirs;
import visiteurs.Visiteur;

public class Zoo {
	private static Zoo instance = null;
	private int montantBanque;
	private List<Secteur> secteurs;
	private List<Employe> employes;
	private List<Visiteur> visiteurs;

	public static Zoo getInstance() {

		if (Zoo.instance == null) {

			synchronized (Zoo.class) {
				if (Zoo.instance == null) {
					Zoo.instance = new Zoo();
				}
			}
		}
		return Zoo.instance;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public void ajouterSecteur(Secteur secteur) {
		this.secteurs.add(secteur);
	}

	public void enleverSecteur(Secteur secteur) {
		this.secteurs.remove(secteur);
	}

	public void ajouterEmploye(Employe employe) {
		this.employes.add(employe);
	}

	public void enleverEmploye(Employe employe) {
		this.employes.remove(employe);
	}

	public void ajouterVisiteur(Visiteur visiteur) {
		this.visiteurs.add(visiteur);
	}

	public void enleverVisiteur(Visiteur visiteur) {
		this.visiteurs.remove(visiteur);
	}

	public static void setInstance(Zoo instance) {
		Zoo.instance = instance;
	}

	public int getMontantBanque() {
		return montantBanque;
	}

	public void setMontantBanque(int montantBanque) {
		this.montantBanque = montantBanque;
	}

	public List<Secteur> getSecteurs() {
		return secteurs;
	}

	public void setSecteurs(List<Secteur> secteurs) {
		this.secteurs = secteurs;
	}

	@Override
	public String toString() {
		return "Zoo [\n" + StockNourriture.getInstance() + "\n" + StockCroquettes.getInstance() + "\n"
				+ StockSouvenirs.getInstance() + "\nMontantBanque=" + montantBanque + "\nsecteurs=" + secteurs
				+ ",\nEmployes=" + employes + "]";
	}

	public Zoo() {
		super();
		this.secteurs = new ArrayList<Secteur>();
		this.employes = new ArrayList<Employe>();
		this.visiteurs = new ArrayList<Visiteur>();
	}

	public List<Visiteur> getVisiteurs() {
		return visiteurs;
	}

	public void setVisiteurs(List<Visiteur> visiteurs) {
		this.visiteurs = visiteurs;
	}

}
