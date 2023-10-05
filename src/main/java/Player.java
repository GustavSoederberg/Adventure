import java.util.ArrayList;

public class Player {

    //Attributes
    private Room currentRoom;
    private Room xyzzyRoom;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private final int MAX_WEIGHT = 5;
    private int currentInventoryWeight;
    private Weapon equippedWeapon;

    private int health = 100;

    //Constructor
    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.xyzzyRoom = currentRoom;
    }


    //Getters
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room getXyzzyRoom() {
        return xyzzyRoom;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getMAX_WEIGHT() {
        return MAX_WEIGHT;
    }

    public int getCurrentInventoryWeight() {
        return currentInventoryWeight;
    }

    public int getHealth() {
        return health;
    }

    //Setters
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;

    }

    public void setXyzzyRoom(Room xyzzyRoom) {
        this.xyzzyRoom = xyzzyRoom;

    }

    //Methods
    public boolean move(String direction) {
        switch (direction) {
            case "east" -> {
                if (currentRoom.getEast() != null && !currentRoom.getEast().isLockedWest()) {
                    currentRoom = currentRoom.getEast();
                    return true;

                } else {
                    return false;
                }

            }
            case "north" -> {
                if (currentRoom.getNorth() != null && !currentRoom.getNorth().isLockedSouth()) {
                    currentRoom = currentRoom.getNorth();
                    return true;

                } else {
                    return false;
                }

            }
            case "south" -> {
                if (currentRoom.getSouth() != null && !currentRoom.getSouth().isLockedNorth()) {
                    currentRoom = currentRoom.getSouth();
                    return true;

                } else {
                    return false;
                }
            }
            case "west" -> {
                if (currentRoom.getWest() != null && !currentRoom.getWest().isLockedEast()) {
                    currentRoom = currentRoom.getWest();
                    return true;

                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public String look() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Looking around: \n" +
                currentRoom.getName() + "\n" +
                currentRoom.getDescription() +
                "\nItems in city: ");
        for (Item item : currentRoom.getRoomItems()) {
            stringBuilder.append(item.getName() + ", ");
        }
        return stringBuilder.toString();
    }

    public void teleport() {
        Room newXyzzy = getCurrentRoom();
        setCurrentRoom(getXyzzyRoom());
        setXyzzyRoom(newXyzzy);
    }

    public Item findItem(String searchItem, ArrayList<Item> items) {
        String searchLower = searchItem.toLowerCase();
        if (searchItem == "" || searchItem == " ") {
            return null;
        }

        for (Item item : items) {
            String itemNameLower = item.getName().toLowerCase();
            if (itemNameLower.contains(searchLower)) {
                return item;
            }
        }

        return null;
    }

    public Adventure.returnMessage take(String searchItemName) {
        if (!roomIsEmpty()) {
            Item itemFound = findItem(searchItemName, getCurrentRoom().getRoomItems());
            if (itemFound != null) {
                if ((calculateWeight(inventory) + itemFound.getWeight()) <= MAX_WEIGHT) {
                    inventory.add(itemFound);
                    currentInventoryWeight = calculateWeight(inventory);
                    getCurrentRoom().getRoomItems().remove(itemFound);
                    return Adventure.returnMessage.OK;
                } else return Adventure.returnMessage.CANT;
            } else return Adventure.returnMessage.NOT_FOUND;
        } else return Adventure.returnMessage.ROOM_EMPTY;
    }

    public Adventure.returnMessage equipWeapon(String searchItem, ArrayList<Item> items){
        Item weapon = findItem(searchItem, items);
        if (weapon != null) {
            if (weapon instanceof Weapon) {
                    equippedWeapon = (Weapon) weapon;
                    return Adventure.returnMessage.OK;
            } else
                return Adventure.returnMessage.CANT;
        }
        else return Adventure.returnMessage.NOT_FOUND;
    }

    public Adventure.returnMessage takeAllItems() {
        if (roomIsEmpty()) {
            return Adventure.returnMessage.ROOM_EMPTY;
        } else if (calculateWeight(currentRoom.getRoomItems()) + currentInventoryWeight <= MAX_WEIGHT) {
            inventory.addAll(currentRoom.getRoomItems());
            currentInventoryWeight = calculateWeight(inventory);
            getCurrentRoom().getRoomItems().clear();
            return Adventure.returnMessage.OK;
        } else {
            return Adventure.returnMessage.CANT;
        }
    }


    public Adventure.returnMessage drop(String searchItem) {
        if (!inventoryIsEmpty()) {
            Item itemFound = findItem(searchItem,inventory);
            if (itemFound != null) {
                getCurrentRoom().getRoomItems().add(itemFound);
                inventory.remove(itemFound);
                return Adventure.returnMessage.OK;
            }
            else return Adventure.returnMessage.NOT_FOUND;
        }
        else return Adventure.returnMessage.INVENTORY_EMPTY;
    }

    public void dropAllItems() {
        currentRoom.getRoomItems().addAll(inventory);
        inventory.clear();
    }

    public int calculateWeight(ArrayList<Item> items) {
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public boolean inventoryIsEmpty() {
        if (inventory.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean roomIsEmpty() {
        if (currentRoom.getRoomItems().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public Adventure.returnMessage eat(Item item) {
        if (item != null) {
            if (item instanceof Food) {
                health += ((Food) item).getHealthPoints();
                inventory.remove(item);
                return Adventure.returnMessage.OK;
            } else
                return Adventure.returnMessage.CANT;
        } else return Adventure.returnMessage.NOT_FOUND;

    }

    public Adventure.returnMessage tryToEat(Item item) {
        if (item != null) {
            if (item instanceof Food) {
                if ((((Food) item).getHealthPoints() > 0)) {
                    health += ((Food) item).getHealthPoints();
                    inventory.remove(item);
                    return Adventure.returnMessage.OK;
                } else {
                    return Adventure.returnMessage.POISON;
                }
            } else
                return Adventure.returnMessage.CANT;
        } else return Adventure.returnMessage.NOT_FOUND;
    }

    public String inventoryToString() {
        StringBuilder stringbuilder = new StringBuilder();
        for (Item item : inventory) {
            stringbuilder.append(item.getName() + ", ");
        }
        return stringbuilder.toString();
    }

    public Item getLastItemAdded() {
        return inventory.get(inventory.size() - 1);
    }
}

