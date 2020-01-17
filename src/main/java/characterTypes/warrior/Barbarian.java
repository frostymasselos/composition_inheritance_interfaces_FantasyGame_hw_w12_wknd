package characterTypes.warrior;

import playerComponents.warriorWeapon.Club;

public class Barbarian extends Warrior {

    private BarbarianType name;

    public Barbarian (BarbarianType name) {
        super(175, 10, new Club("Club"));
        this.name = name;
    }

    public String getName() {
        return this.name.getName();
    }

    public void setName () {

    }
}
