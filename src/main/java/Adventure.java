
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

    public Room getCurrentRoom() {
        return currentRoom;
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
        room9.setEast(room8);
        room9.setNorth(room6);
    }



    /*public void move(String direction) {
        switch (direction) {
            case "east" -> {
                if (currentRoom.getEast() != null) { currentRoom = currentRoom.getEast();
                    System.out.println("Moved " + direction); }
            }
            case "north" -> {
                if (currentRoom.getNorth() != null) { currentRoom = currentRoom.getNorth();
                    System.out.println("Moved " + direction); }
            }
            case "south" -> {
                if (currentRoom.getSouth() != null) { currentRoom = currentRoom.getSouth();
                    System.out.println("Moved " + direction); }
            }
            case "west" -> {
                if (currentRoom.getWest() != null) { currentRoom = currentRoom.getWest();
                    System.out.println("Moved " + direction); }
            }
        }
    }*/


    public String moveNorth() {
        if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            return "Moved North \n" +
                    currentRoom;
        }
        else {
            return "You can't go that way";

        }

    }
    public String moveSouth() {
        if (currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            return "Moved South \n" +
                    currentRoom;
        }
        else {
            return "You can't go that way";

        }

    }
    public String moveEast() {
        if (currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
            return "Moved East \n" +
                    currentRoom;
        }
        else {
            return "You can't go that way";

        }

    }
    public String moveWest() {
        if (currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            return "Moved West \n" +
                    currentRoom;
        }
        else {
            return "You can't go that way";

        }

    }

    public String look() {
        return "Looking around: \n" +
        currentRoom.getName() + "\n" +
                currentRoom.getDescription();
    }

    public String help() {
        return "This is the help text";
    }
}
