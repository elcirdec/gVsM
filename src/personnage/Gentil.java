package personnage;

import java.util.Random;
import java.util.Scanner;

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
			System.out.println("Votre fuite a réussit\n");
		}else {
			System.out.println("Votre fuite a échouer\n");
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

	public <T extends Antagoniste> boolean seBattre(T adversere,Scanner scanner) {
		boolean fuire=false;
		int res2;
		boolean gentilEstIlMort=false;
		int mechancete=adversere.getMechancete();
		do {
			System.out.println(adversere.getNom()+" est un mechant de mechanceté "+adversere.getMechancete());
			System.out.println("Vous avez une chance sur "+mechancete+" de réussir a fuire\n");
			System.out.println("Voulez vous fuire?\n 1 - Oui 2 - Non\n");
			res2=scanner.nextInt();
		}while(res2<1 || res2>2);
		if(res2==1) {
			fuire=this.fuire(mechancete);
		}		
		while((this.estVivant() && adversere.estVivant()) && !fuire) {
			this.seBattreDialogue(adversere);
			if(adversere.estVivant()) {
				adversere.attaqueDeMechant(this);
			}
		}

		if( !(adversere.estVivant()) ) {	//si l'adversere est mort
			System.out.println("Vous avez gagné "+adversere.getNom()+" le mechant a perdu\n");
		}else if( !(this.estVivant()) ){
			System.out.println("Vous etes mort");
			gentilEstIlMort=true;					
		}
		return gentilEstIlMort;
	}
	////////////////////// GESTION classe interne ///////////////////////
	public void donnerMenuUtiliserArticle(Scanner scanner) {
		sacADos.menuUtiliserArticle(scanner);
	}
	public boolean isArmeEquipper() {
		return sacADos.armeEquipper();
	}
	public void ajouterArticle(Article article,Scanner scanner) {
		boolean armeEquiper=this.isArmeEquipper();
		int nbArticle=sacADos.getNbArticle();
		int nbArticleMax=sacADos.getNbArticleMax();
		if(nbArticle<nbArticleMax) {
			sacADos.sacADosNonPlein(article,scanner,armeEquiper);
		}else {
			sacADos.sacADosPlein(article, scanner, armeEquiper);
		}
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
				System.out.println(i+" - "+sacADos[i].getNom()+" ( type = "+sacADos[i].getType()+" utilisé = "+sacADos[i].isArticleDejaUtiliser()+" )\n");
			}
		}

		public boolean armeEquipper() {
			String type;
			for(int i=0;i<nbArticle;i++) {
				type=sacADos[i].getType();
				if(type.equals("arme")) {
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
					System.out.println(i+" - "+sacADos[i].getNom()+" ( type = "+sacADos[i].getType()+" utilisé = "+sacADos[i].isArticleDejaUtiliser()+" )\n");
					emplacementDeLArme=i;
				}							
			}
			return emplacementDeLArme;
		}

		public void remplacerArme(Article article,Scanner scanner) {
			int emplacementDeLArme=emplacementDeLArme();
			int res;
			do {
				System.out.println("Taper 0 pour abandonner l'article acheté ou"
						+ "\nTaper "+emplacementDeLArme+" pour remplacer votre arme actuelle "+sacADos[emplacementDeLArme].getNom()+" par la nouvelle\n"+article.getNom()+"\n");
				res=scanner.nextInt();
			}while(res!=0 && res!=emplacementDeLArme);

			if(res!=0){	
				sacADos[emplacementDeLArme]=article;
				gentil.parler("J'ajoute "+article.getNom()+" a mon inventaire\n");
			}else {
				gentil.parler(PASDECHANCE);
			}
		}

		public void sacADosNonPlein(Article article,Scanner scanner,Boolean armeEquiper) {
			if(Boolean.TRUE.equals(armeEquiper)) {	// on ne peut pas avoir 2 armes
				System.out.println("Vous ne pouvez pas avoir plus d'une arme");
				remplacerArme(article,scanner);
			}else {
				sacADos[nbArticle]=article;
				nbArticle++;
				gentil.parler("J'ajoute "+article.getNom()+" a mon inventaire\n");
			}
		}

		public void sacADosPlein(Article article,Scanner scanner,Boolean armeEquiper) {
			int res;
			if(Boolean.TRUE.equals(armeEquiper)) {	// on ne peut pas avoir 2 armes
				System.out.println("Vous ne pouvez pas avoir plus d'une arme");
				System.out.println("Votre sac a dos est plein\n");
				remplacerArme(article,scanner);
			}else {
				do {
					afficherSacADos();	
					System.out.println("Votre sac a dos est plein\nTaper "+nbArticle+" pour abandonner l'article acheté ou"
							+ "\nTaper le numero de l'article que vous voulez supprimer pour ranger "+article.getNom()+"\n");
					res=scanner.nextInt();
				}while(res<0 && res>nbArticle+1);	

				if(res!=(nbArticle)){	
					sacADos[res]=article;
					gentil.parler("J'ajoute "+article.getNom()+" a mon inventaire\n");
				}else {
					gentil.parler(PASDECHANCE);
				}

			}
		}

		public void menuUtiliserArticle(Scanner scanner) {		
			int res;
			if(nbArticle>0) {
				afficherSacADos();

				do {
					System.out.println("Veuillez choisir un nombre entre 0 et "+(nbArticle-1)+ " pour utiliser un article (non utiliser) ou \n choisissez "+nbArticle+" pour quitter le menu d'utilsation des articles \n");
					res=scanner.nextInt();

				}while(res<0 || res>nbArticle+1|| sacADos[res].isArticleDejaUtiliser());
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

	}


	public boolean isSolvable(int debit) {
		return (this.getArgent()-debit>=0);
	}

	public int getAttaque() {
		return attaque;
	}


}
