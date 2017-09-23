package gestionnaires;

import animaux.Secteur;
import domain.Zoo;
import employes.Caissier;
import visiteurs.Adulte;
import visiteurs.Enfant;
import visiteurs.Etudiant;
import visiteurs.Visiteur;

public class GestionnaireVisiteur {

	private static GestionnaireVisiteur instance = null;
	
	public static GestionnaireVisiteur getInstance() {

		if (GestionnaireVisiteur.instance == null) {

			synchronized (GestionnaireVisiteur.class) {
				if (GestionnaireVisiteur.instance == null) {
					GestionnaireVisiteur.instance = new GestionnaireVisiteur();
				}
			}
		}
		return GestionnaireVisiteur.instance;
	}
	
	public static void acheterTicker(Visiteur visiteur){
		switch(visiteur.getClass().toString()){
		case "Adulte":
			Zoo.getInstance().setMontantBanque(Zoo.getInstance().getMontantBanque()+Adulte.prixPaye);
			break;
		case "Enfant":
			Zoo.getInstance().setMontantBanque(Zoo.getInstance().getMontantBanque()+Enfant.prixPaye);
			break;
		case "Etudiant":
			Zoo.getInstance().setMontantBanque(Zoo.getInstance().getMontantBanque()+Etudiant.prixPaye);
			break;
		default:
			break;
		}
		System.out.println("[GESTIONNAIRE VISITEUR] J'ai acheté mon ticket ! C'est parti ! ");
	}
	
	public static void changerSecteur(Secteur secteur, Visiteur visiteur){
		System.out.println("[GESTIONNAIRE VISITEUR] Le visiteur "+visiteur.getId()+" se déplace vers le secteur "+secteur.getCodeSecteur());
		visiteur.setSecteur(secteur);
	}
	
	public static void faireTourZoo(Visiteur visiteur){
		for(Secteur secteur : Zoo.getInstance().getSecteurs()){
			visiteur.setSecteur(secteur);
		}
	}
}
