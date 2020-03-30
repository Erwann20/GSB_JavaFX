package gsb.view;

import gsb.MainApp;

public class AboutController implements Controller{

	private MainApp mainApp;
	
	@Override
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
	}

	@Override
	public String getNOMMETHODE() {
		// TODO Auto-generated method stub
		return " A propos";
	}

}
