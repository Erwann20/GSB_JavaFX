package gsb.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@XmlRootElement
public class Praticien {
	
	@JsonProperty("Nom_Praticien")
	private String Nom_Praticien;
	private StringProperty Nom_PraticienProperty;
	
	@JsonProperty("Prenom_Praticien")
	private String Prenom_Praticien;
	private StringProperty Prenom_PraticienProperty;
	
	@JsonProperty("Nom_visiteur")
	private String Nom_visiteur;
	private StringProperty Nom_visiteurProperty;
	
	@JsonProperty("Prenom_visiteur")
	private String Prenom_visiteur;
	private StringProperty Prenom_visiteurProperty;
	
	public Praticien() {
		
	}

	public Praticien(String nom_Praticien, String prenom_Praticien, String nom_visiteur, String prenom_visiteur) {
		
		Nom_Praticien = nom_Praticien;
		Prenom_Praticien = prenom_Praticien;
		Nom_visiteur = nom_visiteur;
		Prenom_visiteur = prenom_visiteur;
	}

	public String getNom_Praticien() {
		return Nom_Praticien;
	}

	public void setNom_Praticien(String nom_Praticien) {
		Nom_Praticien = nom_Praticien;
	}

	public String getPrenom_Praticien() {
		return Prenom_Praticien;
	}

	public void setPrenom_Praticien(String prenom_Praticien) {
		Prenom_Praticien = prenom_Praticien;
	}

	public String getNom_visiteur() {
		return Nom_visiteur;
	}

	public void setNom_visiteur(String nom_visiteur) {
		Nom_visiteur = nom_visiteur;
	}

	public String getPrenom_visiteur() {
		return Prenom_visiteur;
	}

	public void setPrenom_visiteur(String prenom_visiteur) {
		Prenom_visiteur = prenom_visiteur;
	}
	
	public StringProperty getNom_PraticienProperty() {
		return new SimpleStringProperty(this.Nom_Praticien);
	}

	public void setNom_PraticienProperty(StringProperty nom_PraticienProperty) {
		Nom_PraticienProperty = nom_PraticienProperty;
	}

	public StringProperty getPrenom_PraticienProperty() {
		return new SimpleStringProperty(this.Prenom_Praticien);
	}

	public void setPrenom_PraticienProperty(StringProperty prenom_PraticienProperty) {
		Prenom_PraticienProperty = prenom_PraticienProperty;
	}

	public StringProperty getNom_visiteurProperty() {
		return new SimpleStringProperty(this.Nom_visiteur);
	}

	public void setNom_visiteurProperty(StringProperty nom_visiteurProperty) {
		Nom_visiteurProperty = nom_visiteurProperty;
	}

	public StringProperty getPrenom_visiteurProperty() {
		return new SimpleStringProperty(this.Prenom_visiteur);
	}

	public void setPrenom_visiteurProperty(StringProperty prenom_visiteurProperty) {
		Prenom_visiteurProperty = prenom_visiteurProperty;
	}

	@Override
	public String toString() {
		return "Praticien [Nom_Praticien=" + Nom_Praticien + ", Prenom_Praticien=" + Prenom_Praticien
				+ ", Nom_visiteur=" + Nom_visiteur + ", Prenom_visiteur=" + Prenom_visiteur + "]\n";
	}
	
	
		
	
}
