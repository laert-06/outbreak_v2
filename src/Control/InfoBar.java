package Control;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class InfoBar extends HBox {

    private Label info;

    public InfoBar(){
        this.info=new Label("Controll with A and D");
        this.getChildren().addAll(info);
    }
}
