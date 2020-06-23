package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OutbreakApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        GameUI ui= new GameUI();
        Scene scene= new Scene(ui,600,700);
        primaryStage.setScene(scene);
        primaryStage.show();
        ui.drawStart();


    }

    public static void startApp(String[] args) {
        launch(args);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
