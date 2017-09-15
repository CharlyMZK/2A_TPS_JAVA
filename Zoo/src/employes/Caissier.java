package employes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Caissier extends Employe implements Pointage {
	List<Caissier> subordonnes;
	private int caisseAttribue;

	public Caissier(String nom, Date dateNaissance, String adresse, int codePostal, int salaire, String prenom,
			String email, int caisseAttribue) {
		super(nom, dateNaissance, adresse, codePostal, salaire, prenom, email);
		this.caisseAttribue = caisseAttribue;
		this.subordonnes = new ArrayList<Caissier>();
	}

	public int getCaisseAttribue() {
		return caisseAttribue;
	}

	public void setCaisseAttribue(int caisseAttribue) {
		this.caisseAttribue = caisseAttribue;
	}

	@Override
	public String toString() {
		return "\n	-	Caissier [caisseAttribue=" + caisseAttribue + "]";
	}

	@Override
	public void Pointer() {
		System.out.println("J'ai pointé ! ");
	}

	public void ajouterSubordonne(Caissier caissier) {
		this.subordonnes.add(caissier);
	}

	public void retirerSubordonne(Caissier caissier) {
		this.subordonnes.remove(caissier);
	}

	public List<Caissier> getSubordonnes() {
		return subordonnes;
	}

	public void setSubordonnes(List<Caissier> subordonnes) {
		this.subordonnes = subordonnes;
	}

}
