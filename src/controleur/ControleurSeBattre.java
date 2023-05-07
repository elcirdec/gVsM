package controleur;

import personnage.Antagoniste;
import personnage.Gentil;

public class ControleurSeBattre {

	public ControleurSeBattre() {
	}
	
	public <T extends Antagoniste> boolean seBattre(Gentil gentil, T adversere, int resultat) {
		return gentil.seBattre(adversere, resultat);
	}
}
