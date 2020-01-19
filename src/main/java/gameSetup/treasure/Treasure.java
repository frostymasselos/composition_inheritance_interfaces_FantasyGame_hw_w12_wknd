package gameSetup.treasure;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Treasure {

    private String name;
    private double coreWealth;


    public Treasure(String name, double coreWealth) {
        this.name = name;
        this.coreWealth = coreWealth;
    }

    public String getName () {
        return this.name;
    }

    public void emptyCoreWealth() { this.coreWealth = 0; }

    public double getCoreWealth () {
        return this.coreWealth;
    }

    public double getWealth() {
        int coreValue = (int)coreWealth;
        int upperValue = (int)coreWealth * 3;

        double randomNum = (ThreadLocalRandom.current().nextInt(coreValue, upperValue));
        emptyCoreWealth();
        return randomNum;
    }
}