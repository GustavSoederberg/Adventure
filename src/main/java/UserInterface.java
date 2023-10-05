import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private final Scanner input;
    private final Adventure adventure;

    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
        input = new Scanner(System.in);
    }

    public void start() {
        boolean gameIsRunning = true;
        System.out.println("Welcome to the adventure game!");


        while (gameIsRunning) {
            System.out.println("Awaiting your command:");
            String userChoice = input.nextLine();

            String[] userInputs = userChoice.split(" ", 2);
            String firstWord = userInputs[0];
            String secondWord = userInputs.length > 1 ? userInputs[1] : "";
            switch (firstWord) {
                case "go" -> {
                    if (adventure.move(secondWord)) {
                        System.out.println("Moved " + secondWord + "\n" + adventure.getCurrentRoom());
                        if (adventure.getCurrentRoom().isVisited()) {
                            System.out.println("You've been here before");
                        } else {
                            adventure.getCurrentRoom().setVisited(true);
                        }
                    } else {
                        System.out.println("You cannot go that way!");
                    }
                }
                case "take" -> {
                    if (!secondWord.equalsIgnoreCase("all")) {
                        switch (adventure.take(secondWord)) {
                            case OK -> System.out.println("Added: " + adventure.getLastItemAdded().getName() + " to inventory");
                            case CANT -> System.out.println("You cannot carry this.");
                            case NOT_FOUND -> System.out.println("No item found with that name.");
                            case ROOM_EMPTY -> System.out.println("This room is empty");

                        }
                    } else {
                        ArrayList<Item> itemsToTake = new ArrayList<>(adventure.getRoomItems());
                        switch (adventure.takeAllItems()) {
                            case OK -> {
                                StringBuilder stringBuilder = new StringBuilder();
                                for (Item item : itemsToTake) {
                                    stringBuilder.append(item.getName() + ", ");
                                }
                                System.out.println("Picked up: " + stringBuilder.toString());
                            }
                            case CANT -> System.out.println("You cannot carry this");
                            case ROOM_EMPTY -> System.out.println("No items to take");
                        }
                    }
                }
                case "drop" -> {
                    if (!secondWord.equalsIgnoreCase("all")) {
                        switch (adventure.drop(secondWord)) {
                            case OK -> System.out.println("Dropped: " + secondWord);
                            case NOT_FOUND -> System.out.println("No items found with that name");
                            case INVENTORY_EMPTY -> System.out.println("You have no items to drop");
                        }
                    } else {
                        System.out.println("Dropped: " + adventure.inventoryToString());
                        adventure.dropAllItems();
                    }
                }
                case "inventory" -> {
                    System.out.println("Your inventory consists of: " + adventure.inventoryToString());
                    if (adventure.getEquippedWeapon() != null) {
                        System.out.println("Equipped weapon: " + adventure.getEquippedWeapon().getName());
                    }
                    System.out.println("Current weight: " + adventure.calculateWeight(adventure.getInventory()) + "/" + adventure.getMAX_WEIGHT());
                }
                case "equip" -> {
                    switch (adventure.equipWeapon(secondWord, adventure.getInventory())) {
                        case OK -> System.out.println(adventure.getEquippedWeapon().getName() + " equipped");
                        case CANT -> System.out.println("This is not a weapon");
                        case NOT_FOUND -> System.out.println("No weapon found with that name");
                    }
                }
                case "attack" -> adventure.attackTest();
                case "xyzzy" -> {
                    System.out.println("Teleporting to " + adventure.getXyzzyRoom());
                    adventure.teleport();
                }
                case "eat" -> {
                    Item itemToEat;
                    itemToEat = adventure.findItem(secondWord, adventure.getInventory());
                    switch (adventure.tryToEat(itemToEat)) {
                        case NOT_FOUND -> {
                            System.out.println("Item to eat not found");
                        }
                        case CANT -> {
                            System.out.println("You can eat " + itemToEat);
                        }
                        case OK -> {
                            System.out.println("You ate " + itemToEat);
                        }
                        case POISON -> {
                            System.out.println("This does not look healthy, are you sure you want to eat it?: (y/n)");
                            boolean isRunning = true;
                            while (isRunning) {
                                String choice = input.nextLine();
                                if (choice.equalsIgnoreCase("y")) {
                                    adventure.eat(itemToEat);
                                    System.out.println("You ate " + itemToEat);
                                    isRunning = false;

                                } else if (choice.equalsIgnoreCase("n")) {
                                    System.out.println("You put the food back in your inventory");
                                    isRunning = false;
                                } else {
                                    System.out.println("Unknown input, please write y to eat or n to put the food back in inventory");
                                }
                            }
                        }
                    }
                }
                case "look" -> System.out.println(adventure.look());
                case "health" -> {
                    if (adventure.getHealth() >= 75) {
                        System.out.println("Your health is: " + adventure.getHealth() + "\nYour health is all good.");
                    } else if (adventure.getHealth() >= 50) {
                        System.out.println("Your health is: " + adventure.getHealth() + "\nYour health is ok but not perfect.");
                    } else if (adventure.getHealth() >= 25) {
                        System.out.println("Your health is: " + adventure.getHealth() + "\nYour health is not very good.");
                    } else {
                        System.out.println("Your health is: " + adventure.getHealth() + "\nYou are close to death.");
                    }
                }
                case "help" -> System.out.println(adventure.help());
                case "exit" -> {
                    System.out.println("Bye!");
                    gameIsRunning = false;
                }
                default -> System.out.println("Please enter a valid command!");
            }
            if (adventure.getHealth() < 1) {
                System.out.println("You died!");
                gameIsRunning = false;
            }
        }
    }
}
