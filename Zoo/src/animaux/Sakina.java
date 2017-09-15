package animaux;

import java.util.Date;

public class Sakina extends Animal {

	private int nombreGriffes;

	public Sakina(Date dateNaissance, String nom, int poids, int taille, int rationJournaliere, char sexe,
			int nombreGriffes) {
		super(dateNaissance, nom, poids, taille, rationJournaliere, sexe);
		this.nombreGriffes = nombreGriffes;
	}

	@Override
	public String toString() {
		return "Sakina [nombreGriffes=" + nombreGriffes + "]";
	}

}
