package BoardObjects;

import java.util.Random;

public class Person implements Collidable {

    private int x, y, height, width, direction, speed;
    private boolean sick, outside;

    public Person(int x, int y) {
        this.x = x;
        this.y = y;
        this.height = 10;
        this.width = 10;
        Random chance = new Random();
        chance.ints(0, 100);
        this.sick = chance.nextInt() > 20 ? false :  true;
        this.outside = true;

        this.speed = 3;
        this.direction = chance.nextInt() % 360;
        while (this.direction == 90) {
            this.direction = chance.nextInt() % 360;
        }
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
            this.direction = 370 - this.direction;
        }

        if (this.x + this.width > maxX) {
            this.x = maxX - this.width;

            this.direction = 370 - this.direction;
        }

        if (this.y - this.height < 0) {
            this.y = this.height;

            this.direction = 190 - this.direction;
            this.direction %= 360;
        }
        if (this.y > maxY) {
            this.y = maxY;

            this.direction = 190 - this.direction;
            this.direction %= 360;
        }

    }


    public void reflect(Collidable c) {

        if (c instanceof MedicalFacility && this.sick == true) {
            this.speed = 0;
            this.sick = false;
            this.speed = 3;
            return;
        }
        if (c instanceof Home && this.sick == false) {
            this.speed = 0;
            this.sick = true;
            this.speed = 3;
            return;
        }
        //unten
        if (c.getY() < this.y) {
            this.direction = 180 - this.direction;
            this.direction %= 360;
        }
        if(c.getY()+c.getHeight()>this.y+this.getHeight()){
            this.direction = 135 - this.direction;
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

    public void reflect(Person c1, Person c2) {
        if (c1.sick == true || c2.sick == true) {
            c1.sick = true;
            c2.sick = true;
            return;
        }
    }

    @Override
    public void evaluate(Person person) {
        person.reflect(this, person);
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

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int x) {
        this.direction = x;
    }

}