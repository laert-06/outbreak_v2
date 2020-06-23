package Control;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class Toolbar extends ToolBar {

    public Toolbar(GameUI ui){
        Button start;
        Button stop;
        Button restart;
        start = new Button("Start");
        start.setOnAction(e -> ui.startGame());
        stop = new Button("Stop");
        stop.setOnAction(e -> ui.stopGame());
        restart = new Button("Restart");
        restart.setOnAction(e -> ui.restartGame());

        this.getItems().addAll(start,stop, restart);
    }
}
