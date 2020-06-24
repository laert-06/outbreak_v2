package Control;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class Toolbar extends ToolBar {

    public Toolbar(GameUI ui){
        Button start;
        Button pause;
        Button quit;
        start = new Button("Start");
        start.setOnAction(e -> ui.startGame());
        pause = new Button("Pause");
        pause.setOnAction(e -> ui.pauseGame());
        quit = new Button("Quit");
        quit.setOnAction(e -> ui.stopGame());

        this.getItems().addAll(start, pause, quit);
    }
}
