package playerComponents.fighterWeapon;

public abstract class FighterWeapon {

    private String name;
    private int damage;

    public FighterWeapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return this.damage;
    }
}
