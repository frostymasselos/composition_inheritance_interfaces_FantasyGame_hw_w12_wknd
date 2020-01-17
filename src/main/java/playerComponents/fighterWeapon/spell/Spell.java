package playerComponents.fighterWeapon.spell;

import playerComponents.ForAMagi;
import playerComponents.Swappable;
import playerComponents.fighterWeapon.FighterWeapon;

public abstract class Spell implements Swappable, ForAMagi {

    private String name;
    private int damage;

    public Spell (String name, int damage) {
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
