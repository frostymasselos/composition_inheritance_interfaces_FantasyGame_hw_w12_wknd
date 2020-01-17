package characterTypes.player.magi;

import playerComponents.creature.Creature;
import playerComponents.creature.Ogre;
import playerComponents.fighterWeapon.spell.Fireball;
import playerComponents.fighterWeapon.spell.Spell;

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
