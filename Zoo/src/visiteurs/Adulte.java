package visiteurs;

import java.util.Date;

public class Adulte extends Visiteur {
	private boolean carteMembre;
	
	public Adulte(int id, int codePostal, Date dateNaissance, Date dateVisite, boolean carteMembre) {
		super(id, codePostal, dateNaissance, dateVisite);
		this.carteMembre = carteMembre;
	}

	public static final int prixPaye = 15;
}
