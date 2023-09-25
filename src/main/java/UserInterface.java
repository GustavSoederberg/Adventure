import java.util.Scanner;

public class UserInterface {
    private Scanner input = new Scanner(System.in);
    public Adventure adventure = new Adventure();
    public void start() {
        System.out.println("Welcome to the adventure game!");
        String userChoice = "";
        userChoice = input.next();
        switch (userChoice) {
            case "north" -> adventure.move(userChoice);
            case "west" -> adventure.move(userChoice);
            case "east" -> adventure.move(userChoice);
            case "south" -> adventure.move(userChoice);
            case "exit" -> System.exit(0);
        }
    }
}
