package Objet_Metier;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Oeuvre implements Serializable {

    @Id
    private String titre;
    private int editeur;
    private int nombreExemplaire;

    public Oeuvre(String titre, int editeur, int nombreExemplaire) {
        this.titre = titre;
        this.editeur = editeur;
        this.nombreExemplaire = nombreExemplaire;
    }

    /**
     *
     * @param titre
     */
    public Oeuvre e_identification(String titre) {
        // TODO - implement Oeuvre.e_identification
        throw new UnsupportedOperationException();
    }

}
