package playerTools.spell;

public abstract class Spell {

    private int damage;

    public Spell(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }

}



