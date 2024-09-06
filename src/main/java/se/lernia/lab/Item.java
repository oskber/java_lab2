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

    public void move(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " at (" + positionX + ", " + positionY + ")";
    }
}

class Monster extends Item {
    private final int strength;

    public Monster(int positionX, int positionY, int health, int strength) {
        super(positionX, positionY);
        this.strength = strength;
    }

    public void attack(Player player) {
        player.decreaseHealth(strength);
        System.out.println("A monster attacked you!");
    }
}

class Sword extends Item {
    private final int damage;

    public Sword(int positionX, int positionY, int damage) {
        super(positionX, positionY);
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }
    public void killMonster(Monster monster, Maze maze) {
        maze.removeItem(monster);
        System.out.println("A monster was in your path, and you killed it!");
    }
}

class Shield extends Item {
    private final int health;

    public Shield(int positionX, int positionY, int health) {
        super(positionX, positionY);
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
    public void protectPlayer(Player player) {
        player.increaseHealth(health);
        System.out.println("You picked up a shield and increased your health to " + player.getHealth() + ".");
    }
}

class Treasure extends Item {
    private final int value;

    public Treasure(int positionX, int positionY, int value) {
        super(positionX, positionY);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

