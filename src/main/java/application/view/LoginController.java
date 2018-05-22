package application.view;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

	@FXML
	private Label logLab;
	@FXML
	private TextField textLogin;
	@FXML
	private PasswordField textHaslo;
	@FXML
	private Label labelHaslo;
	@FXML
	private Label labelLogin;
	@FXML
	private Button loginButton;
	
	static ResultSet result;
	@SuppressWarnings("unused")
	private Main mainApp;
	@FXML
	private void loginButtonAction(ActionEvent event) throws Exception{
		//checkLoginSQL();
		/*if(textLogin.getText().equals("nazwisko@leggo.com") && textHaslo.getText().equals("test")) {
			logLab.setText("Witaj " + textLogin.getText() + "!");
			TeacherController.showTeacher(mainApp);
		}
		else if(textLogin.getText().equals("nazwisko@leggo.com") && textHaslo.getText().equals("test2")) {
			logLab.setText("Witaj " + textLogin.getText() + "!");
			StudentController.showStudent(mainApp);
		}
		else if(textLogin.getText().equals("nazwisko@leggo.com") && textHaslo.getText().equals("test3")) {
			logLab.setText("Witaj " + textLogin.getText() + "!");
			AdminController.showAdmin(mainApp);
		}
		else {
			logLab.setText("Has³o nieprawid³owe!");
		}*/
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
		
	}
}
