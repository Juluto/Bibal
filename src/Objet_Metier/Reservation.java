package Objet_Metier;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
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

	public static Reservation identifier(String nomUsager, String titreOeuvre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Query requeteReservation = em
				.createQuery("SELECT r FROM Reservation r WHERE usager_nom=:nom AND oeuvre_titre=:titre");
		requeteReservation.setParameter("nom", nomUsager);
		requeteReservation.setParameter("titre", titreOeuvre);
		try{
			return (Reservation) requeteReservation.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public static Reservation usagerReserver(String nomUsager) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Query requete = em
				.createQuery("SELECT r FROM Reservation r WHERE usager_nom=:nom");
		requete.setParameter("nom", nomUsager);
		try {
			return (Reservation) requete.getResultList().get(0);
		} catch (IndexOutOfBoundsException e){
			return null;
		}
	}

	public static Reservation oeuvreReserver(String titreOeuvre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Query requete = em
				.createQuery("SELECT r FROM Reservation r WHERE oeuvre_titre=:oeuvre_titre");
		requete.setParameter("oeuvre_titre", titreOeuvre);
		try {
			return (Reservation) requete.getResultList().get(0);
		} catch (IndexOutOfBoundsException e){
			return null;
		}
	}

}
