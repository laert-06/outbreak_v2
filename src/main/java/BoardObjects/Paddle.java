package BoardObjects;

public class Paddle implements Collidable {
    private int x;
    private int y;
    private int width,height;

    public Paddle(int x,int y){
        this.x=x;
        this.y=y;
        this.height=20;
        this.width=200;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveLeft(){
        x-=20;
    }

    public void moveRight(){
        x+=20;
    }

    @Override
    public void evaluate(Person person) {
        person.reflect(this);
    }
}
