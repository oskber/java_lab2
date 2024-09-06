package se.lernia.lab;

import java.util.ArrayList;
import java.util.List;


public class Player implements Movable {
    private final String name;
    private int positionX;
    private int positionY;
    private int health;
    private final int strength;
    private final Maze maze;
    private final List<Item> inventory;


    public Player(String name, int positionX, int positionY, int health, int strength, Maze maze) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.health = health;
        this.strength = strength;
        this.maze = maze;
        this.inventory = new ArrayList<>();
    }

    @Override
    public void move(int moveX, int moveY) {
        int newX = this.positionX + moveX;
        int newY = this.positionY + moveY;

        if (newY >= 0 && newX >= 0 && newY < maze.getRows() && newX < maze.getCols() && !maze.isWall(newY, newX)) {
            this.positionX = newX;
            this.positionY = newY;
            checkForItem();
        } else {
            System.out.println("Can't move to (" + newX + "," + newY + "), it's a wall!");
        }
    }

    private void checkForItem() {
        Item item = maze.getItemAtPosition(positionX, positionY);
        if (item != null) {
            if (item instanceof Monster monster) {
                if (hasSword()) {
                    Sword sword = getSword();
                    sword.killMonster(monster, maze);
                } else {
                    monster.attack(this);
                }
            } else {
                inventory.add(item);
                maze.removeItem(item);
                handleItemPickup(item);
            }
        }
    }

    private boolean hasSword() {
        return inventory.stream().anyMatch(item -> item instanceof Sword);
    }

    private Sword getSword() {
        return (Sword) inventory.stream().filter(item -> item instanceof Sword).findFirst().orElse(null);
    }

    private void handleItemPickup(Item item) {
        if (item instanceof Sword sword) {
            System.out.println("You picked up a sword!");
            Monster monster = (Monster) maze.getItemAtPosition(positionX, positionY);
            if (monster != null) {
                sword.killMonster(monster, maze);
            }
        } else if (item instanceof Shield shield) {
            System.out.println("You picked up a shield!");
            shield.protectPlayer(this);
        } else if (item instanceof Treasure) {
            System.out.println("You win, you found the treasure!");
            Game.restartGame();
        }
    }


    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;

    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position=(" + positionX + ", " + positionY + ")" +
                ", health=" + health +
                ", strength=" + strength +
                ", inventory=" + inventory +
                '}';
    }

    public void decreaseHealth(int amount) {
        this.health -= amount;
        if (this.health <= 0) {
            System.out.println("Your health is now " + this.health);
            System.out.println("You have been killed by the monster...");
            Game.restartGame();
        } else {
            System.out.println("Your health is now " + this.health + ",");
        }
    }

    public void increaseHealth(int amount) {
        this.health += amount;
        System.out.println("Your health is now " + this.health);
    }

    public int getHealth() {
        return health;
    }
}
