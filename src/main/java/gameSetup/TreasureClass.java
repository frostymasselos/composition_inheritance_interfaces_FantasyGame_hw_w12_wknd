package gameSetup;

import java.util.concurrent.ThreadLocalRandom;

public abstract class TreasureClass {

    private String name;
    private double wealth;

    public TreasureClass(String name, int wealth) {
        this.name = name;
        this.wealth = wealth;
    }

    public String getName () {
        return this.name;
    }

    public double getCoreWealth () {
        return this.wealth;
    }

    public double getWealth() {
        int coreValue = (int)wealth;
        int upperValue = (int)wealth * 3;

        double randomNum = (ThreadLocalRandom.current().nextInt(coreValue, upperValue));
        return randomNum;
    }
}