package cs3151.project3;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static final String MAIN_WINDOW_TITLE = "Project 3";
	public static final String MAIN_WINDOW = "view/mainWindow.fxml";
	

	/**
	 * JavaFX entry point.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param primaryStage
	 *            the main window hook
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		URL location = Main.class.getResource(Main.MAIN_WINDOW);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		loader.load();
		Parent parent = loader.getRoot();
		Scene scene = new Scene(parent);
		primaryStage.setTitle(Main.MAIN_WINDOW_TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Java entry point
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
