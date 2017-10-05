package Objet_Metier;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Exemplaire implements Serializable {

    @Id
    private int id;
    private int Etat;

    public Exemplaire(int id, int Etat) {
        this.Etat = Etat;
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
