package animaux;

import java.util.ArrayList;
import java.util.List;

import magasin.Magasin;

public class Secteur {
	private int codeSecteur;
	List<Enclos> listeEnclos;
	List<Magasin> listeMagasin;

	public int getCodeSecteur() {
		return codeSecteur;
	}

	public void setCodeSecteur(int codeSecteur) {
		this.codeSecteur = codeSecteur;
	}

	public List<Enclos> getListeEnclos() {
		return listeEnclos;
	}

	public void setListeEnclos(List<Enclos> listeEnclos) {
		this.listeEnclos = listeEnclos;
	}

	public void ajouterEnclos(Enclos enclos) {
		this.listeEnclos.add(enclos);
	}

	public void enleverEnclos(Enclos enclos) {
		this.listeEnclos.remove(enclos);
	}

	public Secteur(int codeSecteur) {
		super();
		this.codeSecteur = codeSecteur;
		this.listeEnclos = new ArrayList<Enclos>();
		this.listeMagasin = new ArrayList<Magasin>();
	}

	@Override
	public String toString() {
		return "\n	-	Secteur [codeSecteur=" + codeSecteur + ", listeEnclos=" + listeEnclos
				+ " \n					listeMagasins : " + listeMagasin + "]";
	}

	public void ajouterMagasin(Magasin magasin) {
		this.listeMagasin.add(magasin);
	}

	public void enleverMagasin(Enclos magasin) {
		this.listeMagasin.remove(magasin);
	}

	public List<Magasin> getListeMagasin() {
		return listeMagasin;
	}

	public void setListeMagasin(List<Magasin> listeMagasin) {
		this.listeMagasin = listeMagasin;
	}

}
