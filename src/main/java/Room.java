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
    private ArrayList<Item> roomItems = new ArrayList<>();
    private ArrayList<Enemy> roomEnemies = new ArrayList<>();

    //Constructor
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        isVisited = false;
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

    public ArrayList<Item> getRoomItems() {
        return roomItems;
    }

    public ArrayList<Enemy> getRoomEnemies() {
        return roomEnemies;
    }

    public void addItem(String name, String description, int weight) {
        roomItems.add(new Item(name, description, weight));
    }

    public void addItem(Item item) {
        roomItems.add(item);
    }

    public void addFood(String name, String description, int weight, int healthPoints) {
        roomItems.add(new Food(name, description, weight, healthPoints));
    }

    public void addMeleeWeapon(String name, String description, int weight, int attackPoints) {
        roomItems.add(new MeleeWeapon(name, description, weight, attackPoints));
    }

    public void addRangedWeapon(String name, String description, int weight, int attackPoints, int ammunition) {
        roomItems.add(new RangedWeapon(name, description, weight, attackPoints, ammunition));
    }

    public void addEnemy(String name, String description, int health, Weapon equippedWeapon) {
        roomEnemies.add(new Enemy(name, description, health, equippedWeapon));
    }

    //Setters
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

    public Enemy findEnemy(String searchEnemy) {
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

    public void removeEnemy(Enemy enemy) {
        roomEnemies.remove(enemy);
    }

    public void removeItem(Item item) {
        roomItems.remove(item);
    }

    public void removeAllItems() {
        roomItems.clear();
    }

    public void addAllItemsFromList(ArrayList<Item> itemArrayList) {
        roomItems.addAll(itemArrayList);
    }

    public boolean roomHasEnemies() {
        return !roomEnemies.isEmpty();
    }

    public boolean roomHasItems() {
        return !roomItems.isEmpty();
    }

    public Enemy getEnemyIndex(int i) {
        return roomEnemies.get(i);
    }


    //ToString
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("City name: " + name + "\n");
        if (!isVisited) {
            stringBuilder.append("Description: " + description);
        }
        if (roomHasItems()) {
            stringBuilder.append("\nItems in room: ");
            for (Item item : roomItems) {
                stringBuilder.append(item.getName() + " (" + item.getDescription() + "), ");
            }
        }
        if (roomHasEnemies()) {
            stringBuilder.append("\nEnemies in room: ");
            for (Enemy enemy : roomEnemies) {
                stringBuilder.append(enemy.getName() + " (" + enemy.getDescription() + "), ");
            }
        }
        return stringBuilder.toString();
        }
    }
