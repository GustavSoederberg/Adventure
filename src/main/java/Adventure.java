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
    public Player getPlayer() {
        return player;
    }

    public ArrayList<Item> getRoomItems() {
        return player.getCurrentRoom().getRoomItems();
    }

    //Methods
    public String help() {
        return """
                You're in a space station.
                To move between rooms you have to write north, south, east and west.
                You can write look to get at name and description of the current room you're in.
                To exit the game write exit.
                """;
    }

    /*public void checkRoomsAroundIsVisited() {
        if (player.getCurrentRoom().getNorth() != null && !player.getCurrentRoom().getNorth().isVisited()) {
            System.out.println("North is not visited");
        }
    }*/

    public ArrayList<Item> getInventory(){
        return player.getInventory();
    }

    public Item findItem(String searchItem, ArrayList<Item> items){
        return player.findItem(searchItem, items);
    }
    public boolean take(Item item){
        return player.take(item);

    }

    public boolean move(String direction){
        return player.move(direction);
    }
}
