package playerComponents.fighterWeapon.warriorWeapon;

import playerComponents.ForAWarrior;
import playerComponents.Swappable;
import playerComponents.fighterWeapon.FighterWeapon;

public abstract class WarriorWeapon implements Swappable, ForAWarrior {

    private String name;
    private int damage;

    public WarriorWeapon (String name, int damage) {
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
