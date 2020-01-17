package characterTypes.antagonist;

import characterTypes.Living;

public abstract class Antagonist extends Living {

    private String name;
    private int damage;

    public Antagonist (int maxHealth, String name, int damage) {
        super(maxHealth);
        this.name = name;
        this.damage = damage;
    }

    public String getName () {
        return name;
    }

    public int attack () {
        return damage;
    }
}
