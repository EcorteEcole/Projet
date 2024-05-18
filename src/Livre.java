
public class Livre extends Produit {
	String titre;
	String auteur;
	int année;
	String editeur;
	
	public Livre(int code) {
		super(code);
	}

	public String toString() {
		return "Livre [code=" + this.code +
				", prixAchat=" + this.prixAchat +
				", prixVente=" + this.prixVente +
				", stock=" + this.stock +
				", description=" + this.description +
				", titre=" + this.titre +
				", auteur=" + this.auteur + 
				", année=" +this.année +
				", editeur=" + this.editeur +
				"]";
	}
}
