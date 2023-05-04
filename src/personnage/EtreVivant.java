package personnage;

public abstract class EtreVivant {
	private String nom;
	private int pointDeVie;

	public EtreVivant(String nom, int pointDeVie) {
		this.nom = nom;
		this.pointDeVie = pointDeVie;
	}
	
	//method
	public boolean estVivant() {
		return(pointDeVie>0);
	}
	public void perdrePointDeVie(int nbPointDeVieEnMoins) {
		this.pointDeVie= this.pointDeVie-nbPointDeVieEnMoins;
		System.out.println("\n"+this.getNom()+" perd "+nbPointDeVieEnMoins+" point de Vie il lui reste donc "+this.getPointDeVie()+" point de Vie\n");
	}

	public void ajouterPointDeVie(int nbPointDeVieEnPlus) {
		this.pointDeVie= this.pointDeVie+nbPointDeVieEnPlus;
		System.out.println("\n"+"Vous gagnez "+nbPointDeVieEnPlus+" point de Vie vous avez donc au total "+this.getPointDeVie()+" point de Vie\n");
	}
	
	public void parler(String texte) {
		System.out.println(this.getNom()+" - "+texte);
	}
	
	//getter
	public String getNom() {
		return nom;
	}
	public int getPointDeVie() {
		return pointDeVie;
	}


}
