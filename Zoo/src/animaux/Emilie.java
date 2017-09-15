package animaux;

import java.util.Date;

public class Emilie extends Animal {
	private int nombrePoils;

	public Emilie(Date dateNaissance, String nom, int poids, int taille, int rationJournaliere, char sexe,
			int nombrePoils) {
		super(dateNaissance, nom, poids, taille, rationJournaliere, sexe);
		this.nombrePoils = nombrePoils;
	}

	@Override
	public String toString() {
		return "Emilie [nombrePoils=" + nombrePoils + "]";
	}

}
