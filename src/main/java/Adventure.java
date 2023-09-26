
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

    private Room xyzzyRoom;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room getXyzzyRoom() {
        return xyzzyRoom;
    }

    public Adventure() {
        room1 = new Room("Room 1", "Room number 1");
        room2 = new Room("Room 2", "Room number 2");
        room3 = new Room("Room 3", "Room number 3");
        room4 = new Room("Room 4", "Room number 4");
        room5 = new Room("Room 5", "Room number 5");
        room6 = new Room("Room 6", "Room number 6");
        room7 = new Room("Room 7", "Room number 7");
        room8 = new Room("Room 8", "Room number 8");
        room9 = new Room("Room 9", "Room number 9");
        currentRoom = room1;
        xyzzyRoom = room1;
    }

    public void setAllRooms() {
        //Room 1
        room1.setEast(room2);
        room1.setSouth(room4);
        //Room 2
        room2.setWest(room1);
        room2.setEast(room3);
        room2.setSouth(room5);
        //Room 3
        room3.setWest(room2);
        room3.setSouth(room6);
        //Room 4
        room4.setSouth(room7);
        room4.setNorth(room1);
        room4.setEast(room5);

        room4.setLockedNorth(true);
        //Room 5
        room5.setNorth(room2);
        room5.setWest(room4);
        room5.setEast(room6);
        room5.setSouth(room8);
        //Room 6
        room6.setNorth(room3);
        room6.setWest(room5);
        room6.setSouth(room9);
        //Room 7
        room7.setNorth(room4);
        room7.setEast(room8);
        //Room 8
        room8.setNorth(room5);
        room8.setWest(room7);
        room8.setEast(room9);
        //Room 9
        room9.setWest(room8);
        room9.setNorth(room6);

        currentRoom.setVisited(true);
    }


    public boolean move(String direction) {
        switch (direction) {
            case "east" -> {
                if (currentRoom.getEast() != null && !currentRoom.getEast().isLockedWest()) {
                    currentRoom = currentRoom.getEast();
                    return true;

                } else {return false;}

            }
            case "north" -> {
                if (currentRoom.getNorth() != null && !currentRoom.getNorth().isLockedSouth()) {
                    currentRoom = currentRoom.getNorth();
                    return true;

                } else {return false;}

            }
            case "south" -> {
                if (currentRoom.getSouth() != null && !currentRoom.getSouth().isLockedNorth()) {
                    currentRoom = currentRoom.getSouth();
                    return true;

                } else {return false;}
            }
            case "west" -> {
                if (currentRoom.getWest() != null && !currentRoom.getWest().isLockedEast()) {
                    currentRoom = currentRoom.getWest();
                    return true;

                } else{return false;}
            }
        }
        return false;
    }

    public String look() {
        return "Looking around: \n" +
                currentRoom.getName() + "\n" +
                currentRoom.getDescription();
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

    public void unlock(){


    }
}
