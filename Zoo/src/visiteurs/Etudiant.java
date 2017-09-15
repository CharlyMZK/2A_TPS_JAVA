package visiteurs;

import java.util.Date;

public class Etudiant extends Visiteur{
	private boolean carteReduction;
	
	public Etudiant(int id, int codePostal, Date dateNaissance, Date dateVisite, boolean carteReduction) {
		super(id, codePostal, dateNaissance, dateVisite);
		this.carteReduction = carteReduction;
	}

	public static final int prixPaye = 10;
}
