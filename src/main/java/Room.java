import java.util.ArrayList;

public class Room {

    //Attributes
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private boolean isVisited;
    private boolean isLockedNorth;
    private boolean isLockedSouth;
    private boolean isLockedWest;
    private boolean isLockedEast;
    private ArrayList<Item> roomItems = new ArrayList<Item>();
    private ArrayList<Enemy> roomEnemies = new ArrayList<>();

    //Constructor
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        isVisited = false;
        isLockedNorth = false;
        isLockedSouth = false;
        isLockedEast = false;
        isLockedWest = false;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public boolean isLockedNorth() {
        return isLockedNorth;
    }

    public boolean isLockedSouth() {
        return isLockedSouth;
    }

    public boolean isLockedWest() {
        return isLockedWest;
    }

    public boolean isLockedEast() {
        return isLockedEast;
    }

    public ArrayList<Item> getRoomItems() {
        return roomItems;
    }

    public ArrayList<Enemy> getRoomEnemies() {
        return roomEnemies;
    }

    public void addItem(String name, String description, int weight) {
        roomItems.add(new Item(name, description, weight));
    }

    public void addFood(String name, String description, int weight, int healthPoints) {
        roomItems.add(new Food(name, description, weight, healthPoints));
    }

    public void addMeleeWeapon(String name, String description, int weight, int attackPoints) {
        roomItems.add(new MeleeWeapon(name, description, weight, attackPoints));
    }

    public void addRangedWeapon(String name, String description, int weight, int attackpoints, int ammunition) {
        roomItems.add(new RangedWeapon(name, description, weight, attackpoints, ammunition));
    }

    public void addEnemy(String name, String description, int health, Weapon equippedWeapon) {
        roomEnemies.add(new Enemy(name, description, health, equippedWeapon));
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public void setLockedNorth(boolean lockedNorth) {
        isLockedNorth = lockedNorth;
    }

    public void setLockedSouth(boolean lockedSouth) {
        isLockedSouth = lockedSouth;
    }

    public void setLockedWest(boolean lockedWest) {
        isLockedWest = lockedWest;
    }

    public void setLockedEast(boolean lockedEast) {
        isLockedEast = lockedEast;
    }

    public Enemy findEnemy(String searchEnemy, ArrayList<Enemy> items) {
        String searchLower = searchEnemy.toLowerCase();
        if (searchEnemy.isEmpty() || searchEnemy.equals(" ")) {
            return null;
        }
        for (Enemy enemy : roomEnemies) {
            String itemNameLower = enemy.getName().toLowerCase();
            if (itemNameLower.contains(searchLower)) {
                return enemy;
            }
        }
        return null;
    }


    //ToString
    @Override
    public String toString() {
        if (isVisited) {
            return "Room name: " + name + "\nItems in room: " + roomItems;
        } else {
            return "Room name: " + name +
                    "\nDescription: " + description +
                    "\nItems in room: " + roomItems;
        }
    }

    public void addItem(Item item) {
        roomItems.add(item);
    }

    public void removeEnemy(Enemy enemy) {
        roomEnemies.remove(enemy);
    }
}
