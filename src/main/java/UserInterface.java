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
                    if (adventure.getRoomItems().isEmpty()){
                        System.out.println("No items to take");
                    }
                    String search = input.nextLine();
                    if (adventure.getPlayer().findItem(search, adventure.getRoomItems()) != null) {
                        System.out.println("Added: " + search);
                        adventure.getPlayer().take(adventure.getPlayer().findItem(search , adventure.getRoomItems()));
                    } else {
                        System.out.println("No items found with that name");
                    }

                }
                case "take all" -> {
                    if (adventure.getRoomItems().isEmpty()) {
                        System.out.println("No items to take");
                    } else {
                        System.out.println("Picked up: " + adventure.getRoomItems());
                        adventure.getPlayer().takeAllItems(adventure.getRoomItems());
                    }
                }
                case "drop" -> {
                    if (adventure.getPlayer().getInventory().isEmpty()){
                        System.out.println("No items to drop");
                    }
                    String search = input.nextLine();
                    if(adventure.getPlayer().findItem(search, adventure.getPlayer().getInventory()) != null){
                        System.out.println("Dropped: " + search);
                        adventure.getPlayer().drop(adventure.getPlayer().findItem(search, adventure.getPlayer().getInventory()));
                    }
                    else {
                        System.out.println("No items found with that name");
                    }
                }

                case "drop all" -> {
                    if (adventure.getPlayer().getInventory().isEmpty()) {
                        System.out.println("You have no items to drop!");
                    } else {
                        System.out.println("Dropped: " + adventure.getPlayer().getInventory());
                        adventure.getPlayer().dropAllItems();
                    }
                }
                case "inventory" -> System.out.println("Your inventory consists of: " + adventure.getPlayer().getInventory());
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
