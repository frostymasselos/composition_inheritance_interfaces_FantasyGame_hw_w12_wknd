package characterTypes;

public abstract class Player extends Living implements IPlayer {

    private double wealth;

    public Player(int max_Health) {
        super(max_Health);
        this.wealth = 0.0;
    }

    //    PLAYER HEALTH ATTRIBUTES

    public void restoreFullHealth () {
        super.current_Health = max_Health;
    }

    public void gainHealth(int health) {
        if (health >= 0) {
            if (current_Health + health <= max_Health) {
                current_Health += health;
                System.out.println(this.getName() + "'s health increases to " + Integer.toString(this.current_Health));
            } else {
                restoreFullHealth();
                System.out.println(this.getName() + "'s health is fully restored");
            }
        } else {
            System.out.println("Health number is negative");
            return;
        }
    }


//    PLAYERS CAN ACCRUE WEALTH


    public double getWealth () {
        return wealth;
    }

    public void addWealth (int amount) {
        wealth += amount;
        System.out.println(this.getName() + " acquired " + Integer.toString(amount) + " wealth");
        System.out.println(this.getName() + " now has " + Integer.toString((int)this.getWealth()) + " wealth");
    }



}
