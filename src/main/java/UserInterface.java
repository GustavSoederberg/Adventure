import java.util.Scanner;

public class UserInterface {
    private Scanner input;
    private Adventure adventure;

    public UserInterface(Adventure adventure){
        this.adventure = adventure;
       input = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the adventure game!");
        String userChoice;

        while (true) {
            System.out.println("Awaiting your command:");
            userChoice = input.nextLine();
            switch (userChoice) {
                case "north", "east", "west", "south" -> {
                    if (adventure.move(userChoice)) {
                        System.out.println("Moved " + userChoice + "\n" + adventure.getCurrentRoom());
                        if (adventure.getCurrentRoom().isVisited()) {
                            System.out.println("You've been here before");
                        } else {
                            adventure.getCurrentRoom().setVisited(true);
                        }

                    } else {
                        System.out.println("You cannot go that way!");
                    }
                }
                case "xyzzy" -> {
                    System.out.println("Teleporting to " + adventure.getXyzzyRoom());
                    adventure.teleport();
                }
                case "look" -> System.out.println(adventure.look());
                case "help" -> System.out.println(adventure.help());
                case "exit" -> System.exit(0);
                default -> System.out.println("Please enter a valid command!");
            }
        }
    }
}
