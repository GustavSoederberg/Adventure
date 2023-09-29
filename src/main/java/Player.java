import java.util.ArrayList;

public class Player {

    //Attributes
    private Room currentRoom;
    private Room xyzzyRoom;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private final int MAX_WEIGHT = 5;
    private int currentInventoryWeight;

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
        return "Looking around: \n" +
                currentRoom.getName() + "\n" +
                currentRoom.getDescription() +
                "\nItems in room: " + currentRoom.getRoomItems();
    }

    public void teleport() {
        Room newXyzzy = getCurrentRoom();
        setCurrentRoom(getXyzzyRoom());
        setXyzzyRoom(newXyzzy);
    }

    public Item findItem(String searchItem, ArrayList<Item> items) {
        Item itemResult;
        for (Item i : items) {
            if (searchItem.equalsIgnoreCase(i.getName())) {
                itemResult = i;
                return itemResult;
            }
        }
        return null;
    }

    public boolean take(Item item) {
        if ((calculateWeight(inventory) + item.getWeight()) <= MAX_WEIGHT) {
            inventory.add(item);
            getCurrentRoom().getRoomItems().remove(item);
            return true;
        }
        return false;
    }

    public boolean takeAllItems() {
        if (calculateWeight(currentRoom.getRoomItems()) <= MAX_WEIGHT) {
            inventory.addAll(currentRoom.getRoomItems());
            getCurrentRoom().getRoomItems().clear();
            return true;
        } else {
            return false;
        }
    }

    public void drop(Item item) {
        getCurrentRoom().getRoomItems().add(item);
        inventory.remove(item);
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
        if (inventory.size() < 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean roomIsEmpty() {
        if (currentRoom.getRoomItems().size() < 1) {
            return true;
        } else {
            return false;
        }
    }
}

