package gsb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Praticien {
	@JsonProperty("PRA_NOM")
	private String nom;
	@JsonProperty("PRA_PRENOM")
	private String prenom;
	@JsonProperty("PRA_ADRESSE")
	private String adresse;
	@JsonProperty("PRA_CP")
	private String cp;
	@JsonProperty("PRA_VILLE")
	private String ville;
	@JsonProperty("PRA_COEFNOTORIETE")
	private String coeff;
	@JsonProperty("TYP_LIBELLE")
	private String libelle;
	@JsonProperty("TYP_LIEU")
	private String lieu;
	
	public Praticien() {
		
	}
	public Praticien(String nom, String prenom, String adresse, String cp, String ville, String coeff, String libelle,
			String lieu) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.coeff = coeff;
		this.libelle = libelle;
		this.lieu = lieu;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCoeff() {
		return coeff;
	}
	public void setCoeff(String coeff) {
		this.coeff = coeff;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	
}
