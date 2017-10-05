package Objet_Metier;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Emprunt implements Serializable {

    @Id
    private int id;
    private Date Date;

    /**
     *
     * @param u
     * @param o
     * @param e
     * @param dateJour
     */
    public Emprunt Emprunt(int id, Usager u, Oeuvre o, Exemplaire e, Date dateJour) {
        // TODO - implement Emprunt.Emprunt
        throw new UnsupportedOperationException();
    }

}
