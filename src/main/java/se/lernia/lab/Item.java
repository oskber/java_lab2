package se.lernia.lab;

public abstract class Item {
    private int positionX;
    private int positionY;

    public Item(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }



    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void Move(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " at (" + positionX + ", " + positionY + ")";
    }
}

class Monster extends Item implements Movable {
    private int health;
    private int strength;

    public Monster(int positionX, int positionY, int health, int strength) {
        super(positionX, positionY);
    }

    @Override
    public void move(int moveX, int moveY) {

    }
}

class Sword extends Item {

    public Sword(int positionX, int positionY, int damage) {
        super(positionX, positionY);

    }
}

class Shield extends Item {
    private int health;

    public Shield(int positionX, int positionY, int health) {
        super(positionX, positionY);
    }
}

class Treasure extends Item {

    public Treasure(int positionX, int positionY, int value) {
        super(positionX, positionY);
    }
}

