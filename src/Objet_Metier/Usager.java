package Objet_Metier;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usager implements Serializable {

    @Id
    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private String adresse;

    public Usager(String nom, String prenom, String mail, String telephone, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public Usager() {
        super();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void mettreAJour() {
        throw new UnsupportedOperationException();
    }

    public Usager e_identification(String nom) {
        throw new UnsupportedOperationException();
    }
}