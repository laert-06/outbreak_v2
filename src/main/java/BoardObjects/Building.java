package BoardObjects;

public abstract class Building implements Collidable{
    private int x,y,height,width;
    private boolean isOccupied;

    public Building(int x, int y, int width,int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.isOccupied=false;
    }

    public void setOccupied(boolean b){
        this.isOccupied=b;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
