public abstract class Weapon extends Item{
    protected int attackPoints;
    public Weapon(String name, String description, int weight, int attackPoints) {
        super(name, description, weight);
        this.attackPoints = attackPoints;
    }
    public abstract int remainingUse();

    public abstract int attack();
}
