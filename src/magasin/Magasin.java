package magasin;

import java.util.Scanner;

import personnage.Gentil;

public class Magasin {
	private String nomMagasin;
	private int nbArticleMaxInventaire=10;
	private int nbArticle=0;
	private Article [] inventaire = new Article [nbArticleMaxInventaire]; //chaque magasin aura 10 article proposé max

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
	
	public void menuInventaire(Gentil gentil,Scanner scanner){
		int res2;
		if(nbArticle>0) {
			afficherInventaire();
			System.out.println("Vous avez "+gentil.getArgent()+" d'argent\n");

			do {
				System.out.println("Veuillez choisir un nombre entre 0 et "+(nbArticle-1)+ " pour acheter un article ou \nchoisissez "+nbArticle+" pour quitter le menu d'achat des articles de "+this.nomMagasin+" \n");
				res2=scanner.nextInt();
			}while(res2<0 || res2>nbArticle+1);
			if(res2==nbArticle) {
				System.out.println("Vous quittez le menu d'achat de "+this.nomMagasin+"\n");
			}else {
				if(gentil.isSolvable(inventaire[res2].getPrix())) {
					gentil.perdreArgent(inventaire[res2].getPrix());
					gentil.ajouterArticle(inventaire[res2],scanner);
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
	
}
