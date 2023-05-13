package frontiere;

import java.util.Scanner;

import controleur.ControleurSacADos;
import magasin.Article;
import personnage.Gentil;

public class BoundarySacADos {
	ControleurSacADos controleurSacADos = new ControleurSacADos();

	public void sacADosNonPlein(Article article,Gentil gentil, Scanner scanner) {
		boolean isArmeEquipper=controleurSacADos.isArmeEquipper(gentil);
		if(isArmeEquipper && (article.getType()=="arme")) {	// on ne peut pas avoir 2 armes
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
		if(isArmeEquipper && (article.getType()=="arme")) {	// on ne peut pas avoir 2 armes
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
		boolean isArticleUtiliser;
		
		int res;
		if(nbArticle>0) {
			do {
				isArticleUtiliser=false;
				System.out.println("Veuillez choisir un nombre entre 0 et "+(nbArticle-1)+ " pour utiliser un article (non utiliser) ou \n choisissez "+nbArticle+" pour quitter le menu d'utilsation des articles \n");
				res=scanner.nextInt();
				if(controleurSacADos.getArticle(gentil, res) instanceof Article) {
					isArticleUtiliser=controleurSacADos.getArticle(gentil,res).isArticleDejaUtiliser();
				}
			}while(res<0 || res>nbArticle+1|| isArticleUtiliser);
			controleurSacADos.menuUtiliserArticle(gentil, res);
		}else {
			System.out.println("Pas d'article dans le Sac a dos");
		}
		
	}

	public void remplacerArme(Article article, Gentil gentil ,Scanner scanner) {
		int res;
		int emplacementDeLArme=controleurSacADos.emplacementDeLArme(gentil);
		do {
			System.out.println("Voulez vous abandonner votre arme "+controleurSacADos.getArticle(gentil,emplacementDeLArme).getNom()+" par la nouvelle arme\n"+article.getNom()+"\n1-Oui 2-Non");
			res=scanner.nextInt();
		}while(res!=1 && res!=2);
		
		controleurSacADos.remplacerArme(article, gentil, res);

	}


}
