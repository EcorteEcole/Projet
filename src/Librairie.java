
public class Librairie {
	String nom;
	private static final int nbMax=500;
	private static Produit[] stock;
	private int nbProduit;
	
	Librairie(String nom) {
		this.nom = nom;
		stock = new Produit[nbMax];
		this.nbProduit = 0;
	}
	
	public Produit acheterProduit(int code, int qt) {
		for (int i = 0; i < this.nbProduit; i++) {
			if (stock[i].code == code) {
				stock[i].augmenterStock(qt);
				return stock[i];
			}
		}
		return null;
	}
	
	public Produit vendreProduit(int code, int qt) {
		for (int i = 0; i < this.nbProduit; i++) {
			if (stock[i].code == code) {
				int stockRestant = stock[i].diminuerStock(qt);
				if (stockRestant == 0) {
					return null;
				}
				return stock[i];
			}
		}
		return null;
	}
	
	public Produit rechercherProduit(int code) {
		for (int i = 0; i < this.nbProduit; i++) {
			if (stock[i].code == code) {
				return stock[i];
			}
		}
		return null;
	}
	
	public void ajouterProduit(Produit produit) {
		stock[nbProduit] = produit;
		nbProduit++;
	}
	
}
