package gsb.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import gsb.MainApp;
import gsb.model.Praticien;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.FileChooser;
import javafx.util.Duration;

/**
 * 	
 * @author erwann
 *
 */
public class PraticienController implements Controller{
	
	private MainApp mainApp;
	@FXML
	private TextField nameVisitor;
	
	@FXML
	private TableView<Praticien> tableView;
	@FXML
	private TableColumn<Praticien, String> columNom_Praticien;
	@FXML
	private TableColumn<Praticien, String> columPrenom_Praticien;
	@FXML
	private TableColumn<Praticien, String> columNom_visiteur;
	@FXML
	private TableColumn<Praticien, String> columPrenom_visiteur;	
	@FXML
	private Button buttonCsv;
	@FXML
	private Button buttonConfirm;
	@FXML
	private TextArea detailVisit; 
	@FXML
	private ProgressBar loader; 
	
	private ObservableList<Praticien> praticienData = FXCollections.observableArrayList();

    
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;	
		this.buttonCsv.setVisible(false);
		
		this.loader.setProgress(0);
		
	
		this.buttonConfirm.setOnAction((ActionEvent e) -> {
			  Timeline task = new Timeline(
				        new KeyFrame(
				                Duration.ZERO,       
				                new KeyValue(this.loader.progressProperty(), 0)
				        ),
				        new KeyFrame(
				                Duration.seconds(2), 
				                new KeyValue(this.loader.progressProperty(), 1)
				        )
					  );  
			  task.setOnFinished(event -> {
				  initData();
			  });
			  
			  task.playFromStart();
			 
		});
		
		
	}

	
	public void initData() {
		List<Praticien> reqHttp = this.mainApp.getLesPraticiens().getListePraticienWithVisiteurName(this.nameVisitor.getText());

		switch(this.mainApp.getLesPraticiens().getStatus()) {
		case(416):
			Alert alert = new Alert(AlertType.INFORMATION);
	      	alert.setTitle("Erreur valeur");
	      	alert.setHeaderText("Erreur valeur");
	      	alert.setContentText("Le nom du visiteur ("+ this.nameVisitor.getText() + ") n'existe pas");
	      	alert.show();
	      	break;
		case(500):
			alert = new Alert(AlertType.INFORMATION);
	      	alert.setTitle("Erreur saisie");
	      	alert.setHeaderText("Erreur saisie");
	      	alert.setContentText("Veuillez saisir une valeur");
	      	alert.show();
	      	break;
		case(415):
			alert = new Alert(AlertType.INFORMATION);
	      	alert.setTitle("Requête vide");
	      	alert.setHeaderText("Aucun praticien");
	      	alert.setContentText("pas de praticien attribuer à ce visiteur");
	      	alert.show();
	      	break;
	      	
	}
		
		if (!(reqHttp == null) ){
			for(Praticien unPra: reqHttp) {
				
				this.detailVisit.setText("Detail du visiteur: \n"+
										  "Nom :" + unPra.getNom_visiteur() + "\n" +
										  "Prenom :" + unPra.getPrenom_visiteur());
				this.praticienData.add(unPra);
				this.buttonCsv.setVisible(true);
				
			}
		} else {
			this.buttonCsv.setVisible(false);
			this.tableView.getItems().clear();
		}
			
		
		 
		
			this.tableView.setItems(praticienData);
			
			this.columNom_Praticien.setCellValueFactory(cellData -> cellData.getValue().getNom_PraticienProperty());
			this.columPrenom_Praticien.setCellValueFactory(cellData -> cellData.getValue().getPrenom_PraticienProperty());

			
	}
		
	
		
		
	
	
	
	@FXML
	public void exportCSV() throws IOException {
		
		FileChooser fileChooser = new FileChooser();
		
		  // Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
		          "CSV files (*.csv)", "*.csv");
		  
		fileChooser.getExtensionFilters().add(extFilter);
		 
		fileChooser.getExtensionFilters().add(extFilter);
		  // Show save file dialog
		File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
		
	
		
		 // Get a Calendar and set it to the current time.
        Calendar cal = Calendar.getInstance();
        cal.setTime(Date.from(Instant.now()));
		
		String dateNameFile = String.format("file-%1$tY-%1$tm-%1$td-%1$tk-%1$tS-%1$tp", cal);
		
		String absolutePath = file.getAbsolutePath();
		String filePath = absolutePath.substring(0,absolutePath.lastIndexOf(File.separator))+ "\\" + dateNameFile + file.getName();

		
		FileWriter csvWriter = new FileWriter(filePath);
		
		
		for (Praticien toto : this.tableView.getItems()) {
			csvWriter.append("Nom praticien");
			csvWriter.append(",");
		    csvWriter.append(toto.getNom_Praticien());
		    csvWriter.append("\n");
		    csvWriter.append("Prenom praticien");
			csvWriter.append(",");
		    csvWriter.append(toto.getPrenom_Praticien());
		    csvWriter.append("\n");
		    csvWriter.append("Nom visiteur");
			csvWriter.append(",");
		    csvWriter.append(toto.getNom_visiteur());
		    csvWriter.append("\n");
		    csvWriter.append("Prenom visiteur");
			csvWriter.append(",");
		    csvWriter.append(toto.getPrenom_visiteur());
		    csvWriter.append("\n");
		    csvWriter.append("\n");
		}
		
		csvWriter.flush();
		csvWriter.close();

	}
	
	public String getNOMMETHODE() {
		// TODO Auto-generated method stub
		return " liste des praticiens";
	}

}
