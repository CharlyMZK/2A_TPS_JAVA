package employes;

import java.util.Date;

public class Gerant extends Employe {
	@Override
	public String toString() {
		return "\n	-	Gerant []";
	}

	public Gerant(String nom, Date dateNaissance, String adresse, int codePostal, int salaire, String prenom,
			String email) {
		super(nom, dateNaissance, adresse, codePostal, salaire, prenom, email);
	}

}
