package characterTypes.magi;

import characterTypes.Player;
import characterTypes.fighter.IFighter;
import playerComponents.magiTools.creature.Creature;
import playerComponents.magiTools.spell.Spell;


public abstract class Magi extends Player implements IFighter {

    private Creature creature;
    private Spell weapon;

    public Magi (int max_Health, Creature creature, Spell weapon) {
        super(max_Health);
        this.creature = creature;
        this.weapon = weapon;
    }

    public void sustainAttack (int attack) {
        if (creature.checkIfAlive()) {
            creature.looseHealth(attack);
        } else {
            looseHealth(attack);
        }
        if (current_Health < 0) {
            alive = false;
        }
    }

    public void restoreDefenses (){
        creature.restoreFullHealth();
    }

    public Creature getCreature () {
        return creature;
    }

    public void changeCreature (Creature creature) {
        this.creature = creature;
    }

    public Spell getWeapon() {
        return weapon;
    }

    public void changeWeapon(Spell weapon) {
        this.weapon = weapon;
    }

    public int attack(){
        System.out.println(this.getName() + " attacks!");
        return this.weapon.getDamage();
    }

}
