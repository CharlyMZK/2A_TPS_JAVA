package animaux;

import java.util.ArrayList;
import java.util.List;

public class Enclos {
	private String type;
	private int taille;
	List<Animal> animaux;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public List<Animal> getAnimaux() {
		return animaux;
	}

	public void setAnimaux(List<Animal> animaux) {
		this.animaux = animaux;
	}

	public void ajouterAnimal(Animal animal) {
		this.animaux.add(animal);
	}

	public void enleverAnimal(Animal animal) {
		this.animaux.remove(animal);
	}

	public Enclos(String type, int taille) {
		super();
		this.type = type;
		this.taille = taille;
		this.animaux = new ArrayList<Animal>();
	}

	@Override
	public String toString() {
		return "\n		-	Enclos [type=" + type + ", taille=" + taille + ", animaux=" + animaux + "]";
	}

}
