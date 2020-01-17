package characterTypes.player.warrior;

import characterTypes.player.Player;
import playerComponents.fighterWeapon.warriorWeapon.WarriorWeapon;

public abstract class Warrior extends Player {

    private int defense;
    private WarriorWeapon weapon;

    public Warrior (int max_Health, int defense, WarriorWeapon weapon) {
        super(max_Health);
        this.defense = defense;
        this.weapon = weapon;
    }

    public int getDefense() {
        return defense;
    }

    public WarriorWeapon getWeapon() {
        return weapon;
    }

    public void changeWeapon(WarriorWeapon weapon) {
        this.weapon = weapon;
    }

    public int attack(){
        System.out.println(this.getName() + " attacks!");
        return this.weapon.getDamage();
    }

}
