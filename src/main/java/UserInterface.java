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
                    if (adventure.roomIsEmpty()) {
                        System.out.println("No items to take");
                    }
                    if (!secondWord.equals("all")) {
                        if (adventure.findItem(secondWord, adventure.getRoomItems()) != null) {
                            Item searchItem;
                            searchItem = adventure.findItem(secondWord, adventure.getRoomItems());
                            if (adventure.take(searchItem)) {
                                System.out.println("Added: " + searchItem.getName());
                            } else {
                                System.out.println("You can't carry more items. Please drop items to make space");
                            }
                        } else {
                            System.out.println("No items found with that name");
                        }
                    } else {
                        ArrayList<Item> itemsToTake = new ArrayList<>(adventure.getRoomItems());
                        if (adventure.roomIsEmpty()) {
                            System.out.println("No items to take");
                        } else if (adventure.takeAllItems()) {
                            System.out.println("Picked up: " + itemsToTake);
                        } else {
                            System.out.println("You cannot carry this");
                        }
                    }
                }
                case "drop" -> {
                    if (adventure.inventoryIsEmpty()) {
                        System.out.println("No items to drop");
                    }
                    else if (!secondWord.equals("all")) {
                        if (adventure.findItem(secondWord, adventure.getInventory()) != null) {
                            System.out.println("Dropped: " + secondWord);
                            adventure.drop(adventure.findItem(secondWord, adventure.getInventory()));
                        } else {
                            System.out.println("No items found with that name");
                        }
                    } else {
                        if (adventure.getInventory().isEmpty()) {
                            System.out.println("You have no items to drop!");
                        } else {
                            System.out.println("Dropped: " + adventure.inventoryToString());
                            adventure.dropAllItems();
                        }
                    }
                }
                case "inventory" -> {
                    System.out.println("Your inventory consists of: " + adventure.inventoryToString());
                    System.out.println("Current weight: " + adventure.calculateWeight(adventure.getInventory()) + "/" + adventure.getMAX_WEIGHT());
                }
                case "xyzzy" -> {
                    System.out.println("Teleporting to " + adventure.getXyzzyRoom());
                    adventure.teleport();
                }
                case "eat" -> {
                        Item itemToEat;
                        itemToEat = adventure.findItem(secondWord, adventure.getInventory());
                        switch (adventure.eat(itemToEat)) {
                            case NOT_FOUND -> {
                                System.out.println("Item to eat not found");
                            }
                            case CANT -> {
                                System.out.println("You can eat " + itemToEat);
                            }
                            case OK -> {
                                System.out.println("You ate " + itemToEat);
                            }
                        }
                }
                case "look" -> System.out.println(adventure.look());
                case "health" -> {
                    if (adventure.getHealth() >= 75) {
                        System.out.println("Your health is: " + adventure.getHealth() +
                                "\nYour health is all good.");
                    }
                    else if (adventure.getHealth() >= 50) {
                        System.out.println("Your health is: " + adventure.getHealth() +
                                "\nYour health is ok but not perfect.");
                    }
                    else if (adventure.getHealth() >= 25) {
                        System.out.println("Your health is: " + adventure.getHealth() +
                                "\nYour health is not very good.");
                    }
                    else {
                        System.out.println("Your health is: " + adventure.getHealth() +
                                "\nYou are close to death.");
                    }
                }
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
