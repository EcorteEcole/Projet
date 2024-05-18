
public class Magazine extends Produit {
	String titre;
	byte mois;
	int année;
	String categorie;
	Magazine(int code) {
		super(code);
	}
	
	
	public String toString() {
		return "Magazine [code=" + this.code +
				", prixAchat=" + this.prixAchat +
				", prixVente=" + this.prixVente +
				", stock=" + this.stock +
				", description=" + this.description +
				", titre=" + this.titre +
				", mois=" + this.mois + 
				", année=" +this.année +
				", categorie=" + this.categorie +
				"]";
	}
}
