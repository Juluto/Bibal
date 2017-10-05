package IHM;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Main.Main;
import Objet_Metier.Livre;
import Objet_Metier.Magazine;
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
		switch (choix)
		{
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
		//Field ajouter oeuvre
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
		typeAjouterOeuvre.getSelectionModel().select("Livre");
		
	}

	@FXML
	public void ajouterOeuvre(ActionEvent event) {
		String choix = typeAjouterOeuvre.getSelectionModel().getSelectedItem();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBAL");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		switch (choix)
		{
		case "Livre":
			Livre newLivre = new Livre(titreAjouterOeuvre.getText(), editeurAjouterOeuvre.getText(), 0, auteurAjouterOeuvre.getText());
			em.persist(newLivre);
			em.getTransaction().commit();
			break;
		case "Magazine":
			Magazine newMagazine = new Magazine(titreAjouterOeuvre.getText(), editeurAjouterOeuvre.getText(), 0, numeroAjouterOeuvre.getText(), dateAjouterOeuvre.getText());
			em.persist(newMagazine);
			em.getTransaction().commit();
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
		switch (choix)
		{
		case "Livre":
			Livre livre = em.find(Livre.class, titreSupprimerOeuvre.getText());
			em.remove(livre);
			em.getTransaction().commit();
			labelSupprimerOeuvre.setText("Livre supprimer");
			labelSupprimerOeuvre.setTextFill(Color.BLACK);
			titreSupprimerOeuvre.setText(null);
			break;
		case "Magazine":
			Magazine magazine = em.find(Magazine.class, titreSupprimerOeuvre.getText());
			em.remove(magazine);
			em.getTransaction().commit();
			labelSupprimerOeuvre.setText("Magazine supprimer");
			labelSupprimerOeuvre.setTextFill(Color.BLACK);
			titreSupprimerOeuvre.setText(null);
			break;
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
