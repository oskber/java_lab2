package se.lernia.lab;


import java.util.List;
import java.util.Scanner;

public class Game {
    private static Maze maze;
    private static Player player;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        setupGame();
        gameLoop();


    }


    private static void gameLoop() {
        boolean running = true;
        while (running) {
            maze.printMaze();
            System.out.println(player);
            System.out.println("Move (w/a/s/d) or Quit (q)");
            String input = sc.nextLine();

            switch (input.toLowerCase()) {
                case "w":
                    player.move(0, -1); // Move up
                    break;
                case "s":
                    player.move(0, 1); // Move down
                    break;
                case "a":
                    player.move(-1, 0); // Move left
                    break;
                case "d":
                    player.move(1, 0); // Move right
                    break;
                case "q":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input, use w/a/s/d to move or q to quit.");
            }
        }

    }

    private static void setupGame() {
        maze = new Maze(6, 6);
        maze.initializeMaze();
        System.out.println("Enter your player name: ");
        String playerName = sc.nextLine();

        player = new Player(playerName, 1, 1, 100, 20, maze);
        maze.setPlayer(player);

        Item treasure = new Treasure(3, 3, 100);
        Item sword = new Sword(2, 2, 15);
        Item monster = new Monster(3, 4, 10, 50);

        maze.addItem(treasure);
        maze.addItem(sword);
        maze.addItem(monster);
    }


//        Item treasure = new Treasure(3, 3, 100);
//        Item sword = new Sword(2, 2, 15);
//        Item monster = new Monster(3, 4, 10, 5);
//
//        maze.addItem(treasure);
//        maze.addItem(sword);
//        System.out.println("Items in maze: " + maze.getItems());


}
