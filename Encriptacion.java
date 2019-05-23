package application;
import java.util.Base64;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Encriptacion extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25,25,25,25));
			BorderPane root = new BorderPane();
			Scene scene = new Scene(grid,250,150);
			Label etiqueta = new Label("Palabra");
			grid.add(etiqueta, 0, 1);
			TextField palabra1 = new TextField();
			grid.add(palabra1, 1, 1);
			Button encriptacion = new Button("Encriptar");
			grid.add(encriptacion, 1, 2);
			Button desencriptacion = new Button("Desencriptar");
			grid.add(desencriptacion, 1, 3);
			encriptacion.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					byte[] palabra = palabra1.getText().getBytes();
					String palabraEncriptada = Base64.getEncoder().encodeToString(palabra);
					palabra1.setText(palabraEncriptada);
				}
			});
			desencriptacion.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					String palabra = palabra1.getText();
					byte[] palabraDesencriptada = Base64.getDecoder().decode(palabra);
					palabra = new String(palabraDesencriptada);
					palabra1.setText(palabra);
				}
			});
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
        }
	public static void main(String[] args) {
		launch(args);
	}
}
