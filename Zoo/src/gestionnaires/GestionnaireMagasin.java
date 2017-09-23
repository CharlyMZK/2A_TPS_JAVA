package gestionnaires;

import domain.StockCroquettes;
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
		if( (StockNourriture.getInstance().getNombreGlaces()-nombreGlaces) < 0 ) {
			StockNourriture.getInstance().remplirStock();
		}
		StockNourriture.getInstance().setNombreGlaces(StockNourriture.getInstance().getNombreGlaces()-1);
		System.out.println("[GESTIONNAIRE MAGASIN] Le caissier "+caissier.getNom()+" vend "+nombreGlaces+" glace(s) a un visiteur ("+visiteur.getDateVisite()+") il vous reste "+StockNourriture.getInstance().getNombreGlaces()+" glaces");
		Zoo.getInstance().setMontantBanque(Zoo.getInstance().getMontantBanque()+(nombreGlaces+StockNourriture.getInstance().getPrixGlaces()));
	}
	
	public static void vendreSouvenir(Visiteur visiteur, Integer nombreStatuettes, Caissier caissier){
		
		if( (StockSouvenirs.getInstance().getNombreStatuettes()-nombreStatuettes) < 0 ) {
			StockSouvenirs.getInstance().remplirStock();
		}
		StockSouvenirs.getInstance().setNombreStatuettes(StockSouvenirs.getInstance().getNombreStatuettes()-1);
		System.out.println("[GESTIONNAIRE MAGASIN] Le caissier "+caissier.getNom()+" vend "+nombreStatuettes+" statuette(s) a un visiteur ("+visiteur.getDateVisite()+"), il vous reste "+StockSouvenirs.getInstance().getNombreStatuettes()+" statuettes");
		Zoo.getInstance().setMontantBanque(Zoo.getInstance().getMontantBanque()+(nombreStatuettes+StockSouvenirs.getInstance().getPrixStatuette()));
	}
}
