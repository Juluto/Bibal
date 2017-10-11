package IHM;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Appli.BackOffice;
import Main.Main;
import Objet_Metier.Oeuvre;
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
	private Pane paneEmprunterExemplaire;
	@FXML
	private TextField nomEmprunterExemplaire;
	@FXML
	private TextField titreExmpunterExemplaire;
	@FXML
	private Button retourEmprunterExemplaire;
	@FXML
	private Button validerEmprunterExemplaire;
	@FXML
	private Label labelEmprunterExemplaire;
	@FXML
	private Pane paneAnnulerReservation;
	@FXML
	private TextField titreAnnulerReservation;
	@FXML
	private TextField usagerAnnulerReservation;
	@FXML
	private Button retourAnnulerReservation;
	@FXML
	private Button validerAnnulerReservation;
	@FXML
	private Label labelAnnulerReservation;
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
	private Pane paneRendreExemplaire;
	@FXML
	private TextField nomRendreExemplaire;
	@FXML
	private TextField idRendreExemplaire;
	@FXML
	private Button retourRendreExemplaire;
	@FXML
	private Button validerRendreExemplaire;
	@FXML
	private Label labelRendreExemplaire;

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
	public void setQuitter(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	public void setFrontPaneMenu(ActionEvent event) {
		paneMenu.toFront();
	}

	@FXML
	public void setFrontPaneUsager(ActionEvent event) {
		paneGestionUsager.toFront();
	}

	@FXML
	public void setFrontPaneExemplaireOeuvre(ActionEvent event) {
		paneGererExemplaireOeuvre.toFront();
	}

	@FXML
	public void setFrontPaneEmpruntReservation(ActionEvent event) {
		paneEmpruntReservation.toFront();
	}

	@FXML
	public void setFrontPaneAjouterUsager(ActionEvent event) {
		paneAjouterUsager.toFront();
	}

	@FXML
	public void setFrontPaneSupprimerUsager(ActionEvent event) {
		paneSupprimerUsager.toFront();
	}

	@FXML
	public void setFrontPaneModifierUsager(ActionEvent event) {
		paneModifierUsager.toFront();
	}

	@FXML
	public void setFrontPaneAjouterOeuvre(ActionEvent event) {
		paneAjouterOeuvre.toFront();
	}

	@FXML
	public void setFrontPaneSupprimerOeuvre(ActionEvent event) {
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
	public void setFrontPaneEmprunterExemplaire(ActionEvent event) {
		paneEmprunterExemplaire.toFront();
	}

	@FXML
	public void setFrontPaneRendreExemplaire(ActionEvent event) {
		paneRendreExemplaire.toFront();
	}

	@FXML
	public void ajouterUsager(ActionEvent event) {
		String message = BackOffice.ajouterUsager(nomUsager.getText(), prenomUsager.getText(), mailUsager.getText(),
				telUsager.getText(), adresseUsager.getText());
		ajoutUsagerWait.setText(message);
	}

	@FXML
	public void supprimerUsager(ActionEvent event) {
		String message = BackOffice.supprimerUsager(nomUsagerSupprimer.getText());
		labelSupprimerUsager.setText(message);
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
		String message = BackOffice.confirmerModifierUsager(fieldModifierNomUsager.getText(),
				modifierPrenomUsager.getText(), modifierMailUsager.getText(), modifierTelUsager.getText(),
				modifierAdresseUsager.getText());
		labelModifierUsager.setText(message);
		labelModifierUsager.setTextFill(Color.BLACK);
	}

	@FXML
	public void retourUsager(ActionEvent event) {
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
	public void ajouterOeuvre(ActionEvent event) {
		String message = BackOffice.ajouterOeuvre(titreAjouterOeuvre.getText(), editeurAjouterOeuvre.getText(),
				typeAjouterOeuvre.getSelectionModel().getSelectedItem(), auteurAjouterOeuvre.getText(),
				numeroAjouterOeuvre.getText(), dateAjouterOeuvre.getText());
		labelAjouterOeuvre.setText(message);
	}

	@FXML
	public void supprimerOeuvre(ActionEvent event) {
		String message = BackOffice.supprimerOeuvre(typeSupprimerOeuvre.getSelectionModel().getSelectedItem(),
				titreSupprimerOeuvre.getText());
		labelSupprimerOeuvre.setText(message);
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
		String message = BackOffice.validerAjouterExemplaire(titreAjouterExemplaire.getText(),
				Integer.parseInt(quantiteAjouterExemplaire.getText()));
		labelValiderAjouterExemplaire.setText(message);
	}

	@FXML
	public void validerSupprimerExemplaire(ActionEvent event) {
		String message = BackOffice.validerSupprimerExemplaire(Integer.parseInt(numeroSupprimerExemplaire.getText()));
		labelSupprimerExemplaire.setText(message);
	}

	@FXML
	public void validerModifierExemplaire(ActionEvent event) {
		String message = BackOffice.validerModifierExemplaire(Integer.parseInt(numeroModifierExemplaire.getText()),
				etatModifierExemplaire.getSelectionModel().getSelectedItem());
		labelModifierExemplaire.setText(message);
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
		labelAjouterExemplaire.setText(null);
		labelAjouterExemplaire.setTextFill(Color.BLACK);

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
	public void validerReserverOeuvre(ActionEvent event) {
		String message = BackOffice.validerReserverOeuvre(usagerReserverOeuvre.getText(),
				titreReserverOeuvre.getText());
		labelReserverOeuvre.setText(message);
	}

	@FXML
	public void validerAnnulerReservation(ActionEvent event) {
		String message = BackOffice.validerAnnulerReservation(usagerAnnulerReservation.getText(),
				titreAnnulerReservation.getText());
		labelAnnulerReservation.setText(message);
	}

	@FXML
	public void validerEmprunterExemplaire(ActionEvent event) {
		String message = BackOffice.validerEmprunterExemplaire(nomEmprunterExemplaire.getText(),
				titreExmpunterExemplaire.getText());
		labelEmprunterExemplaire.setText(message);
	}

	@FXML
	public void validerRendreExemplaire(ActionEvent event) {
		String message = BackOffice.validerRendreExemplaire(nomRendreExemplaire.getText(),
				idRendreExemplaire.getText());
		labelRendreExemplaire.setText(message);
	}

	@FXML
	public void retourEmpruntReservation(ActionEvent event) {
		// Field reserver oeuvre
		usagerReserverOeuvre.setText(null);
		titreReserverOeuvre.setText(null);
		labelReserverOeuvre.setText(null);
		labelReserverOeuvre.setTextFill(Color.BLACK);

		// Field emprunter exemplaire
		nomEmprunterExemplaire.setText(null);
		titreExmpunterExemplaire.setText(null);
		labelEmprunterExemplaire.setText(null);
		labelEmprunterExemplaire.setTextFill(Color.BLACK);

		// Field annuler reservation
		titreAnnulerReservation.setText(null);
		usagerAnnulerReservation.setText(null);
		labelAnnulerReservation.setText(null);
		labelAnnulerReservation.setTextFill(Color.BLACK);

		// Field rendre exemplaire
		nomRendreExemplaire.setText(null);
		idRendreExemplaire.setText(null);
		labelRendreExemplaire.setText(null);
		labelRendreExemplaire.setTextFill(Color.BLACK);

		paneEmpruntReservation.toFront();
	}

}
