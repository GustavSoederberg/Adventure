
public class Adventure {
    private Map map = new Map();
    private Player player;



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

    /*public void checkRoomsAroundIsVisited() {
        if (player.getCurrentRoom().getNorth() != null && !player.getCurrentRoom().getNorth().isVisited()) {
            System.out.println("North is not visited");
        }
    }*/
    public void teleport() {
        Room newXyzzy = player.getCurrentRoom();
        player.setCurrentRoom(player.getXyzzyRoom());
        player.setXyzzyRoom(newXyzzy);
    }
}
