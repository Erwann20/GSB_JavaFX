package gsb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TypePraticien {
	@JsonProperty("id")
	private String id;
	@JsonProperty("TYP_CODE")
	private String code;
	@JsonProperty("TYP_LIBELLE")
	private String libelle;
	@JsonProperty("TYP_LIEU")
	private String lieu;
	
	public TypePraticien() {
		
	}

	public TypePraticien(String id, String code, String libelle, String lieu) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.lieu = lieu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
