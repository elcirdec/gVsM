package frontiere;

import java.util.Scanner;
import java.util.Random;

import magasin.*;
import personnage.*;

public class BoundaryMenuJeu {
		private Random ran = new Random();

		private Gentil gentil = new Gentil("Le Gentil", 1000, 1000, 50);
		private Mechant mechant = new Mechant("Le mechant", 1000, 2);
		private Monstre monstre = new Monstre("Le monstre", 500, 1);
		private Alchimie alchimiste = new Alchimie("Chez le bon alchimiste");
		private Taverne taverne = new Taverne("Chez le bon tavernier");
		private Armurerie armurerie = new Armurerie("Chez le bon armurier");
		

		private BoundarySeBattre boundarySeBattre = new BoundarySeBattre();
		private BoundaryAcheterProduit boundaryAcheterProduit = new BoundaryAcheterProduit();
		private BoundarySacADos boundarySacADos = new BoundarySacADos();
		
		public boolean menuJeu(Scanner scanner){
			int res=0;
			boolean gentilEstIlMort=false;
			System.out.println("0 - Travailler\n1 - Affronter un ennemie\n2 - Aller a la taverne\n3 - Aller chez l'alchimiste\n4 - Aller a l'armuerie\n5 - Utiliser un article du sac a dos\n6 - Quitter le jeu\n");
			do {
				System.out.println("Veuillez choisir un nombre entre 0 et 5 pour effectuer une action ou 6 pour quitter le jeu\n");
				res=scanner.nextInt();

			}while(res<0 || res>6);
			
			switch(res) {
			case 0:
				gentil.travailler(gentil, 1000);	// travaille et obtient 1000 d'argent
				break;
			case 1:
				gentilEstIlMort=boundarySeBattre.seBattre(gentil, mechant, scanner); 
				//sinon c'est que la fuite a reussit
				break;
			case 2:
				boundaryAcheterProduit.menuInventaire(gentil, taverne, scanner);
				break;
			case 3:
				boundaryAcheterProduit.menuInventaire(gentil, alchimiste, scanner);
				break;
			case 4:
				boundaryAcheterProduit.menuInventaire(gentil, armurerie ,scanner);
				break;
			case 5:
				boundarySacADos.menuUtiliserArticle(scanner, gentil);
				break;
			case 6:
				System.out.println("Vous quittez le jeu");
				gentilEstIlMort=true;
				break;
			default:
				System.out.println("Erreur reponse switch menuJeu");
				break;
			}			
			
			int valeurDes = 1+ran.nextInt(20);
			if(valeurDes==20) {
				System.out.println("Un monstre vous attaque inopinément et engage le combat\nVous ne pouvez pas fuire !\n");
				gentilEstIlMort=boundarySeBattre.seBattre(gentil, monstre, scanner); 
			}
			return gentilEstIlMort;
		}
		
		public void jouer() {
			boolean finPartie = false;
			try(Scanner scanner = new Scanner(System.in)){
				do {
					finPartie=menuJeu(scanner);
				}while (!finPartie);
			}
		}

}
