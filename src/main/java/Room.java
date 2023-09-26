public class Room {
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private boolean isVisited;

    public Room(String name, String description){
        this.name = name;
        this.description = description;
        isVisited = false;
    }

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
