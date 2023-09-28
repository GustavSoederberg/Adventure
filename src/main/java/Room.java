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
    private ArrayList<Item> roomItems = new ArrayList<Item>()

    //Constructor
    public Room(String name, String description){
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


    //ToString
    @Override
    public String toString() {
        if (isVisited) {
            return "Room name: " + name;
        }
        else {
            return "Room name: " + name +
                    "\nDescription: " + description;
        }
    }
}
