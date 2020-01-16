package playerTools.reviveable;

public abstract class Reviveable {
    private int health;

    public Reviveable(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void emptyBottle(){
        this.health = 0;
    }
}
