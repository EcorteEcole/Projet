
public class CD extends Produit {
	int duree;
	String titre;
	String interprete;
	int annee;
	int nbDeTitres;
	CD(int code) {
		super(code);
	}
	
	public String toString() {
		return "CD [code=" + this.code +
				", prixAchat=" + this.prixAchat +
				", prixVente=" + this.prixVente +
				", stock=" + this.stock +
				", description=" + this.description + 
				", duree=" + this.duree + 
				", titre=" + this.titre +
				", interprete=" + this.interprete +
				", annee=" + this.annee +
				", nbDeTitres=" + this.nbDeTitres +
				"]";
	}
}
