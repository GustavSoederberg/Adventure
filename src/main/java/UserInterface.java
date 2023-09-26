import java.util.Scanner;

public class UserInterface {
    private final Scanner input = new Scanner(System.in);
    private final Adventure adventure = new Adventure();
    public void start() {
        adventure.setAllRooms();
        System.out.println("Welcome to the adventure game!");
        String userChoice;

        while (true) {
            System.out.println("Awaiting your command:");
            userChoice = input.nextLine();
            switch (userChoice) {
                case "north" -> System.out.println(adventure.move("north"));
                case "west" -> System.out.println(adventure.move("west"));
                case "east" -> System.out.println(adventure.move("east"));
                case "south" -> System.out.println(adventure.move());
                case "look" -> System.out.println(adventure.look());
                case "help" -> System.out.println(adventure.help());
                case "exit" -> System.exit(0);
                default -> System.out.println("Please enter a valid command!");
            }
        }
    }
}
