package characterTypes.player.warrior;

import characterTypes.player.Player;
import characterTypes.player.fighter.IFighter;
import playerComponents.fighterWeapon.warriorWeapon.WarriorWeapon;

public abstract class Warrior extends Player implements IFighter {

    private int currentDefense;
    private int maxDefense;
    private WarriorWeapon weapon;

    public Warrior (int max_Health, int max_Defense, WarriorWeapon weapon) {
        super(max_Health);
        this.maxDefense = max_Defense;
        this.weapon = weapon;
        this.currentDefense = maxDefense;
    }

    public int getDefense() {
        return currentDefense;
    }

    public void restoreDefenses () {
        this.currentDefense = this.maxDefense;
    }

    public void emptyDefense () {
        this.currentDefense = 0;
    }

    public void sustainAttack (int attack) {
        if (this.currentDefense - attack <= 0) {
            int overkill = attack - this.currentDefense;
            emptyDefense();
            looseHealth(overkill);
        } else {
            this.currentDefense -= attack;
        }
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
