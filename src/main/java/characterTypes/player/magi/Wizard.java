package characterTypes.player.magi;

import playerComponents.creature.Creature;
import playerComponents.fighterWeapon.spell.Spell;

public class Wizard extends Magi {

    private WizardType name;

    public Wizard (Creature creature, Spell spell, WizardType name) {
        super(700, creature, spell);
        this.name = name;
    }

    public String getName () {
        return this.name.getName();
    }
}
