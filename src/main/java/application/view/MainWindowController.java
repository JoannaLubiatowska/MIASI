package application.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;

import application.Main;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

public class MainWindowController {
	@FXML
	private Button logoutButton;
	@FXML
	private TextField titleTextBox;
	@FXML
	private ComboBox SubjectComboBox;
	@FXML
	private TextField maxPunctationTextBox;
	@FXML
	private ComboBox examComboBox;
	@FXML
	private ComboBox studentComboBox;
	@FXML
	private TextField resultPunctationTextBox;
	@FXML
	private Button addExamButton;
	@FXML
	private Button saveButton;
	@FXML
	private TextField degreeTextBox;
	
	private Main mainApp;

	// Event Listener on Button[#logoutButton].onAction
	@FXML
	public void logoutButtonAction(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#addExamButton].onAction
	@FXML
	public void addExamButtonAction(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#saveButton].onAction
	@FXML
	public void saveButtonAction(ActionEvent event) {
		// TODO Autogenerated
	}

	public static void showMainWindow(Main mainApp) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/MainWindow.fxml"));
			Parent parent = loader.load();
			Scene scene = new Scene(parent);
			((MainWindowController) loader.getController()).setMainApp(mainApp);
			mainApp.getStage().setScene(scene);
			mainApp.getStage().setTitle("Oceny");
			mainApp.getStage().show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
}
