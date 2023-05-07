package frontiere;

import java.util.Scanner;

import controleur.ControleurSacADos;
import magasin.Article;
import personnage.Gentil;

public class BoundarySacADos {
	ControleurSacADos controleurSacADos;

	public void sacADosNonPlein(Article article,Gentil gentil, Scanner scanner) {
		boolean isArmeEquipper=controleurSacADos.isArmeEquipper(gentil);
		if(isArmeEquipper) {	// on ne peut pas avoir 2 armes
			System.out.println("Vous ne pouvez pas avoir plus d'une arme");
			remplacerArme(article, gentil, scanner);
		}else {
			controleurSacADos.sacADosNonPlein(article, gentil);
		}
	}

	public void sacADosPlein(Article article, Gentil gentil, Scanner scanner) {
		int res;
		int nbArticle=controleurSacADos.getNbAtricle(gentil);
		boolean isArmeEquipper=controleurSacADos.isArmeEquipper(gentil);
		if(isArmeEquipper) {	// on ne peut pas avoir 2 armes
			System.out.println("Vous ne pouvez pas avoir plus d'une arme");
			System.out.println("Votre sac a dos est plein\n");
			remplacerArme(article, gentil, scanner);
		}else {
			do {
				controleurSacADos.afficherSacADos(gentil);
				System.out.println("Votre sac a dos est plein\nTaper "+nbArticle+" pour abandonner l'article achet� ou"
						+ "\nTaper le numero de l'article que vous voulez supprimer pour ranger "+article.getNom()+"\n");
				res=scanner.nextInt();
			}while(res<0 && res>nbArticle+1);	

			if(res!=nbArticle){	
				controleurSacADos.sacADosPlein(article, gentil, res);
			}else {
				gentil.parler("Pas de chance j'ai acheter cet article pour rien\n");
			}

		}
	}

	public void menuUtiliserArticle(Scanner scanner,Gentil gentil) {
		controleurSacADos.afficherSacADos(gentil);
		int nbArticle=controleurSacADos.getNbAtricle(gentil);
		int res;
		if(nbArticle>0) {
			do {
				System.out.println("Veuillez choisir un nombre entre 0 et "+(nbArticle-1)+ " pour utiliser un article (non utiliser) ou \n choisissez "+nbArticle+" pour quitter le menu d'utilsation des articles \n");
				res=scanner.nextInt();

			}while(res<0 || res>nbArticle+1|| controleurSacADos.getArticle(gentil,res).isArticleDejaUtiliser());
			controleurSacADos.MenuUtiliserArticle(gentil, res);
		}
		
	}


	public void remplacerArme(Article article, Gentil gentil ,Scanner scanner) {
		int res;
		int emplacementDeLArme=controleurSacADos.emplacementDeLArme(gentil);
		do {
			System.out.println("Taper 0 pour abandonner l'article achet� ou"
					+ "\nTaper "+emplacementDeLArme+" pour remplacer votre arme actuelle "+controleurSacADos.getArticle(gentil,emplacementDeLArme).getNom()+" par la nouvelle\n"+article.getNom()+"\n");
			res=scanner.nextInt();
		}while(res!=0 && res!=emplacementDeLArme);


	}


}
