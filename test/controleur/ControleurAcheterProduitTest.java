package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import magasin.Article;
import magasin.Magasin;
import magasin.Taverne;
import personnage.Gentil;

class ControleurAcheterProduitTest {

	
	static Gentil gentil;
	static Magasin magasin;
	
	@BeforeAll
	static void setUpBeforeClass() {
		gentil = new Gentil("Le Gentil", 1000, 1000, 50);
		magasin = new Taverne("Chez le bon tavernier");
	}
	
	
	@Test
	void testGetArticle() {
		assertEquals("McDo",magasin.getArticle(0).getNom());
		assertEquals("Ramen",magasin.getArticle(5).getNom());
	}	

	@Test
	void testIsAjouterArticlePossible() {
		ControleurAcheterProduit controleurAcheterProduit = new ControleurAcheterProduit();
		Article article = new Article("Ramen", "nourriture/boisson", 10000, 5000);
		assertTrue(controleurAcheterProduit.isAjouterArticlePossible(gentil),"Sac a dos vide");
		for(int i=0;i<10;i++) {
			gentil.ajouterArticleSacADosNonPlein(article);	//remplir le Sac a dos
		}
		assertFalse(controleurAcheterProduit.isAjouterArticlePossible(gentil),"Sac a dos plein");
	}

	@Test
	void testIsSolvable() {
		ControleurAcheterProduit controleurAcheterProduit = new ControleurAcheterProduit();
		Article article = new Article("Ramen", "nourriture/boisson", 10000, 5000);
		assertFalse(controleurAcheterProduit.isSolvable(gentil, article));
		Article article2 = new Article("McDo", "nourriture/boisson", -1000, 500);
		assertTrue(controleurAcheterProduit.isSolvable(gentil, article2));
	}

	@Test
	void testGetNbArticle() {
		ControleurAcheterProduit controleurAcheterProduit = new ControleurAcheterProduit();
		assertEquals(6,controleurAcheterProduit.getNbArticle(magasin));
	}

	@Test
	void testGetNomMagasin() {
		ControleurAcheterProduit controleurAcheterProduit = new ControleurAcheterProduit();
		assertEquals("Chez le bon tavernier",controleurAcheterProduit.getNomMagasin(magasin));
	}

}
