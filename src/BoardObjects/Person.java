package BoardObjects;

import java.util.Random;

public class Person {

    private int x, y, height, width, direction, speed;
    private boolean sick, outside;


    public Person(int x, int y, int b) {
        this.x = x;
        this.y = y;
        this.height = 10;
        this.width = 10;
        Random chance = new Random();
//        chance.ints(0, 100);
//
//        if (chance.nextInt() > 30) this.sick = true;
//        else this.sick = false;
        this.sick = b == 1 ? true : false;
        this.outside = true;

        this.speed = 3;
        this.direction = chance.nextInt() % 360;
    }


    public boolean isOutside() {
        return outside;
    }

    public boolean isSick() {
        return sick;
    }

    public void move(int maxX, int maxY) {
        if (!this.outside) return;

        float deltax = this.speed * (float) Math.sin(Math.toRadians(this.direction));
        float deltay = this.speed * (float) Math.cos(Math.toRadians(this.direction));

        this.x += deltax;
        this.y += deltay;


        if (this.x < 0) {
            this.x = 0;
            this.direction = 360 - this.direction;
        }

        if (this.x + this.width > maxX) {
            this.x = maxX - this.width;

            this.direction = 360 - this.direction;
        }

        if (this.y - this.height < 0) {
            this.y = this.height;

            this.direction = 180 - this.direction;
            this.direction %= 360;
        }
        if (this.y > maxY) {
            this.y = maxY;

            this.direction = 180 - this.direction;
            this.direction %= 360;
        }

    }

    public void setDirection(int x) {
        this.direction = x;

    }

    public void reflect(Collidable c) {
        //unten
        if (c.getY() < this.y) {
            this.direction = 180 - this.direction;
            this.direction %= 360;
        }
        if(c.getY()+c.getHeight()>this.y+this.getHeight()){
            this.direction = 360 - this.direction;
            if (this.direction < 0) {
                this.direction = 360 + this.direction;
            }
        }
        if(c.getX()>this.getX()+this.getWidth()){
            this.direction = 360 - this.direction;
        }
        if(c.getX()+c.getWidth()>this.getX()){
            this.direction = 360 - this.direction;
        }
    }


    public void setSick(boolean sick) {
        this.sick = sick;
    }

    public void setOutside(boolean outside) {
        this.outside = outside;
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
