package playerComponents.magiTools.creature;

import playerComponents.ForAMagi;
import playerComponents.Swappable;

public abstract class Creature implements Swappable, ForAMagi {

    private String name;
    private int max_Health;
    private int current_Health;
    private boolean alive;

    public Creature (String name, int health) {
        this.name = name;
        this.max_Health = health;
        this.current_Health = max_Health;
        this.alive = true;
    }

    public String getName () {
        return name;
    }


    public boolean checkIfAlive () {
        if (current_Health > 0) {
            return alive;
        } else {
//            this.alive = false;
            return this.alive;
        }
    }

    public boolean checkIfFullHealth () {
        if (current_Health == max_Health) {
            return true;
        } else {
            return false;
        }
    }

    public void killCreature () {
        current_Health = 0;
        this.alive = false;
    }

    public void restoreFullHealth () {
        current_Health = max_Health;
    }

    public int getHealth () {
        return current_Health;
    }

    public void looseHealth(int health) {
        if (health >= 0) {
            if ((current_Health - health) > 0) {
                current_Health -= health;
            } else {
                System.out.println(this.getName() + " is Dead");
                killCreature();
//                checkIfAlive();
            }
        } else {
            System.out.println("Health number is negative");
            System.out.println(this.getName() + "'s health is " + Integer.toString(this.current_Health));
            return;
        }

        if (this.alive == false) {
            //make sure attacks are redirected at the owner of this beast.
        } else {
            System.out.println(this.getName() + " took " + Integer.toString(health) + " damage");
            System.out.println(this.getName() + "'s health is " + Integer.toString(this.current_Health) );
        }
    }


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



}
