import java.util.Scanner;

public class UserInterface {
    private Scanner input = new Scanner(System.in);
    public Adventure adventure = new Adventure();
    public void start() {
        System.out.println("Welcome to the adventure game!");
        String userChoice = "";

        switch (userChoice) {
            "north" -> adventure.move(userChoice);
            "west" -> adventure.move(userChoice);
            "east" -> adventure.move(userChoice);
            "south" -> adventure.move(userChoice);
            "exit" -> System.exit(0);
        }
    }
}
