public class RangedWeapon extends Weapon{
    private int ammunition = 0;
    public RangedWeapon(String name, String description, int weight, int attackPoints) {
        super(name, description, weight, attackPoints);
    }

    public int getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }
}
