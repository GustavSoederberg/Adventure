public class RangedWeapon extends Weapon{
    private int ammunition;
    public RangedWeapon(String name, String description, int weight, int attackPoints, int ammunition) {
        super(name, description, weight, attackPoints);
        this.ammunition = ammunition;
    }

    @Override
    public int remainingUse() {
        return ammunition;
    }

    @Override
    public int attack() {
        ammunition -= 1;
        return attackPoints;
    }
}
