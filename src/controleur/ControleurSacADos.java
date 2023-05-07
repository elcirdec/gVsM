package controleur;

import magasin.Article;
import personnage.Gentil;

public class ControleurSacADos {

	public void afficherSacADos(Gentil gentil) {
		gentil.afficherSacADos();
	}
	
	public void MenuUtiliserArticle(Gentil gentil, int res){
		gentil.donnerMenuUtiliserArticle(res);
	}
	
	public boolean isArmeEquipper(Gentil gentil) {
		return gentil.isArmeEquipper();
	}
	public int getNbAtricle(Gentil gentil) {
		return gentil.getNbArticleSacADos();
	}
	
	public void sacADosNonPlein(Article article,Gentil gentil) {
		gentil.ajouterArticleSacADosNonPlein(article);
	}
	public void sacADosPlein(Article article,Gentil gentil,int res) {
		gentil.ajouterArticleSacADosPlein(article,res);
	}
	public void remplacerArme(Article article,Gentil gentil, int resultat) {
		gentil.remplacerArmeSacADos(article, resultat);
	}
	
	public int emplacementDeLArme(Gentil gentil) {
		return gentil.emplacementDeLArmeSacADos();		
	}
	
	public Article getArticle(Gentil gentil, int emplacement) {
		return gentil.getArticleSacADos(emplacement);
	}
}
