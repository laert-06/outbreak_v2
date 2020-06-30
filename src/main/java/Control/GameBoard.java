package Control;

import BoardObjects.*;
import Collision.Collision;
import GameView.GameBoardUI;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private Paddle user;
    private Boolean isRunning;
    private List<Building> buildings;
    private List<Person> persons;

    private int ApartmentHeight, ApartmentWidth, MedicalHeight, MedicalWidth;


    public GameBoard() {
        this.user = new Paddle((GameBoardUI.getCanvasWidth() - 200) / 2, 780);
        isRunning = false;
        buildings = new ArrayList<>();
        persons =new ArrayList<>();

        ApartmentHeight = 70;
        ApartmentWidth = 70;
        MedicalHeight = 70;
        MedicalWidth = 70;
        addBuildings();
        addPersons();
    }

    public void addBuildings() {
        for (double i = 0.5; i < 5; i++) {
            buildings.add(new MedicalFacility((int) (i * 140 + 35), 100, ApartmentWidth, ApartmentWidth));
        }
        for (int i = 0; i < 6; i++) {
            buildings.add(new Home(i * 140 + 35, 150, MedicalHeight, MedicalHeight));
        }
    }


    public void addPersons(){
        for (int i = 0; i < 10; i++) {
            persons.add(new Person(i*30 + 200, 400));
        }
    }

    public void update(int maxX,int maxY){
        for (Person p:persons) {
            p.move(maxX,maxY);
            if (p.getDirection() % 90 == 0) {
                p.setDirection(p.getDirection() + 45);
            }
        }

        for (Person x:persons) {
            if(!x.isOutside())continue;

            for(Building b: buildings){
               Collision collision=new Collision(b,x);
               if(collision.isCollision()) {
                   b.evaluate(x);
               }
            }
            for(Person p: persons){
                Collision collision=new Collision(p,x);
                if(collision.isCollision()) {
                    p.evaluate(x);
                }
            }
            Collision collision=new Collision(user,x);
            if(collision.isCollision()) {
                user.evaluate(x);
            }

        }
    }




    public List<Person> getPersons() {
        return persons;
    }

    public List<Building> getBuildings(){
        return buildings;
    }

    public Paddle getPaddle(){
        return user;
    }

    public void start(){
        isRunning=true;
    }

    public void stop(){
        isRunning=false;
    }

    public Boolean isRunning() {
        return isRunning;
    }
}
