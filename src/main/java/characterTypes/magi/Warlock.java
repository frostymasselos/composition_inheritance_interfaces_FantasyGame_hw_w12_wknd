package characterTypes.magi;

import playerComponents.magiTools.creature.Ogre;
import playerComponents.magiTools.spell.Fireball;
import playerComponents.magiTools.spell.Spell;

public class Warlock extends Magi {

    private WarlockType name;

    public Warlock (Spell spell, WarlockType name) {
        super(550, new Ogre("Ogre"), new Fireball());
        this.name = name;
    }

    public String getName () {
        return this.name.getName();
    }

}
