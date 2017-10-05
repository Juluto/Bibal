package Objet_Metier;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Livre extends Oeuvre {

    private String auteur;

    public Livre(String titre, int editeur, int nombreExemplaire) {
        super(titre, editeur, nombreExemplaire);
    }

}
