package gsb.view;

import gsb.MainApp;
import javafx.fxml.FXML;

public class PrincipalContoller {
	
	MainApp mainApp;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML 
	public void home() {
		this.mainApp.initRootLayout();;
	}
	
	@FXML
	public void listepraticien() {
		this.mainApp.afficheVue("view/VuePraticien.fxml");
	}
	
	@FXML
	public void listeConditionnement() {
		this.mainApp.afficheVue("view/VueConditionnement.fxml");
	}
	
	@FXML
	public void about() {
		this.mainApp.afficheVue("view/VueApropos.fxml");
	}
	
	

}
