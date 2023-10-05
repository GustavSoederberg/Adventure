public class MeleeWeapon extends Weapon{
    public MeleeWeapon(String name, String description, int weight, int attackPoints) {
        super(name, description, weight, attackPoints);
    }

    @Override
    public int attack() {
        //Attack function
        return attackPoints;
    }
}
