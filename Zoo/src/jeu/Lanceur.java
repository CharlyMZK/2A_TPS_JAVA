package jeu;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import animaux.Animal;
import animaux.Enclos;
import animaux.Fillippinne;
import animaux.Quentin;
import animaux.Secteur;
import domain.StockCroquettes;
import domain.Zoo;
import employes.AgentEntretien;
import employes.Caissier;
import employes.Employe;
import employes.Gerant;
import employes.Soigneur;
import gestionnaires.GestionnaireEmploye;
import gestionnaires.GestionnaireMagasin;
import gestionnaires.GestionnaireVisiteur;
import magasin.Magasin;
import magasin.StockNourriture;
import magasin.StockSouvenirs;
import magasin.TypeMagasin;
import visiteurs.Adulte;
import visiteurs.Enfant;
import visiteurs.Etudiant;
import visiteurs.Visiteur;

public class Lanceur {

	public static void main(String[] args) {
		instanciateZooSample();
		System.out.println(Zoo.getInstance());
		faireVivreLeZoo();
	}

	public static void instanciateZooSample() {
		// --
		// -- ZOO
		// --

		Zoo.getInstance().setMontantBanque(300);
		// -- Secteurs
		Secteur secteurMontagne = new Secteur(10);
		Secteur secteurPlaine = new Secteur(20);
		// -- Enclos
		Enclos enclosDesQuentins = new Enclos("Metal", 1000);
		Enclos enclosDesFillippinne = new Enclos("Bois", 1500);
		// -- Ajout des enclos dans le secteur
		secteurMontagne.ajouterEnclos(enclosDesFillippinne);
		secteurPlaine.ajouterEnclos(enclosDesQuentins);
		// -- Création des animaux
		Fillippinne bob = new Fillippinne(new Date(), "Bob", 35, 45, 3, 'M', 4);
		Fillippinne bab = new Fillippinne(new Date(), "Bab", 35, 45, 3, 'M', 4);

		Quentin lulu = new Quentin(new Date(), "lulu", 35, 45, 3, 'F', "Rhume");
		Quentin lili = new Quentin(new Date(), "lili", 35, 45, 3, 'F', "Pneumonie");

		enclosDesQuentins.ajouterAnimal(lulu);
		enclosDesQuentins.ajouterAnimal(lili);

		enclosDesFillippinne.ajouterAnimal(bab);
		enclosDesFillippinne.ajouterAnimal(bob);

		// -- Ajout des secteurs dans zoo
		Zoo.getInstance().ajouterSecteur(secteurMontagne);
		Zoo.getInstance().ajouterSecteur(secteurPlaine);

		// --
		// -- EMPLOYES
		// --

		AgentEntretien robert = new AgentEntretien("robert", new Date(), "Mon adresse", 67000, 1100, "redford",
				"rr@gmail.com", "Vitres");
		Zoo.getInstance().ajouterEmploye(robert);
		Caissier vickie = new Caissier("Wennedelle", new Date(), "8 rue des shlag", 68000, 850, "vickie",
				"swag@gmail.com", 1);
		Zoo.getInstance().ajouterEmploye(vickie);
		Caissier charly = new Caissier("mracouille", new Date(), "9 rue du cul", 68000, 850, "Charly",
				"chacha@gmail.com", 1);
		Zoo.getInstance().ajouterEmploye(vickie);
		Soigneur jacques = new Soigneur("robert", new Date(), "Mon adresse", 67000, 1100, "jacques", "rr@gmail.com",
				"Vitres");
		Zoo.getInstance().ajouterEmploye(jacques);
		Gerant gege = new Gerant("gaga", new Date(), "Mon adresse", 67000, 1100, "gege", "rr@gmail.com");
		Zoo.getInstance().ajouterEmploye(gege);

		// --
		// -- MAGASIN
		// --

		Magasin magasinNouriture = new Magasin("Nord-24", 0, TypeMagasin.MAGASIN_DE_NOURRITURE);
		Magasin magasinSouvenir = new Magasin("Sud-24", 0, TypeMagasin.MAGASIN_DE_SOUVENIR);
		secteurMontagne.ajouterMagasin(magasinNouriture);
		secteurPlaine.ajouterMagasin(magasinSouvenir);
		magasinNouriture.ajouterCaissier(vickie);
		magasinSouvenir.ajouterCaissier(charly);

		// --
		// -- STOCKS
		// --

		StockSouvenirs.getInstance().setNombreStatuettes(10);
		StockCroquettes.getInstance().setNombreCroquettes(100);
		StockNourriture.getInstance().setNombreGlaces(10);

	}

	public static void faireVivreLeZoo() {

		boolean run = true;
		Thread t = new Thread() {
			public void run() {
				int cpt = 1;
				synchronized (Zoo.getInstance().getVisiteurs()) {
					while (run == true) {

						try {
							Thread.sleep(7000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Visiteur visiteur = null;
						if (cpt % 5 == 0) {
							visiteur = new Adulte(cpt, 67000, new Date(), new Date(), false);
						} else if (cpt % 3 == 0) {
							visiteur = new Enfant(cpt, 67000, new Date(), new Date());
						} else {
							visiteur = new Etudiant(cpt, 67000, new Date(), new Date(), false);
						}

						Zoo.getInstance().ajouterVisiteur(visiteur);
						cpt++;
						System.out.println("Le visiteur " + visiteur.getId() + " est entré dans le zoo");
						GestionnaireVisiteur.acheterTicker(visiteur);

					}

				}
			}
		};

		t.start();

		// --

		Thread vieDesVisiteursThread = new Thread() {
			public void run() {
				while (run == true) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (!Zoo.getInstance().getVisiteurs().isEmpty()) {
						for (Visiteur visiteur : Zoo.getInstance().getVisiteurs()) {

							Secteur secteur = choisirSecteur();
							while (secteur == visiteur.getSecteur()) {
								secteur = choisirSecteur();
							}
							GestionnaireVisiteur.changerSecteur(secteur, visiteur);

							Secteur secteurVisiteur = visiteur.getSecteur();
							List<Magasin> magasinDispo = secteurVisiteur.getListeMagasin();

							for (Magasin magasin : magasinDispo) {
								if (magasin.getType().equals(TypeMagasin.MAGASIN_DE_NOURRITURE)) {
									GestionnaireMagasin.vendreGlace(visiteur, 1, magasin.getCaissiers().get(0));
								}
								if (magasin.getType().equals(TypeMagasin.MAGASIN_DE_SOUVENIR)) {
									GestionnaireMagasin.vendreSouvenir(visiteur, 1, magasin.getCaissiers().get(0));
								}
							}

						}
					}
				}
			}
		};
		vieDesVisiteursThread.start();

		Thread vieSoigneursThread = new Thread() {
			public void run() {
				while (run == true) {
					try {
						Thread.sleep(7000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (!Zoo.getInstance().getEmployes().isEmpty()) {
						for (Employe employe : Zoo.getInstance().getEmployes()) {
							if (employe.getClass().getName().toString().equals("employes.Soigneur")) {
								for (Secteur secteur : Zoo.getInstance().getSecteurs()) {
									for (Enclos enclos : secteur.getListeEnclos()) {
										for (Animal animal : enclos.getAnimaux()) {
											Soigneur soigneur = (Soigneur) employe;
											GestionnaireEmploye.nourrir(soigneur, animal);
											GestionnaireEmploye.soigner(soigneur, animal);
										}
									}
								}
							}
						}
					}
				}
			}
		};
		vieSoigneursThread.start();

		Thread vieDesAgentsThread = new Thread() {
			public void run() {
				while (run == true) {
					try {
						Thread.sleep(14000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (!Zoo.getInstance().getEmployes().isEmpty()) {
						for (Employe employe : Zoo.getInstance().getEmployes()) {
							if (employe.getClass().getName().toString().equals("employes.AgentEntretien")) {
								AgentEntretien agent = (AgentEntretien) employe;
								for (Secteur secteur : Zoo.getInstance().getSecteurs()) {
									for (Enclos enclos : secteur.getListeEnclos()) {
										GestionnaireEmploye.reparer(agent, enclos);
										GestionnaireEmploye.nettoyer(agent, enclos);
									}
								}
							}

						}
					}
				}
			}
		};
		vieDesAgentsThread.start();

		Thread vieDuZoo = new Thread() {
			public void run() {
				while (run == true) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out
							.println("===============================================================================");
					System.out.println(
							"[ZOO] Vous avez actuellement " + Zoo.getInstance().getMontantBanque() + " simflouze");
					System.out
							.println("===============================================================================");

					if (Zoo.getInstance().getMontantBanque() < 0) {
						System.out.println(
								"===============================================================================");
						System.out.println("[GAME OVER] Vous avez actuellement " + Zoo.getInstance().getMontantBanque()
								+ " simflouze, c'est la banqueroute ! ");
						System.out.println(
								"===============================================================================");
					}

					
//					 System.out.println("Voulez vous acheter quelquechose ? O/N");
//					  
//					 Scanner in = new Scanner(System.in); 
//					 int i = in.nextInt(); 
//					 String input = in.next();
//					  
//					  if(input.equals("O")) {
//					  System.out.println("1 : Voulez vous ajouter un enclos ?");
//					  
//					  input = System.console().readLine(); switch(input) { case "1":
//					  System.out.println("Enclos ajouté !"); break; default: break; }
//					 
//					  
//					 }
					 
				}
			}
		};
		vieDuZoo.start();

	}

	public static Secteur choisirSecteur() {
		int valeur = 0;
		if (Zoo.getInstance().getSecteurs().size() >= 1) {
			Random r = new Random();
			valeur = r.nextInt(Zoo.getInstance().getSecteurs().size());
		}

		Secteur secteur = Zoo.getInstance().getSecteurs().get(valeur);
		return secteur;
	}
}
