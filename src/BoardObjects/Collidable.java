package BoardObjects;

public interface Collidable {

    void evaluate(Person person);

    int getX();
    int getY();
    int getHeight();
    int getWidth();
}
