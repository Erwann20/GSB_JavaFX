package gsb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Conditionnement {
	@JsonProperty("MED_DEPOTLEGAL")
	private String med_depotlegale;
	private StringProperty med_depotlegaleProperty;
	@JsonProperty("MED_NOMCOMMERCIAL")
	private String med_nomcommerciale;
	private StringProperty med_nomcommercialeProperty;
	@JsonProperty("BOITE_QTE")
	private String boite_qte;
	private StringProperty boite_qteProperty;
	@JsonProperty("NB_BOITE_A_COMMANDER")
	private String nb_boite_a_commander;
	private StringProperty nb_boite_a_commanderProperty;
	@JsonProperty("MEDICAMENT_QTE")
	private String medicament_qte;
	private StringProperty medicament_qteProperty;

	public Conditionnement() {
		
	}
	
	

	public Conditionnement(String med_depotlegale, String med_nomcommerciale, String boite_qte,
			String nb_boite_a_commander, String medicament_qte) {
		
		this.med_depotlegale = med_depotlegale;
		this.med_nomcommerciale = med_nomcommerciale;
		this.boite_qte = boite_qte;
		this.nb_boite_a_commander = nb_boite_a_commander;
		this.medicament_qte = medicament_qte;
	}



	public String getMed_depotlegale() {
		return med_depotlegale;
	}

	public void setMed_depotlegale(String med_depotlegale) {
		this.med_depotlegale = med_depotlegale;
	}

	public String getMed_nomcommerciale() {
		return med_nomcommerciale;
	}

	public void setMed_nomcommerciale(String med_nomcommerciale) {
		this.med_nomcommerciale = med_nomcommerciale;
	}

	public String getBoite_qte() {
		return boite_qte;
	}

	public void setBoite_qte(String boite_qte) {
		this.boite_qte = boite_qte;
	}

	public String getNb_boite_a_commander() {
		return nb_boite_a_commander;
	}

	public void setNb_boite_a_commander(String nb_boite_a_commander) {
		this.nb_boite_a_commander = nb_boite_a_commander;
	}

	public String getMedicament_qte() {
		return medicament_qte;
	}

	public void setMedicament_qte(String medicament_qte) {
		this.medicament_qte = medicament_qte;
	}

	public StringProperty getMed_depotlegaleProperty() {
		return new SimpleStringProperty(this.med_depotlegale);
	}

	public void setMed_depotlegaleProperty(StringProperty med_depotlegaleProperty) {
		this.med_depotlegaleProperty = med_depotlegaleProperty;
	}

	public StringProperty getMed_nomcommercialeProperty() {
		return new SimpleStringProperty(this.med_nomcommerciale);
	}

	public void setMed_nomcommercialeProperty(StringProperty med_nomcommercialeProperty) {
		this.med_nomcommercialeProperty = med_nomcommercialeProperty;
	}

	public StringProperty getBoite_qteProperty() {
		return new SimpleStringProperty(this.boite_qte);
	}

	public void setBoite_qteProperty(StringProperty boite_qteProperty) {
		this.boite_qteProperty = boite_qteProperty;
	}

	public StringProperty getNb_boite_a_commanderProperty() {
		return new SimpleStringProperty(this.nb_boite_a_commander);
	}

	public void setNb_boite_a_commanderProperty(StringProperty nb_boite_a_commanderProperty) {
		this.nb_boite_a_commanderProperty = nb_boite_a_commanderProperty;
	}

	public StringProperty getMedicament_qteProperty() {
		return new SimpleStringProperty(this.medicament_qte);
	}

	public void setMedicament_qteProperty(StringProperty medicament_qteProperty) {
		this.medicament_qteProperty = medicament_qteProperty;
	}
	
	
	

}
