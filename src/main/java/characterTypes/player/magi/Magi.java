package characterTypes.player.magi;

import characterTypes.player.Player;
import characterTypes.player.fighter.IFighter;
import playerComponents.creature.Creature;
import playerComponents.fighterWeapon.spell.Spell;

import java.util.ArrayList;


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


//    private int max_Health; //choose in sub
//    private int defense; //choose in sub
//    private FighterWeapon weapon; //choose in sub
//    private double wealth; //default
//    private int current_Health;
//    private boolean alive; //default
//
//
//    public Magi(int max_Health, int defense, FighterWeapon weapon) {
//        this.max_Health = max_Health;
//        this.defense = defense;
//        this.weapon = weapon;
//        this.wealth = 0.0;
//        this.current_Health = max_Health;
//        this.alive = true;
//    }
//
//    public boolean isAlive() {
//        return alive;
//    }
//
//    public int getHealth() {
//        return current_Health;
//    }
//
//    public void gainHealth(int health) {
//        if (health >= 0) {
//            if (current_Health + health <= max_Health) {
//                current_Health += health;
//                System.out.println(this.getName() + "'s health increases to " + Integer.toString(this.current_Health));
//            } else {
//                current_Health = max_Health;
//                System.out.println(this.getName() + "'s health is fully restored");
//            }
//        } else {
//            System.out.println("Health number is negative");
//        }
//    }
//
//    public void looseHealth(int health) {
//        if (health >= 0) {
//            if ((current_Health - health) > 0) {
//                current_Health -= health;
//            } else {
//                this.alive = false;
//                System.out.println(this.getName() + " has fallen at the hands of...");
//
//            }
//        } else {
//            System.out.println("Health number is negative");
//        }
//
//        if (this.alive == false) {
//            //remove character from game; whatever array he'll alway be in when fighting, he'll be removed from.
//        } else {
//            System.out.println(this.getName() + " took " + Integer.toString(health) + " damage");
//            System.out.println(this.getName() + "'s health is " + Integer.toString(this.current_Health) );
//        }
//    }
//
//    public int getDefense() {
//        return defense;
//    }
//
//    public FighterWeapon getWeapon() {
//        return weapon;
//    }
//
//    public void changeWeapon(FighterWeapon weapon) {
//        this.weapon = weapon;
//    }
//
//    public double getWealth () {
//        return wealth;
//    }
//
//    public void addWealth (int amount) {
//        wealth += amount;
//        System.out.println(this.getName() + " acquired " + Integer.toString(amount) + " wealth");
//        System.out.println(this.getName() + " now has " + Integer.toString((int)this.getWealth()) + " wealth");
//    }
//
//    public int attack(){
//        System.out.println(this.getName() + " attacks!");
//        return this.weapon.getDamage();
//    }
}
