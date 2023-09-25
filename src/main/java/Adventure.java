
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
    private Room current;
    public Adventure(){
        room1 = new Room("Room 1", " ");
        room2 = new Room("Room 2", " ");
        room3 = new Room("Room 3", " ");
        room4 = new Room("Room 4", " ");
        room5 = new Room("Room 5", " ");
        room6 = new Room("Room 6", " ");
        room7 = new Room("Room 7", " ");
        room8 = new Room("Room 8", " ");
        room9 = new Room("Room 9", " ");
        current = room1;
    }

    public void setAllRooms(){
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

    public void move(String direction){

        switch(direction){
            case "east" -> current = current.getEast();
            case "north" -> current = current.getNorth();
            case "south" -> current = current.getSouth();
            case "west" -> current = current.getWest();
        }

    }

}
