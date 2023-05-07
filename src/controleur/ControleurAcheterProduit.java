package controleur;

import magasin.Magasin;
import personnage.Gentil;

public class ControleurAcheterProduit {
	
	
	public <T extends Magasin> void menuInventaire(Gentil gentil, T magasin, int resultat) {
		magasin.menuInventaire(gentil, magasin, resultat);
	}	
	
	public boolean isAjouterArticlePossible(Gentil gentil) {
		return gentil.isAjouterArticlePossible();
	}
	
	public void afficherInventaire(Magasin magasin) {
		magasin.afficherInventaire();
	}
	
	public int getNbArticle(Magasin magasin) {
		return magasin.getNbArticle();
	}
	
	public String getNomMagasin(Magasin magasin) {
		return magasin.getNomMagasin();
	}
}
