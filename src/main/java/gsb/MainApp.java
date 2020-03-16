package gsb;

import java.io.IOException;

import gsb.model.ListePraticiens;
import gsb.view.Controller;
import gsb.view.PrincipalContoller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	private final String TITRE = "GSB";

    private Stage primaryStage;
    private BorderPane principal;
    ListePraticiens lesPraticiens;
    
    
    public MainApp() {
    	this.lesPraticiens = new ListePraticiens();
    }
    
	@Override
	public void start(Stage primaryStage) {
		
		 this.primaryStage = primaryStage;
	     this.primaryStage.setTitle(TITRE);
	     this.initRootLayout();
		
	}
	
	 private void initRootLayout() {
	        try {
	            // Charge la vue racine à partir du fichier fxml.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class
	                    .getResource("view/VuePrincipale.fxml"));
	            principal = (BorderPane) loader.load();

	            // Affiche la scene dans le layout racine.
	            Scene scene = new Scene(principal);
	            primaryStage.setScene(scene);

	            // Donne l'accès au controleur à l'application main.
	            PrincipalContoller controleur = loader.getController();
	            controleur.setMainApp(this);

	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
	 
	 public void afficheVue(String laVue) {
	        try {
	            // Charge la vue laVue.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource(laVue));
	            AnchorPane vuePoids = (AnchorPane) loader.load();

	            // Positionne la vuePoids au centre de l'affichage racine.
	            principal.setCenter(vuePoids);

	            // Donne l'accès au contrôleur par l'application main.
	            Controller controleur = loader.getController();
	            controleur.setMainApp(this);
	            
	            this.primaryStage.setTitle(TITRE + controleur.getNOMMETHODE());
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	 
	 
	 
	 
	 
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public ListePraticiens getLesPraticiens() {
		return lesPraticiens;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
