package animaux;

import java.util.Date;

public class Quentin extends Animal {

	private String maladie;

	public Quentin(Date dateNaissance, String nom, int poids, int taille, int rationJournaliere, char sexe,
			String maladie) {
		super(dateNaissance, nom, poids, taille, rationJournaliere, sexe);
		this.maladie = maladie;
	}

	@Override
	public String toString() {
		return "Quentin [maladie=" + maladie + "]";
	}

}
