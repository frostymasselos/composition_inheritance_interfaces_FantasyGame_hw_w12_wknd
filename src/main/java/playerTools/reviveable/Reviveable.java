package playerTools.reviveable;

public abstract class Reviveable {
    private int health;

    public Reviveable(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void pourBottle(int value){
        this.health -= value;
    }
}
