package magasin;

public class Armurerie extends Magasin{

	private static final String ARME = "arme";	
	public Armurerie(String nomMagasin) {
		super(nomMagasin);	
		initialisationMagasinArmurerie();
		
	}

	public void initialisationMagasinArmurerie(){
		Article article = new Article("Banane", ARME, 50, 100);
		this.ajouterArticleInventaire(article);
		Article article1 = new Article("Poêle en inox", ARME, 150, 200);
		this.ajouterArticleInventaire(article1);
		Article article2 = new Article("Sandale", ARME, 300, 500);
		this.ajouterArticleInventaire(article2);
		Article article3 = new Article("Couteau", ARME, 500, 1000);
		this.ajouterArticleInventaire(article3);
		Article article4 = new Article("Katana", ARME, 1000, 5000);
		this.ajouterArticleInventaire(article4);
	}


}
