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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

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
	private ObservableList<Praticien> praticienData = FXCollections.observableArrayList();

    
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;	
		this.buttonCsv.setVisible(false);
	}
	
	@FXML
	public void initData() {
		List<Praticien> reqHttp = this.mainApp.getLesPraticiens().getListePraticienWithVisiteurName(this.nameVisitor.getText());

		if (!(reqHttp == null) ){
			for(Praticien unPra: reqHttp) {
		
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
			this.columNom_visiteur.setCellValueFactory(cellData -> cellData.getValue().getNom_visiteurProperty());
			this.columPrenom_visiteur.setCellValueFactory(cellData -> cellData.getValue().getPrenom_visiteurProperty());
		
			
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
