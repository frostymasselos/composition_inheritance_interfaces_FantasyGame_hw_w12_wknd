package playerComponents.revivalTool;

import playerComponents.Swappable;

public abstract class RevivingTool implements Swappable {

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

    public boolean checkIfFilled () {
        if (current_Amount > 0) {
            return filled;
        } else {
            this.filled = false;
            return this.filled;
        }

    }

    public boolean isFull () {
        if (current_Amount == max_Amount) {
            return true;
        } else {
            return false;
        }
    }

    public int getAmount() {
        return current_Amount;
    }

    public void clearBottle () {
        current_Amount = 0;
    }


    public void pour(int amount) {
        if (amount >= 0) {
            if ((current_Amount - amount) > 0) {
                current_Amount -= amount;
            } else {
                clearBottle();
                this.checkIfFilled();
                System.out.println(this.getName() + " is empty");

            }
        } else {
            System.out.println("Amount number is negative");
            return;
        }

        if (this.filled == false) {
        } else {
            System.out.println(this.getName() + " loses " + Integer.toString(amount) + " amount");
            System.out.println(this.getName() + "'s amount is " + Integer.toString(this.current_Amount) );
        }
    }
}
