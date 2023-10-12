import java.util.ArrayList;

public class Adventure {
    private Player player;

    //Constructor
    public Adventure() {
        Map map = new Map();
        map.buildMap();
        player = new Player(map.getStartRoom());
    }
    public void printStartMessage(){
        System.out.println("""
                Welcome to the adventure game!
                In this game you will explore som of Denmarks greatest cities.
                You will find weapons and food in the cities around you and
                use them to fight against the different bosses in the game. 
                To start the game write: "go" and then north, south, east or west
                depending on the direction you want to go. 
                You can always write "help" if you're stuck or don't know what to do.
                Good luck!
                """);
    }

    enum returnMessage{
        NOT_FOUND,
        ENEMY_NOT_FOUND,
        CANT,
        OK,
        ROOM_EMPTY,
        INVENTORY_EMPTY,
        POISON
    }

    public void eat(Item item) {
        player.eat(item);
    }

    public returnMessage equipWeapon(String searchItem, ArrayList<Item> items){
        return player.equipWeapon(searchItem, items);
    }

    public returnMessage tryToEat(Item item) {
        return player.tryToEat(item);
    }

    public ArrayList<Item> getRoomItems() {
        return player.getCurrentRoom().getRoomItems();
    }

    public Room getXyzzyRoom() {
        return player.getXyzzyRoom();
    }

    public boolean currentRoomIsVisited(){
        return player.currentRoomIsVisited();
    }
    public returnMessage drop(String searchItem){
        return player.drop(searchItem);
    }

    public void setCurrentRoomIsVisited(boolean isVisited){
        player.setCurrentRoomIsVisited(isVisited);
    }

    //Methods

    public String help() {
        return """
                ----------------------------------------------------------------------------------------------
                You're in Denmark.
                
                To move between cities you have to write go and then north, south, east and west depending
                on which direction you want to go.
                
                You can write look to get at name and description of the current city you're in, as
                well as any items and enemies that may be in that city.
                
                To pick up items use the 'take' command followed by an item name or 'all' to pick up all items
                in a room.
                
                To drop items use the 'drop' command followed by an item name or 'all' to drop all items.
                
                To eat or drink items use the 'eat' command followed by the item you want to consume.
                
                Use the 'attack' command followed by the name of an enemy to attack.
                
                To exit the game write exit.
                ----------------------------------------------------------------------------------------------
                """;
    }

    public ArrayList<Item> getInventory() {
        return player.getInventory();
    }

    public Item findItem(String searchItem, ArrayList<Item> items) {
        return player.findItem(searchItem, items);
    }

    public Enemy findEnemy(String searchEnemy) {
        return getCurrentRoom().findEnemy(searchEnemy);
    }

    public returnMessage takeAllItems() {
        return player.takeAllItems();
    }

    public returnMessage take(String item) {
        return player.take(item);
    }

    public returnMessage attack(Enemy enemy) {
        return player.attack(enemy);
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

    public int calculateInventoryWeight() {
        return player.calculateInventoryWeight();
    }

    public int getMAX_WEIGHT() {
        return player.getMAX_WEIGHT();
    }

    public String look() {
        return player.look();
    }

    public String inventoryToString() {
        return player.inventoryToString();
    }

    public int getHealth() {
        return player.getHealth();
    }

    public String getNameOfLastItemAdded() {
        return player.getNameOfLastItemAdded();
    }

    public Weapon getEquippedWeapon() {
        return player.getEquippedWeapon();
    }

    public String getWeaponName(){
        return player.getWeaponName();
    }
}
