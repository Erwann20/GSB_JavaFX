package gsb.model;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ListePraticiens {
	private Client client;
	private WebTarget target;
	private Response response;
	private Integer status;
	
	public ListePraticiens() {

	}
	
	public String getPraticiens() {
			this.client = ClientBuilder.newClient();
			this.target = client.target("http://127.0.0.1:8000/api/visiteur");
			this.response= target.request().get();
			String value = response.readEntity(String.class);
	    	response.close();  	
		return value;
	}
	
	public List<Praticien> getListePraticien() {
		
		this.client = ClientBuilder.newClient();
		this.target = client.target("http://127.0.0.1:8000/api/visiteur");
		List<Praticien> result = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Praticien>>() {
		});
		
		return result;
		
	}
	
	public String getPraticienWithVisiteur(String nameVisiteur) {
		this.client = ClientBuilder.newClient();
		this.target = client.target("http://127.0.0.1:8000/api/visiteur/"+nameVisiteur);
		this.response= target.request().get();
		String value = response.readEntity(String.class);
    	response.close();  
    	
		return value;
	}
	
	public List<Praticien> getListePraticienWithVisiteurName(String nameVisiteur) {
		List<Praticien> result= null;
		this.client = ClientBuilder.newClient();
		this.target = client.target("http://127.0.0.1:8000/api/visiteur/"+nameVisiteur);
				
		switch(this.target.request().get().getStatus()) {
			case (200):
				result = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Praticien>>() {
					
				});
				this.status = this.target.request().get().getStatus();
				break;
			case(416):
		      	this.status = this.target.request().get().getStatus();
		      	break;
			case(500):
				this.status = this.target.request().get().getStatus();
		      	break;
			case(415):
				this.status = this.target.request().get().getStatus();
		      	break;
		    
		      	
		}
				
		return result;
		
	}

	public Integer getStatus() {
		return status;
	}
	
	

}
