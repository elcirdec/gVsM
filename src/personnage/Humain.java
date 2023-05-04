package personnage;

public class Humain extends EtreVivant{
	private int argent;

	public Humain(String nom, int pointDeVie, int argent) {
		super(nom, pointDeVie);
		this.argent = argent;
	}

	//method

	public void perdreArgent(int debit) {
		this.argent= this.argent-debit;
		System.out.println(this.getNom()+" perd "+debit+" d'argent il lui reste "+this.argent+"\n");
	}

	public void ajouterArgent(int credit) {
		this.argent= this.argent+credit;
		System.out.println(this.getNom()+" gagne "+credit+" d'argent il a donc au total "+this.argent+"\n");
	}
	

	public void travailler(Humain salarie,int salaire) {		
		System.out.println("Voici ton salaire de "+salaire+" "+salarie.getNom()+" tu a bien travaillé!\n");
		salarie.ajouterArgent(salaire);
	}
	
	//getter
	public int getArgent() {
		return argent;
	}
	
}
