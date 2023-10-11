public class Map {
    private Room startRoom;

    public Room getStartRoom() {
        return startRoom;
    }

    public void buildMap() {
        Room aalborg = new Room("Aalborg", "Population: 120.000");
        startRoom = aalborg;
        aalborg.addFood("Rød Aalborg", "Schapps", 4, -99);
        aalborg.addMeleeWeapon("Sværd", "Et Stort sværd", 3, 50);
        aalborg.addMeleeWeapon("Pind", "En lille pind", 1, 4);
        aalborg.addRangedWeapon("Sniper", "50. cal", 10, 10, 5);
        aalborg.addEnemy("Trold", "En stor grim trold", 50, new MeleeWeapon("Rød Aalborg", "Schapps", 4, 5));


        Room kerteminde = new Room("Kerteminde", "Population: 6.000");
        kerteminde.addFood("Ice Cream", "A delicious ice cream", 2, 20);
        kerteminde.addEnemy("Kenned", "50 year old drunk guy at the bar", 30, new MeleeWeapon("Broken Tuborg", "Broken bottle of beer", 2, 14));

        Room helsingør = new Room("Helsingør", "Population: 47.000");
        helsingør.addEnemy("Gitte", "chairman of the local cultural association", 50, new MeleeWeapon("Magazine from B.T.", "Magazine with all the latest news about the royal family", 1, 8));
        helsingør.addRangedWeapon("Sniper", "50. cal", 10, 30, 5);

        Room randers = new Room("Randers", "Population: 62.000");
        randers.addFood("Mokaï", "Alcoholic beverage that gives a lot of energy", 2, 40);
        randers.addItem("Scooter", "An illegal, and likely stolen, scooter", 15);

        Room odense = new Room("Odense", "Population: 500.000");
        odense.addFood("Odense Pilsner", "Nice beer from Odense", 2, 30);
        odense.addEnemy("Spørge-Jørgen", "guys who works at the dock", 45, new MeleeWeapon("plate with flæskestegssandwich", "plate with flæskestegssandwich from Havnens Perle" , 2, 9));

        Room copenhagen = new Room("Copenhagen", "Population: 1.300.000");
        copenhagen.addFood("Coffee", "A black cup of coffee", 1, 5);
        copenhagen.addFood("Cigarette", "A blue kings cigarette", 1, -10);
        copenhagen.addRangedWeapon("Gøb", "A gun", 5, 30, 6);

        Room flensborg = new Room("Flensborg", "Population: 89.000");

        Room svendborg = new Room("Svendborg", "Population: 87.000");

        Room faxe = new Room("Faxe", "Population: 4.000");
        faxe.addFood("Faxe Kondi", "A delicious soda", 2, 30);


        //Room 1
        aalborg.setEast(kerteminde);
        aalborg.setSouth(randers);
        //Room 2
        kerteminde.setWest(aalborg);
        kerteminde.setEast(helsingør);
        kerteminde.setSouth(odense);
        //Room 3
        helsingør.setWest(kerteminde);
        helsingør.setSouth(copenhagen);
        //Room 4
        randers.setSouth(flensborg);
        randers.setNorth(aalborg);
        randers.setEast(odense);
        //Room 5
        odense.setNorth(kerteminde);
        odense.setWest(randers);
        odense.setEast(copenhagen);
        odense.setSouth(svendborg);
        //Room 6
        copenhagen.setNorth(helsingør);
        copenhagen.setWest(odense);
        copenhagen.setSouth(faxe);
        //Room 7
        flensborg.setNorth(randers);
        flensborg.setEast(svendborg);
        //Room 8
        svendborg.setNorth(odense);
        svendborg.setWest(flensborg);
        svendborg.setEast(faxe);
        //Room 9
        faxe.setWest(svendborg);
        faxe.setNorth(copenhagen);
    }
}
