/*
 * (c) 2021 by Eric Dubuis - BFH BTX8041, Programming 1
 */
package btx.prog.one.sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

	/**
	 * Callback for JavaFX.
	 *
	 * @param stage the stage for this simple app
	 */
    @Override
    public void start(Stage stage) throws Exception {
        var systemInfo = new SystemInfo();
        var javaVersion = systemInfo.javaVersion();
        var javafxVersion = systemInfo.javafxVersion();


        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 1000, 480);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main entry point for this app.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        launch();
    }

}
