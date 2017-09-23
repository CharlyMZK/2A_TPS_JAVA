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
	
	public void remplirStock() {
		System.out.println("[STOCK] Vous n'avez plus de croquettes ! Le stock est rempli, vous avez été débité de 50 simflouze");
		StockCroquettes.getInstance().setNombreCroquettes(10);
		Zoo.getInstance().setMontantBanque(Zoo.getInstance().getMontantBanque()-50);
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
