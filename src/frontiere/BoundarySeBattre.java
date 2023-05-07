package frontiere;

import java.util.Scanner;

import controleur.ControleurSeBattre;
import personnage.Antagoniste;
import personnage.Gentil;

public class BoundarySeBattre {
	private ControleurSeBattre controleurSeBattre;

	public BoundarySeBattre(ControleurSeBattre controleurSeBattre) {
		this.controleurSeBattre = controleurSeBattre;
	}
	
	public  <T extends Antagoniste> boolean seBattre(Gentil gentil, T adversere,Scanner scanner) {
		int mechancete=adversere.getMechancete();
		int resultat;
		do {
			System.out.println(adversere.getNom()+" est un mechant de mechancet� "+adversere.getMechancete());
			System.out.println("Vous avez une chance sur "+mechancete+" de r�ussir a fuire\n");
			System.out.println("Voulez vous fuire?\n 1 - Oui 2 - Non\n");
			resultat=scanner.nextInt();
		}while(resultat<1 || resultat>2);
		
		boolean gentilEstIlMort=controleurSeBattre.seBattre(gentil, adversere, resultat);
		return gentilEstIlMort;
	}

}
