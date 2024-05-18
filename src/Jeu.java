
public class Jeu extends Produit {
	String nom;
	int max;
	String theme;
	private String niveau;
	
	Jeu(int code) {
		super(code);
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		if (!niveau.equals("débutant") && 
		        !niveau.equals("intermédiaire") && 
		        !niveau.equals("expert")) {
		        return;
		}
		this.niveau = niveau;
	}

	public String toString() {
		return "Jeux [code=" + this.code +
				", prixAchat=" + this.prixAchat +
				", prixVente=" + this.prixVente +
				", stock=" + this.stock +
				", description=" + this.description+ 
				", nom=" + this.nom +
				", max=" + this.max + 
				", theme" + this.theme +
				", niveau=" + this.niveau +
				"]";
	}
}
