package characterTypes;

public abstract class Player extends Living implements IPlayer {

    private double wealth;

    public Player(int max_Health) {
        super(max_Health);
        this.wealth = 0.0;
    }

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

    public double getWealth () {
        return wealth;
    }

    public void addWealth (double amount) {
        wealth += amount;
        int wealthToPrintToConsole = (int)amount;
        System.out.println(this.getName() + " acquired " + Integer.toString(wealthToPrintToConsole) + " wealth");
        System.out.println(this.getName() + " now has " + Integer.toString((int)this.getWealth()) + " wealth");
    }

    public void depleteWealth () {
        wealth = 0;
    }

//    public int attack () {
//        return 0;
//    }

}
