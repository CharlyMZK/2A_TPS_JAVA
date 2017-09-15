package magasin;

import java.util.ArrayList;
import java.util.List;

import employes.*;

public class Magasin {
	private String emplacement;
	private int recette;
	private TypeMagasin type;
	private List<Caissier> caissiers;

	public List<Caissier> getCaissiers() {
		return caissiers;
	}

	public void setCaissiers(List<Caissier> caissiers) {
		this.caissiers = caissiers;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public int getRecette() {
		return recette;
	}

	public void setRecette(int recette) {
		this.recette = recette;
	}

	public TypeMagasin getType() {
		return type;
	}

	public void setType(TypeMagasin type) {
		this.type = type;
	}

	public Magasin(String emplacement, int recette, TypeMagasin type) {
		super();
		this.emplacement = emplacement;
		this.recette = recette;
		this.type = type;
		this.caissiers = new ArrayList<Caissier>();
	}

	public void ajouterCaissier(Caissier caissier) {
		this.caissiers.add(caissier);
	}

	public void enleverCaissier(Caissier caissier) {
		this.caissiers.remove(caissier);
	}

	@Override
	public String toString() {
		return "\n		-	Magasin [emplacement=" + emplacement + ", recette=" + recette + ", type=" + type + "]";
	}

}
