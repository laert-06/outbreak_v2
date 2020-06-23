package Control;


import BoardObjects.Apartment;
import BoardObjects.Building;
import BoardObjects.Paddle;
import BoardObjects.Person;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;


public class GameUI extends VBox {

    private Canvas canvas;
    private GraphicsContext g;
    private GameBoard board;
    private Timeline timeline;


    public GameUI() {
        InfoBar infoBar = new InfoBar();
        Toolbar toolbar = new Toolbar(this);

        this.canvas = new Canvas(600, 600);
        g = this.canvas.getGraphicsContext2D();
        this.getChildren().addAll(toolbar, canvas, infoBar);
        board = new GameBoard();
        this.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {
                if(board.isRunning()) {
                    if (keyEvent.getCode() == KeyCode.A) {
                        if (board.getPaddle().getX() >= 5) board.getPaddle().moveLeft();
                    }
                    if (keyEvent.getCode() == KeyCode.D) {
                        if (board.getPaddle().getX() + board.getPaddle().getWidth() <= 595)
                            board.getPaddle().moveRight();
                    }
                }
            }
        });

        this.timeline=new Timeline(new KeyFrame(Duration.millis(1000/60),e->this.update()));
        this.timeline.setCycleCount(Timeline.INDEFINITE);



    }

    public void update(){
        board.update((int)canvas.getWidth(),(int)canvas.getHeight());
        draw();
    }



    public void draw() {
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, 600, 600);
        drawPaddle();
        drawBuilding();
        drawPerson();

    }

    public void drawPerson(){
        for(Person p: board.getPersons()){
            if(p.isSick())g.setFill(Color.GREEN);
            else g.setFill(Color.WHITE);
            g.fillRect(p.getX(), p.getY(), p.getWidth(), p.getHeight());
        }
    }

    public void drawBuilding() {
        for (Building b : board.getBuildings()) {
            if (b instanceof Apartment) g.setFill(Color.PURPLE);
            else g.setFill(Color.RED);
            g.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
        }

    }

    public void drawPaddle() {
        g.setFill(Color.BLUE);
        Paddle user = board.getPaddle();
        g.fillRect(user.getX(), user.getY(), user.getWidth(), user.getHeight());
    }

    public void startGame() {
        if (!this.board.isRunning()) {
            this.board.start();
            timeline.play();

        }

    }
    public void drawStart(){
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, 600, 600);
        g.setFill(Color.BLACK);
        g.setTextAlign(TextAlignment.CENTER);
        g.setTextBaseline(VPos.CENTER);
        g.setFont(Font.font( "Helvetica",FontWeight.BOLD,50));
        g.fillText("Corona Outbreak",Math.round(canvas.getWidth()  / 2),
                Math.round(canvas.getLayoutY()+100));
    }


    public void stopGame() {
            this.board.stop();
            timeline.stop();
            g.setFill(Color.RED);
            g.setTextAlign(TextAlignment.CENTER);
            g.setTextBaseline(VPos.CENTER);
            g.setFont(Font.font(40));
            g.fillText("Game Stopped",Math.round(canvas.getWidth()  / 2),
                    Math.round(canvas.getHeight() / 2));

    }

}

