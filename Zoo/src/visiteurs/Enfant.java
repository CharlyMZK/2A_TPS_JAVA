package visiteurs;

import java.util.Date;

public class Enfant extends Visiteur{
	

	public Enfant(int id, int codePostal, Date dateNaissance, Date dateVisite) {
		super(id, codePostal, dateNaissance, dateVisite);
	}

	public static final int prixPaye = 10;
	
}
