package personnage;

public abstract class Antagoniste extends EtreVivant{
	private int mechancete;
	
	public Antagoniste(String nom, int pointDeVie, int mechancete) {
		super(nom, pointDeVie);
		this.mechancete = mechancete;
	}
	
	public abstract void attaqueDeMechant(Gentil gentil);

	public int getMechancete() {
		return mechancete;
	}
}
