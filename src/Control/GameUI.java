package Control;


import BoardObjects.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
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
    static int canvasWidth = 840;
    static int canvasHeight = 900;


    Image home = new Image("file:images/home.png");
    Image medicalFacility = new Image("file:images/medicalFacility.png");
    Image healthyPerson = new Image("file:images/healthyPerson.png");
    Image infectedPerson = new Image("file:images/infectedPerson.png");
    Image coronaOutbreak = new Image("file:images/coronaOutbreak.jpeg");
    Image greyBackground = new Image("file:images/greyBackground.jpeg");


    public GameUI() {
        InfoBar infoBar = new InfoBar();
        Toolbar toolbar = new Toolbar(this);

        this.canvas = new Canvas(canvasWidth, canvasHeight);
        g = this.canvas.getGraphicsContext2D();
        this.getChildren().addAll(toolbar, canvas, infoBar);
        board = new GameBoard();
        this.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {
                String keyCode = keyEvent.getCharacter();
                if(board.isRunning()) {
                    if (keyEvent.getCode() == KeyCode.A || keyEvent.getCode() == KeyCode.LEFT) {
                        if (board.getPaddle().getX() >= 5) board.getPaddle().moveLeft();
                    }
                    if (keyEvent.getCode() == KeyCode.D || keyEvent.getCode() == KeyCode.RIGHT) {
                        if (board.getPaddle().getX() + board.getPaddle().getWidth() <= canvasWidth - 5)
                            board.getPaddle().moveRight();
                    }
                }
            }
        });

        this.timeline=new Timeline(new KeyFrame(Duration.millis(1000/80),e->this.update()));
        this.timeline.setCycleCount(Timeline.INDEFINITE);



    }

    public void update(){
        board.update((int)canvas.getWidth(),(int)canvas.getHeight());
        draw();
    }



    public void draw() {
        g.drawImage(greyBackground, 0, 0);
        drawPaddle();
        drawBuilding();
        drawPerson();

    }

    public void drawPerson(){
        for(Person p: board.getPersons()){
            if(p.isSick())g.drawImage(infectedPerson, p.getX(), p.getY());
            else g.drawImage(healthyPerson, p.getX(), p.getY());
        }
    }

    public void drawBuilding() {
        for (Building b : board.getBuildings()) {
            if (b instanceof Home) g.drawImage(home, b.getX(), b.getY());
            else  g.drawImage(medicalFacility, b.getX(), b.getY());
        }

    }

    public void drawPaddle() {
        g.setFill(Color.DARKRED);
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
        g.drawImage(coronaOutbreak, 0, 0);
//        g.setFill(Color.BLACK);
//        g.fillRect(0, 0, canvasWidth, canvasHeight);
//        g.drawImage(coronaOutbreak, 0, 0);
//        g.setFill(Color.WHITE);
//        g.setTextAlign(TextAlignment.CENTER);
//        g.setTextBaseline(VPos.CENTER);
//        g.setFont(Font.font( "Helvetica",FontWeight.BOLD,50));
//        g.fillText("Corona Outbreak",Math.round(canvas.getWidth()  / 2),
//        Math.round(canvas.getLayoutY()+100));
    }


    public void pauseGame() {
        this.board.stop();
        timeline.stop();
        g.setFill(Color.RED);
        g.setTextAlign(TextAlignment.CENTER);
        g.setTextBaseline(VPos.CENTER);
        g.setFont(Font.font(40));
        g.fillText("Game paused",Math.round(canvas.getWidth()  / 2),
                Math.round(canvas.getHeight() / 2));
    }

    public void restartGame() {
        board.reset();
    }

    public void quitGame() {
        Platform.exit();
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

}

