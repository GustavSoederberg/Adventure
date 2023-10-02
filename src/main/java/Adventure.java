import java.util.ArrayList;

public class Adventure {
    private Player player;

    //Constructor
    public Adventure() {
        Map map = new Map();
        map.buildMap();
        player = new Player(map.getRoom1());
    }

    //Getters
    /*public Player getPlayer() {
        return player;
    }

     */

    enum returnMessage{
        NOT_FOUND,
        CANT,
        OK,
        ROOM_EMPTY;
    }

    public returnMessage eat(Item item){
        return player.eat(item);
    }

    public ArrayList<Item> getRoomItems() {
        return player.getCurrentRoom().getRoomItems();
    }
    public Room getXyzzyRoom() {
        return player.getXyzzyRoom();
    }

    //Methods


    public String help() {
        return """
                You're in Denmark.
                To move between cities you have to write north, south, east and west.
                You can write look to get at name and description of the current city you're in, as
                well as any items that may be in that city.
                To exit the game write exit.
                """;
    }

    /*public void checkRoomsAroundIsVisited() {
        if (player.getCurrentRoom().getNorth() != null && !player.getCurrentRoom().getNorth().isVisited()) {
            System.out.println("North is not visited");
        }
    }*/

    public ArrayList<Item> getInventory() {
        return player.getInventory();
    }

    public Item findItem(String searchItem, ArrayList<Item> items) {
        return player.findItem(searchItem, items);
    }

    public boolean takeAllItems() {
        return player.takeAllItems();
    }

    public returnMessage take(String item) {
        return player.take(item);

    }

    public boolean move(String direction) {
        return player.move(direction);
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public void teleport() {
        player.teleport();
    }

    public void dropAllItems() {
        player.dropAllItems();
    }

    public int calculateWeight(ArrayList<Item> items) {
        return player.calculateWeight(items);
    }

    public int getMAX_WEIGHT() {
        return player.getMAX_WEIGHT();
    }

    public String look() {
        return player.look();
    }

    public boolean inventoryIsEmpty() {
        return player.inventoryIsEmpty();
    }

    public boolean roomIsEmpty() {
        return player.roomIsEmpty();
    }

    public void drop(Item item) {
        player.drop(item);
    }

    public String inventoryToString() {
        return player.inventoryToString();
    }

    public int getHealth() {
        return player.getHealth();
    }
}
