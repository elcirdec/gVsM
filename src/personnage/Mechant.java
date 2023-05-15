package personnage;

import java.util.Random;

public class Mechant extends Antagoniste{
	private Random ran = new Random();

	public Mechant(String nom, int pointDeVie, int mechancete) {
		super(nom, pointDeVie, mechancete);
	}

	@Override
	public void attaqueDeMechant(Gentil gentil) {
		int valeurDes = 1+ran.nextInt(5);
		int degats = 0;
		switch(valeurDes) {
		case 1:
			parler("Tu est moche!");
			degats=5*this.getMechancete();
			break;
		case 2:
			parler("Coup de poing!");
			degats=20*this.getMechancete();
			break;				
		case 3:
			parler("Coup de pied!");
			degats=25*this.getMechancete();
			break;
		case 4:
			parler("Coups serieux!");
			degats=50*this.getMechancete();
			break;
		case 5:
			parler("Coups mega serieux!");
			degats=100*this.getMechancete();
			break;
		default:
			System.out.println("Choix incorrect");
			break;
		}
		gentil.perdrePointDeVie(degats);
	}


}
