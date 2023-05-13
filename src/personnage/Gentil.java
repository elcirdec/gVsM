package personnage;

import java.util.Random;
import magasin.Article;

public class Gentil extends Humain{

	private int attaque;
	private SacADos sacADos;
	private Random ran = new Random();
	private static final String PASDECHANCE = "Pas de chance j'ai acheter cet article pour rien\n";

	public Gentil(String nom, int pointDeVie, int argent, int attaque) {
		super(nom, pointDeVie, argent);
		this.attaque = attaque;
		sacADos=new SacADos(this);
	}


	public boolean fuire(int chanceDeFuite) {	
		int valeurDes = ran.nextInt(chanceDeFuite);
		if(valeurDes==0) {
			System.out.println("Votre fuite a r�ussit\n");
		}else {
			System.out.println("Votre fuite a �chouer\n");
		}
		return (valeurDes==0);
	}

	public <T extends EtreVivant> void seBattreDialogue(T adversere) {
		boolean armeEquiper=this.isArmeEquipper();
		if(armeEquiper) {	
			parler("J'utilise mon arme "+sacADos.getNomArmeEquiper()+" et je te fais "+this.attaque+" point de degat");
			adversere.perdrePointDeVie(attaque);
		}else {
			parler("J'utilise mes poings et je te fais "+this.attaque+" point de degat");
			adversere.perdrePointDeVie(attaque);
		}
	}

	public <T extends Antagoniste> boolean seBattre(T adversere, int resultat) {
		boolean fuire=false;
		boolean gentilEstIlMort=false;
		int mechancete=adversere.getMechancete();

		if(resultat==1) {
			fuire=this.fuire(mechancete);
		}		
		while((this.estVivant() && adversere.estVivant()) && !fuire) {
			this.seBattreDialogue(adversere);
			if(adversere.estVivant()) {
				adversere.attaqueDeMechant(this);
			}
		}

		if( !(adversere.estVivant()) ) {	//si l'adversere est mort
			System.out.println("Vous avez gagn� "+adversere.getNom()+" le mechant a perdu\n");
		}else if( !(this.estVivant()) ){
			System.out.println("Vous etes mort");
			gentilEstIlMort=true;					
		}
		return gentilEstIlMort;
	}

	////////////////////// GESTION classe interne ///////////////////////
	public void donnerMenuUtiliserArticle(int res) {
		sacADos.menuUtiliserArticle(res);
	}

	public void afficherSacADos() {
		sacADos.afficherSacADos();
	}

	public boolean isArmeEquipper() {
		return sacADos.armeEquipper();
	}

	public boolean isAjouterArticlePossible() {
		int nbArticle=sacADos.getNbArticle();
		int nbArticleMax=sacADos.getNbArticleMax();
		return (nbArticle<nbArticleMax);
	}

	public void remplacerArmeSacADos(Article article, int resultat) {
		sacADos.remplacerArme(article, resultat);
	}

	public void ajouterArticleSacADosNonPlein(Article article) {
		sacADos.ajouterArticleSacADosNonPlein(article);
	}

	public void ajouterArticleSacADosPlein(Article article, int res) {
		sacADos.ajouterArticleSacADosPlein(article,res);
	}

	public int emplacementDeLArmeSacADos() {
		return sacADos.emplacementDeLArme();
	}

	public Article getArticleSacADos(int emplacement) {
		return sacADos.getArticle(emplacement);
	}

	public int getNbArticleSacADos() {
		return sacADos.getNbArticle();
	}

	////////////////////// Classe Interne ///////////////////////
	private static class SacADos {

		private Gentil gentil;
		private static final int nbArticleMax=10;
		private int nbArticle=0;
		private String nomArmeEquiper;
		private Article[] sacADos=new Article[nbArticleMax];


		private SacADos(Gentil gentil) {
			this.gentil = gentil;
		}


		public void afficherSacADos() {
			for(int i=0;i<nbArticle;i++) {
				System.out.println(i+" - "+sacADos[i].getNom()+" ( type = "+sacADos[i].getType()+" utilis� = "+sacADos[i].isArticleDejaUtiliser()+" )\n");
			}
		}

		public boolean armeEquipper() {
			String type;
			for(int i=0;i<nbArticle;i++) {
				type=sacADos[i].getType();
				if(type.equals("arme") && sacADos[i].isArticleDejaUtiliser()) {
					nomArmeEquiper=sacADos[i].getNom();
					return true;
				}
			}
			return false;
		}

		public int emplacementDeLArme() {
			int emplacementDeLArme=0;
			for(int i=0;i<nbArticle;i++) {
				if(sacADos[i].getType().equals("arme")) {
					System.out.println(i+" - "+sacADos[i].getNom()+" ( type = "+sacADos[i].getType()+" utilis� = "+sacADos[i].isArticleDejaUtiliser()+" )\n");
					emplacementDeLArme=i;
				}							
			}
			return emplacementDeLArme;
		}

		public void remplacerArme(Article article, int resultat) {
			int emplacementDeLArme=emplacementDeLArme();
			article.setArticleDejaUtiliser(true);
			if(resultat==1){	
				sacADos[emplacementDeLArme]=article;
				gentil.parler("Mon arme est desormais "+article.getNom()+"\n");
			}else {
				gentil.parler(PASDECHANCE);
			}
		}

		public void ajouterArticleSacADosNonPlein(Article article) {
			sacADos[nbArticle]=article;
			nbArticle++;
			gentil.parler("J'ajoute "+article.getNom()+" a mon inventaire\n");
		}

		public void ajouterArticleSacADosPlein(Article article, int res) {

			sacADos[res]=article;
			gentil.parler("J'ajoute "+article.getNom()+" a mon inventaire\n");

		}

		public void menuUtiliserArticle(int res) {		
			if(nbArticle>0) {

				if(res==(nbArticle)) {
					System.out.println("Vous quittez le menu des articles");
				}else {

					switch(sacADos[res].getType()) {

					case "nourriture/boisson":
						gentil.ajouterPointDeVie(sacADos[res].effetArticle(gentil));
						break;
					case "potion","arme":
						gentil.attaque=sacADos[res].effetArticle(gentil);
						System.out.println("Votre attaque passe a "+gentil.attaque);
					break;
					default:
						System.out.println("Erreur switch article");
						break;
					}
				}

			}else{
				System.out.println("Pas d'article dans le sac a dos\n");
			}
		}

		public String getNomArmeEquiper() {
			return nomArmeEquiper;
		}

		public int getNbArticleMax() {
			return nbArticleMax;
		}

		public int getNbArticle() {
			return nbArticle;
		}

		public Article getArticle(int emplacement) {
			return sacADos[emplacement];
		}

	}


	public boolean isSolvable(Article article) {
		return (this.getArgent()-article.getPrix()>=0);
	}

	public int getAttaque() {
		return attaque;
	}


}
