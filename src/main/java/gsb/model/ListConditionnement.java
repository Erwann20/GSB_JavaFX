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

public class ListConditionnement {
	
	private Client client;
	private WebTarget target;
	private Response response;
	
	public ListConditionnement() {
		
	}
	
	public List<Conditionnement> getListeConditionnementWithVisiteurName(String nameVisiteur) {
		List<Conditionnement> result= null;
		this.client = ClientBuilder.newClient();
		this.target = client.target("http://127.0.0.1:8000/api/commande/"+nameVisiteur+"/hljwm5CCLj");
					
		System.out.print(this.target.request().get().getStatus());
		
		switch(this.target.request().get().getStatus()) {
			case (200):
				result = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Conditionnement>>() {
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
