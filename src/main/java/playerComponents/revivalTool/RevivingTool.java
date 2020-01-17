package playerComponents.revivalTool;

public abstract class RevivingTool {

    private String name;
    private int max_Amount;
    private int current_Amount;
    private boolean filled;

    public RevivingTool (String name, int amount) {
        this.name = name;
        this.max_Amount = amount;
        this.current_Amount = max_Amount;
        this.filled = true;
    }

    public String getName () {
        return name;
    }

    public boolean isEmpty() {
        return filled;
    }

    public int getAmount() {
        return current_Amount;
    }


    public void pourBottle(int amount) {
        if (amount >= 0) {
            if ((current_Amount - amount) > 0) {
                current_Amount -= amount;
            } else {
                this.filled = false;
                System.out.println(this.getName() + " is filled...");

            }
        } else {
            System.out.println("Amount number is negative");
        }

        if (this.filled == false) {
            //make sure attacks are redirected at the owner of this beast.
        } else {
            System.out.println(this.getName() + " loses " + Integer.toString(amount) + " amount");
            System.out.println(this.getName() + "'s amount is " + Integer.toString(this.current_Amount) );
        }
    }
}
