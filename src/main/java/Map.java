public class Map {
    private Room room1;

    public Room getRoom1() {
        return room1;
    }

    public void buildMap() {
        room1 = new Room("Room 1", "Room number 1");
        room1.addItem("Æble", "æble", 1);
        room1.addItem("Banan", "banan", 1);
        room1.addItem("Pære", "pære", 1);
        Room room2 = new Room("Room 2", "Room number 2");
        Room room3 = new Room("Room 3", "Room number 3");
        Room room4 = new Room("Room 4", "Room number 4");
        Room room5 = new Room("Room 5", "Room number 5");
        Room room6 = new Room("Room 6", "Room number 6");
        Room room7 = new Room("Room 7", "Room number 7");
        Room room8 = new Room("Room 8", "Room number 8");
        Room room9 = new Room("Room 9", "Room number 9");


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
    }


}
