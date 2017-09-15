package gestionnaires;

import domain.Zoo;
import employes.Caissier;
import magasin.StockNourriture;
import magasin.StockSouvenirs;
import visiteurs.Visiteur;

public class GestionnaireMagasin {

	private static GestionnaireMagasin instance = null;
	
	public static GestionnaireMagasin getInstance() {

		if (GestionnaireMagasin.instance == null) {

			synchronized (GestionnaireMagasin.class) {
				if (GestionnaireMagasin.instance == null) {
					GestionnaireMagasin.instance = new GestionnaireMagasin();
				}
			}
		}
		return GestionnaireMagasin.instance;
	}
	
	public static void vendreGlace(Visiteur visiteur, Integer nombreGlaces, Caissier caissier){
		System.out.println("Le caissier "+caissier.getNom()+" vend "+nombreGlaces+" glace(s) a un visiteur ("+visiteur.getDateVisite()+")");
		Zoo.getInstance().setMontantBanque(Zoo.getInstance().getMontantBanque()+(nombreGlaces+StockNourriture.getInstance().getPrixGlaces()));
	}
	
	public static void vendreSouvenir(Visiteur visiteur, Integer nombreStatuettes, Caissier caissier){
		System.out.println("Le caissier "+caissier.getNom()+" vend "+nombreStatuettes+" statuette(s) a un visiteur ("+visiteur.getDateVisite()+")");
		Zoo.getInstance().setMontantBanque(Zoo.getInstance().getMontantBanque()+(nombreStatuettes+StockSouvenirs.getInstance().getPrixStatuette()));
	}
}
