import java.util.Scanner;

public class UserInterface {
    private final Scanner input = new Scanner(System.in);
    private final Adventure adventure = new Adventure();
    public void start() {
        adventure.setAllRooms();
        System.out.println("Welcome to the adventure game!");
        String userChoice;

        while (true) {
            System.out.println("Current room: " + adventure.getCurrentRoom());
            System.out.println("Awaiting your command:");
            userChoice = input.nextLine();
            switch (userChoice) {
                case "north" -> adventure.moveNorth();
                case "west" -> adventure.moveWest();
                case "east" -> adventure.moveEast();
                case "south" -> adventure.moveSouth();
                case "look" -> System.out.println(adventure.look());
                case "help" -> System.out.println("Printing help info");
                case "exit" -> System.exit(0);
                default -> System.out.println("Please enter a valid command!");
            }
        }
    }
}
