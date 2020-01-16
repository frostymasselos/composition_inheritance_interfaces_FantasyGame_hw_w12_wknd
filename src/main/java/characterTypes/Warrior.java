package characterTypes;

import playerTools.weapon.Weapon;

public abstract class Warrior implements IPlayer {

    private int max_Health; //choose in sub
    private int defense; //choose in sub
    private Weapon weapon; //choose in sub
    private double wealth; //default
    private int current_Health;
    private boolean alive; //default


    public Warrior(int max_Health, int defense, Weapon weapon) {
        this.max_Health = max_Health;
        this.defense = defense;
        this.weapon = weapon;
        this.wealth = 0.0;
        this.current_Health = max_Health;
        this.alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getHealth() {
        return current_Health;
    }

    public void gainHealth(int health) {
        if (health >= 0) {
            if (current_Health + health <= max_Health) {
                current_Health += health;
                System.out.println(this.getName() + "'s health increases to " + Integer.toString(this.current_Health));
            } else {
                current_Health = max_Health;
                System.out.println(this.getName() + "'s health is fully restored");
            }
        } else {
            System.out.println("Health number is negative");
        }
    }

    public void looseHealth(int health) {
        if (health >= 0) {
            if (current_Health - health > 0) {
                current_Health -= health;
            } else {
                this.alive = false;

            }
        } else {
            System.out.println("Health number is negative");
        }

        if (this.alive = false) {
            //remove character from game; whatever array he'll alway be in when fighting, he'll be removed from.
        } else {
            System.out.println(this.getName() + "took " + Integer.toString(health) + " damage");
            System.out.println(this.getName() + "'s health is " + Integer.toString(this.current_Health) );
        }
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
