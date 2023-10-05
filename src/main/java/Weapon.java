public class Weapon extends Item{
    private int attackPoints;
    public Weapon(String name, String description, int weight, int attackPoints) {
        super(name, description, weight);
        this.attackPoints = attackPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }
}
