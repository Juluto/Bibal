package Objet_Metier;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reservation implements Serializable {

    @Id
    private int id;
    private Date date;

    /**
     *
     * @param u
     * @param o
     * @param dateJour
     */
    public Reservation Reservation(int id, Usager u, Oeuvre o, Date dateJour) {
        // TODO - implement Reservation.Reservation
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param o
     * @param u
     */
    public Reservation e_identification(Oeuvre o, Usager u) {
        // TODO - implement Reservation.e_identification
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param r
     */
    public Reservation annuler(Reservation r) {
        // TODO - implement Reservation.annuler
        throw new UnsupportedOperationException();
    }

}
