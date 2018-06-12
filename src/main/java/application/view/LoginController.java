package application.view;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.exception.WrongEmailFormatException;
import application.service.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

	@SuppressWarnings("unused")
	private Main mainApp;
	
	private LoginService loginService = new LoginService();

	@FXML
	private void loginButtonAction(ActionEvent event) throws Exception {
		try {
			if (loginService.signIn(textLogin.getText(), textHaslo.getText())) {
				MainWindowController.showMainWindow(mainApp);
			} else {
				Main.showInformation("Logowanie", "Login lub haslo nieprawodlowe!", Alert.AlertType.WARNING);
			}
		} catch (WrongEmailFormatException e) {
			Main.showInformation("Logowanie", "Login ma nieprawid³owy format!", Alert.AlertType.WARNING);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;

	}
}
