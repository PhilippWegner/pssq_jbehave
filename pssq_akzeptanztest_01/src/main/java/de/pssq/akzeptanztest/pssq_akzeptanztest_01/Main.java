package de.pssq.akzeptanztest.pssq_akzeptanztest_01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("ArtikelApp");
			FXMLLoader loader = new FXMLLoader();
			System.out.println("LOCATION: " + getClass().getResource("gui/BasisView.fxml"));
			loader.setLocation(getClass().getResource("gui/BasisView.fxml"));
			GridPane root = loader.load();
			Scene scene = new Scene(root, 750, 490);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch();
	}

}