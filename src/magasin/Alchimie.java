package magasin;

public class Alchimie extends Magasin{
	private static final String POTION = "potion";	
	public Alchimie(String nomMagasin) {
		super(nomMagasin);	
		initialisationMagasinAlchimie();

	}

	public void initialisationMagasinAlchimie(){
		Article article = new Article("Potion Kilo good", POTION, 2, 100);
		this.ajouterArticleInventaire(article);
		Article article1 = new Article("Potion Mega good", POTION, 4, 200);
		this.ajouterArticleInventaire(article1);
		Article article2 = new Article("Potion Giga good", POTION, 8, 400);
		this.ajouterArticleInventaire(article2);
		Article article3 = new Article("Potion Tera good", POTION, 16, 800);
		this.ajouterArticleInventaire(article3);
		Article article4 = new Article("Potion Peta good", POTION, 32, 1600);
		this.ajouterArticleInventaire(article4);
	}

//	public static void main(String[] args) {
//		Gentil gentil = new Gentil("Le Gentil", 1000, 1000, 50);
//		Alchimie alchimiste= new Alchimie("Chez le bon alchimiste");
//		int res;
//		Scanner scanner = new Scanner(System.in);
//			do {
//				alchimiste.menuInventaire(gentil);
//				System.out.println("br");
//				res=scanner.nextInt();
//				System.out.println("ok");
//			}while(res!=5);
//		
//	}
}