package application;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import application.view.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class Main extends Application {    

	private Stage stage;
	
    @Override
    public void start(Stage stage) throws Exception{
    	this.stage = stage;
    	
		URL url = Main.class.getResource("view/LoginScene.fxml");
		FXMLLoader loader = new FXMLLoader(url);
    	Scene scene = new Scene(loader.load());
    	stage.setScene(scene);
    	
//    	loadStage();
		stage.show();
    }
    
    public void loadStage() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	URL location = Main.class.getClassLoader().getResource("view/LoginScene.fxml");
    	loader.setLocation(location);
    	Parent root = loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Logowanie");
		((LoginController) loader.getController()).setMainApp(this);
    }
    
    public static boolean showQuestionDialog(String title, String headerText, String contentText) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get().getButtonData() == ButtonData.OK_DONE;
    }
    
    public static void showInformation(String title, String contentText, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        
        alert.showAndWait();
    }
    
    String showInputDialog(String title, String headerText, String contentText) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setHeaderText(headerText);
        dialog.setContentText(contentText);
        do {
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                return result.get();
            } else {
                if (showQuestionDialog("Anulowanie operacji", "Czy chcesz anulowaæ operacjê?", null)) {
                    return null;
                }
            }
        } while(true);
    }
    
    public static void main(String[] args) {
        launch(args);
    }

	public Stage getStage() {
		return stage;
	}
}

