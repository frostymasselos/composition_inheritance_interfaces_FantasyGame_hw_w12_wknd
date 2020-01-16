package characterTypes;

import playerTools.weapon.Weapon;

public abstract class Warrior implements IPlayer {

    private int health; //choose in sub
    private int defense; //choose in sub
    private Weapon weapon; //choose in sub
    private double wealth; //default


    public Warrior(int health, int defense, Weapon weapon) {
        this.health = health;
        this.defense = defense;
        this.weapon = weapon;
        this.wealth = 0.0;
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void changeWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public double getWealth() {
        return wealth;
    }

    public int attack(){
        return this.weapon.getDamage();
    }
}
