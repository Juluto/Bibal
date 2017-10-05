package Objet_Metier;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Magazine extends Oeuvre {

	private String numero;
	private String date;

	public Magazine(String titre, String editeur, int nombreExemplaire, String numero, String date) {
		super(titre, editeur, nombreExemplaire);
		this.numero = numero;
		this.date = date;
	}

	public Magazine() {
		super();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
