package characterTypes.player.magi;

import playerComponents.creature.Creature;
import playerComponents.fighterWeapon.spell.Spell;

public class Warlock extends Magi {

    private WarlockType name;

    public Warlock (Creature creature, Spell spell, WarlockType name) {
        super(550, creature, spell);
        this.name = name;
    }

    public String getName () {
        return this.name.getName();
    }

}
