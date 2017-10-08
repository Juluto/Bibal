package Objet_Metier;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne
	private Oeuvre oeuvre;
	@ManyToOne
	private Usager usager;

	public Reservation(Usager u, Oeuvre o, Date date) {
		this.usager = u;
		this.oeuvre = o;
		this.date = date;
	}

	public Reservation() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Oeuvre getOeuvre() {
		return oeuvre;
	}

	public void setOeuvre(Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
	}

	public Usager getUsager() {
		return usager;
	}

	public void setUsager(Usager usager) {
		this.usager = usager;
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
