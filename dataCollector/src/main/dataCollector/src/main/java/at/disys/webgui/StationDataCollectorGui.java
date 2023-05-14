package at.disys.webgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * JavaFX App
 * The GUI for the data collector
 *
 */

public class StationDataCollectorGui extends Application {

    //TODO: Implement GUI as a JavaFX Application

    @Override
    public void start(javafx.stage.Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StationDataCollectorGui.class.getResource("GetInvoice.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        primaryStage.setTitle("Wellcome to the Fuel Station Data Collector!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}
