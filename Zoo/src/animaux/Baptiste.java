package animaux;

import java.util.Date;

public class Baptiste extends Animal {
	private int nombreCheveux;

	public Baptiste(Date dateNaissance, String nom, int poids, int taille, int rationJournaliere, char sexe,
			int nombreCheveux) {
		super(dateNaissance, nom, poids, taille, rationJournaliere, sexe);
		this.nombreCheveux = nombreCheveux;
	}

	@Override
	public String toString() {
		return "Baptiste [nombreCheveux=" + nombreCheveux + "]";
	}

}
