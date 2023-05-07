package magasin;

import personnage.Gentil;

public class Magasin {
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
			System.out.println(i+" - "+inventaire[i].getNom()+" ( type = "+inventaire[i].getType()+" | prix = "+inventaire[i].getPrix()+" )\n");
		}
	}
	
	public <T extends Magasin> void menuInventaire(Gentil gentil, T magasin, int resultat) {
		if(nbArticle>0) {
			if(resultat==nbArticle) {
				System.out.println("Vous quittez le menu d'achat de "+this.nomMagasin+"\n");
			}else {
				if(gentil.isSolvable(inventaire[resultat].getPrix())) {
					gentil.perdreArgent(inventaire[resultat].getPrix());
					gentil.ajouterArticle(inventaire[resultat]);		////????
				}else {
					System.out.println("Vous quittez le menu d'achat de "+this.nomMagasin+" car vous etes trop pauvre\n");
				}
			}
		}		

	}
	

	//getter
	public Article[] getInventaire() {
		return inventaire;
	}
	
	public int getNbArticle() {
		return nbArticle;
	}

	public String getNomMagasin() {
		return nomMagasin;
	}
}
