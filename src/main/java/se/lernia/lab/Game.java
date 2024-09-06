package se.lernia.lab;


import java.util.Scanner;

public class Game {
    private static Maze maze;
    private static Player player;
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        setupGame();
        gameLoop();


    }

    public static void restartGame() {
        System.out.println("Restarting game...");
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
                    player.move(0, -1);
                    break;
                case "s":
                    player.move(0, 1);
                    break;
                case "a":
                    player.move(-1, 0);
                    break;
                case "d":
                    player.move(1, 0);
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
        maze = new Maze(8, 8);
        maze.initializeMaze();
        System.out.println("Enter your player name: ");
        String playerName = sc.nextLine();

        player = new Player(playerName, 1, 1, 100, 0, maze);
        maze.setPlayer(player);

        Item treasure = new Treasure(6, 6, 100);
        Item sword = new Sword(1, 6, 15);
        Item monster = new Monster(3, 5, 10, 50);
        Item monster2 = new Monster(4, 2, 10, 50);
        Item shield = new Shield(1, 4, 100);

        maze.addItem(treasure);
        maze.addItem(sword);
        maze.addItem(monster);
        maze.addItem(monster2);
        maze.addItem(shield);
    }
}
