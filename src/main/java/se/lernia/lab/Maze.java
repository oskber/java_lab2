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
        initializeMaze();
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
        //maze[5][5] = 1;
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
                if (player != null && player.getPositionX() == j && player.getPositionY() == i) {
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