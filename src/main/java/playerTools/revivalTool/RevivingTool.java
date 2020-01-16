package playerTools.revivalTool;

public abstract class RevivingTool {
    private int health;

    public RevivingTool(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void pourBottle(int value){
        this.health -= value;
    }
}
