package playerComponents.creature;

public abstract class Creature {

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

    public boolean isAlive() {
        return alive;
    }

    public int getHealth() {
        return current_Health;
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

    public void looseHealth(int health) {
        if (health >= 0) {
            if ((current_Health - health) > 0) {
                current_Health -= health;
            } else {
                this.alive = false;
                System.out.println(this.getName() + " has fallen at the hands of...");

            }
        } else {
            System.out.println("Health number is negative");
        }

        if (this.alive == false) {
            //make sure attacks are redirected at the owner of this beast.
        } else {
            System.out.println(this.getName() + " took " + Integer.toString(health) + " damage");
            System.out.println(this.getName() + "'s health is " + Integer.toString(this.current_Health) );
        }
    }



}
