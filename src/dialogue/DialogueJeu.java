package dialogue;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import controleur.ControleurAcheterProduit;
import controleur.ControleurSacADos;
import controleur.ControleurSeBattre;
import presentation.JFrameMenuAlchimiste;
import presentation.JFrameMenuArmurerie;
import presentation.JFrameMenuPrincipale;
import presentation.JFrameMenuTaverne;
import presentation.JFrameSacADos;
import frontiere.BoundaryMenuJeu;
import magasin.Alchimie;
import magasin.Armurerie;
import magasin.Article;
import magasin.Taverne;
import personnage.Gentil;
import personnage.Mechant;
import personnage.Monstre;

public class DialogueJeu {

	private JFrameMenuPrincipale jFrameJeu;
	private JFrameMenuAlchimiste jFrameMenuAlchimiste;
	private JFrameMenuArmurerie jFrameMenuArmurerie;
	private JFrameMenuTaverne jFrameMenuTaverne;
	private JFrameSacADos jFrameSacADos;

	private javax.swing.JDialog jDialog1=new javax.swing.JDialog();

	private ControleurAcheterProduit controleurAcheterProduit = new ControleurAcheterProduit();
	private ControleurSacADos controleurSacADos= new ControleurSacADos();
	private ControleurSeBattre controleurSeBattre=new ControleurSeBattre();

	private Gentil gentil = new Gentil("Le Gentil", 1000, 1000, 50);
	private Mechant mechant = new Mechant("Le mechant", 1000, 2);
	private Monstre monstre = new Monstre("Le monstre", 500, 1);
	private Alchimie alchimiste = new Alchimie("Chez le bon alchimiste");
	private Taverne taverne = new Taverne("Chez le bon tavernier");
	private Armurerie armurerie = new Armurerie("Chez le bon armurier");

	private boolean gentilEstIlMort=false;

	public void initDialog() {
		//Create presentation frame
		jFrameJeu = new JFrameMenuPrincipale();
		jFrameMenuAlchimiste = new JFrameMenuAlchimiste();
		jFrameMenuArmurerie = new JFrameMenuArmurerie();
		jFrameMenuTaverne = new JFrameMenuTaverne();
		jFrameSacADos = new JFrameSacADos();

		//Associate dialogue to presentation
		jFrameJeu.setDialogue(this);
		jFrameMenuAlchimiste.setDialogue(this);
		jFrameMenuArmurerie.setDialogue(this);
		jFrameMenuTaverne.setDialogue(this);
		jFrameSacADos.setDialogue(this);

		jFrameJeu.setVisible(true);
		jFrameMenuAlchimiste.setVisible(false);
		jFrameMenuArmurerie.setVisible(false);
		jFrameMenuTaverne.setVisible(false);
		jFrameSacADos.setDialogue(this);
	}

	public void eventChoixActionMenuPrincipale(int noAction) {

		jFrameJeu.resetPresentation();
		if(noAction>6 || noAction<0) {
			jFrameJeu.setPresentationChoixMenuErreur();
		}else {
			switch(noAction) {
			case 0:
				gentil.travailler(gentil, 1000);
				//Display confirmation window using JOptionPane
				JOptionPane.showConfirmDialog(jDialog1,"Voici ton salaire de "+1000+" "+gentil.getNom()+" tu a bien travaillé!","Travaille",
						JOptionPane.DEFAULT_OPTION);
				break;
			case 1:
				gentilEstIlMort=controleurSeBattre.seBattre(gentil, mechant, 2);

				if(gentilEstIlMort) {
					JOptionPane.showConfirmDialog(null,"Vous etes mort","Dead",
							JOptionPane.DEFAULT_OPTION);
				}else {
					JOptionPane.showConfirmDialog(null,"Vous avez triompher","Alive",
							JOptionPane.DEFAULT_OPTION);
				}
				break;
			case 2:
				jFrameJeu.setVisible(false);
				jFrameMenuTaverne.setPresentationArgent(gentil.getArgent());
				jFrameMenuTaverne.setVisible(true);
				break;
			case 3:
				jFrameJeu.setVisible(false);
				jFrameMenuAlchimiste.setPresentationArgent(gentil.getArgent());
				jFrameMenuAlchimiste.setVisible(true);
				break;
			case 4:
				jFrameJeu.setVisible(false);
				jFrameMenuArmurerie.setPresentationArgent(gentil.getArgent());
				jFrameMenuArmurerie.setVisible(true);
				break;
			case 5:
				int nbArticle=controleurSacADos.getNbAtricle(gentil);
				if(nbArticle!=0) {
					String[] nomArticle = new String[nbArticle];
					for(int i=0;i<nomArticle.length;i++) {
						nomArticle[i]=controleurSacADos.getArticle(gentil, i).getNom();
					}
					boolean[] etatArticle = new boolean[nbArticle];
					for(int i=0;i<etatArticle.length;i++) {
						etatArticle[i]=controleurSacADos.getArticle(gentil, i).isArticleDejaUtiliser();
					}

					jFrameJeu.setVisible(false);

					jFrameSacADos.setPresentationNomArticle(nomArticle,nbArticle);
					jFrameSacADos.setPresentationEtatArticle(etatArticle,nbArticle);
					jFrameSacADos.setPresentationNbArticle(nbArticle-1);
					jFrameSacADos.setPresentationNbArticlePlusUn(nbArticle);
					jFrameSacADos.setVisible(true);
				}else {
					JOptionPane.showConfirmDialog(jDialog1,"Vous n'avez aucun article pour le moment","Pas d'article dans le sac a dos",
							JOptionPane.DEFAULT_OPTION);
				}
				break;
			case 6:
				jFrameJeu.dispose();
				break;
			default:
				System.out.println("Erreur reponse switch menuJeu");
				break;
			}
			if(gentilEstIlMort) {
				jFrameJeu.dispose();
			}
		}
	}

	public void eventChoixActionMenuTaverne(int noAction) {
		jFrameMenuTaverne.resetPresentation();
		if(noAction>6 || noAction<0) {
			jFrameMenuTaverne.setPresentationChoixMenuErreur();
		}else if(noAction!=6){
			Article article=controleurAcheterProduit.getArticle(taverne, noAction);

			if(gentil.isSolvable(article)){	
				if(controleurAcheterProduit.isAjouterArticlePossible(gentil)) {
					controleurSacADos.sacADosNonPlein(article, gentil);
				}else {

					String[] options = new String[10];
					for(int i=0;i<options.length;i++) {
						options[i]=controleurSacADos.getArticle(gentil, i).getNom();
					}
					int x = JOptionPane.showOptionDialog(null, "Votre sac a dos est plein, Sélectionner l'article que vous voulez supprimer",
							"Sac a dos plein",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
					controleurSacADos.sacADosPlein(article, gentil,x);
				}
			}else {
				JOptionPane.showConfirmDialog(null,"Vous n'avez pas assez d'argent vous quitter le menu du magasin","Vous etes pauvre",
						JOptionPane.DEFAULT_OPTION);
			}
			controleurAcheterProduit.menuInventaire(gentil, taverne, noAction);
			jFrameJeu.setVisible(true);
			jFrameMenuTaverne.setVisible(false);
		}else {
			jFrameJeu.setVisible(true);
			jFrameMenuTaverne.setVisible(false);
		}

	}

	public void eventChoixActionMenuAlchimiste(int noAction) {
		System.out.println(noAction);
		jFrameMenuAlchimiste.resetPresentation();
		if(noAction>5 || noAction<0) {
			jFrameMenuAlchimiste.setPresentationChoixMenuErreur();
		}else if(noAction!=5){
			Article article=controleurAcheterProduit.getArticle(alchimiste, noAction);

			if(gentil.isSolvable(article)){	
				if(controleurAcheterProduit.isAjouterArticlePossible(gentil)) {
					controleurSacADos.sacADosNonPlein(article, gentil);
				}else {

					String[] options = new String[10];
					for(int i=0;i<options.length;i++) {
						options[i]=controleurSacADos.getArticle(gentil, i).getNom();
					}
					int x = JOptionPane.showOptionDialog(null, "Votre sac a dos est plein, Sélectionner l'article que vous voulez supprimer",
							"Sac a dos plein",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
					controleurSacADos.sacADosPlein(article, gentil,x);
				}
			}else {
				JOptionPane.showConfirmDialog(null,"Vous n'avez pas assez d'argent vous quitter le menu du magasin","Vous etes pauvre",
						JOptionPane.DEFAULT_OPTION);
			}
			controleurAcheterProduit.menuInventaire(gentil, alchimiste, noAction);
			jFrameJeu.setVisible(true);
			jFrameMenuAlchimiste.setVisible(false);
		}else {
			jFrameJeu.setVisible(true);
			jFrameMenuAlchimiste.setVisible(false);
		}

	}

	public void eventChoixActionMenuArmurie(int noAction) {

		jFrameMenuArmurerie.resetPresentation();
		if(noAction>5 || noAction<0) {
			jFrameMenuArmurerie.setPresentationChoixMenuErreur();
		}else if(noAction!=5){
			Article article=controleurAcheterProduit.getArticle(armurerie, noAction);

			if(gentil.isSolvable(article)){		
				if(!controleurSacADos.isArmeEquipper(gentil)) {
					if(controleurAcheterProduit.isAjouterArticlePossible(gentil)) {
						controleurSacADos.sacADosNonPlein(article, gentil);
					}else {

						String[] options = new String[10];
						for(int i=0;i<options.length;i++) {
							options[i]=controleurSacADos.getArticle(gentil, i).getNom();
						}
						int x = JOptionPane.showOptionDialog(null, "Votre sac a dos est plein, Sélectionner l'article que vous voulez supprimer",
								"Sac a dos plein",
								JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
						System.out.println(x);
						controleurSacADos.sacADosPlein(article, gentil,x);
					}
				}else {
					String[] options = {"oui","non"};
					int positionArmeEquipper=controleurSacADos.emplacementDeLArme(gentil);
					Article arme= controleurSacADos.getArticle(gentil, positionArmeEquipper);
					int x = JOptionPane.showOptionDialog(null, "Vous ne pouvez avoir qu'une seul arme voulez vous remplacer "+arme.getNom()+" ?",
							"Sac a dos plein",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
					if(x==0) {
						controleurSacADos.remplacerArme(article, gentil, 1);
					}
				}
			}else {
				JOptionPane.showConfirmDialog(null,"Vous n'avez pas assez d'argent vous quitter le menu du magasin","Vous etes pauvre",
						JOptionPane.DEFAULT_OPTION);
			}
			controleurAcheterProduit.menuInventaire(gentil, armurerie, noAction);
			jFrameJeu.setVisible(true);
			jFrameMenuArmurerie.setVisible(false);
		}else {
			jFrameJeu.setVisible(true);
			jFrameMenuArmurerie.setVisible(false);
		}

	}

	public void eventChoixActionMenuSacADos(int noAction) {

		jFrameSacADos.resetPresentation();
		System.out.println(controleurSacADos.getNbAtricle(gentil));
		if(noAction>controleurSacADos.getNbAtricle(gentil) || noAction<0) {
			jFrameSacADos.setPresentationChoixMenuErreur(controleurSacADos.getNbAtricle(gentil)+1);
		}else if(noAction!=controleurSacADos.getNbAtricle(gentil)){

			if(!controleurSacADos.getArticle(gentil, noAction).isArticleDejaUtiliser()) {
				controleurSacADos.menuUtiliserArticle(gentil, noAction);
			}else {
				JOptionPane.showConfirmDialog(null,"Vous avez deja utiliser cet article","Pas de memoire",
						JOptionPane.DEFAULT_OPTION);
			}

			jFrameJeu.setVisible(true);
			jFrameSacADos.setVisible(false);
		}else {
			jFrameJeu.setVisible(true);
			jFrameSacADos.setVisible(false);
		}

	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		//Create dialogReservation
		DialogueJeu dialogueJeu = new DialogueJeu();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dialogueJeu.initDialog();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
