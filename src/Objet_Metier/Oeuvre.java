package Objet_Metier;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

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

	/**
	 *
	 * @param titre
	 */
	public Oeuvre e_identification(String titre) {
		// TODO - implement Oeuvre.e_identification
		throw new UnsupportedOperationException();
	}

}
