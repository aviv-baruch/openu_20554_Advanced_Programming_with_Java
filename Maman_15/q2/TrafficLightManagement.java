package q2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Scanner;

/**
 * The TrafficLightManagement class is a JavaFX application that manages the traffic light system.
 */
public class TrafficLightManagement extends Application {
    /**
     * The entry point for the JavaFX application.
     *
     * @param stage the primary stage for this application
     * @throws IOException if an error occurs during the loading of the FXML file
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file and create the root pane
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TrafficLightManagementApplication.fxml"));
        Pane root = loader.load();

        // Get the controller from the loader
        TrafficLightManagementController controller = loader.getController();

        // Prompt the user for red and green light durations
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the duration for green light (in milliseconds): ");
        int greenLightDuration = scanner.nextInt();

        // Set the timing values in the controller
        controller.setLightDurations(greenLightDuration);

        // Create the scene with the root pane
        Scene scene = new Scene(root);

        // Set the scene on the stage and show the stage
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method, which launches the JavaFX application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
