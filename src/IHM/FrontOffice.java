package IHM;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Main.Main;
import Objet_Metier.Exemplaire;
import Objet_Metier.Livre;
import Objet_Metier.Magazine;
import Objet_Metier.Oeuvre;
import Objet_Metier.Reservation;
import Objet_Metier.Usager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class FrontOffice implements Initializable {

	@FXML
	private Pane paneAjouterUsager;
	@FXML
	private TextField nomUsager;
	@FXML
	private TextField prenomUsager;
	@FXML
	private TextField mailUsager;
	@FXML
	private TextField telUsager;
	@FXML
	private TextField adresseUsager;
	@FXML
	private Button confirmerAjouterUsager;
	@FXML
	private Button retourAjouterUsager;
	@FXML
	private Text ajoutUsagerWait;
	@FXML
	private Pane paneGestionUsager;
	@FXML
	private Button ajouterUsager;
	@FXML
	private Button modifierUsager;
	@FXML
	private Button supprimerUsager;
	@FXML
	private Button retourGestionUsager;
	@FXML
	private Pane paneSupprimerUsager;
	@FXML
	private TextField nomUsagerSupprimer;
	@FXML
	private Button confirmerSupprimerUsager;
	@FXML
	private Label labelSupprimerUsager;
	@FXML
	private Button retourSupprimerUsager;
	@FXML
	private Pane paneModifierUsager;
	@FXML
	private Button rechercherUsager;
	@FXML
	private TextField fieldModifierNomUsager;
	@FXML
	private Button modifierNomUsager;
	@FXML
	private TextField modifierPrenomUsager;
	@FXML
	private TextField modifierMailUsager;
	@FXML
	private TextField modifierTelUsager;
	@FXML
	private TextField modifierAdresseUsager;
	@FXML
	private Label labelModifierUsager;
	@FXML
	private Button confirmerModifierUsager;
	@FXML
	private Button retourModifierUsager;
	@FXML
	private Pane paneEmpruntReservation;
	@FXML
	private Button retourEmpruntReservation;
	@FXML
	private Button reserverOeuvre;
	@FXML
	private Button annulerReservation;
	@FXML
	private Button emprunterExemplaire;
	@FXML
	private Button rendreExemplaire;
	@FXML
	private Pane paneMenu;
	@FXML
	private Button gestionUsager;
	@FXML
	private Button gererExemplaireOeuvre;
	@FXML
	private Button gererEmpruntReservation;
	@FXML
	private Button quitter;
	@FXML
	private Pane paneAjouterOeuvre;
	@FXML
	private ComboBox<String> typeAjouterOeuvre;
	@FXML
	private Text textAuteurAjouterOeuvre;
	@FXML
	private Text textNumeroAjouterOeuvre;
	@FXML
	private Text textDateAjouterOeuvre;
	@FXML
	private TextField titreAjouterOeuvre;
	@FXML
	private TextField editeurAjouterOeuvre;
	@FXML
	private TextField auteurAjouterOeuvre;
	@FXML
	private TextField numeroAjouterOeuvre;
	@FXML
	private TextField dateAjouterOeuvre;
	@FXML
	private Button retourAjouterOeuvre;
	@FXML
	private Button confirmAjouterOeuvre;
	@FXML
	private Label labelAjouterOeuvre;
	@FXML
	private Pane paneSupprimerOeuvre;
	@FXML
	private ComboBox<String> typeSupprimerOeuvre;
	@FXML
	private TextField titreSupprimerOeuvre;
	@FXML
	private Button confirmSupprimerOeuvre;
	@FXML
	private Button retourSupprimerOeuvre;
	@FXML
	private Label labelSupprimerOeuvre;
	@FXML
	private Pane paneAjouterExemplaire;
	@FXML
	private TextField titreAjouterExemplaire;
	@FXML
	private TextField quantiteAjouterExemplaire;
	@FXML
	private Button verifierAjouterExemplaire;
	@FXML
	private Button modifierAjouterExemplaire;
	@FXML
	private Button validerAjouterExemplaire;
	@FXML
	private Button retourAjouterExemplaire;
	@FXML
	private Label labelAjouterExemplaire;
	@FXML
	private Label labelValiderAjouterExemplaire;
	@FXML
	private Pane paneSupprimerExemplaire;
	@FXML
	private TextField numeroSupprimerExemplaire;
	@FXML
	private Button validerSupprimerExemplaire;
	@FXML
	private Button retourSupprimerExemplaire;
	@FXML
	private Label labelSupprimerExemplaire;
	@FXML
	private Pane paneGererExemplaireOeuvre;
	@FXML
	private Button ajouterExemplaire;
	@FXML
	private Button supprimerExemplaire;
	@FXML
	private Button modifierExemplaire;
	@FXML
	private Button ajouterOeuvre;
	@FXML
	private Button supprimerOeuvre;
	@FXML
	private Button retourExemplaireOeuvre;
	@FXML
	private Pane paneModifierExemplaire;
	@FXML
	private TextField numeroModifierExemplaire;
	@FXML
	private ComboBox<String> etatModifierExemplaire;
	@FXML
	private Button validerModifierExemplaire;
	@FXML
	private Button retourExemplaire;
	@FXML
	private Label labelModifierExemplaire;
	@FXML
	private Pane paneReserverOeuvre;
	@FXML
	private TextField titreReserverOeuvre;
	@FXML
	private TextField usagerReserverOeuvre;
	@FXML
	private Button retourReserverOeuvre;
	@FXML
	private Button validerReserverOeuvre;
	@FXML
	private Label labelReserverOeuvre;
	@FXML
	private Pane paneAnnulerReservation;
	@FXML
	private TextField usagerAnnulerReservation;
	@FXML
	private TextField titreAnnulerReservation;
	@FXML
	private Button validerAnnulerReservation;
	@FXML
	private Button retourAnnulerReservation;
	@FXML
	private Label labelAnnulerReservation;

	public void setMain(Main main) {

	}

	public FrontOffice() {
		super();
	}

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		typeAjouterOeuvre.getItems().removeAll(typeAjouterOeuvre.getItems());
		typeAjouterOeuvre.getItems().addAll("Livre", "Magazine");
		typeAjouterOeuvre.getSelectionModel().select("Livre");

		typeSupprimerOeuvre.getItems().removeAll(typeSupprimerOeuvre.getItems());
		typeSupprimerOeuvre.getItems().addAll("Livre", "Magazine");
		typeSupprimerOeuvre.getSelectionModel().select("Livre");

		etatModifierExemplaire.getItems().removeAll(etatModifierExemplaire.getItems());
		etatModifierExemplaire.getItems().addAll("Disponible", "Emprunte", "En restauration");
		etatModifierExemplaire.getSelectionModel().select("Disponible");
	}

	@FXML
	private void setFrontPaneMenu(ActionEvent event) {
		paneMenu.toFront();
	}

	@FXML
	private void setFrontPaneUsager(ActionEvent event) {
		paneGestionUsager.toFront();
	}

	@FXML
	public void setFrontPaneExemplaireOeuvre(ActionEvent event) {
		paneGererExemplaireOeuvre.toFront();
	}

	@FXML
	private void setFrontPaneEmpruntReservation(ActionEvent event) {
		paneEmpruntReservation.toFront();
	}

	@FXML
	public void setFrontPaneAjouterUsager(ActionEvent event) {
		paneAjouterUsager.toFront();
	}

	@FXML
	private void setFrontPaneSupprimerUsager(ActionEvent event) {
		paneSupprimerUsager.toFront();
	}

	@FXML
	private void setFrontPaneModifierUsager(ActionEvent event) {
		paneModifierUsager.toFront();
	}

	@FXML
	private void setFrontPaneAjouterOeuvre(ActionEvent event) {
		paneAjouterOeuvre.toFront();
	}

	@FXML
	private void setFrontPaneSupprimerOeuvre(ActionEvent event) {
		paneSupprimerOeuvre.toFront();
	}

	@FXML
	public void setFrontPaneAjouterExemplaire(ActionEvent event) {
		paneAjouterExemplaire.toFront();
	}

	@FXML
	public void setFrontPaneSupprimerExemplaire(ActionEvent event) {
		paneSupprimerExemplaire.toFront();
	}

	@FXML
	public void setFrontPaneModifierExemplaire(ActionEvent event) {
		paneModifierExemplaire.toFront();
	}
	
	@FXML
	public void setFrontPaneReserverOeuvre(ActionEvent event) {
		paneReserverOeuvre.toFront();
	}
	
	@FXML
	public void setFrontPaneAnnulerReservation(ActionEvent event) {
		paneAnnulerReservation.toFront();
	}

	@FXML
	private void setQuitter(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	private void ajouterUsager(ActionEvent event) {
		// Add to database
		Usager newUsager;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		newUsager = new Usager(nomUsager.getText(), prenomUsager.getText(), mailUsager.getText(), telUsager.getText(),
				adresseUsager.getText());
		em.persist(newUsager);
		em.getTransaction().commit();
		em.close();
		emf.close();

		// Remove field
		nomUsager.setText(null);
		prenomUsager.setText(null);
		mailUsager.setText(null);
		telUsager.setText(null);
		adresseUsager.setText(null);
		ajoutUsagerWait.setText("Ajout usager effectue");
	}

	@FXML
	private void retourUsager(ActionEvent event) {
		// Field Ajouter usager
		nomUsager.setText(null);
		prenomUsager.setText(null);
		mailUsager.setText(null);
		telUsager.setText(null);
		adresseUsager.setText(null);
		ajoutUsagerWait.setText(null);
		ajoutUsagerWait.setText(null);

		// Field Supprimer usager
		nomUsagerSupprimer.setText(null);
		labelSupprimerUsager.setText(null);
		labelSupprimerUsager.setTextFill(Color.BLACK);

		// Field Modifier usager
		modifierPrenomUsager.setDisable(true);
		modifierPrenomUsager.setText(null);
		modifierMailUsager.setDisable(true);
		modifierMailUsager.setText(null);
		modifierTelUsager.setDisable(true);
		modifierTelUsager.setText(null);
		modifierAdresseUsager.setDisable(true);
		modifierAdresseUsager.setText(null);
		confirmerModifierUsager.setDisable(true);
		fieldModifierNomUsager.setDisable(false);
		rechercherUsager.setDisable(false);
		fieldModifierNomUsager.setText(null);
		labelModifierUsager.setText(null);
		labelModifierUsager.setTextFill(Color.BLACK);

		paneGestionUsager.toFront();
	}

	@FXML
	public void supprimerUsager(ActionEvent event) {
		Usager usager;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			usager = em.find(Usager.class, nomUsagerSupprimer.getText());
			em.remove(usager);
			em.getTransaction().commit();
			labelSupprimerUsager.setText("Usager supprimer");
			labelSupprimerUsager.setTextFill(Color.BLACK);
			nomUsagerSupprimer.setText(null);
		} catch (IllegalArgumentException e) {
			labelSupprimerUsager.setText("Cet usager n'existe pas !");
			labelSupprimerUsager.setTextFill(Color.RED);
		}
		em.close();
		emf.close();
	}

	@FXML
	public void rechercherModifierUsager(ActionEvent event) {
		Usager usager;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		usager = em.find(Usager.class, fieldModifierNomUsager.getText());
		if (usager != null) {
			modifierPrenomUsager.setDisable(false);
			modifierPrenomUsager.setText(usager.getPrenom());
			modifierMailUsager.setDisable(false);
			modifierMailUsager.setText(usager.getMail());
			modifierTelUsager.setDisable(false);
			modifierTelUsager.setText(usager.getTelephone());
			modifierAdresseUsager.setDisable(false);
			modifierAdresseUsager.setText(usager.getAdresse());
			confirmerModifierUsager.setDisable(false);
			rechercherUsager.setDisable(true);
			fieldModifierNomUsager.setDisable(true);
			labelModifierUsager.setText(null);
			labelModifierUsager.setTextFill(Color.BLACK);
		} else {
			labelModifierUsager.setText("Cet usager n'existe pas !");
			labelModifierUsager.setTextFill(Color.RED);
		}
		em.close();
		emf.close();
	}

	@FXML
	public void modifierUsager(ActionEvent event) {
		modifierPrenomUsager.setDisable(true);
		modifierPrenomUsager.setText(null);
		modifierMailUsager.setDisable(true);
		modifierMailUsager.setText(null);
		modifierTelUsager.setDisable(true);
		modifierTelUsager.setText(null);
		modifierAdresseUsager.setDisable(true);
		modifierAdresseUsager.setText(null);
		confirmerModifierUsager.setDisable(true);
		fieldModifierNomUsager.setDisable(false);
		rechercherUsager.setDisable(false);
	}

	@FXML
	public void confirmerModifierUsager(ActionEvent event) {
		Usager usager;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		usager = em.find(Usager.class, fieldModifierNomUsager.getText());
		em.getTransaction().begin();
		usager.setPrenom(modifierPrenomUsager.getText());
		usager.setMail(modifierMailUsager.getText());
		usager.setTelephone(modifierTelUsager.getText());
		usager.setAdresse(modifierAdresseUsager.getText());
		em.getTransaction().commit();

		modifierPrenomUsager.setDisable(true);
		modifierPrenomUsager.setText(null);
		modifierMailUsager.setDisable(true);
		modifierMailUsager.setText(null);
		modifierTelUsager.setDisable(true);
		modifierTelUsager.setText(null);
		modifierAdresseUsager.setDisable(true);
		modifierAdresseUsager.setText(null);
		confirmerModifierUsager.setDisable(true);
		fieldModifierNomUsager.setDisable(false);
		rechercherUsager.setDisable(false);
		labelModifierUsager.setText("Usager modifier");
		labelModifierUsager.setTextFill(Color.BLACK);
		em.close();
		emf.close();
	}

	@FXML
	public void typeAjouterOeuvre(ActionEvent event) {
		String choix = typeAjouterOeuvre.getSelectionModel().getSelectedItem();
		switch (choix) {
		case "Livre":
			textNumeroAjouterOeuvre.setVisible(false);
			numeroAjouterOeuvre.setVisible(false);
			numeroAjouterOeuvre.setText(null);
			textDateAjouterOeuvre.setVisible(false);
			dateAjouterOeuvre.setVisible(false);
			dateAjouterOeuvre.setText(null);
			textAuteurAjouterOeuvre.setVisible(true);
			auteurAjouterOeuvre.setVisible(true);
			break;
		case "Magazine":
			textAuteurAjouterOeuvre.setVisible(false);
			auteurAjouterOeuvre.setVisible(false);
			auteurAjouterOeuvre.setText(null);
			textNumeroAjouterOeuvre.setVisible(true);
			numeroAjouterOeuvre.setVisible(true);
			textDateAjouterOeuvre.setVisible(true);
			dateAjouterOeuvre.setVisible(true);
			break;
		}
	}

	@FXML
	public void retourExemplaireOeuvre(ActionEvent event) {
		// Field ajouter oeuvre
		textNumeroAjouterOeuvre.setVisible(false);
		numeroAjouterOeuvre.setVisible(false);
		numeroAjouterOeuvre.setText(null);
		textDateAjouterOeuvre.setVisible(false);
		dateAjouterOeuvre.setVisible(false);
		dateAjouterOeuvre.setText(null);
		textAuteurAjouterOeuvre.setVisible(true);
		auteurAjouterOeuvre.setVisible(true);
		auteurAjouterOeuvre.setText(null);
		editeurAjouterOeuvre.setText(null);
		titreAjouterOeuvre.setText(null);
		labelAjouterOeuvre.setText(null);
		labelAjouterOeuvre.setTextFill(Color.BLACK);
		typeAjouterOeuvre.getSelectionModel().select("Livre");

		// Field supprimer oeuvre
		titreSupprimerOeuvre.setText(null);
		labelSupprimerOeuvre.setText(null);
		labelSupprimerOeuvre.setTextFill(Color.BLACK);

		// Field ajouter exemplaire
		titreAjouterExemplaire.setText(null);
		quantiteAjouterExemplaire.setText(null);
		titreAjouterExemplaire.setDisable(false);
		quantiteAjouterExemplaire.setDisable(true);
		validerAjouterExemplaire.setDisable(true);

		// Field supprimer exemplaire
		numeroSupprimerExemplaire.setText(null);
		labelSupprimerExemplaire.setText(null);

		// Field modifier exemplaire
		numeroModifierExemplaire.setText(null);
		labelModifierExemplaire.setText(null);
		etatModifierExemplaire.getSelectionModel().select("Disponible");
		labelModifierExemplaire.setTextFill(Color.BLACK);

		paneGererExemplaireOeuvre.toFront();
	}

	@FXML
	public void retourEmpruntReservation(ActionEvent event) {
		paneEmpruntReservation.toFront();
	}

	@FXML
	public void ajouterOeuvre(ActionEvent event) {
		String choix = typeAjouterOeuvre.getSelectionModel().getSelectedItem();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		switch (choix) {
		case "Livre":
			Livre newLivre = new Livre(titreAjouterOeuvre.getText(), editeurAjouterOeuvre.getText(), 0,
					auteurAjouterOeuvre.getText());
			em.persist(newLivre);
			em.getTransaction().commit();
			labelAjouterOeuvre.setText("Livre ajoute");
			auteurAjouterOeuvre.setText(null);
			editeurAjouterOeuvre.setText(null);
			titreAjouterOeuvre.setText(null);
			dateAjouterOeuvre.setText(null);
			numeroAjouterOeuvre.setText(null);
			break;
		case "Magazine":
			Magazine newMagazine = new Magazine(titreAjouterOeuvre.getText(), editeurAjouterOeuvre.getText(), 0,
					numeroAjouterOeuvre.getText(), dateAjouterOeuvre.getText());
			em.persist(newMagazine);
			em.getTransaction().commit();
			labelAjouterOeuvre.setText("Magazine ajoute");
			auteurAjouterOeuvre.setText(null);
			editeurAjouterOeuvre.setText(null);
			titreAjouterOeuvre.setText(null);
			dateAjouterOeuvre.setText(null);
			numeroAjouterOeuvre.setText(null);
			break;
		}
		em.close();
		emf.close();
	}

	@FXML
	public void supprimerOeuvre(ActionEvent event) {
		String choix = typeSupprimerOeuvre.getSelectionModel().getSelectedItem();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		switch (choix) {
		case "Livre":
			try {
				Livre livre = em.find(Livre.class, titreSupprimerOeuvre.getText());
				em.remove(livre);
				em.getTransaction().commit();
				labelSupprimerOeuvre.setText("Livre supprimer");
				labelSupprimerOeuvre.setTextFill(Color.BLACK);
				titreSupprimerOeuvre.setText(null);
			} catch (IllegalArgumentException e) {
				labelSupprimerOeuvre.setText("Ce livre n'existe pas !");
				labelSupprimerOeuvre.setTextFill(Color.RED);
			}
			break;
		case "Magazine":
			try {
				Magazine magazine = em.find(Magazine.class, titreSupprimerOeuvre.getText());
				em.remove(magazine);
				em.getTransaction().commit();
				labelSupprimerOeuvre.setText("Magazine supprimer");
				labelSupprimerOeuvre.setTextFill(Color.BLACK);
				titreSupprimerOeuvre.setText(null);
			} catch (IllegalArgumentException e) {
				labelSupprimerOeuvre.setText("Ce magazine n'existe pas !");
				labelSupprimerOeuvre.setTextFill(Color.RED);
			}
			break;
		}
		em.close();
		emf.close();
	}

	@FXML
	public void verifierAjouterExemplaire(ActionEvent event) {
		Oeuvre oeuvre;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		oeuvre = em.find(Oeuvre.class, titreAjouterExemplaire.getText());
		if (oeuvre != null) {
			titreAjouterExemplaire.setDisable(true);
			quantiteAjouterExemplaire.setDisable(false);
			validerAjouterExemplaire.setDisable(false);
			labelAjouterExemplaire.setText(null);
			labelValiderAjouterExemplaire.setText(null);

		} else {
			labelAjouterExemplaire.setText("Cet oeuvre n'existe pas !");
			labelValiderAjouterExemplaire.setText(null);
		}
		em.close();
		emf.close();
	}

	@FXML
	public void modifierAjouterExemplaire(ActionEvent event) {
		titreAjouterExemplaire.setDisable(false);
		quantiteAjouterExemplaire.setDisable(true);
		quantiteAjouterExemplaire.setText(null);
		validerAjouterExemplaire.setDisable(true);
	}

	@FXML
	public void validerAjouterExemplaire(ActionEvent event) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		Oeuvre oeuvre = em.find(Oeuvre.class, titreAjouterExemplaire.getText());
		for (int i = 0; i < Integer.parseInt(quantiteAjouterExemplaire.getText()); i++) {
			em.getTransaction().begin();
			Exemplaire exemplaire = new Exemplaire(0, "Disponible", oeuvre);
			em.persist(exemplaire);
			em.getTransaction().commit();
		}
		em.close();
		emf.close();
		labelValiderAjouterExemplaire.setText("Exemplaire ajoute");
	}

	@FXML
	public void validerSupprimerExemplaire(ActionEvent event) {
		Exemplaire exemplaire;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			exemplaire = em.find(Exemplaire.class, Integer.parseInt(numeroSupprimerExemplaire.getText()));
			em.remove(exemplaire);
			em.getTransaction().commit();
			labelSupprimerExemplaire.setText("Exemplaire supprimer");
			labelSupprimerExemplaire.setTextFill(Color.BLACK);
			numeroSupprimerExemplaire.setText(null);
		} catch (IllegalArgumentException e) {
			labelSupprimerExemplaire.setText("Cet exemplaire n'existe pas !");
			labelSupprimerExemplaire.setTextFill(Color.RED);
		}
		em.close();
		emf.close();
	}

	@FXML
	public void validerModifierExemplaire(ActionEvent event) {
		Exemplaire exemplaire;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			exemplaire = em.find(Exemplaire.class, Integer.parseInt(numeroModifierExemplaire.getText()));
			exemplaire.setEtat(etatModifierExemplaire.getSelectionModel().getSelectedItem());
			em.getTransaction().commit();
			labelModifierExemplaire.setText("Exemplaire modifie");
			labelModifierExemplaire.setTextFill(Color.BLACK);
		} catch (NullPointerException e) {
			labelSupprimerExemplaire.setText("Cet exemplaire n'existe pas !");
			labelSupprimerExemplaire.setTextFill(Color.RED);
		}
		em.close();
		emf.close();
	}

	@FXML
	public void validerReserverOeuvre(ActionEvent event) {
		Usager usager;
		Oeuvre oeuvre;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		usager = em.find(Usager.class, usagerReserverOeuvre.getText());
		oeuvre = em.find(Oeuvre.class, titreReserverOeuvre.getText());
		if (usager == null || oeuvre == null) {
			if (usager == null) {
				labelReserverOeuvre.setText("L'usager n'existe pas !");
				labelReserverOeuvre.setTextFill(Color.RED);
			}
			if (oeuvre == null) {
				labelReserverOeuvre.setText("L'oeuvre n'existe pas !");
				labelReserverOeuvre.setTextFill(Color.RED);
			}
		} else {
			Reservation reservation = new Reservation(usager, oeuvre, new Date());
			em.persist(reservation);
			em.getTransaction().commit();
			labelReserverOeuvre.setText("Oeuvre emprunte");
			labelReserverOeuvre.setTextFill(Color.BLACK);
		}
		em.close();
		emf.close();
	}
	
	@FXML
	public void validerAnnulerReservation(ActionEvent event) {
		Usager usager;
		Oeuvre oeuvre;
		Reservation reservation;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		reservation = null;
		usager = em.find(Usager.class, usagerAnnulerReservation.getText());
		oeuvre = em.find(Oeuvre.class, titreAnnulerReservation.getText());
		if (usager == null || oeuvre == null) {
			if (usager == null) {
				labelAnnulerReservation.setText("L'usager n'existe pas !");
				labelAnnulerReservation.setTextFill(Color.RED);
			}
			if (oeuvre == null) {
				labelAnnulerReservation.setText("L'oeuvre n'existe pas !");
				labelAnnulerReservation.setTextFill(Color.RED);
			}
		}
		else {
			Query requete = em.createQuery("SELECT r FROM Reservation r WHERE usager_nom=:nom AND oeuvre_titre=:titre");
	        requete.setParameter( "nom", usager.getNom() );
	        requete.setParameter( "titre", oeuvre.getTitre() );      
	        try {
	            reservation = (Reservation) requete.getSingleResult();
	            em.remove(reservation);
	            em.getTransaction().commit();
	            labelAnnulerReservation.setText("Reservation annule");
				labelAnnulerReservation.setTextFill(Color.BLACK);
	        } catch ( NoResultException e ) {
	        	labelAnnulerReservation.setText("La reservation n'existe pas !");
				labelAnnulerReservation.setTextFill(Color.RED);
	        }
		}
		em.close();
		emf.close();
	}

	/**
	 *
	 * @param nom
	 * @param titre
	 */
	public void reserver(String nom, String titre) {
		// TODO - implement FrontOffice.reserver
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param nom
	 * @param titre
	 */
	public void emprunter(String nom, String titre) {
		// TODO - implement FrontOffice.emprunter
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param nom
	 * @param titre
	 */
	public boolean annuler(String nom, String titre) {
		// TODO - implement FrontOffice.annuler
		throw new UnsupportedOperationException();
	}

}
