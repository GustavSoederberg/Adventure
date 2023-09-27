
public class Adventure {
    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;
    private Room room5;
    private Room room6;
    private Room room7;
    private Room room8;
    private Room room9;
    private Room currentRoom;


    public Adventure() {
        map.buildMap();
        player = new Player(map.getRoom1());
    }

    public Room getCurrentRoom(){
        return player.getCurrentRoom();
    }


    public boolean move(String direction) {
        return player.move(direction);
    }

    public String look() {
        return player.getCurrentRoom().getDescription();
    }


    public Room getXyzzyRoom() {
        return player.getXyzzyRoom();
    }


    public String help() {
        return """
                You're in a spacestation. 
                To move between rooms you have to write north, south, east and west. 
                You can write look to get at name and description of the current room you're in.
                To exit the game write exit.
                """;
    }

    public void checkRoomsAroundIsVisited() {
        if (currentRoom.getNorth() != null && !currentRoom.getNorth().isVisited()) {
            System.out.println("North is not visited");
        }
    }
    public void teleport() {
        Room newXyzzy = currentRoom;
        currentRoom = xyzzyRoom;
        xyzzyRoom = newXyzzy;
    }
}
