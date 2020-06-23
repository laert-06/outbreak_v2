package sample;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private Paddle user;
    private Boolean isRunning;
    private List<Building> buildings;
    private List<Person> Persons;

    private int ApartmentHeight, ApartmentWidth, MedicalHeight, MedicalWidth;


    public GameBoard() {
        this.user = new Paddle(200, 500);
        isRunning = false;
        buildings = new ArrayList<>();

        ApartmentHeight = 30;
        ApartmentWidth = 30;
        MedicalHeight = 50;
        MedicalWidth = 70;
        addBuildings();
    }

    public void addBuildings() {
        for (int i = 0; i < 8; i++) {
            buildings.add(new Apartment(i * 100 + 30, 200, ApartmentWidth, ApartmentHeight));

        }

        for (int i = 0; i < 5; i++) {
            buildings.add(new MedicalFacility(i * 100 + 50, 100, MedicalWidth, MedicalHeight));
        }
    }




    public void update(){

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
