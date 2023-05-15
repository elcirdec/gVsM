package magasin;

import personnage.Gentil;

public class Magasin implements Batiment{
	private String nomMagasin;
	private int nbArticleMaxInventaire=10;
	private int nbArticle=0;
	private Article [] inventaire = new Article [nbArticleMaxInventaire]; //chaque magasin aura 10 article propos� max

	public Magasin(String nomMagasin) {
		this.nomMagasin = nomMagasin;	
	}

	//method
	public void ajouterArticleInventaire(Article article) {
		if(nbArticle<nbArticleMaxInventaire) {
			inventaire[nbArticle]=article;
			nbArticle++;
		}else {
			System.out.println("erreur inventaire plein");
		}
	}

	public void afficherInventaire() {
		for(int i=0;i<nbArticle;i++) {
			System.out.println(i+" - "+inventaire[i].getNom()+" ( effet = "+inventaire[i].getEffet()+" "+inventaire[i].effetSuffixe()+" | prix = "+inventaire[i].getPrix()+" )\n");
		}
	}

	public <T extends Magasin> void menuInventaire(Gentil gentil, T magasin, int resultat) {
		if(nbArticle>0) {
			if(gentil.isSolvable(inventaire[resultat])) {
				gentil.perdreArgent(inventaire[resultat].getPrix());
			}else {
				System.out.println("Vous quittez le menu d'achat de "+this.nomMagasin+" car vous etes trop pauvre\n");
			}

		}		

	}


	//getter
	public Article getArticle(int emplacementArticle) {
		return inventaire[emplacementArticle];
	}

	public int getNbArticle() {
		return nbArticle;
	}

	public String getNomMagasin() {
		return nomMagasin;
	}
}
