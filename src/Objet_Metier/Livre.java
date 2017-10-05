package Objet_Metier;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Livre extends Oeuvre {

    private String auteur;

    public Livre(String titre, String editeur, int nombreExemplaire, String auteur) {
        super(titre, editeur, nombreExemplaire);
        this.auteur = auteur;
    }
    
    public Livre() {
        super();
    }

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}
