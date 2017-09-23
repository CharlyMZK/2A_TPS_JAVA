package gestionnaires;

import java.util.Date;

import animaux.Animal;
import animaux.Baptiste;
import animaux.Emilie;
import animaux.Fillippinne;
import animaux.Quentin;
import animaux.Sakina;
import domain.StockCroquettes;
import domain.Zoo;
import magasin.StockNourriture;

public class GestionnaireAnimaux {
	private static GestionnaireAnimaux instance = null;

	public static GestionnaireAnimaux getInstance() {

		if (GestionnaireAnimaux.instance == null) {

			synchronized (GestionnaireAnimaux.class) {
				if (GestionnaireAnimaux.instance == null) {
					GestionnaireAnimaux.instance = new GestionnaireAnimaux();
				}
			}
		}
		return GestionnaireAnimaux.instance;
	}

	public void accoupler(Animal animal1, Animal animal2) {
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Animal animal = null;
				switch (animal1.getClass().toString()) {
					case "Baptiste":
						animal = new Baptiste(new Date(), "Lala", 35, 45, 3, 'M', 4);
						break;
					case "Emilie":
						animal = new Emilie(new Date(), "emy", 35, 45, 3, 'M', 4);
						break;
					case "Quentin":
						animal = new Quentin(new Date(), "quenth", 35, 45, 3, 'M', "chaude pisse");
						break;
					case "Sakina":
						animal = new Sakina(new Date(), "saki", 35, 45, 3, 'M', 4);
						break;
					case "Fillippinne":
						animal = new Fillippinne(new Date(), "filou", 35, 45, 3, 'M', 4);
						break;
				}
				
				Zoo.getInstance().getSecteurs().get(0).getListeEnclos().get(0).ajouterAnimal(animal);
			}
		};

		t.start();
	}
	
	public void jouer(Animal animal) {
		System.out.println("[GESTIONNAIRE ANIMAUX] j'm'amuse trop lol");
	}
	
	public void manger(Animal animal, int nombreCroquettes) {
		System.out.println("[GESTIONNAIRE ANIMAUX] Je mange c'est trop bon ! ");
		
		
		if( (StockCroquettes.getInstance().getNombreCroquettes()-nombreCroquettes) < 0 ) {
			StockCroquettes.getInstance().remplirStock();
		}
		
		StockCroquettes.getInstance().setNombreCroquettes(StockCroquettes.getInstance().getNombreCroquettes()-nombreCroquettes);
		
		System.out.println("[STOCK] Il vous reste "+StockCroquettes.getInstance().getNombreCroquettes()+" croquettes");
	}
}
