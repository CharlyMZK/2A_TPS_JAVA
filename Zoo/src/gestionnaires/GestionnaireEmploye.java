package gestionnaires;

import animaux.Animal;
import animaux.Enclos;
import domain.Zoo;
import employes.AgentEntretien;
import employes.Gerant;
import employes.Soigneur;

public class GestionnaireEmploye {

	private static GestionnaireEmploye instance = null;
	
	public static GestionnaireEmploye getInstance() {

		if (GestionnaireEmploye.instance == null) {

			synchronized (GestionnaireEmploye.class) {
				if (GestionnaireEmploye.instance == null) {
					GestionnaireEmploye.instance = new GestionnaireEmploye();
				}
			}
		}
		return GestionnaireEmploye.instance;
	}
	
	public static void nourrir(Soigneur soigneur, Animal animal){
		System.out.println("[GESTIONNAIRE EMPLOYE] "+soigneur.getNom()+" est entrain de nourrir "+animal.getNom());
		GestionnaireAnimaux.getInstance().manger(animal, animal.getRationJournaliere());
	}
	
	public static void soigner(Soigneur soigneur, Animal animal){
		System.out.println("[GESTIONNAIRE EMPLOYE] "+soigneur.getNom()+" soigne "+animal.getNom());
		Zoo.getInstance().setMontantBanque(Zoo.getInstance().getMontantBanque()-5);
		System.out.println("[ZOO] Ces soins vous ont couté 5 simflouze");
	}
	
	public static void embaucher(Gerant gerant){
		System.out.println("[GESTIONNAIRE EMPLOYE] "+gerant.getNom()+" embauche quelqu'un");
	}
	
	public static void nettoyer(AgentEntretien agent, Enclos enclos){
		System.out.println("[GESTIONNAIRE EMPLOYE] "+agent.getNom()+" est entrain de nettoyer l'enclos "+enclos.getType());
		Zoo.getInstance().setMontantBanque(Zoo.getInstance().getMontantBanque()-5);
		System.out.println("[ZOO] Ce nettoyage vous ont couté 5 simflouze");
	}
	
	public static void reparer(AgentEntretien agent, Enclos enclos){
		System.out.println("[GESTIONNAIRE EMPLOYE] "+agent.getNom()+" est entrain de réparer l'enclos "+enclos.getType());
		Zoo.getInstance().setMontantBanque(Zoo.getInstance().getMontantBanque()-5);
		System.out.println("[ZOO] Ces reparations vous ont couté 5 simflouze");
	}
}


