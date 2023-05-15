package personnage;

public class Monstre extends Antagoniste{

	public Monstre(String nom, int pointDeVie, int mechancete) {
		super(nom, pointDeVie, mechancete);
		
	}

	@Override
	public void attaqueDeMechant(Gentil gentil) {
		gentil.perdrePointDeVie(50*this.getMechancete());		
	}

	
}
