package animaux;

import java.util.Date;

public class Fillippinne extends Animal {
	private int nombreDents;

	public Fillippinne(Date dateNaissance, String nom, int poids, int taille, int rationJournaliere, char sexe,
			int nombreDents) {
		super(dateNaissance, nom, poids, taille, rationJournaliere, sexe);
		this.nombreDents = nombreDents;
	}

	@Override
	public String toString() {
		return "Fillippinne [nombreDents=" + nombreDents + "]";
	}

}
