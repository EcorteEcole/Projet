
public class DVD extends Produit {
	int duree;
	String titre;
	String realisateur;
	int annee;
	DVD(int code) {
		super(code);
	}
	
	public String toString() {
		return "DVD [code=" + this.code +
				", prixAchat=" + this.prixAchat +
				", prixVente=" + this.prixVente +
				", stock=" + this.stock +
				", description=" + this.description + 
				", duree=" + this.duree + 
				", titre=" + this.titre +
				", realisateur" + this.realisateur +
				", annee=" + this.annee +
				"]";
	}
}
