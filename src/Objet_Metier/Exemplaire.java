package Objet_Metier;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Exemplaire implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String Etat;
    @ManyToOne
    private Oeuvre oeuvre;

    public Exemplaire(int id, String Etat) {
        this.Etat = Etat;
    }
    
    public Exemplaire(int id, String Etat, Oeuvre oeuvre) {
        this.Etat = Etat;
        this.oeuvre = oeuvre;
    }
    
    public Exemplaire() {
    	super();
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}

	public Oeuvre getOeuvre() {
		return oeuvre;
	}

	public void setOeuvre(Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
	}

	public void mettreAJour() {
        // TODO - implement Exemplaire.mettreAJour
        throw new UnsupportedOperationException();
    }

    public void rechercher() {
        // TODO - implement Exemplaire.rechercher
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param o
     */
    public Exemplaire e_identification(Oeuvre o) {
        // TODO - implement Exemplaire.e_identification
        throw new UnsupportedOperationException();
    }

}
