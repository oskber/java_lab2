package se.lernia.lab;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {
    private final int[][] maze;
    private List<Item> items;
    private Player player;

    public Maze(int rows, int cols) {
        this.maze = new int[rows][cols];
        this.items = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItemAtPosition(int row, int col) {
        for (Item item : items) {
            if (item.getPositionX() == row && item.getPositionY() == col) {
                return item;
            }
        }
        return null;
    }


    public void initializeMaze() {
        for (int[] row : maze) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < maze.length; i++) {
            maze[i][0] = 1;
            maze[i][maze[0].length - 1] = 1;
        }
        for (int j = 1; j < maze[0].length; j++) {
            maze[0][j] = 1;
            maze[maze.length - 1][j] = 1;
        }
        setWall(2, 2);
        setWall(2, 3);
        setWall(3, 3);
        setWall(6, 2);
        setWall(5, 2);
        setWall(5, 6);
        setWall(5, 5);
        setWall(5, 4);

    }


    public void setWall(int row, int col) {
        if (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length) {
            maze[row][col] = 1;
        }
    }

    public int getRows() {
        return maze.length;
    }

    public int getCols() {
        return maze[0].length;
    }

    public boolean isWall(int row, int col) {
        return maze[row][col] == 1;
    }

    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (player != null && player.getPositionY() == i && player.getPositionX() == j) {
                    System.out.print("P ");
                } else if (maze[i][j] == 1) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}