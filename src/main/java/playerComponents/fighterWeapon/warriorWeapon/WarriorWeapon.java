package playerComponents.fighterWeapon.warriorWeapon;

import playerComponents.fighterWeapon.FighterWeapon;

public abstract class WarriorWeapon {

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
