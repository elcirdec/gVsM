package magasin;

public interface Batiment {
	public void ajouterArticleInventaire(Article article);
	public void afficherInventaire();
	public Article getArticle(int emplacementArticle);
	public int getNbArticle();
	public String getNomMagasin();
}
