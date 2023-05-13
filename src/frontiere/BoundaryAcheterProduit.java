package frontiere;

import java.util.Scanner;

import controleur.ControleurAcheterProduit;
import magasin.Article;
import magasin.Magasin;
import personnage.Gentil;

public class BoundaryAcheterProduit {
	ControleurAcheterProduit controleurAcheterProduit = new ControleurAcheterProduit();
	BoundarySacADos boundarySacADos = new BoundarySacADos();

	public <T extends Magasin> void menuInventaire(Gentil gentil, T magasin, Scanner scanner) {

		controleurAcheterProduit.afficherInventaire(magasin);
		int nbArticle=controleurAcheterProduit.getNbArticle(magasin);
		String nomMagasin=controleurAcheterProduit.getNomMagasin(magasin);
		int resultat;
		if(nbArticle>0) {
			System.out.println("Vous avez "+gentil.getArgent()+" d'argent\n");
			do {
				System.out.println("Veuillez choisir un nombre entre 0 et "+(nbArticle-1)+ " pour acheter un article ou \nchoisissez "+nbArticle+" pour quitter le menu d'achat des articles de "+nomMagasin+" \n");
				resultat=scanner.nextInt();
			}while(resultat<0 || resultat>nbArticle+1);

			if(resultat==nbArticle) {
				System.out.println("Vous quittez le menu d'achat de "+nomMagasin+"\n");
			}else {
				Article article=controleurAcheterProduit.getArticle(magasin, resultat);

				if(gentil.isSolvable(article)){						
					if(controleurAcheterProduit.isAjouterArticlePossible(gentil)) {
						boundarySacADos.sacADosNonPlein(article, gentil, scanner);
					}else {
						boundarySacADos.sacADosPlein(article, gentil, scanner);
					}
				}
				controleurAcheterProduit.menuInventaire(gentil, magasin, resultat);
			}
		}

	}



}
