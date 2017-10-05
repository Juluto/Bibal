package Objet_Metier;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Magazine extends Oeuvre {

    private int Numero;
    private int Date;

    public Magazine(String titre, int editeur, int nombreExemplaire) {
        super(titre, editeur, nombreExemplaire);
    }

}
