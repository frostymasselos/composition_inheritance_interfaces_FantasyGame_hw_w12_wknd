package playerTools.creature;

public abstract class Creature {

    private int protection;

    public Creature(int damage) {
        this.protection = damage;
    }

    public int getProtection(){
        return this.protection;
    }

    public void looseProtection(int value){
        this.protection -= value;
    }

}
