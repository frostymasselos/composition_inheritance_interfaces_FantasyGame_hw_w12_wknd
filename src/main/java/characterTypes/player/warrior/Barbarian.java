package characterTypes.player.warrior;

import playerComponents.fighterWeapon.warriorWeapon.Club;

public class Barbarian extends Warrior {

    private BarbarianType name;

    public Barbarian (BarbarianType name) {
        super(175, 150, new Club("Club"));
        this.name = name;
    }

    public String getName() {
        return this.name.getName();
    }

    public void setName () {

    }
}
