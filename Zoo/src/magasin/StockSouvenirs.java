package magasin;

import domain.Zoo;

public class StockSouvenirs {
	private int nombreStatuettes = 0;
	private final int prixStatuette = 15;
	private static StockSouvenirs instance = null;

	public static StockSouvenirs getInstance() {

		if (StockSouvenirs.instance == null) {

			synchronized (StockSouvenirs.class) {
				if (StockSouvenirs.instance == null) {
					StockSouvenirs.instance = new StockSouvenirs();
				}
			}
		}
		return StockSouvenirs.instance;
	}

	public void remplirStock() {
		System.out.println("[STOCK] Vous n'avez plus de statuettes  ! Le stock est rempli, vous avez été débité de 200 simflouze");
		StockSouvenirs.getInstance().setNombreStatuettes(100);
		Zoo.getInstance().setMontantBanque(Zoo.getInstance().getMontantBanque()-100);
	}
	
	
	public int getNombreStatuettes() {
		return nombreStatuettes;
	}

	public void setNombreStatuettes(int nombreStatuettes) {
		this.nombreStatuettes = nombreStatuettes;
	}

	public int getPrixStatuette() {
		return prixStatuette;
	}

	@Override
	public String toString() {
		return "StockSouvenirs [nombreStatuettes=" + nombreStatuettes + ", prixStatuette=" + prixStatuette + "]";
	}
}
