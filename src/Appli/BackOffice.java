package Appli;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Objet_Metier.Emprunt;
import Objet_Metier.Exemplaire;
import Objet_Metier.Livre;
import Objet_Metier.Magazine;
import Objet_Metier.Oeuvre;
import Objet_Metier.Reservation;
import Objet_Metier.Usager;

public class BackOffice {

	public static String validerReserverOeuvre(String nomUsager, String titreOeuvre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Usager usager = Usager.identifier(nomUsager);
		Oeuvre oeuvre = Oeuvre.identifier(titreOeuvre);
		if (usager == null || oeuvre == null) {
			if (usager == null) {
				em.close();
				emf.close();
				return "L'usager n'existe pas !";
			}
			if (oeuvre == null) {
				em.close();
				emf.close();
				return "L'oeuvre n'existe pas !";
			}
		} else {
			Reservation reservationIdentifier = Reservation.identifier(nomUsager, titreOeuvre);
			if (reservationIdentifier == null) {
				Exemplaire exemplaire = Exemplaire.identifierExemplaireDisponible(titreOeuvre);
				if (exemplaire == null) {
					em.getTransaction().begin();
					Reservation reservation = new Reservation(usager, oeuvre, new Date());
					em.persist(reservation);
					em.getTransaction().commit();
					em.close();
					emf.close();
					return "Oeuvre reserve";
				} else {
					return "Un exemplaire est deja disponible.";
				}
			} else {
				return "L'usager a deja reserve cet oeuvre.";
			}
		}
		em.close();
		emf.close();
		return null;
	}

	public static String validerEmprunterExemplaire(String nomUsager, String titreOeuvre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Usager usager = Usager.identifier(nomUsager);
		Oeuvre oeuvre = Oeuvre.identifier(titreOeuvre);
		if (usager == null || oeuvre == null) {
			if (usager == null) {
				em.close();
				emf.close();
				return "L'usager n'existe pas !";
			}
			if (oeuvre == null) {
				em.close();
				emf.close();
				return "L'oeuvre n'existe pas !";
			}
		} else {
			Exemplaire exemplaire = Exemplaire.identifierExemplaireDisponible(titreOeuvre);
			if (exemplaire != null) {
				em.getTransaction().begin();
				exemplaire = em.find(Exemplaire.class, exemplaire.getId());
				exemplaire.setEtat("Emprunte");
				em.getTransaction().commit();
				em.getTransaction().begin();
				Emprunt emprunt = new Emprunt(oeuvre, usager, exemplaire, new Date());
				em.persist(emprunt);
				em.getTransaction().commit();
				Reservation reservation = Reservation.identifier(nomUsager, titreOeuvre);
				if (reservation != null) {
					em.getTransaction().begin();
					em.remove(reservation);
					em.getTransaction().commit();
				}
				em.close();
				emf.close();
				return "Emprunt effectue";
			} else {
				em.close();
				emf.close();
				return "Il n'y a plus d'exemplaire disponible. Veuillez en reserver un.";
			}
		}
		em.close();
		emf.close();
		return null;
	}

	public static String validerAnnulerReservation(String nomUsager, String titreOeuvre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Usager usager = Usager.identifier(nomUsager);
		Oeuvre oeuvre = Oeuvre.identifier(titreOeuvre);
		if (usager == null || oeuvre == null) {
			if (usager == null) {
				em.close();
				emf.close();
				return "L'usager n'existe pas !";
			}
			if (oeuvre == null) {
				em.close();
				emf.close();
				return "L'oeuvre n'existe pas !";
			}
		} else {
			Reservation reservation = Reservation.identifier(nomUsager, titreOeuvre);
			if (reservation != null) {
				em.getTransaction().begin();
				reservation = em.find(Reservation.class, reservation.getId());
				em.remove(reservation);
				em.getTransaction().commit();
				em.close();
				emf.close();
				return "Reservation annule";
			} else {
				em.close();
				emf.close();
				return "La reservation n'existe pas !";
			}
		}
		em.close();
		emf.close();
		return null;
	}

	public static String validerRendreExemplaire(String nomUsager, String idExemplaire) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Usager usager = Usager.identifier(nomUsager);
		Exemplaire exemplaire = Exemplaire.identifier(Integer.parseInt(idExemplaire));
		if (usager == null || exemplaire == null) {
			if (usager == null) {
				em.close();
				emf.close();
				return "L'usager n'existe pas !";
			}
			if (exemplaire == null) {
				em.close();
				emf.close();
				return "L'exemplaire n'existe pas !";
			}
		} else {
			Emprunt emprunt = Emprunt.identifier(nomUsager, idExemplaire);
			if (emprunt != null) {
				em.getTransaction().begin();
				emprunt = em.find(Emprunt.class, emprunt.getId());
				em.remove(emprunt);
				em.getTransaction().commit();
				em.getTransaction().begin();
				exemplaire = em.find(Exemplaire.class, Integer.parseInt(idExemplaire));
				exemplaire.setEtat("Disponible");
				em.getTransaction().commit();
				em.close();
				emf.close();
				return "L'exemplaire a ete rendu.";
			} else {
				em.close();
				emf.close();
				return "Cet emprunt n'existe pas !";
			}
		}
		em.close();
		emf.close();
		return null;
	}

	public static String validerAjouterExemplaire(String titreOeuvre, int quantite) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Oeuvre oeuvre = Oeuvre.identifier(titreOeuvre);
		if (oeuvre != null) {
			for (int i = 0; i < quantite; i++) {
				em.getTransaction().begin();
				Exemplaire exemplaire = new Exemplaire(0, "Disponible", oeuvre);
				em.persist(exemplaire);
				em.getTransaction().commit();
			}
			Oeuvre.ajouterNombreExemplaire(oeuvre, quantite);
			em.close();
			emf.close();
			return "Exemplaire ajoute";
		} else {
			em.close();
			emf.close();
			return "L'oeuvre n'existe pas.";
		}
	}

	public static String validerModifierExemplaire(int idExemplaire, String etat) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Exemplaire exemplaire = Exemplaire.identifier(idExemplaire);
		if (exemplaire != null) {
			em.getTransaction().begin();
			exemplaire = em.find(Exemplaire.class, idExemplaire);
			exemplaire.setEtat(etat);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return "Exemplaire modifie";
		} else {
			em.close();
			emf.close();
			return "L'exemplaire n'existe pas.";
		}
	}

	public static String validerSupprimerExemplaire(int idExemplaire) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Exemplaire exemplaire = Exemplaire.identifier(idExemplaire);
		if (exemplaire != null && exemplaire.getEtat().contentEquals("Disponible")) {
			em.getTransaction().begin();
			exemplaire = em.find(Exemplaire.class, idExemplaire);
			em.remove(exemplaire);
			em.getTransaction().commit();
			Oeuvre.retirerNombreExemplaire(exemplaire.getOeuvre());
			em.close();
			emf.close();
			return "Exemplaire supprime";
		} else if (exemplaire == null) {
			em.close();
			emf.close();
			return "Cet exemplaire n'existe pas !";
		} else {
			em.close();
			emf.close();
			return "Cet exemplaire n'est pas disponible";
		}
	}

	public static String ajouterOeuvre(String titre, String editeur, String type, String auteur, String numero,
			String date) {
		if (titre.isEmpty() || editeur.isEmpty()) {
			return "Veuillez renseigner les champs";
		} else {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
			EntityManager em = emf.createEntityManager();
			Oeuvre oeuvre = Oeuvre.identifier(titre);
			if (oeuvre == null) {
				switch (type) {
				case "Livre":
					em.getTransaction().begin();
					Livre newLivre = new Livre(titre, editeur, 0, auteur);
					em.persist(newLivre);
					em.getTransaction().commit();
					em.close();
					emf.close();
					return "Livre ajoute";
				case "Magazine":
					em.getTransaction().begin();
					Magazine newMagazine = new Magazine(titre, editeur, 0, numero, date);
					em.persist(newMagazine);
					em.getTransaction().commit();
					em.close();
					emf.close();
					return "Magazine ajoute";
				}
			} else {
				em.close();
				emf.close();
				return "L'oeuvre existe deja";
			}
			em.close();
			emf.close();
			return null;
		}
	}

	public static String supprimerOeuvre(String type, String titre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Oeuvre oeuvre = Oeuvre.identifier(titre);
		Exemplaire exemplaire = Exemplaire.oeuvreExemplaire(titre);
		Reservation reservation = Reservation.oeuvreReserver(titre);
		if (oeuvre != null && exemplaire == null && reservation == null) {
			switch (type) {
			case "Livre":
				em.getTransaction().begin();
				Livre livre = em.find(Livre.class, titre);
				em.remove(livre);
				em.getTransaction().commit();
				em.close();
				emf.close();
				return "Livre supprime";
			case "Magazine":
				em.getTransaction().begin();
				Magazine magazine = em.find(Magazine.class, titre);
				em.remove(magazine);
				em.getTransaction().commit();
				em.close();
				emf.close();
				return "Magazine supprime";
			}
		} else if (oeuvre == null) {
			em.close();
			emf.close();
			return "L'oeuvre n'existe pas.";
		} else {
			em.close();
			emf.close();
			return "Il reste encore des exemplaires ou des reservations";
		}
		em.close();
		emf.close();
		return null;
	}

	public static String ajouterUsager(String nom, String prenom, String mail, String tel, String adresse) {
		if (nom.isEmpty() || prenom.isEmpty() || mail.isEmpty() || tel.isEmpty() || adresse.isEmpty()) {
			return "Veuillez renseigner les champs";
		} else {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
			EntityManager em = emf.createEntityManager();
			Usager usager = Usager.identifier(nom);
			if (usager == null) {
				em.getTransaction().begin();
				Usager newUsager = new Usager(nom, prenom, mail, tel, adresse);
				em.persist(newUsager);
				em.getTransaction().commit();
				em.close();
				emf.close();
				return "Ajout usager effectue";
			} else {
				em.close();
				emf.close();
				return "Usager existe deja";
			}
		}
	}

	public static String confirmerModifierUsager(String nom, String prenom, String mail, String tel, String adresse) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Usager usager = Usager.identifier(nom);
		if (usager != null) {
			em.getTransaction().begin();
			usager = em.find(Usager.class, nom);
			usager.setPrenom(prenom);
			usager.setMail(mail);
			usager.setTelephone(tel);
			usager.setAdresse(adresse);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return "Usager modifie";
		} else {
			em.close();
			emf.close();
			return "L'usager n'existe pas";
		}
	}

	public static String supprimerUsager(String nom) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Usager usager = Usager.identifier(nom);
		if (usager != null) {
			Emprunt emprunt = Emprunt.usagerEmprunter(nom);
			Reservation reservation = Reservation.usagerReserver(nom);
			if (emprunt == null && reservation == null) {
				em.getTransaction().begin();
				usager = em.find(Usager.class, nom);
				em.remove(usager);
				em.getTransaction().commit();
				em.close();
				emf.close();
				return "Usager supprime";
			} else {
				em.close();
				emf.close();
				return "Un emprunt ou une reservation est en cours";
			}
		} else {
			em.close();
			emf.close();
			return "Cet usager n'existe pas !";
		}
	}
}
