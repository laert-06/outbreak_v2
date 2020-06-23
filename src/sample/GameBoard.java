package sample;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private Paddle user;
    private Boolean isRunning;
    private List<Building> buildings;
    private List<Person> persons;

    private int ApartmentHeight, ApartmentWidth, MedicalHeight, MedicalWidth;


    public GameBoard() {
        this.user = new Paddle(200, 500);
        isRunning = false;
        buildings = new ArrayList<>();
        persons =new ArrayList<>();


        ApartmentHeight = 30;
        ApartmentWidth = 30;
        MedicalHeight = 50;
        MedicalWidth = 70;
        addBuildings();
        addPersons();
    }

    public void addBuildings() {
        for (int i = 0; i < 8; i++) {
            buildings.add(new Apartment(i * 100 + 30, 200, ApartmentWidth, ApartmentHeight));
        }

        for (int i = 0; i < 5; i++) {
            buildings.add(new MedicalFacility(i * 100 + 50, 100, MedicalWidth, MedicalHeight));
        }
    }

    public void addPersons(){
        for (int i = 0; i < 8; i++) {
            persons.add(new Person(i * 100 + 30, 400));
        }
    }




    public void update(int maxX,int maxY){
        for (Person x:persons) {
            x.move(maxX,maxY);
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
