public class Enemy {
    private String name;
    private String description;
    private int health;
    private Weapon equippedWeapon;

    public Enemy(String name, String description, int health, Weapon equippedWeapon) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.equippedWeapon = equippedWeapon;
    }
    //Getters
    public String getName() {
        return name;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    //Methods

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }


    public int attack() {
        return equippedWeapon.attack();
    }

    public void hit(int damage) {
        health -= damage;
    }

    public String getDescription() {
        return description;
    }
}
