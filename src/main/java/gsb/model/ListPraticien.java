package gsb.model;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gsb.keyapi.KeyGsbApi;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ListPraticien {

	private Client client;
	private WebTarget target;
	private Response response;
	private KeyGsbApi key;
	
	public ListPraticien() {
		key = new KeyGsbApi();
	}
	
	public List<Praticien> getListeConditionnementWithVisiteurName(String nameVisiteur) {
		List<Praticien> result= null;
		this.client = ClientBuilder.newClient();
		this.target = client.target("http://127.0.0.1:8000/api/praticien/"+ nameVisiteur +"/"+this.key.getKey());
		
		result = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Praticien>>() {
			
		});
		switch(this.target.request().get().getStatus()) {
			case (200):
				result = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Praticien>>() {
				});
				break;
			case(415):
				Alert alert = new Alert(AlertType.INFORMATION);
		      	alert.setTitle("Erreur valeur");
		      	alert.setHeaderText("Erreur valeur");
		      	alert.setContentText("Le nom du praticien ("+ nameVisiteur + ") n'existe pas");
		      	alert.showAndWait();
		      	break;
			case(500):
				alert = new Alert(AlertType.INFORMATION);
		      	alert.setTitle("Erreur saisie");
		      	alert.setHeaderText("Erreur saisie");
		      	alert.setContentText("Veuillez saisir une valeur");
		      	alert.showAndWait();
		      	break;
			case(434):
				alert = new Alert(AlertType.INFORMATION);
		      	alert.setTitle("Requête vide");
		      	alert.setHeaderText("Aucun rapport effectué");
		      	alert.setContentText("Aucun rapport effectué à ce praticien");
		      	alert.showAndWait();
		      	break;
		      	
		}
		return result;
		
	}

}
