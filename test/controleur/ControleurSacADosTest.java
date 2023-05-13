package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import magasin.Article;
import magasin.Magasin;
import magasin.Taverne;
import personnage.Gentil;

class ControleurSacADosTest {

	static Gentil gentil;
	static Magasin magasin;
	
	@BeforeAll
	static void setUpBeforeClass() {
		magasin = new Taverne("Chez le bon tavernier");
	}
	
	@BeforeEach
	public void setUp() {
		gentil = new Gentil("Le Gentil", 1000, 1000, 50);
	}
	
	
	@Test
	void testIsArmeEquipper() {
		ControleurSacADos controleurSacADos = new ControleurSacADos();
		System.out.println(controleurSacADos.isArmeEquipper(gentil));
		assertFalse(controleurSacADos.isArmeEquipper(gentil));
		Article arme = new Article("Katana", "arme", 1000, 5000);
		controleurSacADos.sacADosNonPlein(arme, gentil);
		controleurSacADos.menuUtiliserArticle(gentil, 0);	//utiliser l'arme
		System.out.println(controleurSacADos.isArmeEquipper(gentil));
		assertTrue(controleurSacADos.isArmeEquipper(gentil));
	}

	@Test
	void testGetNbAtricle() {
		ControleurSacADos controleurSacADos = new ControleurSacADos();
		assertEquals(0, controleurSacADos.getNbAtricle(gentil));
		Article arme = new Article("Katana", "arme", 1000, 5000);
		gentil.ajouterArticleSacADosNonPlein(arme);
		assertEquals(1, controleurSacADos.getNbAtricle(gentil));
	}

	@Test
	void testSacADosNonPlein() {
		ControleurSacADos controleurSacADos = new ControleurSacADos();
		Article article = new Article("Riz", "nourriture/boisson", 1500, 200);
		gentil.ajouterArticleSacADosNonPlein(article);	
		assertEquals("Riz", controleurSacADos.getArticle(gentil, 0).getNom());	
		Article article2 = new Article("Boulette de riz", "nourriture/boisson", 1500, 200);
		controleurSacADos.sacADosNonPlein(article2, gentil);	
		assertEquals("Boulette de riz", controleurSacADos.getArticle(gentil, 1).getNom());		
	}

	@Test
	void testSacADosPlein() {
		ControleurSacADos controleurSacADos = new ControleurSacADos();
		Article article = new Article("Riz", "nourriture/boisson", 1500, 200);
		for(int i=0;i<10;i++) {
			controleurSacADos.sacADosNonPlein(article, gentil);	//remplir le Sac a dos
		}
		Article article2 = new Article("Boulette de riz", "nourriture/boisson", 1500, 200);
		controleurSacADos.sacADosPlein(article2, gentil, 2);	//changer le 2eme article avec le nouveau
		assertEquals("Boulette de riz", controleurSacADos.getArticle(gentil, 2).getNom());		//verifier si l'article a ete changer
		
	}

	@Test
	void testRemplacerArme() {
		ControleurSacADos controleurSacADos = new ControleurSacADos();
		Article arme = new Article("Katana", "arme", 1000, 5000);
		controleurSacADos.sacADosNonPlein(arme, gentil);
		String nomArme=controleurSacADos.getArticle(gentil, controleurSacADos.emplacementDeLArme(gentil)).getNom();
		assertEquals("Katana", nomArme);
		Article arme2 = new Article("Wakizashi", "arme", 900, 2500);
		controleurSacADos.remplacerArme(arme2, gentil, 1);	//changement d'arme
		String nomArme2=controleurSacADos.getArticle(gentil, controleurSacADos.emplacementDeLArme(gentil)).getNom();
		assertEquals("Wakizashi", nomArme2);	//Comparaison avec le nom de l'arme remplacer  
	}

	@Test
	void testEmplacementDeLArme() {
		ControleurSacADos controleurSacADos = new ControleurSacADos();
		Article arme = new Article("Katana", "arme", 1000, 5000);
		gentil.ajouterArticleSacADosNonPlein(arme);
		assertEquals(0, controleurSacADos.emplacementDeLArme(gentil));	//placement de l'arme sans autre article
		
		gentil = new Gentil("Le Gentil", 1000, 1000, 50);
		Article article = new Article("Riz", "nourriture/boisson", 1500, 200);
		gentil.ajouterArticleSacADosNonPlein(article);
		gentil.ajouterArticleSacADosNonPlein(arme);
		assertEquals(1, controleurSacADos.emplacementDeLArme(gentil));	//placement de l'arme apres un autre article
	}

	@Test
	void testGetArticle() {
		ControleurSacADos controleurSacADos = new ControleurSacADos();
		Article article = new Article("Riz", "nourriture/boisson", 1500, 200);
		gentil.ajouterArticleSacADosNonPlein(article);
		controleurSacADos.afficherSacADos(gentil);
		assertEquals("Riz", controleurSacADos.getArticle(gentil, 0).getNom());
	}

}
