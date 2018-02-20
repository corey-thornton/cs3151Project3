package cs3151.project3.view_model;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import cs3151.project3.model.DirectorySearch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;

public class MainWindow {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane anchor;

	@FXML
	private TextArea displayText;

	@FXML
	private TextField patternBox;

	@FXML
	private RadioButton selectAll;

	@FXML
	private ToggleGroup group1;

	@FXML
	private RadioButton selectDirectories;

	@FXML
	private RadioButton selectFiles;

	@FXML
	private RadioButton nameOnly;

	@FXML
	private ToggleGroup group2;

	@FXML
	private RadioButton fullPath;

	private ArrayList<String> list;

	private DirectoryChooser directoryChooser;

	private DirectorySearch search;

	@FXML
	void onDirectoryClick(ActionEvent event) {

		this.search = new DirectorySearch();
		this.list = new ArrayList<String>();
		this.directoryChooser = new DirectoryChooser();

		boolean dirSelect = this.selectDirectories.isSelected();
		System.out.println(dirSelect );
		boolean fileSelect = this.selectFiles.isSelected();
		System.out.println(fileSelect);

		ArrayList<String> patternList = new ArrayList<String>();
		StringBuilder sBuild = new StringBuilder();

		File chooser = directoryChooser.showDialog(null);

		if (this.selectDirectories.isSelected()) {
			try {
				search.directorySearch(chooser, list, dirSelect);
			} catch (IllegalArgumentException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error");
				alert.setContentText(e.getMessage());

				alert.show();
			} catch (NullPointerException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error");
				alert.setContentText("Null Directory in " + chooser.getAbsolutePath());

				alert.show();

			}
			try {
				patternList = search.patternMatch(this.patternBox.getText(), list);
			} catch (IllegalArgumentException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error");
				alert.setContentText(e.getMessage());

				alert.show();
			}

		}
		if (this.selectFiles.isSelected()) {
			try {
				search.directorySearch(chooser, list, fileSelect);
			} catch (IllegalArgumentException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error");
				alert.setContentText(e.getMessage());

				alert.show();
			} catch (NullPointerException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error");
				alert.setContentText("Null Directory in " + chooser.getAbsolutePath());

				alert.show();

			}
			try {
				patternList = search.patternMatch(this.patternBox.getText(), list);
			} catch (IllegalArgumentException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error");
				alert.setContentText(e.getMessage());

				alert.show();
			}

		}
		if (this.selectAll.isSelected()) {

			try {
				search.directorySearch(chooser, list);
			} catch (IllegalArgumentException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error");
				alert.setContentText(e.getMessage());

				alert.show();
			} catch (NullPointerException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error");
				alert.setContentText("Null Directory in " + chooser.getAbsolutePath());

				alert.show();

			}
			try {
				patternList = search.patternMatch(this.patternBox.getText(), list);
			} catch (IllegalArgumentException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error");
				alert.setContentText(e.getMessage());

				alert.show();
			}
		}

		buildString(patternList, sBuild, chooser);
		this.displayText.setText(sBuild.toString());

	}

	private void buildString(ArrayList<String> patternList, StringBuilder sBuild, File dir) {
		for (String name : patternList) {
			if (this.nameOnly.isSelected()) {
				String[] sArray = name.split("\\\\");
				String file = sArray[sArray.length - 1];
				sBuild.append(file + "\n");
			} else {
				sBuild.append(name + "\n");
			}

		}
	}

	@FXML
	void initialize() {
		assert anchor != null : "fx:id=\"anchor\" was not injected: check your FXML file 'mainWindow.fxml'.";
		assert directoryChooser != null : "fx:id=\"directoryChooser\" was not injected: check your FXML file 'mainWindow.fxml'.";
		assert displayText != null : "fx:id=\"displayText\" was not injected: check your FXML file 'mainWindow.fxml'.";
		assert patternBox != null : "fx:id=\"patternBox\" was not injected: check your FXML file 'mainWindow.fxml'.";
		assert selectAll != null : "fx:id=\"selectAll\" was not injected: check your FXML file 'mainWindow.fxml'.";
		assert group1 != null : "fx:id=\"group1\" was not injected: check your FXML file 'mainWindow.fxml'.";
		assert selectDirectories != null : "fx:id=\"selectDirectories\" was not injected: check your FXML file 'mainWindow.fxml'.";
		assert selectFiles != null : "fx:id=\"selectFiles\" was not injected: check your FXML file 'mainWindow.fxml'.";
		assert nameOnly != null : "fx:id=\"nameOnly\" was not injected: check your FXML file 'mainWindow.fxml'.";
		assert group2 != null : "fx:id=\"group2\" was not injected: check your FXML file 'mainWindow.fxml'.";
		assert fullPath != null : "fx:id=\"fullPath\" was not injected: check your FXML file 'mainWindow.fxml'.";

	}
}
