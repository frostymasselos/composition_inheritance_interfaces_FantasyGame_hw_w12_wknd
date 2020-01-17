package characterTypes.warrior;

import playerComponents.warriorWeapon.Axe;

public class Dwarf extends Warrior {

    private DwarfType name;

    public Dwarf (DwarfType name) {
        super(175, 30, new Axe("Axe"));
        this.name = name;
    }

    public String getName() {
        return this.name.getName();
    }

    public void setName () {

    }
}
