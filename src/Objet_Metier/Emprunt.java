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
public class Emprunt implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne
	private Oeuvre oeuvre;
	@ManyToOne
	private Usager usager;
	@ManyToOne
	private Exemplaire exemplaire;

	public Emprunt(Oeuvre oeuvre, Usager usager, Exemplaire exemplaire, Date date) {
		super();
		this.oeuvre = oeuvre;
		this.usager = usager;
		this.exemplaire = exemplaire;
		this.date = date;
	}

	public Emprunt() {
		super();
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

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	public static Emprunt identifier(String nomUsager, String idExemplaire) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Query requete = em.createQuery("SELECT e FROM Emprunt e WHERE usager_nom=:nom AND exemplaire_id=:exemplaire");
		requete.setParameter("nom", nomUsager);
		requete.setParameter("exemplaire", idExemplaire);
		try {
			return (Emprunt) requete.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public static Emprunt usagerEmprunter(String nomUsager) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Query requete = em
				.createQuery("SELECT e FROM Emprunt e WHERE usager_nom=:nom");
		requete.setParameter("nom", nomUsager);
		try {
			return (Emprunt) requete.getResultList().get(0);
		} catch (IndexOutOfBoundsException e){
			return null;
		}
	}

}
