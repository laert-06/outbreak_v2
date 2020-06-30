import GameView.GameBoardUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OutbreakApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GameBoardUI ui = new GameBoardUI();
        Scene scene= new Scene(ui,ui.getCanvasWidth(),ui.getCanvasHeight());
        primaryStage.setScene(scene);
        primaryStage.show();
        ui.drawStart();

    }

    public static void startApp(String[] args) {
        launch(args);
    }


    public static void main(String[] args) {
        launch(args);
//        Random chance = new Random();
//        System.out.println(chance.nextInt());
//        Random chance2 = new Random();
//        System.out.println(chance2.nextInt());
//        Random chance3 = new Random();
//        System.out.println(chance3.nextInt());
    }

}
