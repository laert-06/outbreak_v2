package sample;


import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;



public class GameUI extends VBox implements Runnable {

    private Button start;
    private Button stop;
    private Canvas canvas;
    private GraphicsContext g;
    private GameBoard board;
    private Thread thread;


    public GameUI() {
        this.start = new Button("Start");
        this.start.setOnAction(e -> startGame());
        this.stop = new Button("Stop");
        this.stop.setOnAction(e -> stopGame());
        this.canvas = new Canvas(600, 600);
        g = this.canvas.getGraphicsContext2D();
        this.getChildren().addAll(start, stop, canvas);
        board = new GameBoard();
        this.addEventHandler(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()== KeyCode.A){
                    if(board.getPaddle().getX()>=0) board.getPaddle().moveLeft();
                }
                if(keyEvent.getCode()== KeyCode.D){
                    if(board.getPaddle().getX()+board.getPaddle().getWidth()<=600) board.getPaddle().moveRight();
                }

                draw();
            }
        });
    }

    public void draw() {
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, 600, 600);
        drawPaddle();
        drawBuilding();

    }

    public void drawBuilding(){
        for (Building b:board.getBuildings()) {

            if(b instanceof Apartment)g.setFill(Color.PURPLE);
            else g.setFill(Color.RED);

            g.fillRect(b.getX(),b.getY(),b.getWidth(),b.getHeight());

        }

    }

    public void drawPaddle() {
        g.setFill(Color.BLUE);
        Paddle user = board.getPaddle();
        g.fillRect(user.getX(), user.getY(), user.getWidth(), user.getHeight());
    }

    public void startGame() {

            this.board.start();
            /*this.thread = new Thread(this);
            this.thread.start();
            draw();*/


        while(this.board.isRunning()){
            board.update();
            draw();
        }try {
            Thread.sleep(1000); // milliseconds
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }



    }

    public void stopGame() {

            this.board.stop();
            g.setFill(Color.RED);
            g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

    }
        @Override
        public void run(){
            while(this.board.isRunning()){
                board.update();
                draw();
            }try {
                Thread.sleep(1000); // milliseconds
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        }

