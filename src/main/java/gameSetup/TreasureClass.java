package gameSetup;

import java.util.concurrent.ThreadLocalRandom;

public abstract class TreasureClass {

    private String name;
    private int wealth;

    public TreasureClass(String name, int wealth) {
        this.name = name;
        this.wealth = wealth;
    }

    public String getName () {
        return this.name;
    }

    public int getWealth() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 3);
        return wealth * randomNum;
    }
}