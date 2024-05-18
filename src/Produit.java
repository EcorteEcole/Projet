public class Produit {
	int code;
	float prixAchat;
	float prixVente;
	int stock;
	String description;
	
	Produit(int code) {
		this.code = code;
		this.description = "Non disponible";
		this.stock = 0;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public int augmenterStock(int qte) {
		this.stock = this.stock + qte;
		return this.stock;
	}
	
	public int diminuerStock(int qte) {
		if (this.stock < qte) {
			System.out.println("Stock insuffisant");
			return 0;
		}
		this.stock = this.stock - qte;
		return this.stock;
	}
	
	public String toString() {
		return "Produit [code=" + this.code +
				", prixAchat=" + this.prixAchat +
				", prixVente=" + this.prixVente +
				", stock=" + this.stock +
				", description=" + this.description;
	}
}
