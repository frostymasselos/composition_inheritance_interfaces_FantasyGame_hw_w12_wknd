package playerComponents.warriorWeapon;

import playerComponents.Swappable;

public abstract class WarriorWeapon implements Swappable {

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
