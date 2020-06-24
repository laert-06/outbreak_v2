package BoardObjects;

public class Home extends Building {
    public Home(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void evaluate(Person person) {
        person.reflect(this);
    }

}
