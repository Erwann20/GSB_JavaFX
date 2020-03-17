package gsb.view;

import java.util.List;

import gsb.MainApp;
import gsb.model.Conditionnement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ConditionnementController implements Controller {
	
	MainApp mainApp;
	@FXML
	private TextField nameVisitor;
	@FXML
	private TableView<Conditionnement> tableView;
	@FXML
	private TableColumn<Conditionnement, String> columMed_depotlegale;
	@FXML
	private TableColumn<Conditionnement, String> columMed_nomcommerciale;
	@FXML
	private TableColumn<Conditionnement, String> columBoite_qte;
	@FXML
	private TableColumn<Conditionnement, String> columNb_boite_a_commander;
	@FXML
	private TableColumn<Conditionnement, String> columMedicament_qte;	
	
	private ObservableList<Conditionnement> conditionnementData = FXCollections.observableArrayList();

    

	@Override
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
	}
	
	@FXML
	public void initData() {
		List<Conditionnement> reqHttp = this.mainApp.getLesConditionnements().getListeConditionnementWithVisiteurName(this.nameVisitor.getText());
		
		if (!(reqHttp == null) ){
			for(Conditionnement unPra: reqHttp) {
	
				this.conditionnementData.add(unPra);
			}
		} 
		else {
		
			this.tableView.getItems().clear();
		}
			
			this.tableView.setItems(this.conditionnementData);
			
			this.columMed_depotlegale.setCellValueFactory(cellData -> cellData.getValue().getMed_depotlegaleProperty());
			this.columMed_nomcommerciale.setCellValueFactory(cellData -> cellData.getValue().getMed_nomcommercialeProperty());
			this.columBoite_qte.setCellValueFactory(cellData -> cellData.getValue().getBoite_qteProperty());
			this.columNb_boite_a_commander.setCellValueFactory(cellData -> cellData.getValue().getNb_boite_a_commanderProperty());
			this.columMedicament_qte.setCellValueFactory(cellData -> cellData.getValue().getMedicament_qteProperty());
			
	}
		
	
	
	

	@Override
	public String getNOMMETHODE() {
		// TODO Auto-generated method stub
		return " conditionnement";
	}
	
}
