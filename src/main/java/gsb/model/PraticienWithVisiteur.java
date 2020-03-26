package gsb.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@XmlRootElement
public class PraticienWithVisiteur {
	
	@JsonProperty("Nom_Praticien")
	private String Nom_Praticien;
	private StringProperty Nom_PraticienProperty;
	
	@JsonProperty("Prenom_Praticien")
	private String Prenom_Praticien;
	private StringProperty Prenom_PraticienProperty;
	
	@JsonProperty("Prenom_visiteur")
	private String Prenom_visiteur;
	private StringProperty Prenom_visiteurProperty;
	
	@JsonProperty("Nom_visiteur")
	private String Nom_visiteur;
	private StringProperty Nom_visiteurProperty;
	
	@JsonProperty("Praticien_cp")
	private String cp_praticien;
	private StringProperty cp_praticienProperty;

	@JsonProperty("Praticien_adresse")
	private String adresse_praticien;
	private StringProperty adresse_praticienProperty;
	
	@JsonProperty("Praticien_ville")
	private String ville_praticien;
	private StringProperty ville_praticienProperty;
	
;
	
	public PraticienWithVisiteur() {
		
	}
	
	
	public PraticienWithVisiteur(String nom_Praticien, String prenom_Praticien, String prenom_visiteur, String nom_visiteur,
			String cp_praticien, String adresse_praticien, String ville_praticien) {
		super();
		this.Nom_Praticien = nom_Praticien;
		this.Prenom_Praticien = prenom_Praticien;
		this.Prenom_visiteur = prenom_visiteur;
		this.Nom_visiteur = nom_visiteur;
		this.cp_praticien = cp_praticien;
		this.adresse_praticien = adresse_praticien;
		this.ville_praticien = ville_praticien;
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

	
	
	public String getCp_praticien() {
		return cp_praticien;
	}


	public void setCp_praticien(String cp_praticien) {
		this.cp_praticien = cp_praticien;
	}


	public StringProperty getCp_praticienProperty() {
		return cp_praticienProperty;
	}


	public void setCp_praticienProperty(StringProperty cp_praticienProperty) {
		this.cp_praticienProperty = cp_praticienProperty;
	}


	public String getAdresse_praticien() {
		return adresse_praticien;
	}


	public void setAdresse_praticien(String adresse_praticien) {
		this.adresse_praticien = adresse_praticien;
	}


	public StringProperty getAdresse_praticienProperty() {
		return adresse_praticienProperty;
	}


	public void setAdresse_praticienProperty(StringProperty adresse_praticienProperty) {
		this.adresse_praticienProperty = adresse_praticienProperty;
	}


	public String getVille_praticien() {
		return ville_praticien;
	}


	public void setVille_praticien(String ville_praticien) {
		this.ville_praticien = ville_praticien;
	}


	public StringProperty getVille_praticienProperty() {
		return ville_praticienProperty;
	}


	public void setVille_praticienProperty(StringProperty ville_praticienProperty) {
		this.ville_praticienProperty = ville_praticienProperty;
	}


	@Override
	public String toString() {
		return "Praticien [Nom_Praticien=" + Nom_Praticien + ", Prenom_Praticien=" + Prenom_Praticien
				+ ", Nom_visiteur=" + Nom_visiteur + ", Prenom_visiteur=" + Prenom_visiteur + "]\n";
	}
	
	
		
	
}
