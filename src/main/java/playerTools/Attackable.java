package playerTools;

public abstract class Attackable {
    private int damage;

    public Attackable(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }
}
