package Control;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class Toolbar extends ToolBar {

    public Toolbar(GameUI ui){
        Button start;
        Button stop;
        start = new Button("Start");
        start.setOnAction(e -> ui.startGame());
        stop = new Button("Stop");
        stop.setOnAction(e -> ui.stopGame());

        this.getItems().addAll(start,stop);
    }
}
