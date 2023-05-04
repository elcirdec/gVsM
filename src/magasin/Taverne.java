package magasin;

public class Taverne extends Magasin{

	private static final String FOOD = "nourriture/boisson";	
	public Taverne(String nomMagasin) {
		super(nomMagasin);	
		initialisationMagasinTaverne();
	}

	public void initialisationMagasinTaverne(){
		Article article0 = new Article("McDo", FOOD, -1000, 500);
		this.ajouterArticleInventaire(article0);
		Article article1 = new Article("Pate", FOOD, 500, 100);
		this.ajouterArticleInventaire(article1);
		Article article2 = new Article("Riz", FOOD, 1500, 200);
		this.ajouterArticleInventaire(article2);
		Article article3 = new Article("Raclette", FOOD, 3000, 500);
		this.ajouterArticleInventaire(article3);
		Article article4 = new Article("Champagne", FOOD, 5000, 1000);
		this.ajouterArticleInventaire(article4);
		Article article5 = new Article("Ramen", FOOD, 10000, 5000);
		this.ajouterArticleInventaire(article5);
		
	}
}
