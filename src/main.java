import java.io.*;
import java.util.Scanner;


public class main {
	static Librairie lib = new Librairie("Antoine");
	public static void main(String[] args) {
		boolean run = true;
		Scanner keyb = new Scanner(System.in);
		while (run)	{
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("Choisir une option en utilisant sont chifre:");
			System.out.println("1 - Charger les produits a pratir du fichiers d'entrée (produits.txt).");
			System.out.println("2 - Charger des produits manuellement avec le clavier");
			System.out.println("3 - Traiter des achats.");
			System.out.println("4 - Traiter des ventes.");
			System.out.println("5 - Rechercher et afficher un produit.");
			System.out.println("0 - Quitter l'application");
			int choix = keyb.nextInt();
			keyb.nextLine();
			switch (choix) {
			case 1:
				try {
					chargerFichier();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				ajouterProduit(keyb);
				break;
			case 3:
				traiterAchat(keyb);
				break;
			case 4:
				traiterVente(keyb);
				break;
			case 5:
				rechercherProduit(keyb);
				break;
			default:
				run = false;
				break;
			}
			
		}
		System.out.println("Vous avez quitter l'application.");
		keyb.close();
	}
	
	static void chargerFichier() throws IOException {
		System.out.println("---------------------------------------------------------------------------------");
		String  ligneEntree;
		BufferedReader ficEntree = new BufferedReader(new FileReader("C:\\Users\\antoi\\eclipse-workspace\\Projet\\src/produits.txt"));

		ligneEntree = ficEntree.readLine();
		while (ligneEntree != null) {
			
			String[] type = ligneEntree.split(": ");
			if (!type[0].equals("Livre") && !type[0].equals("Magazine") && !type[0].equals("CD")
					&& !type[0].equals("DVD") && !type[0].equals("Jeu")) {
				System.out.println("Type de produit non reconnu.");
				ligneEntree = ficEntree.readLine();
				continue;
			}
			System.out.println("Type: " + type[0]);
			String[] valeurs = type[1].split(",\\s*");
			switch (type[0]) {
				case "Livre":
					Livre livre = new Livre(Integer.parseInt(valeurs[0]));
					livre.prixAchat = Float.parseFloat(valeurs[1]);
					livre.prixVente = Float.parseFloat(valeurs[1]) + 4;
					livre.stock = Integer.parseInt(valeurs[2]);
					livre.titre = valeurs[3];
					livre.auteur = valeurs[4];
					livre.année = Integer.parseInt(valeurs[5]);
					livre.editeur = valeurs[6];
					
					lib.ajouterProduit(livre);
					System.out.println("Livre ajouté avec code: " + livre.code);
					System.out.println(livre.toString());
					break;
				case "Magazine":
					Magazine magazine = new Magazine(Integer.parseInt(valeurs[0]));
					magazine.prixAchat = Float.parseFloat(valeurs[1]);
					magazine.prixVente = Float.parseFloat(valeurs[1]) + 4;
					magazine.stock = Integer.parseInt(valeurs[2]);
					magazine.titre = valeurs[3];
					magazine.mois = Byte.parseByte(valeurs[4]);
					magazine.année = Integer.parseInt(valeurs[5]);
					magazine.categorie = valeurs[6];
					
					lib.ajouterProduit(magazine);
					System.out.println("Magazine ajouté avec code: " + magazine.code);
					System.out.println(magazine.toString());
					break;
				case "CD":
					CD cd = new CD(Integer.parseInt(valeurs[0]));
					cd.prixAchat = Float.parseFloat(valeurs[1]);
					cd.prixVente = Float.parseFloat(valeurs[1]) + 4;
					cd.stock = Integer.parseInt(valeurs[2]);
					cd.duree = Integer.parseInt(valeurs[3]);
					cd.titre = valeurs[4];
					cd.interprete = valeurs[5];
					cd.annee = Integer.parseInt(valeurs[6]);
					cd.nbDeTitres = Integer.parseInt(valeurs[7]);
					
					lib.ajouterProduit(cd);
					System.out.println("CD ajouté avec code: " + cd.code);
					System.out.println(cd.toString());
					break;
				case "DVD":
					DVD dvd = new DVD(Integer.parseInt(valeurs[0]));
					dvd.prixAchat = Float.parseFloat(valeurs[1]);
					dvd.prixVente = Float.parseFloat(valeurs[1]) + 4;
					dvd.stock = Integer.parseInt(valeurs[2]);
					dvd.duree = Integer.parseInt(valeurs[3]);
					dvd.titre = valeurs[4];
					dvd.realisateur = valeurs[5];
					dvd.annee = Integer.parseInt(valeurs[6]);
					
					lib.ajouterProduit(dvd);
					System.out.println("DVD ajouté avec code: " + dvd.code);
					System.out.println(dvd.toString());
					break;
				case "Jeu":
					Jeu jeu = new Jeu(Integer.parseInt(valeurs[0]));
					jeu.prixAchat = Float.parseFloat(valeurs[1]);
					jeu.prixVente = Float.parseFloat(valeurs[1]) + 4;
					jeu.stock = Integer.parseInt(valeurs[2]);
					jeu.nom = valeurs[3];
					jeu.max = Integer.parseInt(valeurs[4]);
					jeu.theme = valeurs[5];
					jeu.setNiveau(valeurs[6]);
					
					lib.ajouterProduit(jeu);
					System.out.println("Jeu ajouté avec code: " + jeu.code);
					System.out.println(jeu.toString());
					break;
			}
		    ligneEntree = ficEntree.readLine();
		}
		ficEntree.close();
	}

	static void ajouterProduit(Scanner keyb) {
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Entre le type de produit que vous voulez ajouter: (Livre, Magazine, CD, DVD, Jeu)");
		String type = keyb.nextLine();
		switch (type.toLowerCase()) {
			case "livre":
				System.out.println("Entre le code du livre:");
				Livre livre = new Livre(keyb.nextInt());
				keyb.nextLine();
				System.out.println("Entrer la description du livre:");
				livre.description = keyb.nextLine();
				System.out.println("Entrer le prix d'achat du livre:");
				livre.prixAchat = keyb.nextFloat();
				System.out.println("Entrer le prix de vente du livre:");
				livre.prixVente = keyb.nextFloat();
				keyb.nextLine();
				System.out.println("Entre le titre du livre:");
				livre.titre = keyb.nextLine();
				System.out.println("Entre l'auteur du livre:");
				livre.auteur = keyb.nextLine();
				System.out.println("Entre l'année de publication du livre:");
				livre.année = keyb.nextInt();
				keyb.nextLine();
				System.out.println("Entre l'éditeur du livre:");
				livre.editeur = keyb.nextLine();
				lib.ajouterProduit(livre);
				System.out.println("Livre ajouté avec code: " + livre.code);
				System.out.println(livre.toString());
				break;
			case "magazine":
				System.out.println("Entre le code du magazine:");
				Magazine magazine = new Magazine(keyb.nextInt());
				keyb.nextLine();
				System.out.println("Entrer la description du magazine:");
				magazine.description = keyb.nextLine();
				System.out.println("Entrer le prix d'achat du magazine:");
				magazine.prixAchat = keyb.nextFloat();
				System.out.println("Entrer le prix de vente du magazine:");
				magazine.prixVente = keyb.nextFloat();
				keyb.nextLine();
				System.out.println("Entre le titre du magazine:");
				magazine.titre = keyb.nextLine();
				System.out.println("Entre le mois de publication du magazine:");
				magazine.mois = keyb.nextByte();
				System.out.println("Entre l'année de publication du magazine:");
				magazine.année = keyb.nextInt();
				keyb.nextLine();
				System.out.println("Entre la catégorie du magazine:");
				magazine.categorie = keyb.nextLine();
				
				lib.ajouterProduit(magazine);
				System.out.println("Magazine ajouté avec code: " + magazine.code);
				System.out.println(magazine.toString());
				break;
			case "cd":
				System.out.println("Entre le code du CD:");
				CD cd = new CD(keyb.nextInt());
				keyb.nextLine();
				System.out.println("Entrer la description du CD:");
				cd.description = keyb.nextLine();
				System.out.println("Entrer le prix d'achat du CD:");
				cd.prixAchat = keyb.nextFloat();
				System.out.println("Entrer le prix de vente du CD:");
				cd.prixVente = keyb.nextFloat();
				System.out.println("Entre la durée du CD:");
				cd.duree = keyb.nextInt();
				keyb.nextLine();
				System.out.println("Entre le titre du CD:");
				cd.titre = keyb.nextLine();
				System.out.println("Entre l'interprète du CD:");
				cd.interprete = keyb.nextLine();
				System.out.println("Entre l'année de publication du CD:");
				cd.annee = keyb.nextInt();
				System.out.println("Entre le nombre de titres du CD:");
				cd.nbDeTitres = keyb.nextInt();
				
				lib.ajouterProduit(cd);
				System.out.println("CD ajouté avec code: " + cd.code);
				System.out.println(cd.toString());
				break;
			case "dvd":
				System.out.println("Entre le code du DVD:");
				DVD dvd = new DVD(keyb.nextInt());
				keyb.nextLine();
				System.out.println("Entrer la description du DVD:");
				dvd.description = keyb.nextLine();
				System.out.println("Entrer le prix d'achat du DVD:");
				dvd.prixAchat = keyb.nextFloat();
				System.out.println("Entrer le prix de vente du DVD:");
				dvd.prixVente = keyb.nextFloat();
				System.out.println("Entre la durée du DVD:");
				dvd.duree = keyb.nextInt();
				keyb.nextLine();
				System.out.println("Entre le titre du DVD:");
				dvd.titre = keyb.nextLine();
				System.out.println("Entre le réalisateur du DVD:");
				dvd.realisateur = keyb.nextLine();
				System.out.println("Entre l'année de publication du DVD:");
				dvd.annee = keyb.nextInt();
				
				lib.ajouterProduit(dvd);
				System.out.println("DVD ajouté avec code: " + dvd.code);
				System.out.println(dvd.toString());
				break;
			case "jeu":
				System.out.println("Entre le code du jeu:");
				Jeu jeu = new Jeu(keyb.nextInt());
				keyb.nextLine();
				System.out.println("Entrer la description du jeu:");
				jeu.description = keyb.nextLine();
				System.out.println("Entrer le prix d'achat du jeu:");
				jeu.prixAchat = keyb.nextFloat();
				System.out.println("Entrer le prix de vente du jeu:");
				jeu.prixVente = keyb.nextFloat();
				keyb.nextLine();
				System.out.println("Entre le nom du jeu:");
				jeu.nom = keyb.nextLine();
				System.out.println("Entre le nombre de joueur max du jeu:");
				jeu.max = keyb.nextInt();
				keyb.nextLine();
				System.out.println("Entre le thème du jeu:");
				jeu.theme =  keyb.nextLine();
				System.out.println("Entre le niveau du jeu: (débutant, intermédiaire, expert)");
				jeu.setNiveau(keyb.nextLine());
				
				lib.ajouterProduit(jeu);
				System.out.println("Jeu ajouté avec code: " + jeu.code);
				System.out.println(jeu.toString());
				break;
		}
	}

	static void traiterAchat(Scanner keyb) {
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Entre le code du produit que vous voulez acheter:");
		int code = keyb.nextInt();
		System.out.println("Entre la quantité que vous voulez acheter:");
		int quantite = keyb.nextInt();
		Produit produit = lib.acheterProduit(code, quantite);
		System.out.println("Achat de " + quantite + " exemplaires du produit " + code);
		if (produit != null) {
			System.out.println("Produit acheté avec succès. Prix total: " + produit.prixAchat * quantite + "$. Stock actuel: " + produit.stock + " produits.");
		} else {
			System.out.println("Erreur lors de l'achat du produit.");
		}
	}

	static void traiterVente(Scanner keyb) {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Entre le code du produit que vous voulez vendre:");
        int code = keyb.nextInt();
        System.out.println("Entre la quantité que vous voulez vendre:");
        int quantite = keyb.nextInt();
        Produit produit = lib.vendreProduit(code, quantite);
        System.out.println("Vente de " + quantite + " exemplaires du produit " + code);
        if (produit != null) {
            System.out.println("Produit vendu avec succès. Prix total: " + produit.prixVente * quantite + "$. Stock actuel: " + produit.stock + " produits.");
        } else {
            System.out.println("Erreur lors de la vente du produit.");
        }
	}

	static void rechercherProduit(Scanner keyb) {
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Entre le code du produit que vous voulez rechercher:");
		int code = keyb.nextInt();
		Produit produit = lib.rechercherProduit(code);
		if (produit != null) {
			System.out.println(produit.toString());
		} else {
			System.out.println("Produit non trouvé.");
		}
	}
}
