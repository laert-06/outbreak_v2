package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OutbreakApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();*

         */

        GameUI ui= new GameUI();
        Scene scene= new Scene(ui,600,700);
        primaryStage.setScene(scene);
        primaryStage.show();
        ui.draw();
    }

    public static void startApp(String[] args) {
        launch(args);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
