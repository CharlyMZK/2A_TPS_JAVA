package magasin;

public class StockNourriture {
	private int nombreGlaces = 0;
	private final int prixGlaces = 3;
	private static StockNourriture instance = null;

	public static StockNourriture getInstance() {

		if (StockNourriture.instance == null) {

			synchronized (StockNourriture.class) {
				if (StockNourriture.instance == null) {
					StockNourriture.instance = new StockNourriture();
				}
			}
		}
		return StockNourriture.instance;
	}

	public int getNombreGlaces() {
		return nombreGlaces;
	}

	public void setNombreGlaces(int nombreGlaces) {
		this.nombreGlaces = nombreGlaces;
	}

	public int getPrixGlaces() {
		return prixGlaces;
	}

	@Override
	public String toString() {
		return "StockNourriture [nombreGlaces=" + nombreGlaces + ", prixGlaces=" + prixGlaces + "]";
	}

}
