package se.lernia.lab;

import java.util.ArrayList;
import java.util.List;

public class Player implements Movable {
    private final String name;
    private int positionX;
    private int positionY;
    private final int health;
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

        if (newX >= 0 && newY >= 0 && newX < maze.getRows() && newY < maze.getCols() && !maze.isWall(newX, newY)) {
            this.positionX = newX;
            this.positionY = newY;
            checkForItem();
        } else {
            System.out.println("Can't move to (" + newX + "," + newY + "), it's a wall!");
        }
    }

    private void checkForItem() {
        Item item = maze.getItemAtPosition(positionX, positionY);
        if(item != null) {
            inventory.add(item);
            maze.removeItem(item);
            if (item instanceof Monster) {
                System.out.println("You ran into a monster!");
            }
            if (item instanceof Sword) {
                System.out.println("You picked up a sword!");
                inventory.add(item);
            }
            if (item instanceof Shield) {
                System.out.println("You picked up a shield!");
            }
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
}
