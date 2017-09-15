package domain;

public class StockCroquettes {
	private int nombreCroquettes = 0;
	private static StockCroquettes instance = null;

	public static StockCroquettes getInstance() {

		if (StockCroquettes.instance == null) {

			synchronized (StockCroquettes.class) {
				if (StockCroquettes.instance == null) {
					StockCroquettes.instance = new StockCroquettes();
				}
			}
		}
		return StockCroquettes.instance;
	}

	public int getNombreCroquettes() {
		return nombreCroquettes;
	}

	public void setNombreCroquettes(int nombreCroquettes) {
		this.nombreCroquettes = nombreCroquettes;
	}

	@Override
	public String toString() {
		return "StockCroquettes [nombre de croquettes : " + nombreCroquettes + "]";
	}

}
