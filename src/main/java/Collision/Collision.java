package Collision;

import BoardObjects.Collidable;
import BoardObjects.Paddle;
import BoardObjects.Person;

public class Collision {
    protected Collidable object;
    protected Person person;

    public Collision(Collidable object, Person person) {
        this.object = object;
        this.person = person;
    }

    public boolean isCollision() {
        if (object.getY() + object.getHeight() < person.getY() ||
                object.getY()>person.getY()+person.getHeight()) return false;
        return !(object.getX() + object.getWidth() < person.getX()) &&
                !(object.getX() > person.getX() + person.getWidth());
    }




}
