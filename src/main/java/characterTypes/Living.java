package characterTypes;

public abstract class Living implements ILiving {

    protected int max_Health;
    protected int current_Health;
    protected boolean alive;

    public Living(int max_Health) {
        this.max_Health = max_Health;
//        this.wealth = 0.0;
        this.current_Health = max_Health;
        this.alive = true;
    }

//    SO FAR JUST ANTAGONIST & PLAYER EXTEND THIS. CREATURES TOO?

    public boolean checkIfAlive () {
        return alive;
    }

    public int getHealth() {
        return current_Health;
    }

    public void getFullHealth () {
        current_Health = max_Health;
    }

    public boolean isFullHealth () {
        if (current_Health == max_Health) {
            return true;
        } else {
            return false;
        }
    }

    public void kill () {
        this.current_Health = 0;
        this.alive = false;
    }

    public void sustainAttack (int attack) {
        this.looseHealth(attack);
    }

    public void looseHealth(int damage) {
        if ((current_Health - damage) > 0) {
            current_Health -= damage;
        } else {
            kill();
            System.out.println(this.getName() + " has fallen at the hands of...");
        }

        if (this.alive == false) {
            //remove character from game; whatever array he'll alway be in when fighting, he'll be removed from.
        } else {
            System.out.println(this.getName() + " took " + Integer.toString(damage) + " damage");
            System.out.println(this.getName() + "'s health is " + Integer.toString(this.current_Health) );
        }
    }

}
