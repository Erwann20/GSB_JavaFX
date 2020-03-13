package gsb.view;

import java.awt.TextArea;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import gsb.MainApp;
import gsb.model.ListePraticiens;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PraticienController implements Controller{
	
	MainApp mainApp;
	@FXML
	Text content;
	@FXML
	TextField nameVisitor;
	ListePraticiens test;
	

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
	}
	
	@FXML
	public void initText() {
		String reqHttp = this.mainApp.getLesPraticiens().getPraticienWithVisiteur(this.nameVisitor.getText());
		
		if (this.nameVisitor.getText().isEmpty()) {
			this.content.setText("veuillez saisir une valeur");
		} else {
			content.setText(reqHttp);
		}
		
	}
	
	
	@FXML
	public void exportCSV() throws IOException {
		// Our example data
		@SuppressWarnings("unchecked")
		List<List<String>> rows = Arrays.asList(
		    Arrays.asList("Jean", "author", "Java"),
		    Arrays.asList("David", "editor", "Python"),
		    Arrays.asList("Scott", "editor", "Node.js")
		);

		FileWriter csvWriter = new FileWriter("new.csv");
		csvWriter.append("Name");
		csvWriter.append(",");
		csvWriter.append("Role");
		csvWriter.append(",");
		csvWriter.append("Topic");
		csvWriter.append("\n");

		for (List<String> rowData : rows) {
		    csvWriter.append(String.join(",", rowData));
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
