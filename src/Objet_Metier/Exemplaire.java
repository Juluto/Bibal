package Objet_Metier;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

	public static Exemplaire identifierExemplaireDisponible(String titreOeuvre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Query requeteEmprunt = em
				.createQuery("SELECT e FROM Exemplaire e WHERE etat = 'Disponible' AND oeuvre_titre=:titre");
		requeteEmprunt.setParameter("titre", titreOeuvre);
		try{
			List<Exemplaire> listExemplaire = (List<Exemplaire>) requeteEmprunt.getResultList();
			return listExemplaire.get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	public static Exemplaire identifier(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		return em.find(Exemplaire.class, id);
	}

	public static Exemplaire oeuvreExemplaire(String titreOeuvre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Query requeteEmprunt = em
				.createQuery("SELECT e FROM Exemplaire e WHERE oeuvre_titre=:titre");
		requeteEmprunt.setParameter("titre", titreOeuvre);
		try{
			List<Exemplaire> listExemplaire = (List<Exemplaire>) requeteEmprunt.getResultList();
			return listExemplaire.get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

}
