package characterTypes.magi;

import playerComponents.magiTools.creature.Dragon;
import playerComponents.magiTools.spell.LightningStrike;

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
