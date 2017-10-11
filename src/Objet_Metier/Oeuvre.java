package Objet_Metier;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Persistence;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCRIMINATOR")
@DiscriminatorValue("OEUVRE")
public class Oeuvre implements Serializable {

	@Id
	private String titre;
	private String editeur;
	private int nombreExemplaire;

	public Oeuvre(String titre, String editeur, int nombreExemplaire) {
		this.titre = titre;
		this.editeur = editeur;
		this.nombreExemplaire = nombreExemplaire;
	}

	public Oeuvre() {
		super();
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public int getNombreExemplaire() {
		return nombreExemplaire;
	}

	public void setNombreExemplaire(int nombreExemplaire) {
		this.nombreExemplaire = nombreExemplaire;
	}


	public static Oeuvre identifier(String titre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		return em.find(Oeuvre.class, titre);
	}

	public static void ajouterNombreExemplaire(Oeuvre oeuvre, int quantite) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		oeuvre = em.find(Oeuvre.class, oeuvre.getTitre());
		oeuvre.setNombreExemplaire(oeuvre.getNombreExemplaire() + quantite);
		em.getTransaction().commit();
	}

	public static void retirerNombreExemplaire(Oeuvre oeuvre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		oeuvre = em.find(Oeuvre.class, oeuvre.getTitre());
		oeuvre.setNombreExemplaire(oeuvre.getNombreExemplaire() - 1);
		em.getTransaction().commit();
	}

}
