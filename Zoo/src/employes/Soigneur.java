package employes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Soigneur extends Employe {
	private String qualification;
	List<Soigneur> subordonnes;

	public Soigneur(String nom, Date dateNaissance, String adresse, int codePostal, int salaire, String prenom,
			String email, String qualification) {
		super(nom, dateNaissance, adresse, codePostal, salaire, prenom, email);
		this.qualification = qualification;
		this.subordonnes = new ArrayList<Soigneur>();
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public void ajouterSubordonne(Soigneur caissier) {
		this.subordonnes.add(caissier);
	}

	public void retirerSubordonne(Soigneur caissier) {
		this.subordonnes.remove(caissier);
	}

	public List<Soigneur> getSubordonnes() {
		return subordonnes;
	}

	public void setSubordonnes(List<Soigneur> subordonnes) {
		this.subordonnes = subordonnes;
	}

	@Override
	public String toString() {
		return "\n	-	Soigneur [qualification=" + qualification + "]";
	}

}
