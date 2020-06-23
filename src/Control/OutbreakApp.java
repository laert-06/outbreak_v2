package Control;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OutbreakApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        GameUI ui= new GameUI();
        Scene scene= new Scene(ui,600,820);
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
