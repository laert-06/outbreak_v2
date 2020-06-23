package sample;

import java.util.Random;

public class Person {

    private int x,y,height,width,direction,speed;
    private boolean sick,outside;



    public Person(int x, int y) {
        this.x = x;
        this.y = y;
        this.height=5;
        this.width=5;
        Random chance= new Random();
        chance.ints(0,100);

        if(chance.nextInt()>30)this.sick=true;
        else this.sick=false;
        this.outside=true;

        this.speed=5;
        this.direction=chance.nextInt();
    }

    public void move(int maxX,int maxY){
        if(!this.outside)return;

        float deltax = this.speed * (float) Math.sin(Math.toRadians(this.direction));
        float deltay = this.speed * (float) Math.cos(Math.toRadians(this.direction));

        this.x+=deltax;
        this.y+=deltay;

        if (this.x < 0) {
            this.x=0;

            this.direction = 360 - this.direction;
        }

        if (this.x + this.width > maxX) {
            this.x=maxX-this.width;

            this.direction = 360 - this.direction;
        }
        if (this.y - this.height < 0) {
            this.y=this.height;

            this.direction = 180 - this.direction;
            if (this.direction < 0) {
                this.direction = 360 + this.direction;
            }
        }
        if (this.y > maxY) {
            this.y=maxY;

            this.direction = 180 - this.direction;
            if (this.direction < 0) {
                this.direction = 360 + this.direction;
            }
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
