package frontiere;

import java.util.Scanner;

import controleur.ControleurAcheterProduit;
import magasin.Magasin;
import personnage.Gentil;

public class BoundaryAcheterProduit {
	ControleurAcheterProduit controleurAcheterProduit;
	BoundarySacADos boundarySacADos;
	
	public BoundaryAcheterProduit(ControleurAcheterProduit controleurAcheterProduit) {
		this.controleurAcheterProduit = controleurAcheterProduit;
	}
	
	public <T extends Magasin> void menuInventaire(Gentil gentil, T magasin, Scanner scanner) {
		
		controleurAcheterProduit.afficherInventaire(magasin);
		int nbArticle=controleurAcheterProduit.getNbArticle(magasin);
		String nomMagasin=controleurAcheterProduit.getNomMagasin(magasin);
		int resultat;
		
		System.out.println("Vous avez "+gentil.getArgent()+" d'argent\n");
		do {
			System.out.println("Veuillez choisir un nombre entre 0 et "+(nbArticle-1)+ " pour acheter un article ou \nchoisissez "+nbArticle+" pour quitter le menu d'achat des articles de "+nomMagasin+" \n");
			resultat=scanner.nextInt();
		}while(resultat<0 || resultat>nbArticle+1);
		
		if(controleurAcheterProduit.isAjouterArticlePossible(gentil)) {
			boundarySacADos.sacADosNonPlein(null, gentil, scanner);
		}else {
			boundarySacADos.sacADosPlein(null, gentil, scanner);
		}
		
	}
	
	
	
}
