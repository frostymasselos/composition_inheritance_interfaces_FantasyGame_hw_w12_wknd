package characterTypes.player.magi;

import playerComponents.creature.Creature;
import playerComponents.creature.Dragon;
import playerComponents.fighterWeapon.spell.LightningStrike;
import playerComponents.fighterWeapon.spell.Spell;

public class Wizard extends Magi {

    private WizardType name;

    public Wizard (WizardType name) {
        super(700, new Dragon("Dragon"), new LightningStrike());
        this.name = name;
    }

    public String getName () {
        return this.name.getName();
    }
}
