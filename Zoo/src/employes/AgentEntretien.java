package employes;

import java.util.Date;
import java.util.List;

public class AgentEntretien extends Employe implements Pointage {
	private String habilitation;
	List<AgentEntretien> subordonnes;

	public AgentEntretien(String nom, Date dateNaissance, String adresse, int codePostal, int salaire, String prenom,
			String email, String habilitation) {
		super(nom, dateNaissance, adresse, codePostal, salaire, prenom, email);
		this.habilitation = habilitation;
	}

	public String getHabilitation() {
		return habilitation;
	}

	public void setHabilitation(String habilitation) {
		this.habilitation = habilitation;
	}

	@Override
	public String toString() {
		return "\n	-	AgentEntretien [habilitation=" + habilitation + "]";
	}

	@Override
	public void Pointer() {
		System.out.println("Je suis un agent");
	}

	public void ajouterSubordonne(AgentEntretien caissier) {
		this.subordonnes.add(caissier);
	}

	public void retirerSubordonne(AgentEntretien caissier) {
		this.subordonnes.remove(caissier);
	}

	public List<AgentEntretien> getSubordonnes() {
		return subordonnes;
	}

	public void setSubordonnes(List<AgentEntretien> subordonnes) {
		this.subordonnes = subordonnes;
	}

}
