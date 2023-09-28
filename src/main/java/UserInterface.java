import java.util.Scanner;

public class UserInterface {
    private final Scanner input;
    private final Adventure adventure;

    public UserInterface(Adventure adventure){
        this.adventure = adventure;
        input = new Scanner(System.in);
    }

    public void start() {
        boolean gameIsRunning = true;
        System.out.println("Welcome to the adventure game!");
        String userChoice;

        while (gameIsRunning) {
            System.out.println("Awaiting your command:");
            userChoice = input.nextLine();
            switch (userChoice) {
                case "north", "east", "west", "south" -> {
                    if (adventure.getPlayer().move(userChoice)) {
                        System.out.println("Moved " + userChoice + "\n" + adventure.getPlayer().getCurrentRoom());
                        if (adventure.getPlayer().getCurrentRoom().isVisited()) {
                            System.out.println("You've been here before");
                        } else {
                            adventure.getPlayer().getCurrentRoom().setVisited(true);
                        }
                    } else {
                        System.out.println("You cannot go that way!");
                    }
                }
                case "take" -> {
                    if (adventure.getRoomItems().isEmpty()) {
                        System.out.println("No items to take");
                    } else {
                        System.out.println(adventure.getRoomItems());
                        adventure.getPlayer().takeAllItems(adventure.getRoomItems());
                        System.out.println(adventure.getRoomItems());
                    }
                }
                case "xyzzy" -> {
                    System.out.println("Teleporting to " + adventure.getPlayer().getXyzzyRoom());
                    adventure.getPlayer().teleport();
                }
                case "look" -> System.out.println(adventure.getPlayer().look());
                case "help" -> System.out.println(adventure.help());
                case "exit" -> {
                    System.out.println("Bye!");
                    gameIsRunning = false;
                }
                default -> System.out.println("Please enter a valid command!");
            }
        }
    }
}
