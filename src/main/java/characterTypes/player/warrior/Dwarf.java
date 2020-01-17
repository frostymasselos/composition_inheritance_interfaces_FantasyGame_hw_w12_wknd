package characterTypes.player.warrior;

import playerComponents.fighterWeapon.warriorWeapon.Axe;

public class Dwarf extends Warrior {

    private DwarfType name;

    public Dwarf (DwarfType name) {
        super(175, 150, new Axe("Axe"));
        this.name = name;
    }

    public String getName() {
        return this.name.getName();
    }

    public void setName () {

    }
}
