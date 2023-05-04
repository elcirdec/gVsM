package magasin;

import personnage.Gentil;

public class Article {
	private String nom;
	private String type;
	private int effet;
	private int prix;
	private boolean articleDejaUtiliser=false;

	public Article(String nom, String type, int effet, int prix) {
		this.nom = nom;
		this.type = type;
		this.effet = effet;
		this.prix = prix;
	}

	//method
	public int effetArticle(Gentil gentil) {
		int nouvelleStat=0;
		switch(this.type) {
		case "arme":
			nouvelleStat=gentil.getAttaque()+effet;
			break;
		case "nourriture/boisson":
			nouvelleStat=effet;
			break;
		case "potion":
			nouvelleStat=gentil.getAttaque()*effet;
			break;
		default:
			System.out.println("Erreur switch article");
		}
		this.articleDejaUtiliser=true;
		return nouvelleStat;
	}

	public boolean isArticleDejaUtiliser() {
		return articleDejaUtiliser;
	}
	
	//getter
	public String getNom() {
		return nom;
	}
	public String getType() {
		return type;
	}
	public int getPrix() {
		return prix;
	}

}
