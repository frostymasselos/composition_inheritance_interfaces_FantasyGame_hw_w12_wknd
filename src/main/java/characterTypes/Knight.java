package characterTypes;

import playerComponents.fighterWeapon.warriorWeapon.Sword;

public class Knight extends Fighter {

    private KnightType name;

    public Knight (KnightType name) {
        super(200, 175, new Sword());
        this.name = name;
    }

    public String getName() {
        return this.name.getName();
    }

}
