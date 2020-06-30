package BoardObjects;

import BoardObjects.Building;

public class MedicalFacility extends Building {
    public MedicalFacility(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void evaluate(Person person) {
        person.reflect(this);
    }
}