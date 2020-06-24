package GameView;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class Toolbar extends ToolBar {

    public Toolbar(GameBoardUI ui){
        Button start;
        Button pause;
        Button restart;
        Button quit;
        start = new Button("Start");
        start.setOnAction(e -> ui.startGame());
        pause = new Button("Pause");
        pause.setOnAction(e -> ui.pauseGame());
        restart = new Button("Restart");
        restart.setOnAction(e -> ui.restartGame());
        quit = new Button("Quit");
        quit.setOnAction(e -> ui.quitGame());

        this.getItems().addAll(start, pause, restart, quit);
    }
}
